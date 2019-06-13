
public class Simulare {
	public static void main(String[] args){
		int[] colectie={10,7,5,11,2,15,1,11,9};
		int i;
		int max=colectie[0];
		int maxNo=0;
		int minNo=0;
		int min=colectie[0];
		for(i=1;i<colectie.length;i++){
			if(colectie[i]<min){
				minNo++;
				min=colectie[i];
				System.out.println("Noul minim e "+min);
			}
			else if(colectie[i]>max){
				maxNo++;
				max=colectie[i];
				System.out.println("Noul maxim e "+max);
			}
		}
		
	}
}
