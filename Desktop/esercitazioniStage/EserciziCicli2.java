import java.util.Scanner;
class EserciziCicli2{
	public static void main(String[]args){
		Scanner tastiera = new Scanner(System.in);
		/*Scrivere un programma / metodo che data una sequenza di interi stampi la media di tutti i numeri inseriti
		che siano divisibili per tre. Per esempio, se si immettono i valori 5, 8, 9, 12, 7, 6 ,1 il risultato stampato
		dovrà essere 9. Risolvere questo esercizio senza usare array.
		*/
		if(args.length == 0){
			System.out.println("Si prega di inserire i numeri direttamente da linea di comando.");
			System.exit(0);
		}
		for(int i = 0; i < args.length; i++){
			for(int j = 0; j < args[i].length(); j++){
				if(args[i].charAt(j) < '0' || args[i].charAt(j) > '9'){
					System.out.println("Si prega di inserire SOLTANTO numeri nella linea di comando.");
					System.exit(0);
				}
			}
		} //Ho finito di controllare l'input, ora converto le String.
		
		int temp = 0;
		int somma = 0;
		int counter = 0;
		
		for(int i = 0; i < args.length; i++){
			temp = Integer.parseInt(args[i]);
			if(temp%3 == 0){
				somma += temp;
				counter++;
			}
		}
		
		System.out.println(somma/counter);
	}
}