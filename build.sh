#!/bin/bash
SCRIPT=$(realpath "$0")
SCRIPTPATH=$(dirname "$SCRIPT")
cd "$SCRIPTPATH"

mvn eclipse:eclipse \
    && mvn clean install \
    && $HOME/loadrc/gitrc/gci.sh
