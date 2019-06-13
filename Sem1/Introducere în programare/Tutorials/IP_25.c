//Afisati vocalele dintr-un sir de n caractere
#include<stdio.h>
int main()
{
char a[5];
char vow[10]={'A','E','I','O','U','a','e','i','o','u'};

for(int i=0;i<5;i++)
	{
	printf("Introduceti un caracter:");
	scanf(" %c", &a[i]);
	}

printf("Lista vocalelor din vector este:");
for(int i=0;i<5;i++)
	{
		for(int b=0;b<10;b++)
			{
			if (a[i]==vow[b])
			{
			printf(" %c",vow[b]);
			}
		}
	}

}