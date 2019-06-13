#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
#include<string.h>

struct Person {
	char *name;
	int age;
	int height;
	int weight;
};

struct Person *Person_create(char *name, int age, int height, int weight)
{
	struct Person *who=malloc(sizeof(struct Person));
	assert(who != NULL);
	
	// who->name=strdup(name);
	who->name=name;
	who->age=age;
	who->height=height;
	who->weight=weight;
	
return who;
}

void Person_destroy(struct Person *who)
{
	assert(who != NULL);
	
	free(who->name);
	free(who);
}

void Person_print(struct Person *who)
{
	printf("Name: %s\n", who->name);
	printf("\tAge: %d\n", who->age);
	printf("\tHeight: %d\n", who->height);
	printf("\tWeight: %d\n", who->weight);
}

int main(int argc, char *argv[])
{
	// make 2 structures
	struct Person *joe=Person_create("Joe Alex",32,64,140);
	struct Person *frank=Person_create("Frank Sex",32,64,140);
	
	// print them out & where they're in memory
	printf("Joe is at location %p:\n",joe);
	Person_print(joe);
	printf("Frank is at location %p:\n",frank);
	Person_print(frank);
	
	// make everyone age 20 yrs and print again
	joe->age += 20;
	joe->height -=2;
	joe->weight+=40;
	
	printf("Joe is at location %p:\n",joe);
	Person_print(joe);
	
	// destroy both records to clean up memory
	Person_destroy(joe);
	Person_destroy(frank);
	
	return 0;
}