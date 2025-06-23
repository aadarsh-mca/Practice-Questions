#!/bin/bash

#----------------------------------
#	Aim : Function
#----------------------------------

# define the function

#	function funName		funName()
#	{						{
#		...						...
#	}						}

#	function call:
#		funName arg1 arg2 arg3
#			$1	-	arg1
#			$2	-	arg2
#			$3	-	arg3
#			...

#	result of last echo statement will be returned from function

function addition
{
	# echo "Here"
	# echo "inside addition function"
	# num1 - $1
	# num2 - $2
	sum=`expr $1 + $2`
	echo $sum
}

# main script
echo "inside main script"
res=`addition 10 20`

echo "result = $res"





















