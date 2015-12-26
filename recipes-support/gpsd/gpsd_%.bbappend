FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
    if ! ${@base_contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        rm -rf ${D}/lib/systemd
    fi
}
