#include<stdio.h>
int a[99][99];

void CereValori (int m, int n)
{
	int i,j;
	for (i=0;i<m;i++)
		for (j=0;j<n;j++)
		{
			printf("Elementul %d al randului %d este: ",j,i);
			scanf("%d",&a[i][j]);
		}
	return;
}

void AfiseazaValori (int m, int n)
{
	int i,j;
	for (i=0;i<m;i++)
	{
		for (j=0;j<n;j++)
		{
		printf("%d",a[i][j]);
		}
		printf("\n");
	}
return;
}

int SumaLinie(int m, int n)
// Afișarea sumei elementelor ale fiecărei linii
{
	int i,j,_sumLpare,_sumLimpare;
	for(i=0;i<=m-1;i++)
	{		
	_sumLpare=0;
	_sumLimpare=0;
	for (j=0;j<n;j++)
	{
	if(a[i][j] % 2 == 0) _sumLpare+=a[i][j];
		else _sumLimpare+=a[i][j];
	}
	printf("Suma elementelor pare ale liniei %d sunt: %d.\n",i+1,_sumLpare);
	printf("Suma elementelor impare ale liniei %d sunt: %d.\n",i+1,_sumLimpare);
	}
}

int SumaColoana(int m, int n)
// Afișarea sumei elementelor ale fiecărei linii
{
	int i,j,_sumLpare,_sumLimpare;
	for(j=0;j<=n-1;j++)
	{		
	_sumLpare=0;
	_sumLimpare=0;
	for (i=0;i<m;i++)
	{
	if(a[i][j] % 2 == 0) _sumLpare+=a[i][j];
		else _sumLimpare+=a[i][j];
	}
	printf("Suma elementelor pare ale coloanei %d sunt: %d.\n",j+1,_sumLpare);
	printf("Suma elementelor impare ale coloanei %d sunt: %d.\n",j+1,_sumLimpare);
	}
}


int main()
{
int m,n;
printf("Cate randuri sa aiba matricea: ");
scanf("%d",&m);	
printf("Cate coloane sa aiba matricea: ");
scanf("%d",&n);	

CereValori(m,n);
AfiseazaValori(m,n);
SumaLinie(m,n);
SumaColoana(m,n);

}