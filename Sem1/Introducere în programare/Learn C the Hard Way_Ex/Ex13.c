#include<stdio.h>
int main (int argc, char *argv[])
{
int i=0;

//goes through each string in the argv
for (i=1; i<argc; i++) {
printf("arg %d: %s\n", i, argv[i]);
}

//creates and array of strings
char *states[] = {"C1", "C2", "C3", "C4", "C5"};

int num_states=sizeof(states)-1;

for(i=0; i<num_states; i++) {
printf("state %d: %s\n", i, states[i]);
}

return 0;
}