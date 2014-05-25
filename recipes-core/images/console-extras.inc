## extra console apps for new image recipe structure

IMAGE_INSTALL_append_raspberrypi = " \
    bcm2835-tests \
    rpiuser-account \
"

IMAGE_INSTALL_append_beaglebone = " \
    xuser-account \
"

IMAGE_INSTALL += " \
    avahi-utils \
    shadow \
    udev-utils \
    encodings \
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
    mc \
    zip \
    gzip \
    bzip2 \
    tar \
    cpio \
    file \
    links \
    irssi \
    tzdata \
    ntp \
    ntpdate \
    ntp-utils \
    gnuplot \
    perl-module-socket \
    perl-module-getopt-std \
    usbutils \
    sysfsutils \
    findutils \
    dosfstools \
    nfs-utils \
    cifs-utils \
    ntfsprogs \
    i2c-tools \
    strace \
    lsof \
    git \
    lirc \
    lirc-exec \
    lirc-remotes \
    lirc-x \
    bluez-hcidump \
    bluez4-agent \
    wpa-supplicant \
    jack-server \
    jack-utils \
    fluidsynth \
    sox \
    "
