#include<stdio.h>
#include<ctype.h>

// forward declarations
int can_print_it(char ch);
void print_letters(char arg[]);

// Functia print_arguments
void print_arguments(int argc, char *argv[])
{
	int i=1;
	for(i;i<argc;i++)
	{
		print_letters(argv[i]);
	}
}

// Functia print_letters
void print_letters(char arg[])
{
	int i=0;
	for(i;arg[i]!='\0';i++)
	{
		char ch=arg[i];
		if(can_print_it(ch)) {
			printf("'%c' == %d",ch,ch);
		}
		printf("\n");
	}
}

// Functia can_print_it
int can_print_it(char ch)
{
	return isalpha(ch) || isblank(ch);
}

// Programul propiu-zis
int main(int argc, char *argv[])
{
	print_arguments(argc, argv);
	return 0;
}