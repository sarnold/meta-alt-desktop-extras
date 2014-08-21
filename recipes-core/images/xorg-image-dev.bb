DESCRIPTION = "A developer X desktop image for small boards (eg, RaspberryPi, BeagleBoneBlack, etc)."
LICENSE = "MIT"
PR = "r0"

require xorg-image-desktop.bb

# example set in local.conf, not sure if this is kosher here
EXTRA_IMAGE_FEATURES += "tools-sdk tools-debug eclipse-debug"

include developer-extras.inc

export IMAGE_BASENAME = "xorg-image-dev"
