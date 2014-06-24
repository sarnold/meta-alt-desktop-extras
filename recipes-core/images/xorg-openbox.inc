XSERVER = " \
    packagegroup-core-x11 \
    packagegroup-core-x11-utils \
    packagegroup-fonts-truetype-core \
    libx11-locale \
    libxi \
    libxtst \
    xserver-xf86-config \
    xorg-minimal-fonts \
    xkeyboard-config \
    setxkbmap \
    xkbcomp \
    xmodmap \
    xrdb \
    rgb \
    xprop \
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
    gdk-pixbuf-loader-ico \
    gdk-pixbuf-loader-bmp \
    gdk-pixbuf-loader-ani \
    gdk-pixbuf-xlib \
    gtk-theme-clearlooks \
    gtk-theme-crux \
    gtk-theme-mist \
    clearlooks-theme-enable \
    gnome-icon-theme \
    gnome-icon-theme-enable \
    hicolor-icon-theme \
    xcursor-transparent-theme \
    pyxdg \
    xdg-utils \
    obconf \
    tint2 \
    lxdm-init \
    x11vnc \
"

IMAGE_INSTALL += "\
    ${XSERVER} \
    ${WINDOW_MANAGER} \
"

