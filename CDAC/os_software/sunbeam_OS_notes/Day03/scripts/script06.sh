#!/bin/bash

#----------------------------------
#	Aim : String conditionals 
#----------------------------------

#	=	: true if both strings are equal
#	!=	: true of both strings are not equal

#	-z $str	: true if str is empty
#	-n $str : true if str is not empty

echo -n "Enter string : "
read str

if [ -z $str ]
then
	echo "String is empty"
	exit
fi

rstr=`echo $str | rev`

if [ $str = $rstr ]
then
	echo "$str is palindrome"
else
	echo "$str is not palindrome"
fi






















