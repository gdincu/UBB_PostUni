import java.util.Scanner;

public class SistemEcuatii {
	public static int citInt(String sir){
		System.out.print(sir);
		try {
			Scanner scn = new Scanner(System.in);		//citire sir si parsare
			int l=scn.nextInt();						//in long
			return l;
		}
		catch(Exception exp) {
			System.out.println("Ai gresit!! Da numar intreg!");
			return citInt(sir);							//apel recursiv pe orice eroare
		}
				        
	} 
	
  public static void Citeste(Rational r){
	   int numar= citInt("da numarator:");
	   int numit= citInt("da numitor  :");
	   r.setA(numar);
	   r.setB(numit);
	   
  }
  public static void Afiseaza(Rational r)
	 { if(r.esteZero())
		  System.out.print(0);
	   else
		   if (r.numitorUnu())
			   System.out.print(r.getA());
		   else 
			   System.out.print(r.getA()+"/"+r.getB());
	 }	
  public static void AfisEcuatie(Rational A,Rational B, Rational C){
	  Afiseaza(A);
	  System.out.print("X+");
	  if(B.getB()<0)System.out.print("\b");
	  Afiseaza(B);         
	  System.out.print("Y=");
	  Afiseaza(C);System.out.println();
	  
  }
  public static Rational Determinant(Rational A, Rational B, Rational C, Rational D){
	   Rational AOriD=new Rational();
	   AOriD.Ori(A,D);					//AOriD=A*D;
	   Rational BOriC=new Rational();	
	   BOriC.Ori(B,C);					//BOriC=B*C;
	   Rational Minor=new Rational();
	   Minor.Minus(AOriD,BOriC);		//Minor=A*D-B*C
	   return Minor;
  }
  public static void RezolvaSistem(){
	   Rational a=new Rational(1,2);
	   Rational b=new Rational(1.3);
	   Rational c=new Rational(7.2);
	   Rational d=new Rational(1,2);
	   Rational e=new Rational(1.3);
	   Rational f=new Rational(7.1);
	   System.out.println("sistemul de 2 ecuatii cu 2 necunoscute:");
	   AfisEcuatie(a,b,c);
	   AfisEcuatie(d,e,f);
	   System.out.println();
	   
	   Rational Delta=new Rational();
	   Delta=Determinant(a,b,d,e);
	   System.out.print("delta=");Afiseaza(Delta);System.out.println();
	   
	   Rational Dx=new Rational();
	   Dx=Determinant(c,b,f,e);
	   System.out.print("deltaX=");Afiseaza(Dx); System.out.println();
	   
	   Rational Dy=new Rational(a);
	   Dy=Determinant(a,c,d,f);
	   
	   System.out.print("deltaY=");Afiseaza(Dy); System.out.println();

	   if (!Delta.esteZero())
	      { Rational x= new Rational(Dx);
	        x.ImparteLa(Delta);
	        Rational y= new Rational(Dy);
	        y.ImparteLa(Delta);
	        System.out.print("x=");Afiseaza(x);System.out.println();
	        System.out.print("y=");Afiseaza(y);System.out.println();
	       }
	   else if (Dx.esteZero() && Dy.esteZero())
	             System.out.println("sistem nedeterminat");
	        else System.out.println("sistem incompatibil");  
	   System.out.println("Program terminat");
  }
  public static int AfisMeniu(){
	  System.out.println("1.Verifica metode aritmetice");
	  System.out.println("2.Rezolva sistem");
	  System.out.println("0.Terminare program");
	  return citInt("Optiunea ta:");
  } 
  public static void main(String aa[])
  {int Opt =AfisMeniu();
   Rational A=new Rational();
   Rational B=new Rational();
   Rational S=new Rational();
   while(Opt!=0){
	   switch(Opt){
	    case 1: System.out.println("primul   rational");Citeste(A);
	    		System.out.println("al 2-lea rational");Citeste(B);
		        S.Plus(A,B);
		        Afiseaza(A);System.out.print(" + ");Afiseaza(B);System.out.print("=");
	   			Afiseaza(S);System.out.println();
	   			Rational SS= new Rational();
	   			SS=Rational.Plus1(A,B);				//Plus1 este metoda a clasei
	   			Afiseaza(A);System.out.print(" + ");Afiseaza(B);System.out.print("=");
	  			Afiseaza(SS);System.out.println();
	   			S.Minus(A,B);
	   			Afiseaza(A);System.out.print(" - ");Afiseaza(B);System.out.print("=");
	   			Afiseaza(S);System.out.println();
	   			S.Ori(A,B);
	   			Afiseaza(A);System.out.print(" * ");Afiseaza(B);System.out.print("=");
	   			Afiseaza(S);System.out.println();
	   			S.Imparte(A,B);
	   			Afiseaza(A);System.out.print(" / ");Afiseaza(B);System.out.print("=");
	   			Afiseaza(S);System.out.println();
	   			break;
	    case 2: RezolvaSistem();
	            break;
	    default:System.out.println("Da optiune valida!!");        
	   }
	   Opt=AfisMeniu();
   }
   System.out.println("Program terminat");
   
         
   }
  
 }
