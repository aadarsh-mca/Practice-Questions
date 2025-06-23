#!/bin/bash

#----------------------------------
#	Aim : sort files of different into different directories
#----------------------------------

#	=~
#		[[ op1 =~ op2 ]]
#	op1 - variable
#	op2 - regular expression

for file in `ls`
do
	if [ -f $file ]
	then
		if [[ $file =~ png$ ]]
		then
			mv $file d1
		elif [[ $file =~ mp4$ ]]
		then
			mv $file d2
		fi
	fi
done























