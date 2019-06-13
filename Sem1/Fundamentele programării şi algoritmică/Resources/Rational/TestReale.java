import java.util.Scanner;
public class TestReale {

	public static long citLong(String mesaj){
		System.out.print(mesaj);
		try {
			Scanner scn = new Scanner(System.in);		//citire sir si parsare
			long l=scn.nextLong();				//in long
			return l;
		}
		catch(Exception exp) {
			System.out.println("Ai gresit!! Da numar intreg!");
			return citLong(mesaj);				//apel recursiv pe orice eroare
		}
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
	public static long AfisMeniu(){
	   System.out.println();
	   System.out.println("1.Verificare constructor din real");
	   System.out.println("2.Citire sir de rationale");
	   System.out.println("3.Afisare sir de rationale");
	   System.out.println("4.Determinare maxim din sir");
	   System.out.println("5.Sortare sir");
	   System.out.println("0.terminare program");
	   long Opt=   citLong("optiunea dvs:");			//return citLong("   ");
	   return Opt;
	} 
    public static Rational Maxim(Rational s[], long L){
       Rational max=new Rational(s[0]);
       for(int i=0;i<L;i++)
    	   if(s[i].maiMare(max)) max=s[i];
       return max;
    }
    public static void Sortare(Rational s[], long n){
    	boolean ok;
    	Rational aux;
    	do{ok=true;
    	   for(int i=0;i<n-1; i++)
    		   if(s[i].maiMare(s[i+1]))
    				   { aux   =s[i];
    				     s[i]  =s[i+1];
    				     s[i+1]=aux;
    				     ok=false;
    				   }
    		
    	} 
    	while (!ok);
    }
	public static void main (String args[]){
	   long a=0,b=0,n=0;
	   
	   Rational sir[]= new Rational[5];
	   
	   Rational maxim= new Rational();
	   long Op= AfisMeniu();
	   while(Op!=0){
		   switch((int)Op) {
		   		case 1: Rational r=new Rational(1.55);
		   				Afiseaza(r);
		           	    break;
		        case 2: n=citLong("lungime=");
		        		for(int i=0;i<n;i++){
		        		   a=citLong("numarator:");
		        		   b=citLong("numitor  :");
		        		   sir[i]=new Rational(a,b);
		        		}			        	    
		           	    break;
		        case 3: System.out.print("\nSirul:");
		        		for(int i=0;i<n;i++){
		        			Afiseaza(sir[i]); 
		        			System.out.print(";  ");
		        		}
		        		System.out.println();
		        		break;
		        case 4: maxim=Maxim(sir,n);
		        		System.out.print("Maximul=");
		                Afiseaza(maxim);
		                
		                break;
		        case 5: Sortare(sir,n);
		        	
		        	    break;
		        
			    default:
			        		System.out.println("Ai gresit optiunea, mai incearca");
			   }
			   Op=AfisMeniu();
		   }
		   System.out.println("Program terminat");  
	}              
}

	  
	  
	  
	  
		


