include recipes-core/images/rpi-console-image.bb

DESCRIPTION = "A custom openbox image based on rpi-console-image"
PR = "r7"

DISTRO_FEATURES += " x11 "
IMAGE_FEATURES += " x11 x11-base "

PACKAGECONFIG_mpd = "mad lame id3tag"
PACKAGECONFIG_libav = "bzip2 jack mp3lame x264"
PACKAGECONFIG_openbox = "imlib2 xrandr xcursor startup-notification"
PACKAGECONFIG_vim = "acl gtkgui x11"

include xorg-openbox.inc

export IMAGE_BASENAME = "rpi-xorg-image"
