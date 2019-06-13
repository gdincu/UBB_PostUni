//Afisati elementele multipli ai lui x dintr-un vector

#include<stdio.h>
int main()
{
int a[7]={1,2,3,4,5,6,7},b=3,count;
for (count; count<7; count++)
{
	if (a[count]%b==0) printf("%d\n",a[count]);
}
}