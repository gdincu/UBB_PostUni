//Marimea vectorului este variabila. Atribuirea elementelor vectorului se termina cand se introduc 2 numere identice unul dupa altul

#include <stdio.h>

int main()
{
	int i,count,count_impar=0,sum;
	int a[99999];
		
	for (count=0; count<99999; count++)
	{	
	printf("Introduce elementul %d: ",count);
	scanf("%d\n",&a[count]);
	
	// // // Calculeaza numarul de elemente impare
	if(a>0 & a[count]%2!=0) count_impar+=1;
	
	if(count%3==0 & a[count]%2==0) sum+=a[count];
	
	// Conditia de iesire din FOR
	if(a[count]==a[count-1]) break;
	}
	
	// // // Afiseaza nr de elemente si arata suma acestora
	
	// printf("\nVectorul are %d elemente.\n\n",count);
	// printf("Aceste elemente sunt: \n");
	
	// for(i=0; i<=count; i++) 
		// {
		// printf("%d ",a[i]);	
		// sum+=a[i];	
		// }
	
	// printf("\nSuma acestor elemente este: %d\n\n",sum);
	
printf("\nSunt %d elemente impare in vector.\n",count_impar);
printf("\nSuma elem pare de pe pozitii divizibile cu 3 este %d.\n",sum);

	
}