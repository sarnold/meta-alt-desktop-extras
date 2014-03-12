FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://ntpd.init"

inherit useradd

EXTRA_OECONF += "--enable-linuxcaps"

do_configure_prepend() {
    sed -i -e 's|NTPSERVERS=""|NTPSERVERS="pool.ntp.org"|' \
        ${WORKDIR}/ntpdate.default

    sed -i \
        -e "s|etc/ntp.drift|var/lib/ntp/ntp.drift|" \
        -e "s|time.server.example.com|0.gentoo.pool.ntp.org|" \
        -e "s|server 127|#server 127|" \
        -e "s|fudge 127|#fudge 127|" \
        ${WORKDIR}/ntp.conf
}

do_install_append() {
    rm -rf ${D}/lib
    install -d ${D}${localstatedir}/lib/ntp ${D}${sysconfdir}/init.d
    chown ntp:ntp ${D}${localstatedir}/lib/ntp
    install -T -m 0755 ${WORKDIR}/ntpd.init ${D}${sysconfdir}/init.d/ntpd
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/lib/ntp \
    --groups uucp \
    --user-group ntp"

FILES_${PN} += "${localstatedir}/lib/ntp"
