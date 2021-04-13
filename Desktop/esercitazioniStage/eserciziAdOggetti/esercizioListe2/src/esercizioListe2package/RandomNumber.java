package esercizioListe2package;

import java.util.Iterator;
import java.util.LinkedList;

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

public class RandomNumber {
	public static LinkedList <Integer> creaRandomCrescente(int n){
		LinkedList <Integer> lista = new LinkedList <Integer> ();
		
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				lista.add(i, (int)(Math.random()*100)+1);
			}
			else {
				lista.add(i, (int)((Math.random()*100)+1) + lista.get(i-1));
			}
		}
		
		return lista;
	}
	
	public static void stampa(LinkedList <Integer> lista) {
		Iterator <Integer> iter = lista.iterator();
		while(iter.hasNext()) {
			System.out.println("<" + iter.next() + ">");
		}
	}
	
	public static LinkedList<Integer> parseString(LinkedList<String> a){
		LinkedList <Integer> lista = new LinkedList <Integer>();
		for(int i = 0; i < a.size(); i++) {
			lista.add(Integer.parseInt(a.get(i)));
		}
		return lista;
	}

}
