#!/bin/bash

#----------------------------------
#	Aim : Take file path from user and check execute permissions
#----------------------------------

echo -n "Enter filepath : "
read filepath

if [ -e $filepath -a -x $filepath ]
then
	echo "file has execute permissions"
else
	echo "file does not exist or file don't have execute permissions"
fi




















