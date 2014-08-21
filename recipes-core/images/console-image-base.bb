DESCRIPTION = "An enhanced console image for small boards (eg, RaspberryPi, BeagleBoneBlack, etc)."
LICENSE = "MIT"
PR = "r0"

# example set in local.conf, not sure if this is kosher here
EXTRA_IMAGE_FEATURES = "debug-tweaks"

IMAGE_FEATURES += "splash package-management ssh-server-openssh hwcodecs ${EXTRA_IMAGE_FEATURES}"

#IMAGE_LINGUAS = "en-us"

inherit core-image

# Include modules in rootfs
IMAGE_INSTALL += " \
    kernel-modules \
    libcgroup \
"

include console-base.inc
include console-extras.inc

export IMAGE_BASENAME = "console-image-base"
