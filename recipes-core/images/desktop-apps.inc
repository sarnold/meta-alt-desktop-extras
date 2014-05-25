DESKTOP_APPS = " \
    imagemagick \
    gkrellm \
    vim \
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
    geany \
    gnuplot-x11 \
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
    ${DESKTOP_APPS} \
    ${DEJAVU_FONTS} \
    ${EXTRA_TIMEZONES} \
"

