VIRTUAL-RUNTIME_xserver_common = "x11-common"

# not sure yet if this needs an alternate like lxdm or not
VIRTUAL-RUNTIME_graphical_init_manager = "lxdm-init"

XSERVER = " \
    packagegroup-core-x11-base \
    packagegroup-core-x11 \
    packagegroup-fonts-truetype-core \
    libxi \
    libxtst \
    libx11-locale \
    xorg-minimal-fonts \
    gdk-pixbuf-loader-ico \
    gdk-pixbuf-loader-bmp \
    gdk-pixbuf-loader-ani \
    gdk-pixbuf-xlib \
    xkbcomp \
    xmodmap \
    xrdb \
    setxkbmap \
    xterm \
"

WINDOW_MANAGER = " \
    openbox \
    openbox-config \
    openbox-core \
    openbox-theme-bear2 \
    openbox-theme-clearlooks \
    openbox-theme-onyx \
    openbox-backgrounds \
    libcanberra-gtk2 \
    gtk-theme-clearlooks \
    gtk-theme-crux \
    gtk-theme-mist \
    clearlooks-theme-enable \
    gnome-icon-theme \
    gnome-icon-theme-enable \
    hicolor-icon-theme \
    pyxdg \
    xdg-utils \
    obconf \
    tint2 \
    lxdm \
"

IMAGE_INSTALL += "\
    ${XSERVER} \
    ${WINDOW_MANAGER} \
"

