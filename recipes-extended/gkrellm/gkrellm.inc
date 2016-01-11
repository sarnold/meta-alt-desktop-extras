SECTION = "x11/utils"
DESCRIPTION = "GKrellM is a GTK-based stacked monitor program."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6aa4c0c48b808b45244efd507765e2b8"

INC_PR = "r2"

SRC_URI += " \
	file://gkrellmd \
	file://gkrellmd.conf \
"

inherit pkgconfig update-rc.d

INITSCRIPT_PACKAGES = "${PN}-daemon"
INITSCRIPT_NAME_${PN}-daemon = "gkrellmd"
INITSCRIPT_PARAMS_${PN}-daemon = "defaults 26"

DEPENDS = "gtk+ glib-2.0 libsm libice"

EXTRA_OEMAKE = "TARGET= 'CC=${CC}' 'STRIP=' INSTALLROOT='/usr'"

export LINK_FLAGS = "${LDFLAGS}"
export SMC_LIBS = "-lSM -lICE -lX11 -lgmodule-2.0 -lm"

do_configure_prepend() {
	sed -i -e "s|getline|gkrellm_getline|" ${S}/src/client.c

	sed -e 's:-O2 ::' \
		-e 's:override CC:CFLAGS:' \
		-e 's:-L/usr/X11R6/lib::' \
		-i */Makefile || die "sed Makefile(s) failed"
}

do_install () {
	oe_runmake 'INSTALLDIR=${D}${bindir}' \
		'SINSTALLDIR=${D}${bindir}' \
		'MANDIR=${D}${mandir}/man1' \
		'SMANDIR=${D}${mandir}/man1' \
		'INCLUDEDIR=${D}${includedir}' \
		'PKGCONFIGDIR=${D}${libdir}/pkgconfig' \
		'LOCALEDIR=${D}${datadir}/locale' \
		'STRIP=' \
		install

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/gkrellmd ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/gkrellmd.conf ${D}${sysconfdir}

	mkdir -p ${D}${sbindir}
	mv ${D}${bindir}/gkrellmd ${D}${sbindir}/
	find ${D} -name true | xargs rm -f
}

PROVIDES += "gkrellm-daemon"

PACKAGES =+ "gkrellm-daemon-dbg gkrellm-daemon"

FILES_${PN}-daemon-dbg = "${sbindir}/.debug"
FILES_${PN}-daemon = "${sysconfdir}/gkrellmd.conf ${sbindir} \
  ${sysconfdir}/init.d/gkrellmd \
"

CONFFILES_${PN}-daemon = "${sysconfdir}/gkrellmd.conf"

