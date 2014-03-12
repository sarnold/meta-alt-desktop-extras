DESCRIPTION = "A custom console image based on core image"
PR = "r1"

include recipes-core/images/core-image-minimal.bb

EXTRA_IMAGE_FEATURES = "debug-tweaks"

IMAGE_FEATURES += " ssh-server-openssh splash package-management hwcodecs \
    ${EXTRA_IMAGE_FEATURES} "

# more settings in rpi-xorg-image
PACKAGECONFIG_mpd = "mad lame id3tag"
PACKAGECONFIG_libav = "bzip2 jack mp3lame x264"
PACKAGECONFIG_sox = "alsa mad id3tag lame"
PACKAGECONFIG_fluidsynth = "jack sndfile"

# Include modules in rootfs
IMAGE_INSTALL += " \
    ${CORE_IMAGE_BASE_INSTALL} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    kernel-modules \
"

include console-extras.inc
include developer-extras.inc

export IMAGE_BASENAME = "console-image-plus"
