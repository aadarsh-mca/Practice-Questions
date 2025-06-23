#!/bin/bash

#----------------------------------
#	Aim : Calculate area of rectangle
#----------------------------------

# area = length * bredth

echo "Enter length and bredth of rectangle : "
read le br

# command substitution
#	- result is substituted at the place command
#	- this is done by any one way out of two
#		`command`
#		$(command)

area=`expr $le \* $br`

echo "Area of rectangle = $area"
























