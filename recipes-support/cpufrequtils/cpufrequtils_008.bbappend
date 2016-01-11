FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://init file://defaults file://cpufreq-init.sh"

do_install_append() {
    if ! ${@base_contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${sbindir}
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/default
        install -T -m 0755 ${WORKDIR}/cpufreq-init.sh ${D}${sbindir}/cpufreq-init.sh
        install -T -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/cpufrequtils
        install -T -m 0644 ${WORKDIR}/defaults ${D}${sysconfdir}/default/cpufrequtils
    fi
}

INITSCRIPT_NAME = "cpufrequtils"
INITSCRIPT_PARAMS_${PN}-init = "defaults 50"

PACKAGES =+ "cpufrequtils-init"

RDEPENDS_${PN}-init += "cpufrequtils"

FILES_${PN} += "${sbindir}/cpufreq-init.sh"
FILES_${PN}-init = "${sysconfdir}/init.d/* ${sysconfdir}/default/*"

