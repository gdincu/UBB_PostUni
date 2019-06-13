//Marimea vectorului este data de catre utilizator

#include <stdio.h>
int main()
{
	int i,count, a[i];;
	printf("\n\nCate elemente vreti sa aiba vectorul?: ");
	scanf("%d\n\n",&i);
	
	// printf("%d",i);
	
	for (count=0; count<i; count++)
	{	
	printf("Introduce elementul %d: ",count);
	scanf("%d\n",&a[count]);
	// printf("%d\n",a[count]);
	}
	
	for (count=1; count<=i; count++)
	{	
	printf("%d\n",a[count]);
	}
	
}