FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://limits.conf"

inherit useradd

do_install_append() {
    RT_DIR="${sysconfdir}/security/limits.d"
    install -d ${D}${RT_DIR}
    install ${WORKDIR}/limits.conf ${D}${RT_DIR}/40-realtime-base.conf
}

PROVIDES = "jack-server libjack"
RDEPENDS_${PN}-dev = "jack-server"

USERADD_PACKAGES = "jack-server"
GROUPADD_PARAM_jack-server = "-g 888 realtime"

FILES_jack-server += "${sysconfdir}/security"
