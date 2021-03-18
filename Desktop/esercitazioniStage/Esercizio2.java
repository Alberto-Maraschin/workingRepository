import java.util.Scanner;
class Esercizio2{
	public static void main(String[]args){
		//Scrivere un metodo che verifichi se una data stringa inserita in input è palindroma, tale metodo dovrà restituire un booleano.
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Per favore inserire una stringa.");
		String stringa = tastiera.nextLine();
		
		System.out.println("La stringa risulta palindroma:	" + Metodi.palindroma(stringa));
	}
}