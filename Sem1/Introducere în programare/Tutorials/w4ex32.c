//Afisarea sumei elementelor pare/impare ale fiecarei linii/coloane a unei matrici n*n

#include<stdio.h>
int main()
{
	int m,n,counta,countb,countsum=0,_sumLpare,_sumLimpare,_sumCpare,_sumCimpare,linie=0,coloana=0,count_a,count_b;
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

//Calculeaza suma elementelor fiecarei linii
	for(count_a=0;count_a<=counta-1;count_a++)
	{		
	_sumLpare=0;
	_sumLimpare=0;
	for (count_b=0;count_b<countb;count_b++)
	{
	if(a[count_a][count_b] % 2 == 0) _sumLpare+=a[count_a][count_b];
		else _sumLimpare+=a[count_a][count_b];
	}
	printf("Suma elementelor pare ale coloanei %d sunt: %d.\n",count_b+1,_sumLpare);
	printf("Suma elementelor impare ale coloanei %d sunt: %d.\n",count_b+1,_sumLimpare);
	}

printf("\n\n");
//Calculeaza suma elementelor fiecarei coloane
	for(count_b=0;count_b<=countb-1;count_b++)
	{		
	_sumCpare=0;
	_sumCimpare=0;
	for (count_a=0;count_a<counta;count_a++)
	{
		if(a[count_a][count_b] % 2 == 0) _sumCpare+=a[count_a][count_b];
		else _sumCimpare+=a[count_a][count_b];
	}
	printf("Suma elementelor pare ale liniei %d sunt: %d.\n",count_b+1,_sumCpare);
	printf("Suma elementelor impare ale liniei %d sunt: %d.\n",count_b+1,_sumCimpare);
	}

		
printf("\n\n");
}