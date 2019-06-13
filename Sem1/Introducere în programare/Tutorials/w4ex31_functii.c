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
		printf("%d%",a[i][j]);
		}
		printf("\n");
	}
return;
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

}