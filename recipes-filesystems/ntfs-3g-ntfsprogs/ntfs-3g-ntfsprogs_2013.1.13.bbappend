FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


PACKAGECONFIG = "uuid"

PROVIDES += "ntfs-3g"
RDEPENDS_${PN}-dev = "ntfs-3g"

