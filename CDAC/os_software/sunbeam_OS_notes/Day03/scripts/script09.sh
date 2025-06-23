#!/bin/bash

#----------------------------------
#	Aim : selection control structure 
#----------------------------------

#	case $choice in
#	1)
#		...
#		;;
#	2)
#		...
#		;;
#	*)
#		...
#		;;
#	esac

echo -n "Enter two numbers : "
read num1 num2

echo -e "1. Add\n2. Sub\n3. Div\n4. Mul"
echo "Enter your choice : "
read choice

case $choice in
1)
	echo `expr $num1 + $num2`
	;;

2)
	echo `expr $num1 - $num2`
	;;

3)
	echo `expr $num1 / $num2`
	;;

4)
	echo `expr $num1 \* $num2`
	;;
*)
	echo "Invalid operation"
	;;
esac




















