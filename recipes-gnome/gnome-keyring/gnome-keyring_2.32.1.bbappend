FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATH =. "${@base_set_filespath(["${THISDIR}/${PN}"], d)}:"

#SRC_URI += "file://egg-asn1x.patch"

