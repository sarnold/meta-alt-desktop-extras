XSERVER = " \
    packagegroup-core-x11 \
    packagegroup-core-x11-base \
    packagegroup-fonts-truetype-core \
    libxi \
    libxtst \
    libx11-locale \
    xorg-minimal-fonts \
    gdk-pixbuf-loader-ico \
    gdk-pixbuf-loader-bmp \
    gdk-pixbuf-loader-ani \
    gdk-pixbuf-xlib \
    liberation-fonts \
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
"

DESKTOP_APPS = " \
    imagemagick \
    feh \
    mupdf \
    xchat \
    midori \
    vala-terminal \
    leafpad \
    leafpad-stock-icons \
    pidgin \
    gnome-bluetooth \
    pcmanfm \
    xfmpc \
    gkrellm-client \
    gst-meta-video \
    gst-meta-audio \
    imlib2-tests \
    imlib2-themes \
"

DEJAVU_FONTS = " \
    ttf-dejavu-sans \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-sans-mono \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
"

EXTRA_TIMEZONES = " \
    tzdata-africa \
    tzdata-americas \
    tzdata-antarctica \
    tzdata-arctic \
    tzdata-asia \
    tzdata-atlantic \
    tzdata-australia \
    tzdata-europe \
    tzdata-misc \
    tzdata-pacific \
    tzdata-posix \
    tzdata-right \
"

IMAGE_INSTALL += "\
    ${XSERVER} \
    ${WINDOW_MANAGER} \
    ${DESKTOP_APPS} \
    ${DEJAVU_FONTS} \
    ${EXTRA_TIMEZONES} \
"


