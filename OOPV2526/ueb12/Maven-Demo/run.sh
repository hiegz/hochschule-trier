#!/bin/bash

mvn exec:java -Dexec.mainClass="Main" -Dexec.args="$1 $2 $3"
