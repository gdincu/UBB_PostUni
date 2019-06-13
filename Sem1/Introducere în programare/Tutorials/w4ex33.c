//Afisarea sumei elementelor pare/impare ale fiecarei linii/coloane a unei matrici n*n

#include<stdio.h>
int main()
{
	int m,n,counta,countb;
	int a[99][99];

//Cere numarul de linii si coloane
	printf("Introduceti nr de linii: ");
	scanf("%d", &m);
	printf("Introduceti nr de coloane: ");
	scanf("%d", &n);
	printf("\n\n");
	
	
//Cere valorile fiecarui element al matricei
	for (counta=0;counta<m;counta++)
		for (countb=0;countb<n;countb++)
		{
			printf("Elementul %d al randului %d este: ",countb,counta);
			scanf("%d",&a[counta][countb]);
		}
	
		
//Afiseaza matricea
	printf("\n\n\nMatricea este: \n");
	for (counta=0;counta<m;counta++)
		{
			for (countb=0;countb<n;countb++)
			{
				printf("%d ",a[counta][countb]);
			}
		printf("\n");
		}

printf("\n\n");

// Afisarea elementelor de pe diagonala principala
for (int i=0; i<counta; i++)
	for(int j=0; j<countb; j++)
	{
		if(i==j) printf ("%d",a[i][j]);
	}

printf("\n\n");

// Afisarea elementelor de pe diagonala secundara
for (int i=0; i<counta; i++)
printf("%d",a[i][countb-1-i]);

}