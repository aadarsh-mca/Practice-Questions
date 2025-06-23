#!/bin/bash

#----------------------------------
#	Aim : Loop control structure
#----------------------------------

#	init
#	while [ condition ]		while condition is true
#	do							body will be executed
#		body
#		modification
#	done

#	init
#	until [ condition ]		until condition is true
#	do							body will be executed
#		body
#		modification
#	done

echo "Enter number : "
read num

i=1
# while [ $i -lt 11 ]
until [ $i -eq 11 ]
do
	echo `expr $i \* $num`
	i=`expr $i + 1`
done





















