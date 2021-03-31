package esercizioInterfacce1package;
import java.util.Scanner;

/*
Scrivere un programma che dato un numero intero in ingresso vengano restituiti un oggetto
rappresentativo del quadrato del numero dato e un oggetto rappresentativo del cubo del numero
assegnato.
Implementa l&#39;algoritmo attraverso l&#39;uso di una interfaccia comune.
*/

public class TestPotenza {
	public static void main(String[]args) {
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Prego inserire un numero intero.");
		String numero = tastiera.next();
		
		for(int i = 0; i < numero.length(); i++) {
			if(numero.charAt(i) < '0' || numero.charAt(i) > '9') {
				System.out.println("Non è stato inserito un numero intero, per favore riprovare.");
				i = 0;
				numero = tastiera.next();
			}
		}
		
		Quadrato quadrato = new Quadrato(Integer.parseInt(numero));
		Cubo cubo = new Cubo(Integer.parseInt(numero));
		
		System.out.println("Ecco il quadrato del numero che avete inserito:	" + quadrato.calcolaRisultato());
		System.out.println("Ecco il cubo del numero che avete inserito:	" + cubo.calcolaRisultato());
		
		tastiera.close();
	}

}
