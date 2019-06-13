//Afisarea sumei elementelor pare/impare ale fiecarei linii/coloane a unei matrici n*n

#include<stdio.h>
int main()
{
	int m,n,counta,countb,min,max,linie=0,coloana=0,count_a,count_b;
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

//Min/Max de pe fiecare linie
	for(count_a=0;count_a<=counta-1;count_a++)
	{		
	max=0;
	min=2147483647;
	for (count_b=0;count_b<countb;count_b++)
	{
	if(a[count_a][count_b] > max) max=a[count_a][count_b];
	if(a[count_a][count_b] < min) min=a[count_a][count_b];
	}
	printf("Minimul de pe linia %d este: %d.\n",count_a+1,min);
	printf("Maximul de pe linia %d este: %d.\n",count_a+1,max);
	}

printf("\n\n");
	for(count_b=0;count_b<=countb-1;count_b++)
	{		
	max=0;
	min=2147483647;
	for (count_a=0;count_a<counta;count_a++)
	{
	if(a[count_a][count_b] > max) max=a[count_a][count_b];
	if(a[count_a][count_b] < min) min=a[count_a][count_b];
	}
	printf("Minimul de pe coloana %d este: %d.\n",count_b+1,min);
	printf("Maximul de pe coloana %d este: %d.\n",count_b+1,max);
	}

printf("\n\n");
}