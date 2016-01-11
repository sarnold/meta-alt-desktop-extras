#!/bin/sh
#
# Copyright (c) 2014 Stephen Arnold <stephen.arnold42 _at_ gmail.com>
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)

echo "Applying the following cpufreq-set options to all cpus: ${@}"

for cpu in $(cpufreq-info -o | sed -n '/CPU/h; $x; $p' | cut -b6) ; do
    cpufreq-set -c ${cpu} ${@}
done
