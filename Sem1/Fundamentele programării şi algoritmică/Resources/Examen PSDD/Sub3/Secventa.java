
public class Secventa {
    private long S[];
    private int Lung;
    public Secventa(int lung) {    // constructor cu  parametru pentru lungimea lui S
	   if(lung<=0) Lung=100;
           else        Lung=lung;  // nu e necesara validarea	
           S=new long[Lung];       // instantierea lui S;

    }			
				   // accesori pentru Lung;
    public int getLung(){ 	   
          return Lung;
    }
    public void setLung(int lung){ //nu e necesara validarea lungimii lung
          if(lung<=0) Lung=100;
          else        Lung=lung;
    } 
    public long getSI(int i){		  // accesor getter pentru S[i];
	  if(i<0) return S[0];		  // validare a indicelui i, return S[0] daca i<0
          else    return S[i];		  // validarea nu-i necesara,
    }
    public void setSI(int i, long Val){   // setarea lui S[i] cu valoarea Val
    	  if(i<0 || i>=Lung) S[0]=Val;    // nu-i necesara validarea
          else               S[i]=Val;
    }
    
    public static boolean Prim(long n){	  //determina primalitatea numarului n
    	  if(n<2)	     return false;//return true daca n e prim, altfel return false
    	  if(n>2 && n%2==0)  return false;
          for(long d=3;d*d<=n;d+=2)	  //d e in multimea {3,5,7,...radical(n)}
    	     if(n%d==0)      return false;
    	  return true;		
    	}
    public void GrupPrime(){
         int i,j;
         i=j=0;
         while(j<Lung){
            if(!Prim(S[j])) j++;
            else   {  long aux =S[j];
                           S[j]=S[i];
                           S[i]=aux;
                      i++;
                      j++;
                   }
         }
   }     
       
 }   
	

