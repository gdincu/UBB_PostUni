//Afisati consoanele dintr-un sir de n caractere
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

printf("Lista consoanelor din vector este:");
for(int i=0;i<5;i++)
	{
		if (a[i]>=65 && a[i]<=90) 
		{ 
		if (a[i]!=65 && a[i]!=69 && a[i]!=73 && a[i]!=79 && a[i]!=85)
			{printf(" %c",a[i]);}
		}

		if (a[i]>=97 && a[i]<=122) 
		{ 
		if (a[i]!=65+32 && a[i]!=69+32 && a[i]!=73+32 && a[i]!=79+32 && a[i]!=85+32)
			{printf(" %c",a[i]);}
		}
	}

}