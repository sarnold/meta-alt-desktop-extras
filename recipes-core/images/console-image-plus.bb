DESCRIPTION = "A custom console image based on core image"
PR = "r2"

include recipes-core/images/core-image-minimal.bb

EXTRA_IMAGE_FEATURES = "debug-tweaks"

IMAGE_FEATURES += " ssh-server-openssh splash package-management hwcodecs \
    ${EXTRA_IMAGE_FEATURES} "

# Include modules in rootfs
IMAGE_INSTALL += " \
    ${CORE_IMAGE_BASE_INSTALL} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    kernel-modules \
    libcgroup \
"

include console-extras.inc
include developer-extras.inc

export IMAGE_BASENAME = "console-image-plus"
