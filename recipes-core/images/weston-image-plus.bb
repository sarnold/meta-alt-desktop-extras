SUMMARY = "A basic Wayland image with some gtk apps"
LICENSE = "MIT"

inherit core-image distro_features_check

EXTRA_IMAGE_FEATURES = "debug-tweaks"

IMAGE_FEATURES += " ssh-server-openssh splash package-management hwcodecs \
    ${EXTRA_IMAGE_FEATURES} "

REQUIRED_DISTRO_FEATURES = "wayland"

# set the following parameters here
DEFAULT_TIMEZONE = "PST8PDT"

# for real-time audio support (includes RT_GROUP_SCHED)
KERNEL_ENABLE_CGROUPS = "1"

CORE_IMAGE_EXTRA_INSTALL += " \
    weston weston-init \
    weston-examples \
    gtk+3-demo \
    clutter-1.0-examples \
"

IMAGE_INSTALL += " \
    kernel-modules \
    libcgroup \
"

include console-extras.inc
include developer-extras.inc
include desktop-apps.inc

export IMAGE_BASENAME = "weston-image-plus"

