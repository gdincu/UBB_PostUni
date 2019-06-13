
public class Rational
{ private long a;		//Specificatie: Rational=a/b ireductibile, a,b long (intregi)
  private long b;
  						//de aici incep accesorii
 public long getA() {
	return a;
}

public void setA(long a) {
	this.a = a;
	this.Simplifica();
}

public long getB() {
	return b;
}

public void setB(long b) {
	this.b = b;
	this.Simplifica();
}

public Rational()				//constructor implicit
 {a=0;
  b=1;
 }

public Rational(long a,long b)	//constructor cu 2 parametri
 {this.a=a;
  this.b=1;						//daca b==0 se pune pe 1
  if(b!=0) this.b=b;
  Simplifica();
 }
public Rational(long x)			//constructor din intreg, folosind alt constructor	
{this(x,1);							
}

 public Rational(Rational r)	//constructor de copiere, nu-i absolut necesar	
 {a=r.a;
  b=r.b;
 }

public Rational (double x){		//constructor din numar real
  long p=(long)x;
  long q=1;
  while(p!=x){
	  x*=10;
	  p=(long)x;
	  q*=10;
  }
  a=p;
  b=q;
  this.Simplifica();	
}

 public static long Cmmdc(long x,long y)	//metoda statica
 {if(x==0 && y==0)  return 0;
  if(x==0 && y>0)   return y;
  if(x>0  && y==0)  return x;
  if(x==y) 			return x;
  if (x>y) 			return Cmmdc(x-y,y);
  					return Cmmdc(x,y-x);
 }

 private void Simplifica()				//metoda private
 {long x=Math.abs(a),y=Math.abs(b);
  if(a*b>=0){							//se pune semnul fractiei la numarator
	      a=x;
	      b=y;
  }
  else {
	      a=-x;
	      b=y;
  }
  long temp=Cmmdc(x,y);					//se impart a si b cu temp>0
  if(temp>0){
	  a/=temp;
	  b/=temp;
  }
 }

 public void AdunaLa(Rational r)		// this <- this +r
 { a=a*r.b+b*r.a;				
   b=b*r.b;
   this.Simplifica();					//trebuie simplificat
 }
 
 public void Plus(Rational r1, Rational r2){//this <- r1+r2
	 a=r1.a;
	 b=r1.b;
	 this.AdunaLa(r2);
	 this.Simplifica();
 }
 
 public void ScadePe(Rational r)		//face this <- this - r
 {a=a*r.b-b*r.a;
  b=b*r.b;
  this.Simplifica();					//trebuie simplificat
 }

 public void Minus(Rational r1, Rational r2){//this <- r1-r2
	 a=r1.a;
	 b=r1.b;
	 this.ScadePe(r2);
	 this.Simplifica();
 }
 public void Inmulteste(Rational r)		//this <- this*r
 {a*=r.a;
  b*=r.b;
  this.Simplifica();					//trebuie simplificat
 }

 public void Ori(Rational r1, Rational r2){	//this <- =r1*r2
	 a=r1.a*r2.a;
	 b=r1.b*r2.b;
	 this.Simplifica();
 }
 
 public Rational Invers()				//retur rationalul invers
 {Rational aux=new Rational(b,a);
  aux.Simplifica();
  return aux;
 
 }
 
 public void ImparteLa(Rational r)		//this <- this /r
 {if(!r.esteZero()) 					//altfel ramane this
	 { this.Inmulteste(r.Invers());
	   this.Simplifica();
	 }
  else System.out.println("impartitor nul, Deimpartit acelasi");
  
  
 }
 
 public void Imparte(Rational r1,Rational r2)	//this <- r1 /r2
 { a=r1.a;
   b=r1.b;
   if(!r2.esteZero()){						//altfel  this <- r1
	   this.Inmulteste(r2.Invers()); 
       this.Simplifica();
   }
   else System.out.println("impartitor nul, Deimpartit acelasi");
	    
 }
 											//exemplu de operatie care apartine clasei...
 public  static Rational Plus1(Rational r1,Rational r2) //metoda statica a clasei
 {Rational z=new Rational(r1);			//nu se poate lucra cu this
  z.AdunaLa(r2);
  z.Simplifica();
  return z;
 }
 
 public boolean numitorUnu()			// daca numitorul  = 1 retur true
 { if (b==1) return true;
             return false;
 } 
 public boolean esteZero()				// daca numaratorul = 0 retur true
  { if (a==0) return true;
              return false;
  } 
 public boolean maiMare(Rational r){	//daca this>r retur true
	 if(a*r.b>b*r.a) 	return true;
	 					return false;
 }
}

