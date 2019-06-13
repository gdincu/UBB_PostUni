// Curata ecranul
void Curata() 
{ 
    system("@cls||clear"); 
} 

// Afiseaza
void Afisare(int xx)
{
start:

Curata();

printf("Introdu o valoare: ");
scanf("%d",&xx);
if (xx<1) goto start;

for(int i = 0; i < xx; i++)
	{
	for(int j = i + 1; j < xx; j++)
    printf(" ");

	for(int j = 0; j <= 2*i; j++)
    printf("O");
printf("\n");
	}
}

