//Afisati vocalele dintr-un sir de n caractere

#include<stdio.h>

int main()
{
char a[7]={'A','z','2','d','E','f','i'};
char vow[10]={'A','E','I','O','U','a','e','i','o','u'};
int counta=0,countb=0;

for (counta; counta<7; counta++)
{
//printf("%c",a[counta]);
		for (countb=0; countb<10; countb++)
		{
			if (a[counta]==vow[countb])
			{
			printf("%c\n",vow[countb]);
			}
		}
}

}