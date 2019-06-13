{1. Enunt.
    Se da o secventa de numere intregi, sa se determine cea mai lunga
    subsecventa care are proprietatea P (numar par)




program SeleRec;                    {Sortare cresc cu Selectsort recursiv}

type SirNat = array [1..100] of  integer;


procedure Swap(var a,b:integer);
var Y:integer;
begin
    Y:=a;
    a:=b;
    b:=Y;
end;

procedure SelREc(n:integer; var X:SirNat; i,j:integer);{ la apel SelRec(n,X,1,2);}
begin
   if(i<n) 
     then
        begin
          if(j<=n)
            then begin
                   if(X[i]>X[j]) then Swap(X[i],X[j]);
                   SelRec(n,X,i,j+1);
                 end
            else SelRec(n,X,i+1,i+2);
        end;
end;

var  X : sirnat;   {tablou ce contine numerele date; are cel mult 100 numere}
     n,            {n=Lungimea lui X}
     i : integer;
begin
    writeln;
    write('dati lungimea sirului:'); readln(n);
    for i:=1 to n do readln(x[i]);
    SelRec(n,X,1,2);
    writeln('Secventa sortata este:');
    for i:=1 to n do write(X[i]:5);
    readln
end.

