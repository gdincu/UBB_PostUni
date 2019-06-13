//Afisati valorile literelor si numerelor in ASCII

#include<stdio.h>
int main()
{
	int i;
	printf("\n\n");
	for (i='a';i<='z';i++)
	{
		printf("%c este %d\n",i,i);
	}
	printf("\n\n");
	for (i='A';i<='Z';i++)
	{
		printf("%c este %d\n",i,i);
	}
	printf("\n\n");
	for (i='0';i<='9';i++)
	{
		printf("%c este %d\n",i,i);
	}
	
}