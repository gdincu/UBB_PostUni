#include<stdio.h>
int main()
{
int x,sum,count;
printf("Suma tutoror numerelor pare divizibile cu 3 si cate dintre ele sunt divizibile cu 4.\n");
printf("----------------------------------------------------------\n");
printf("Introduceti 0 pentru a termina programul.\n");

printf("X este: ");
scanf("%d", &x);
if (x==0) goto label1;


while(x)
{ 
if(x%2==0 & x%3==0) sum+=x;
if(x%4==0) count+=1;
printf("X este: ");
scanf("%d", &x);
}

label1: printf("Suma tuturor numerelor introduse pare divizibile cu 3 este %d.\n", sum);
printf("Au fost introduse %d numere divizibile cu 4.\n", count);
return 0;
}