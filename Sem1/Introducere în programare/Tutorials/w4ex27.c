//Citirea unei matrici patratice de n*n
//Afisarea unei matrici patratice de n*n

#include<stdio.h>
int main()
{
	int m,n,counta,countb;
	int a[99][99];
	
	printf("Introduceti nr de linii: ");
	scanf("%d", &m);
	printf("Introduceti nr de coloane: ");
	scanf("%d", &n);
	printf("\n\n");
	
//cere valorile fiecarui element al matricei
	for (counta=0;counta<m;counta++)
		for (countb=0;countb<n;countb++)
		{
			printf("Elementul %d al randului %d este: ",countb,counta);
			scanf("%d",&a[counta][countb]);
		}
	
//afiseaza matricea
	printf("\n\n\nMatricea este: \n");
	for (counta=0;counta<m;counta++)
		{
			for (countb=0;countb<n;countb++)
			{
				printf("%d",a[counta][countb]);
			}
		printf("\n");
		}
	
}