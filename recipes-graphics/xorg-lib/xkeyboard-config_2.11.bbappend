ILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# workaround for xkb rules change from evdev to base (kills cursor keys)
EXTRA_OECONF =+ "--enable-compat-rules"

