DISTRO_FEATURES = "${DISTRO_FEATURES_DEFAULT} ${DISTRO_FEATURES_LIBC} ${POKY_DEFAULT_DISTRO_FEATURES} pam sysvinit opengl wayland"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "pulseaudio systemd"

LOCALE_UTF8_ONLY = "1"
IMAGE_LINGUAS = "en-us en-gb de-de fr-fr es-mx pt-br it-it"
#LIMIT_BUILT_LOCALES = "POSIX en_US en_GB de_DE fr_FR es_MX pt_BR it_IT"

COMMERCIAL_AUDIO_PLUGINS = "gst-plugins-ugly-mad gst-plugins-ugly-mpegaudioparse"
COMMERCIAL_VIDEO_PLUGINS = "gst-plugins-ugly-mpeg2dec gst-plugins-ugly-mpegstream gst-plugins-bad-mpegvideoparse"

