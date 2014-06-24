DESCRIPTION = "A developer console image for small boards (eg, RaspberryPi, BeagleBoneBlack, etc)."
LICENSE = "MIT"
PR = "r0"

require console-image-base.bb

# example set in local.conf, not sure if this is kosher here
EXTRA_IMAGE_FEATURES = "tools-sdk tools-debug eclipse-debug"

IMAGE_FEATURES += "${EXTRA_IMAGE_FEATURES}"

include developer-extras.inc

export IMAGE_BASENAME = "console-image-dev"
