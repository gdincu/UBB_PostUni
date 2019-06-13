#include<stdio.h>

struct nume_structura
{
int nume_membru_1;
int nume_membru_2;
};

int verifica(int x)
{
int check=0;
for(int i=2;i<=x/2;i++)
{
	if(x%i==0)
	{
		check=1;
		break;
	}
}	
if(x==1) printf("%d",check);
if(check==0) printf("%d",check);
if(check==1) printf("%d",check);
}


int main()
{
int count;
struct nume_structura vector[99];

// Cere numarul de structuri
printf("Cate elemente sa aiba vectorul?:");
scanf("%d",&count);
printf("\n");

// Cere elementele vectorului
for(int i=0;i<count;i++)
scanf("%d%d", &vector[i].nume_membru_1, &vector[i].nume_membru_2);
printf("\n");

// Afiseaza vectorul intial
for(int i=0;i<count;i++)
printf("%d %d - ", vector[i].nume_membru_1, vector[i].nume_membru_2);
printf("\n");

// Verifica structurile care au nume_membru_1 numar prim si sterge structurile respective
for(int i=0;i<count;i++)
{
if(verifica(vector[i].nume_membru_1) == 0)
vector[i].nume_membru_1=0;
vector[i].nume_membru_2=0;
// verifica(vector[i].nume_membru_1); //Folosite sa verificam daca functia returneaza valoarea corecta
// verifica(vector[i].nume_membru_2); //Folosite sa verificam daca functia returneaza valoarea corecta
}

// Afiseaza vectorul final
for(int i=0;i<count;i++)
printf("%d %d - ", vector[i].nume_membru_1, vector[i].nume_membru_2);
printf("\n");

}