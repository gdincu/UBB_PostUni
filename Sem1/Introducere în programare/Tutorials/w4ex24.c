//Afisati literele mari dintr-un vector de n caractere

#include<stdio.h>
#include<ctype.h>


int main()
{
char a[7]={'0','B','2','d','E','f','1'};
int b=3,count=0;
for (count; count<=6; count++)
{
	if (isalpha(a[count]) && isupper(a[count])) printf("%c\n",a[count]);
}
}