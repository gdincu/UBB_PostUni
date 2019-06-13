#include<stdio.h>
int main()
{
int a[5],b[5],i=0,j=0,count,bt,count_total;

printf("Cate elemente sa aiba primul vector?");
scanf("%d.\n",&i);
for (count=0; count<i; count++)
	{	
	printf("Introduce elementul %d: ",count);
	scanf("%d\n",&a[count]);
	}

for(j;j<=count;j++)
	printf("%d ",a[j]);

// printf("Al doile vector va avea %d elemente\n",j);
// scanf("%d",&j);
// int b[999];


// for (bt=0; bt<j; bt++)
	// {	
	// printf("Introduce elementul %d: ",bt);
	// scanf("%d\n",&a[bt]);
	// Conditia de iesire din FOR
	// if(a[bt]==a[bt-1]) break;
	// }

// count_total=count+bt;
// printf("%d",count_total);

// for (count=0; count<99999; count++)
	// {	
	// printf("%d
}