#!/bin/bash

#----------------------------------
#	Aim : Automation of Package Installation 
#----------------------------------

packages=(ncal git gcc vim rename)

sudo apt-get update
if [ $? -ne 0 ]
then
	echo "sources list is not updated ???"
	exit
fi

echo "Sources list is updated successfully !!!"

for pkg in ${packages[@]}
do
	echo "$pkg is getting installed !!!"

	sudo apt-get -y install $pkg
	if [ $? -ne 0 ]
	then
		echo "$pkg is not installed ???"
	else
		echo "$pkg is installed successfully !!!"
	fi
done




















