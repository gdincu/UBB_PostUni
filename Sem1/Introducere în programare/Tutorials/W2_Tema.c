#include<stdio.h>
int main()
{
	int numar,div,i=0;
	printf("Introduceti un numar: ");
	scanf("%d",&numar);
	printf("\n");
	char c[numar];
		
	for(div=1; div<=numar; div++)
	{if(numar%div==0) 
	printf("%d este divizor al lui %d.\n",div,numar);
	//c[div]=div;
	}
	
	printf("\n%d are urmatorii divizori: ",numar);
	for(div=1; div<=numar; div++)
		if(numar%div==0) printf("%d ",div);
}