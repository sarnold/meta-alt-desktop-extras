## base console apps for new image recipe structure

IMAGE_INSTALL_append_raspberrypi = " \
    bcm2835-tests \
    rpiuser-account \
"

IMAGE_INSTALL_append_beaglebone = " \
    xuser-account \
"

IMAGE_INSTALL += " \
    gzip \
    bzip2 \
    tar \
    cpio \
    file \
    sysfsutils \
    coreutils \
    findutils \
    dosfstools \
    ntfsprogs \
    i2c-tools \
    avahi-utils \
    udev-cache \
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
    mc \
"

EXTRA_TIMEZONES = " \
    tzdata-africa \
    tzdata-americas \
    tzdata-antarctica \
    tzdata-arctic \
    tzdata-asia \
    tzdata-atlantic \
    tzdata-australia \
    tzdata-europe \
    tzdata-misc \
    tzdata-pacific \
    tzdata-posix \
    tzdata-right \
"

IMAGE_INSTALL += "\
    ${EXTRA_TIMEZONES} \
"

