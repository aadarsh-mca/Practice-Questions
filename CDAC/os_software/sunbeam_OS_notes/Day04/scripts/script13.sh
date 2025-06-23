#!/bin/bash

#----------------------------------
#	Aim : Count files of current directory
#----------------------------------

count=0

for entry in `ls`
do
	if [ -f $entry ]
	then
		count=`expr $count + 1`
	fi
done

echo "File count = $count"






















