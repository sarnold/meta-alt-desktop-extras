include console-image-plus.bb

DESCRIPTION = "A custom openbox image based on console-image-plus.bb"
PR = "r1"

# base image features set in console-image-plus.bb
IMAGE_FEATURES_append = " x11 x11-base "

# see console-image-plus.bb for other recipe-specific PACKAGECONFIG tweaks
PACKAGECONFIG_openbox = "imlib2 xrandr xcursor startup-notification"
PACKAGECONFIG_libxfce4ui = "gladeui startup-notification"
PACKAGECONFIG_vim = "acl gtkgui x11"

# set the following parameters here (defaults in local.conf)
DEFAULT_TIMEZONE = "PST8PDT"

# for real-time audio support (includes RT_GROUP_SCHED)
KERNEL_ENABLE_CGROUPS = "1"

include xorg-openbox.inc

export IMAGE_BASENAME = "xorg-openbox-image"
