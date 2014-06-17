Yocto  and OpenEmbedded Layer - meta-alt-desktop-extras
=======================================================

This is a miscellaneous software overlay for the meta-oe and poky,
tested on RaspberryPi and BeagleBoneBlack devices.  It can be used
with openembedded-core or poky (master branch), but not oe-classic.

More information can be found at:

http://www.raspberrypi.org/ (official RPi site)

https://github.com/sarnold/meta-alt-desktop-extras/wiki

This layer should work with different OpenEmbedded/Yocto distributions
and layer stacks, such as:

* Distro-less (only with OE-Core).
* Angstrom (main focus of upstream testing).
* Yocto/Poky (main focus of this fork; see Section 2 below).

and is tested locally with poky and meta-openembedded master branches.

This layer depends on::

 URI: git://git.yoctoproject.org/poky
 branch: master
 revision: HEAD

::

 URI: git://github.com/openembedded/meta-oe.git
 layers: see below
 branch: master
 revision: HEAD

How to use it:

1 source poky/oe-init-build-env rpi-build

2 Add needed layers to bblayers.conf:

  (for basic upstream hw image)

    - meta-raspberrypi
    - meta-openembedded/meta-oe

  (for xorg-openbox image)

    - meta-alt-desktop-extras
    - meta-openembedded/meta-gnome
    - meta-openembedded/meta-networking
    - meta-openembedded/meta-multimedia
    - meta-openembedded/meta-efl
    - meta-openembedded/meta-xfce

3 Set MACHINE to raspberrypi in local.conf

4 Set any other desired parameters in local.conf (see following sections)

5 bitbake [rpi-hwup-image|xorg-openbox-image|console-image-plus]

6 dd the .sdimg file to an SD card

7 Boot your RPi.
