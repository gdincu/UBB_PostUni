{1. Enunt.
    Se da o secventa de numere intregi, sa se sorteze recursiv
}



program SeleRec;                    {Sortare cresc cu BuleSort recursiv}

type SirNat = array [1..100] of  integer;


procedure Swap(var a,b:integer);
var Y:integer;
begin
    Y:=a;
    a:=b;
    b:=Y;
end;

procedure BulREc(n:integer; var X:SirNat; Ok:boolean; i:integer);
begin
   if(i<n)
      then
        begin
          if(X[i]>X[i+1])
               then
                 begin
                   Swap(X[i],X[i+1]);
                   Ok:=false;
                 end;
          BulRec(n,X,Ok,i+1);
       end
   else
    if(ok=false)
       then BulRec(n,X,true,1);
end;


var  X : sirnat;   {tablou ce contine numerele date; are cel mult 100 numere}
     n,            {n=Lungimea lui X}
     i : integer;
     Ok: boolean;
begin
    writeln;
    write('dati lungimea sirului:'); readln(n);
    for i:=1 to n do readln(x[i]);
    Ok:=true;
    BulRec(n,X,Ok,1);
    writeln('Secventa sortata este:');
    for i:=1 to n do write(X[i]:5);
    readln
end.

