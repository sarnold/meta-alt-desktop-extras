FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://wpa_supplicant.conf"

do_install_append() {
    install -d ${D}${sysconfdir}
    rm -f ${D}${sysconfdir}/wpa_supplicant.conf
    install ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/
}
