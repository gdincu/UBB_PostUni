// Afișarea sumei elementelor pare/impare ale fiecărei linii/coloane a unei matrici m*n
#include<stdio.h>
int main()
{
int a[99][99];
int _a,_b,counta,countb;

printf("Introduceti nr de linii: ");
	scanf("%d", &counta);
	printf("Introduceti nr de coloane: ");
	scanf("%d", &countb);
	printf("\n\n");

for(_a=0;_a<counta;_a++)	
		for(_b=0;_b<countb;_b++)
		{
			printf("Elementul %d-%d este:",_a,_b);
			scanf("%d",&a[_a][_b]);
		}

printf("\n\nMatricea este:\n\n");
		
for(_a=0;_a<counta;_a++)
	{	
		for(_b=0;_b<countb;_b++)
		{
			printf(" %d",a[_a][_b]);
		}
		printf("\n");
	}

}