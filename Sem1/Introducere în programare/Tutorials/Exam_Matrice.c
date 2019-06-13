// sorteaza elemente matrice crescator/ descrescator pe linii sau pe coloane

#include<stdio.h>
int main()
{
int a[99][99];
int _a,_b,count,sort1,sort2,x;

// Cere nr de linii si coloane
printf("Introduceti nr de linii si coloane: ");
	scanf("%d", &count);
	printf("\n");

// Cere elementele matricei
for(_a=0;_a<count;_a++)	
		for(_b=0;_b<count;_b++)
		{
			printf("Elementul %d-%d este:",_a,_b);
			scanf("%d",&a[_a][_b]);
		}

// Afiseaza matricea intiala
printf("\n\nMatricea este:\n\n");
for(_a=0;_a<count;_a++)
	{	
		for(_b=0;_b<count;_b++)
		{
			printf(" %d",a[_a][_b]);
		}
		printf("\n");
	}

// Cere utilizatorului sa aleaga tipul de sortare
printf("\n\nDoriti sa sortati crescator(1) sau descrescator(2)?:");
scanf("%d",&sort1);
printf("Doriti sa sortati pe linii(1) sau pe coloane(2)?:");
scanf("%d",&sort2);
printf("\n");

// Sortare crescator pe linii
if(sort1==1 && sort2==1)
{
for(_a=0;_a<count;_a++) {
	for(_b=0;_b<count;_b++) {
		for(int j=_b+1;j<count;j++) {
		if(a[_a][_b]>a[_a][j]) {
			x=a[_a][_b];
			a[_a][_b]=a[_a][j];
			a[_a][j]=x;
								}
							}
						}
					}
}

// Sortare descrescator pe linii
if(sort1==2 && sort2==1)
{
for(_a=0;_a<count;_a++) {
	for(_b=0;_b<count;_b++) {
		for(int j=_b+1;j<count;j++) {
		if(a[_a][_b]<a[_a][j]) {
			x=a[_a][_b];
			a[_a][_b]=a[_a][j];
			a[_a][j]=x;
								}
							}
						}
					}
}

// Sortare crescator pe coloane
if(sort1==1 && sort2==2)
{
for(_b=0;_b<count;_b++) {
	for(_a=0;_a<count;_a++) {
		for(int j=_a+1;j<count;j++) {
		if(a[_a][_b]>a[j][_b]) {
			x=a[_a][_b];
			a[_a][_b]=a[j][_b];
			a[j][_b]=x;
								}
							}
						}
					}
}

// Sortare descrescator pe coloane
if(sort1==2 && sort2==2)
{
for(_b=0;_b<count;_b++) {
	for(_a=0;_a<count;_a++) {
		for(int j=_a+1;j<count;j++) {
		if(a[_a][_b]<a[j][_b]) {
			x=a[_a][_b];
			a[_a][_b]=a[j][_b];
			a[j][_b]=x;
								}
							}
						}
					}
}


// Afisare matrice dupa sortare
printf("\nMatricea sortata este:\n\n");
		
for(_a=0;_a<count;_a++)
	{	
		for(_b=0;_b<count;_b++)
		{
			printf(" %d",a[_a][_b]);
		}
		printf("\n");
	}

}