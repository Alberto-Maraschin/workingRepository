package esercizioListe3package;

import java.util.LinkedList;

/*
1. Realizzare il metodo static LinkedList&lt;Integer&gt; mergeOrdinato(Iterator&lt;Integer&gt; a, Iterator&lt;Integer&gt; b)
che effettua il merge ordinato degli elementi dei due iteratori, ritornando il risultato in una lista collegata.
In particolare il merge di due liste ordinate (qui rappresentate dai corrispondenti iteratori, da assumere
come già ordinati) restituisce una nuova lista ordinata contente tutti gli elementi appartenenti alle due liste
di input.
2. Realizzare il metodo static void provaEx3() che crea due liste random ordinate e restituisce il merge
ordinato delle due. Il risultato così ottenuto dovrà essere stampata, insieme ai corrispondenti vettori di
input.
*/

public class TestLista {
	public static void provaEx3() {
		LinkedList <Integer> lista1 = OrdinaLista.creaRandom(10, 30);
		LinkedList <Integer> lista2 = OrdinaLista.creaRandom(12, 50);
		lista1.sort(null);
		lista2.sort(null);
		System.out.println("First list:	");
		OrdinaLista.stampa(lista1);
		System.out.println("Second list:	");
		OrdinaLista.stampa(lista2);
		
		System.out.println("Ecco la lista ottenuta dalla merge delle due precedenti liste.");
		
		LinkedList <Integer> mergedList = OrdinaLista.mergeOrdinato(lista1, lista2);
		mergedList.sort(null);
		OrdinaLista.stampa(mergedList);
	}
	
	public static void main(String[]args) {
		provaEx3();
	}

}
