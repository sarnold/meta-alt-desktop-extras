DESCRIPTION = "A GTK-based stacked monitor program with a stand-alone daemon."
SECTION = "x11/utils"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=6aa4c0c48b808b45244efd507765e2b8"

SRC_URI = "http://members.dslextreme.com/users/billw/gkrellm/gkrellm-${PV}.tar.bz2 \
           file://gkrellm-2.3.5-autofs.patch \
           file://gkrellm-2.3.5-binding.patch \
           file://gkrellm-2.3.5-cifs.patch \
           file://gkrellm-2.3.5-config.patch \
           file://gkrellm-2.3.5-dso.patch \
           file://gkrellm-2.3.5-format-security.patch \
           file://gkrellm-2.3.5-sansfont.patch \
           file://gkrellm-2.3.5-width.patch \
"

require gkrellm.inc

PR = "${INC_PR}.1"

SRC_URI[md5sum] = "e43a9416a6975e3be63d591bdeb33b04"
SRC_URI[sha256sum] = "702b5b0e9c040eb3af8e157453f38dd6f53e1dcd8b1272d20266cda3d4372c8b"
