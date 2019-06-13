x = 0
sum = 0
count=0

print("Suma tutoror numerelor pare divizibile cu 3 si cate dintre ele sunt divizibile cu 4.")
print ("----------------------------------------------------------")
print("Introduceti 0 pentru a termina programul.")

print("X este: ")
x=input()

if (x==0): 
	print("Suma tuturor numerelor introduse pare divizibile cu 3 este 0")
	print("Au fost introduse 0 numere divizibile cu 4.")

while (x):
	if(x%2==0 & x%3==0):
		sum+=x;
	if(x%4==0):
		count+=1;
	print("X este: ")
	x=input()


print("Suma tuturor numerelor introduse pare divizibile cu 3 este ")
print (sum)
print("Au fost introduse ")
print(count)
print( "numere divizibile cu 4.")
