#!/bin/bash

#----------------------------------
#	Aim : for loop 
#----------------------------------

#	for (( init ; cond ; mod ))
#	do
#		...
#	done

#	for varName in collection
#	do
#		...
#	done

echo -n "Enter number : "
read num

# for (( i = 1 ; i <= 10 ; i++ ))
# for i in 1 2 3 4 5 6 7 8 9 10
for i in `seq 10`
do
	echo `expr $i \* $num`
done



















