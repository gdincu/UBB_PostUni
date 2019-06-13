#include<stdio.h>
int main()
{
char a[5];
int i;

for(i=0;i<=4;i++)
	{
	printf("%d - Introduceti un caracter:",i);
	scanf(" %c",&a[i]);
	// printf("Elementul %d este %c\n",i,a[i]);
	}

printf("\nLista elementelor in ordine inversa este: ");
for(int i=4;i>=0;i--)
	{
	printf("%c", a[i]);
	}

}