FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://mpd "

DEPENDS = "alsa-lib libsamplerate0 libsndfile1 libvorbis libogg faad2 curl sqlite bzip2"

PACKAGECONFIG[ffmpeg] = "--enable-ffmpeg,--disable-ffmpeg,ffmpeg"
PACKAGECONFIG[pulseaudio] = "--enable-pulse,--disable-pulse,pulseaudio"

inherit update-rc.d

INITSCRIPT_NAME = "mpd"
INITSCRIPT_PARAMS = "defaults 75"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/mpd ${D}${sysconfdir}/init.d/

    chown mpd:mpd ${D}/${localstatedir}/lib/mpd

    install -d ${D}${sysconfdir}/default/volatiles
    echo "d mpd mpd 0775 ${localstatedir}/run/mpd none" \
        > ${D}${sysconfdir}/default/volatiles/99_mpd
    echo "d mpd mpd 0775 ${localstatedir}/log/mpd none" \
        >> ${D}${sysconfdir}/default/volatiles/99_mpd
}

pkg_postinst_${PN}_append () {
sed -i -e "s|log/mpd|log/mpd/mpd|" $D${sysconfdir}/mpd.conf
chown mpd:mpd $D${localstatedir}/lib/mpd
}

FILES_${PN} += "${sysconfdir}/init.d/* /var/*"
