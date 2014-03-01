DESCRIPTION = "A lightweight PDF viewer and toolkit written in portable C."
HOMEPAGE = "http://www.mupdf.com"
SECTION = "x11/applications"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=73f1eb20517c55bf9493b7dd6e480788"

inherit gitpkgv pkgconfig

TAG = "1.3"
BRANCH = "master"

# what happened to the git fetcher? no more tags as SRCREVs?
#### this is 1.3 hash
#SRCREV = "8530783a10e467947f8698cf44d38313b5454cb2"
#### this is 1.2 hash
SRCREV = "9d20a4f3a69fdea855f8678c1ad50b5db7472d81"
PKGV = "${GITPKGVTAG}"

#PV = "${TAG}"
PR = "r0"

DEPENDS = "openjpeg-native jbig2dec-native jpeg-native freetype-native libpng-native openjpeg jbig2dec jpeg freetype zlib bzip2 ${X11_DEPS}"
X11_DEPS = "virtual/libx11 libxext libxau libxdmcp libxcb"

SRC_URI = "git://git.ghostscript.com/mupdf.git;protocol=http;branch=${BRANCH} \
           file://${PN}-1.1_p20121127-buildsystem.patch \
           file://${PN}-1.1_p20121127-desktop-integration.patch \
           file://${PN}-1.2-mubusy_rename_fix.patch \
           file://${PN}-1.2-pkg-config.patch \
           file://${PN}-1.1_rc1-zoom-2.patch \
"

S = "${WORKDIR}/git"

LEAD_SONAME = "libfitz.so.1.2"

# mupdf crashes when built with -ggdb3
# http://bugs.ghostscript.com/show_bug.cgi?id=691578
FULL_OPTIMIZATION := "${@oe_filter_out('-ggdb3', '${FULL_OPTIMIZATION}', d)}"

do_configure_prepend() {
    cd ${S}
    rm -rf ${S}/thirdparty

    sed -i -e "/^prefix=/s:=.*:=/usr:" \
        ${S}/debian/${PN}.pc

    # http://bugs.ghostscript.com/show_bug.cgi?id=693467
    sed -i -e '/^\(Actions\|MimeType\)=/s:\(.*\):\1;:' \
        ${S}/debian/${PN}.desktop

    my_soname="${LEAD_SONAME}"

    sed -i -e "\$a\$(FITZ_LIB):" \
        -e "\$a\\\t\$(QUIET_LINK) \$(CC) \$(LDFLAGS) --shared -Wl,-soname -Wl,${my_soname} -Wl,--no-undefined -o \$@ \$^ \$(LIBS)" \
        -e "/^FITZ_LIB :=/s:=.*:= build/release/${my_soname}:" \
        ${S}/Makefile

    # we don't include CJK fonts to make binary more slim
    # comment out following two lines if you need support for CJK
    sed -i 's:^\t\$.GENDIR./font_cjk.c::g' ${S}/Makefile
}

do_compile() {
    cd ${S}
    unset CFLAGS LDFLAGS
    export PKG_CONFIG_PATH=${STAGING_LIBDIR_NATIVE}/pkgconfig
    oe_runmake build=release build/release
    oe_runmake build=release build/release/cmapdump LD="${BUILD_CC}" CFLAGS="-I${S}/pdf -I${S}/fitz -I${STAGING_INCDIR_NATIVE}" LDFLAGS="-L${STAGING_LIBDIR_NATIVE} -Wl,-rpath-link,${STAGING_LIBDIR_NATIVE}" CC=${BUILD_CC}
    oe_runmake build=release build/release/fontdump LD="${BUILD_CC}" CFLAGS="-I${S}/pdf -I${S}/fitz -I${STAGING_INCDIR_NATIVE}" LDFLAGS="-L${STAGING_LIBDIR_NATIVE} -Wl,-rpath-link,${STAGING_LIBDIR_NATIVE}" CC=${BUILD_CC}

    cd ${S}
    export PKG_CONFIG="pkg-config"
    export PKG_CONFIG_PATH=${STAGING_LIBDIR}/pkgconfig
    oe_runmake build=release XCFLAGS="-fpic"
}

do_install() {
    cd ${S}
    oe_runmake DESTDIR="${D}" install build=release
    install -d ${D}${datadir}/applications
    install -d ${D}${datadir}/pixmaps
    install -d ${D}${includedir}
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${S}/debian/mupdf.xpm ${D}/${datadir}/pixmaps/
    install -m 0644 ${S}/debian/mupdf.desktop ${D}${datadir}/applications/
    install -m 0644 ${S}/pdf/mupdf-internal.h ${D}${includedir}/
    install -m 0644 ${S}/fitz/fitz-internal.h ${D}${includedir}/
    install -m 0644 ${S}/xps/muxps-internal.h ${D}${includedir}/
    install -m 0644 ${S}/debian/mupdf.pc ${D}${libdir}/pkgconfig

    ln -s ${LEAD_SONAME} ${D}${libdir}/libfitz.so
}

FILES_${PN}-dev += "${includedir}"

