FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://consolekit "

inherit update-rc.d

INITSCRIPT_NAME = "consolekit"
INITSCRIPT_PARAMS = "defaults 10"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}

FILES_${PN} += "${sysconfdir}/init.d"

