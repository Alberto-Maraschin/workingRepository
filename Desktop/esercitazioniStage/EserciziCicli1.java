import java.util.Scanner;
class EserciziCicli1{
	public static void main(String[]args){
		Scanner tastiera = new Scanner(System.in);
		/*Scrivere un programma / metodo che data una sequenza di interi stampi "Tutti positivi e pari" se i numeri
		inseriti sono tutti positivi e pari, altrimenti stampa "NO". Risolvere questo esercizio senza usare array.
		*/
		boolean allPositiveAndEvenNumbers = true;
		int number = 1;
		System.out.println("Vi chiedero' a breve di inserire i numeri interi che più desiderate, quando volete chiudere il programma vi basterà digitare 0");
		//Ho scelto lo zero perché a livello matematico non c'è una convenzione che dica se lo zero è positivo o negativo.
		
		while(number != 0){
			System.out.println("Prego, inserire un numero intero.");
			number = tastiera.nextInt();
			if(number < 0 || number%2 == 1){
				allPositiveAndEvenNumbers = false;
			}
		}
		if(allPositiveAndEvenNumbers == true){
			System.out.println("Tutti positivi e pari");
		}
		else{
			System.out.println("NO");
		}
	}
}