#include<stdio.h>
int main(int argc, char *argv[])
{
	int areas[] = { 10, 12, 13, 14, 20 };
	// char name[]="Zed";
	char name[]="Zed";
	char full_name[]={
		'G','a','b',
		' ','D','.',' ',
		'D','i','n','c','u','\0'
	};
printf("\n");	
printf("The size of an int: %ld\n", sizeof(int));
printf("The size of areas (int[]): %ld\n", sizeof(areas));
printf("The number of ints in areas: %ld\n", sizeof(areas) / sizeof(int));
printf("The 1st area is %d, the 2nd %d.\n", areas[0], areas[1]);

printf("\n");
printf("The size of a char is %d.\n", sizeof(char));
printf("The size of name (char[]): %ld.\n", sizeof(name));
printf("The number of chars: %ld.\n", sizeof(name) / sizeof(char));
printf("%d",name[4]);

printf("\n\n");
printf("The size of full_name (char[]): %ld.\n", sizeof(full_name));
printf("The number of chars: %ld.\n", sizeof(full_name)/sizeof(char));

printf("\n");
printf("name=\"%s\" and full_name=\"%s\"\n", name, full_name);

}