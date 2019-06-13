
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
    
    public static int Div4(long n){	  // determina numarul de divizori ai numarului n
        if(n==1) return 1;
        int cont=2;
        long d;
        for(d=2;d*d<n;d++){
           if(n%d==0)  cont+=2;
           if(cont>4)  return cont; 	//optimizare 
    	}
        if(d*d==n)     cont++;		//nu e necesara, doar patratele perfecte au un numar
					//impar de divizori si nu conteaza pentru problema
        return cont;
    }

    public void GrupDiv4(){
         int i,j;
         i=j=0;
         while(j<Lung){
            if(Div4(S[j])!=4) j++;
            else   {  long aux =S[j];
                           S[j]=S[i];
                           S[i]=aux;
                      i++;
                      j++;
                   }
         }
   }     
       
 }   
	

