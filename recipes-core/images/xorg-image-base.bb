DESCRIPTION = "A small Xorg openbox image for small boards (eg, RaspberryPi, BeagleBoneBlack, etc)."
LICENSE = "MIT"
PR = "r0"

require console-image-base.bb

# example set in local.conf, not sure if this is kosher here
EXTRA_IMAGE_FEATURES = "x11 x11-base"

IMAGE_FEATURES += "${EXTRA_IMAGE_FEATURES}"

include xorg-openbox.inc

export IMAGE_BASENAME = "xorg-image-base"
