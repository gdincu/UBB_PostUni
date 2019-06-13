// Afisati cifrele dintr-un vector de n caractere
#include<stdio.h>
int main()
{
char a[5];

for(int i=0;i<5;i++)
	{
	printf("Introduceti un caracter:");
	scanf(" %c", &a[i]);
	}

printf("Lista cifrelor din vector este:");
for(int i=0;i<5;i++)
	{
	if(a[i]>=48 && a[i]<=57) printf("%c ",a[i]);
	}

}