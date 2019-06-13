//Afisati cifrele dintr-un vector de n caractere (ASCII 48-57)

#include<stdio.h>

int main()
{
char a[7]={'0','b','2','d','e','f','1'};
int count=0, var;
for (count; count<7; count++)
{
	var=a[count];
	if(var>=48 && var<=57) 
	printf("%c\n",a[count]);
}


}