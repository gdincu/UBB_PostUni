//Afisati literele mari dintr-un vector de n caractere (ASCII 65-90)

#include<stdio.h>
int main()
{
char a[7]={'0','B','2','d','E','f','1'};
int b=3,count=0,var;
for (count; count<=6; count++)
{
	var=a[count];
	if (var>=65 && var<=90) printf("%c\n",a[count]);
}
}