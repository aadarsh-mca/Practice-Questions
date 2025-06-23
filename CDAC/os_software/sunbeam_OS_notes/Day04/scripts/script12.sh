#!/bin/bash

#----------------------------------
#	Aim : 
#----------------------------------

num=5


i=1
# while [ $i -le 10 ]
# while (( i <= 10 ))
while [[ i -le 10 ]]
do
	#echo $(( $i * $num ))
	echo $(( i * num ))
	i=`expr $i + 1`
done





















