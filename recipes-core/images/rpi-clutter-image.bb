DESCRIPTION = "A custom image with support for the Open GL-based toolkit \
Clutter, based on core-image."

# this shouldn't be required, but seems to be now...
include recipes-core/images/rpi-hwup-image.bb

# core-image bbclass provides core-boot and base packages
inherit core-image

IMAGE_FEATURES += "package-management ssh-server-dropbear splash"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    packagegroup-core-clutter-core \
    nano \
    userland \
    cpufrequtils \
    connman-tests \
"

# core-image bbclass provides core-boot and base packages
inherit core-image
