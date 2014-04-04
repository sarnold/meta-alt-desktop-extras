# extra compilers and other developer tools

IMAGE_INSTALL_append_raspberrypi = " \
    wiringpi \
    rpio \
    rpi-gpio \
    gnat-gcc-bin \
"

IMAGE_INSTALL += " \
    diffutils \
    erlang \
    vala \
    lua \
    vala-dbus-binding-tool \
    python-docutils \
    python-pyserial \
    python-pyusb \
    guile \
    bison \
    flex \
    yasm \
    gdb \
"
