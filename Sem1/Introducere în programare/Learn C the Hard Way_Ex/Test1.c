#include <assert.h>
#include <stdio.h>
int main () {
	
	int ages[]={ 23, 43, 12,89, 2};
	char *names[]={"Alan", "Frank", "Marry", "John", "Lisa"};
	
	int *pointer1=ages;
	char **pointer2=names;
	
	for(int i=0;i<5;i++)
		printf("%s\n",pointer2[i]);
	
	return 0;
}