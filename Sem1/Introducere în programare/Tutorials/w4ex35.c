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

int min=a[0][0];
int max=a[0][0];
// Afisarea max/min elementelor de pe diagonala principala
for (int i=0; i<counta; i++)
	for(int j=0; j<countb; j++)
	{
		if(i==j)
			{
			if (a[i][j]>max) max=a[i][j];
			if (a[i][j]<min) min=a[i][j];
			}
	}
printf("\nMinimul de pe diagonala principala este %d.",min);
printf("\nMaximul de pe diagonala principala este %d.",max);



printf("\n\n");
min=a[counta][countb];
max=a[counta][countb];
// Afisarea max/min elementelor de pe diagonala secundara
for (int i=0; i<counta; i++)
	for(int j=0; j<countb; j++)
	{
		if (i+j == counta-1)
			{	
			if (a[i][j]>max) max=a[i][j];
			if (a[i][j]<min) min=a[i][j];
			}
	}
printf("\nMinimul de pe diagonala secundara este %d.",min);
printf("\nMaximul de pe diagonala secundara este %d.",max);

}