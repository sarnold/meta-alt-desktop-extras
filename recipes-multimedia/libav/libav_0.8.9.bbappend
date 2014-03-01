FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
# Don't forget to bump PRINC if you update the extra files.
PRINC := "${@int(PRINC) + 1}"

DEPENDS =+ " gnutls "

TARGET_CFLAGS =+ " -fPIC -DPIC "
TARGET_LDFAGS =+ " -lvorbis "

EXTRA_OECONF =+ " --enable-version3 --enable-pic --disable-static --enable-gnutls"
