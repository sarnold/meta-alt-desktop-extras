DESCRIPTION = "A GTK-based stacked monitor program with a stand-alone daemon."
SECTION = "x11/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6aa4c0c48b808b45244efd507765e2b8"

SRC_URI = "http://members.dslextreme.com/users/billw/gkrellm/gkrellm-${PV}.tar.bz2"

require gkrellm.inc

PR = "${INC_PR}.1"

SRC_URI[md5sum] = "8ced6843f4681ad8501fd04285ecff1f"
SRC_URI[sha256sum] = "eae0a6862fe6131c67c2f8bca451b0410e69229a5a16463dd1f2266b3ff13dcb"
