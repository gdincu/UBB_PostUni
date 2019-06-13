//Afisati cifrele dintr-un vector de n caractere

#include<stdio.h>
#include<ctype.h>

int main()
{
char a[7]={'0','b','22','d','e','f','1'};
int b=3,count=0;
for (count; count<=6; count++)
{
	if (isdigit(a[count])) printf("%c\n",a[count]);
}
}