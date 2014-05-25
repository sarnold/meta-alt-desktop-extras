FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF = "--program-prefix= --with-x --without-freetype --without-perl --disable-openmp --without-xml --disable-opencl"
