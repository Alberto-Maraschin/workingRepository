package esercizioListe2package;

/*
Realizzare il metodo static LinkedList&lt;Integer&gt; creaRandomCrescente(int n) che genera una lista collegata
costituita da n valori random crescenti.
Suggerimento: il primo valore della lista viene generato casualmente (ad es nell’intervallo 0-100); i
valori successivi si ottengono sommando al corrispondente valore della cella precedente un nuovo
valore random intero (ad es. con intervallo 0-100).
Parte 2
Realizzare un metodo static LinkedList&lt;Integer&gt; parseString(LinkedList&lt;String&gt; a) che ritorna una lista
Collegata di interi ottenuti applicando il metodo Integer.parseInt(…) agli elementi dell’iteratore passato
come parametro.
a. Per il test generare una lista di stringhe opportuna con almeno 10 elementi
b. Individuare almeno un input in cui il metodo genera una eccezione
3. Realizzare il metodo static void provaEx2() per il test dei metodi
*/

import java.util.LinkedList;

public class TestLista {
	
	public static void provaex2() {
		System.out.println("Ecco la lista di numeri casuali crescenti.");
		LinkedList <Integer> lista = RandomNumber.creaRandomCrescente(10);
		RandomNumber.stampa(lista);
		
		LinkedList <String> a = new LinkedList <String>();
		//a.add("Hello"); Questa istruzione darebbe eccezione
		//a.add(""); Anche questa darebbe eccezione
		a.add("56");
		a.add("42");
		a.add("42");
		a.add("38");
		a.add("-2");
		a.add("+3");
		a.add("35677");
		a.add("0");
		a.add("-200");
		a.add("+1000");
		System.out.println("Ecco la lista di stringhe convertite in int.");
		lista = RandomNumber.parseString(a);
		RandomNumber.stampa(lista);
	}
	
	public static void main(String[]args) {
		provaex2();
	}

}
