## base console apps for new image recipe structure

IMAGE_INSTALL_append_raspberrypi = " \
    bcm2835-tests \
    rpiuser-account \
"

IMAGE_INSTALL_append_beaglebone = " \
    xuser-account \
"

IMAGE_INSTALL += " \
    avahi-utils \
    udev-utils \
    encodings \
    shadow \
    sudo \
    bash \
    nano \
    zram \
    rsync \
    screen \
    gkrellm-daemon \
    cpufrequtils \
    cpufrequtils-init \
    python-shell \
    packagegroup-base-vfat \
    packagegroup-base-alsa \
    alsa-utils-speakertest \
    alsa-utils-amixer \
    mpd \
    mpc \
    empcd \
    lirc \
    lirc-exec \
    lirc-remotes \
    lirc-x \
    tzdata \
    ntp \
    ntpdate \
    ntp-utils \
    mc \
"
