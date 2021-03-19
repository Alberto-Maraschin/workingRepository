import java.util.Scanner;
class EserciziCicli3{
	public static void main(String[]args){
		Scanner tastiera = new Scanner(System.in);
		/*Scrivere un programma / metodo che chiede all’utente di inserire una sequenza di caratteri (chiedendo
		prima quanti caratteri voglia inserire) e li ristampa man mano che vengono inseriti. L’intero procedimento
		(chiedere quanti caratteri voglia inserire, leggere i caratteri e man mano stamparli) dovrà essere ripetuto 5
		volte. Risolvere questo esercizio senza usare array.
		*/
		
		int total = 0;
		char answer = ' ';
		
		for(int i = 0; i < 5; i++){
			System.out.println("Quanti caratteri vuoi inserire? Digitare un numero intero.");
			total = tastiera.nextInt();
		
			while(total > 0){
				System.out.println("Inserire un carattere.");
				answer = tastiera.next().charAt(0);
				System.out.println(answer);
				total--;
			}
		}
	}
}