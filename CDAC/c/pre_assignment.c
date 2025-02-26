#include <stdio.h>

/**
 * 
 * 1.
 * area and circumference of circle
 * 
 */
// #define PIE 3.14

// float getArea(float);
// float getCircum(float);

// int main() {
//     float radius, area, circum;
//     printf("\nEnter the radius : ");
//     scanf("%f", &radius);

//     printf("\nArea of circle is %.2f", getArea(radius));
//     printf("\nCircumference of circle is %.2f", getCircum(radius));

//     return 0;
// }

// float getArea(float radius) {
//     return (PIE * radius * radius);
// }

// float getCircum(float radius) {
//     return (2 * PIE * radius);
// }


/**
 * 
 * 2.
 * Display ASCII of char
 * 
 */
// int main() {
//     char ch;

//     printf("\nEnter a char : ");
//     scanf("%c", &ch);

//     printf("\nASCII of %c is %d", ch, (int)ch);
//     return 0;
// }


/**
 * 
 * 3.
 * Total and Percentage of Marks of 5 Subject
 * 
 */
// int main() {
//     float maths, science, hindi, english, marathi;

//     printf("\nEnter the marks of each subject in this order (math, science, hindi, english, marathi) :");
//     scanf("%f %f %f %f %f", &maths, &science, &hindi, &english, &marathi);

//     printf("\nTotal marks out of 500 is : %.2f", (maths + science + hindi + english + marathi));
//     printf("\nPercent is : %.2f", (maths + science + hindi + english + marathi) / 500 * 100);

//     return 0;
// }


/**
 * 
 * 4.
 * Basic Salary after deduction
 * 
 */
// float getNetSalary(int);

// int main() {
//     int salary;
    
//     printf("\nEnter your basic salary : ");
//     scanf("%d", &salary);

//     float netSalary = getNetSalary(salary);
//     printf("\nYour net salary will be : %.2f", netSalary);

//     return 0;
// }

// float getNetSalary(int salary) {
//     float netSalary = salary;

//     // add 2% PF
//     netSalary += (salary * 0.02);

//     // deduct 3% TAX
//     netSalary -= (salary * 0.03);

//     // add 5% HRA
//     netSalary += (salary * 0.05);

//     // add 8% DA
//     netSalary += (salary * 0.08);

//     return netSalary;
// }


/**
 * 
 * 5.
 * Swapping numbers using
 *   i.  3 variable
 *  ii.  without third vairable
 * 
 */
// void swap(int*, int*);
 
// int main() {
//     int num1, num2;

//     printf("\nEnter 2 numbers (num1, num2) : ");
//     scanf("%d %d", &num1, &num2);

//     swap(&num1, &num2);
//     printf("\nAfter swapping : num1 = %d, num2 = %d", num1, num2);

//     num1 = num1 + num2;
//     num2 = num1 - num2;
//     num1 = num1 - num2;
//     printf("\nAfter swapping : num1 = %d, num2 = %d", num1, num2);

//     return 0;
// }

// void swap(int* num1, int* num2) {
//     int temp = *num1;
//     *num1 = *num2;
//     *num2 = temp;
// }


/**
 * 
 * 6. 
 * 
 * 
 */