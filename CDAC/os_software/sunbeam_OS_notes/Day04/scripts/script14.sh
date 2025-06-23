#!/bin/bash

#----------------------------------
#	Aim : Array
#----------------------------------

# declaration	:	arr=(10 20 30 40 50)

#	${arr[@]}	:	all elements of array
#	${#arr[@]}	:	number of elements in array

#	${arr[$i]}	:	ith index element of the array

#	${arr[@]:m}	:	elements of array from m index
#	${arr[@]:m:n}	:	n elements of array from m index


arr=(10 20 30 40 50)

echo "All elements of array : ${arr[@]}"
echo "Number of elements : ${#arr[@]}"

echo -n "Array using while loop : "
i=0
while [ $i -lt ${#arr[@]} ]
do
	echo -n " ${arr[$i]}"
	i=`expr $i + 1`
done
echo ""

echo -n "Array using for each : "
for element in ${arr[@]}
do
	echo -n " $element"
done
echo ""

echo "2nd index onwards : ${arr[@]:2}"
echo "2nd index onwards 2 elements : ${arr[@]:2:2}"











