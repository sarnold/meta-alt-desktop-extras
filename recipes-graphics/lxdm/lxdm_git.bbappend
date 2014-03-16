FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://xserver-lxdm \
"

DEPENDS_prepend = "virtual/libintl intltool-native "

DEPENDS += " iso-codes "

inherit update-rc.d pkgconfig

INITSCRIPT_NAME = "xserver-lxdm"
INITSCRIPT_PARAMS_${PN}-init = "defaults 40"

CFLAGS_append = " -fno-builtin-fork -fno-builtin-memset -fno-builtin-strstr "

EXTRA_OECONF += " --enable-gtk3=no --enable-password=yes --with-x -with-xconn=xcb "

do_patch_extra() {
    cp ${STAGING_DATADIR}/gettext/po/Makefile.in.in ${S}/po/
}

addtask do_patch_extra before do_configure after do_patch

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/xserver-lxdm ${D}${sysconfdir}/init.d/

    sed -i -e '/# session=/a session=/usr/bin/openbox-session' \
        ${D}${sysconfdir}/lxdm/lxdm.conf

    sed -i -e '/# bg=/a bg=/usr/share/backgrounds/rpi/fancy-pi.jpg' \
        ${D}${sysconfdir}/lxdm/lxdm.conf
}

PACKAGES =+ " lxdm-init "

RDEPENDS_${PN}-init += " xserver-common (>= 1.30) xinit "

PROVIDES += " lxdm-init "
RPROVIDES_${PN}-init = " lxdm-init "
RPROVIDES_${PN}-init += " xserver-nodm-init "
RREPLACES_${PN}-init += " xserver-nodm-init "
RCONFLICTS_${PN}-init += " xserver-nodm-init "

FILES_${PN}-init = "${sysconfdir}/init.d"

pkg_postinst_${PN}-init () {
if test "x$D" != "x"; then
    exit 1
else
    # Register lxdm as default DM
    mkdir -p ${sysconfdir}/X11/
    echo "${sbindir}/lxdm" > ${sysconfdir}/X11/default-display-manager
fi
}

