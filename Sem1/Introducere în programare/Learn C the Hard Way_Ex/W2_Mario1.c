#include<stdio.h>
int main()
{
int n=30,count,count_space,count_char;

printf("Cate randuri vreti sa aiba piramida? : ");
scanf("%d",&n);

for(count=1; count<=n; count++)
{
	for(count_space=(n-count); count_space>=0; count_space--)
	printf(" ");

	for(count_char=1; count_char<=count; count_char++)
	printf("#");

	printf(" ");

	for(count_char=1; count_char<=count; count_char++)
	printf("O");

	printf("\n");

}

}