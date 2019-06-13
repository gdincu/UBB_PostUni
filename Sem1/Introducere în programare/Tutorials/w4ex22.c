//Afisati in ordine inversa caracterele dintr-un vector de caractere

#include<stdio.h>
int main()
{
char a[7]={'a','b','c','d','e','f','g'};
int b=3,count=6;
for (count; count>=0; count--)
{
	printf("%c\n",a[count]);
}
}