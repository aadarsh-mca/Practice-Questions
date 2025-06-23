#!/bin/bash

#----------------------------------
#	Aim : Positional parameters
#----------------------------------

#	./script15.sh 10 sunbeam 3.142

#	$*	- all positional parameters
#			10 sunbeam 3.142

#	$#	- count of positional parameters
#			3

#	$i	-	ith positional parameter
#			$1 - 10 (1st param)
#			$2 - sunbeam	(2nd param)
#			$3 - 3.142	(3rd param)
#			....

#	$0	-	name of script
#			./script15.sh

#	$$	-	process ID of current bash

echo "Positional parameter : $*"
echo "Count of pos parameters : $#"

echo "1st param = $1"
echo "2nd param = $2"
echo "3rd param = $3"

echo "Name of script : $0"
echo "PID of bash : $$"

for param in $*
do
	echo $param
done






















