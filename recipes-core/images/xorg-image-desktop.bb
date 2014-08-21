DESCRIPTION = "A lightweight X desktop image for small boards (eg, RaspberryPi, BeagleBoneBlack, etc)."
LICENSE = "MIT"
PR = "r0"

require xorg-image-base.bb

include desktop-apps.inc

export IMAGE_BASENAME = "xorg-image-desktop"
