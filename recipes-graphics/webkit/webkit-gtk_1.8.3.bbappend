FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# workaround for bug #85076 (still open)
#   https://bugs.webkit.org/show_bug.cgi?id=85076

EXTRA_OECONF += " --disable-jit "
