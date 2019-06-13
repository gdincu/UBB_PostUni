#include<stdio.h>

int main(int argc, char *argv[])
{
	// create 2 arrays
	int ages[]={ 23, 43, 12,89, 2};
	char *names[]={"Alan", "Frank", "Marry", "John", "Lisa"};
	
	// get the size ages
	int count=sizeof(ages)/sizeof(int);
	
	// 1st way of using indexing
	int i=0;
	for (i;i<count;i++)
	{
		printf("%s has %d years.\n",names[i],ages[i]);
	}
	
	printf("----------------------------------------------------------\n");
	
	// set up the pointers to the start of the arrays
	int *cur_age=ages;
	char **cur_name=names;
	int val=sizeof(cur_age);
	
	printf("%d",val);
	// 2nd way using pointers
	for (i=0;i<count;i++)
	{
		printf("%s is %d years old.\n",*(cur_name + i), *(cur_age + i) );
	}
	
	printf("----------------------------------------------------------\n");
	
	// 3rd way - pointers are just arrays
	for(i=0;i<count;i++)
	{
		printf("%s is %d years old again.\n",cur_name[i],cur_age[i]);
	}
	
	printf("----------------------------------------------------------\n");
	
	// 4th way with pointers in a stupid complex way
	for(cur_name=names, cur_age=ages; (cur_age - ages) < count; cur_name++, cur_age++)
	{
		printf("%s lived %d years so far.\n",*cur_name,*cur_age);
	}
	
	return 0;
}