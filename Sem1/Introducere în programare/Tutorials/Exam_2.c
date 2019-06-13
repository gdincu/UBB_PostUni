#include<stdio.h>

// Curata ecranul
void Curata() 
{ 
    system("@cls||clear"); 
} 

// Citeste n
int Citire_n(int *a)
{
start:
Curata();
printf("Introduceti un numar par:");
scanf("%d",a);
if(*a%2!=0) goto start;
}

// Definim structura de 2 nr intregi global
struct nume_structura
{
int nume_membru_1;
int nume_membru_2;
};

// Verfica daca al 2lea element este palindrom si mai mare ca 10
int Palindrom(int a)
{
int reversedInteger = 0, remainder, originalInteger;
originalInteger = a;

while( a!=0 )
    {
    remainder = a%10;
    reversedInteger = reversedInteger*10 + remainder;
    a /= 10;
	}

	// palindrome if orignalInteger and reversedInteger are equal
    if (originalInteger == reversedInteger)
    return 1;
}


int main()
{
int count,_a,_b,_c,z;
struct nume_structura vector[99][99],sort_diag1[99],sort_diag2[99],aux[99];

Citire_n(&count);

// Cere elementele matricei
for(_a=0;_a<count;_a++)	
		for(_b=0;_b<count;_b++)
		{
			printf("Elementul %d-%d este:",_a,_b);
			scanf("%d%d", &vector[_a][_b].nume_membru_1, &vector[_a][_b].nume_membru_2);
		}

// Afiseaza matricea intiala
printf("\n\nMatricea este:\n\n");
for(_a=0;_a<count;_a++)
	{	
		for(_b=0;_b<count;_b++)
		{
			printf(" (%d,%d)", vector[_a][_b].nume_membru_1, vector[_a][_b].nume_membru_2);
		}
		printf("\n");
	}

	
// Insereaza elementele de pe diagonala principala (de la stanga la dreapta) intr-un alt vector
for(_a=0;_a<count;_a++)	
		for(_b=0;_b<count;_b++)
		{
		if(_a==_b) 
			{
			sort_diag1[_b].nume_membru_1=vector[_a][_b].nume_membru_1;
			sort_diag1[_b].nume_membru_2=vector[_a][_b].nume_membru_2;
			}
		}

// Afiseaza elementele vectorului de sortare pt elem de pe diagonala principala
printf("\nElementele de pe diagonala principala sunt: ");
for(_b=0;_b<count;_b++)
	printf(" (%d,%d)",sort_diag1[_b].nume_membru_1,sort_diag1[_b].nume_membru_2);

// Sorteaza elementele vectorului de sortare pt elem de pe diagonala principala
for(_b=0;_b<count;_b++)
	for(_c=_b+1;_c<count;_c++)
	{
		if (sort_diag1[_b].nume_membru_1<sort_diag1[_c].nume_membru_1)
		{
		aux[_b].nume_membru_1=sort_diag1[_b].nume_membru_1;
		aux[_b].nume_membru_2=sort_diag1[_b].nume_membru_2;
		
		sort_diag1[_b].nume_membru_1=sort_diag1[_c].nume_membru_1;
		sort_diag1[_b].nume_membru_2=sort_diag1[_c].nume_membru_2;

		sort_diag1[_c].nume_membru_1=aux[_b].nume_membru_1;
		sort_diag1[_c].nume_membru_2=aux[_b].nume_membru_2;
		}
	}

printf("\nElementele sortate de pe diagonala principala sunt: ");
for(_b=0;_b<count;_b++)
	printf(" (%d,%d)",sort_diag1[_b].nume_membru_1,sort_diag1[_b].nume_membru_2);


// Insereaza elementele de pe diagonala secundara (de la stanga la dreapta) intr-un alt vector
for(_a=count;_a>=0;_a--)	
		for(_b=count;_b>=0;_b--)
		{
		if(_a+_b==count-1) 
			{
			sort_diag2[count-_b-1].nume_membru_1=vector[_b][_a].nume_membru_1;
			sort_diag2[count-_b-1].nume_membru_2=vector[_b][_a].nume_membru_2;
			}
		}

		
// Afiseaza elementele vectorului de sortare pt elem de pe diagonala secundara
printf("\nElementele de pe diagonala secundara sunt: ");		
for(_b=0;_b<count;_b++)
	printf(" (%d,%d)",sort_diag2[_b].nume_membru_1,sort_diag2[_b].nume_membru_2);
	
	
// Sorteaza elementele vectorului de sortare pt elem de pe diagonala secundara
for(_b=0;_b<count;_b++)
	for(_c=_b+1;_c<count;_c++)
	{
		if (sort_diag2[_b].nume_membru_1<sort_diag2[_c].nume_membru_1)
		{
		aux[_b].nume_membru_1=sort_diag2[_b].nume_membru_1;
		aux[_b].nume_membru_2=sort_diag2[_b].nume_membru_2;
		
		sort_diag2[_b].nume_membru_1=sort_diag2[_c].nume_membru_1;
		sort_diag2[_b].nume_membru_2=sort_diag2[_c].nume_membru_2;

		sort_diag2[_c].nume_membru_1=aux[_b].nume_membru_1;
		sort_diag2[_c].nume_membru_2=aux[_b].nume_membru_2;
		}
	}

printf("\nElementele sortate de pe diagonala secundara sunt: ");		
for(_b=0;_b<count;_b++)
	printf(" (%d,%d)",sort_diag2[_b].nume_membru_1,sort_diag2[_b].nume_membru_2);
	
// Afiseaza pozitia elementelor care a doua componenta numar palindrom mai mare decat 10
printf("\n\n");
for(_a=0;_a<count;_a++)	
		for(_b=0;_b<count;_b++)
		{
			if( (Palindrom(vector[_a][_b].nume_membru_2)==1) && (vector[_a][_b].nume_membru_2>10))
				printf("\nElementul de pe pozitia (%d,%d) este palindrom si mai mare ca 10.",_a,_b);
		}



return 0;
}