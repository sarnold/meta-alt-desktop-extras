FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS =+ " gnutls "

TARGET_CFLAGS =+ " -fPIC -DPIC "
TARGET_LDFAGS =+ " -lvorbis "

EXTRA_OECONF =+ " --enable-version3 --enable-pic --disable-static --enable-gnutls"
