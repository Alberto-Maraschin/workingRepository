import java.util.Scanner;
class EserciziStringhe1{
	public static void main(String[]args){
		Scanner tastiera = new Scanner(System.in);
		/*Scrivere un programma / metodo che data una stringa in input la stampi al contrario. Per esempio, se si
		immette la stringa "Viva Java", il programma stampa "avaJ aviV"
		*/
		System.out.println("Per favore, inserire una stringa.");
		String answer = tastiera.nextLine();
		String reversed = "";
		int j = answer.length()-1;
		
		for(int i = 0; i < answer.length(); i++){
			reversed += answer.charAt(j);
			j--;
		}
		
		System.out.println("Ecco la stringa al contrario:	" +reversed);
	}
}