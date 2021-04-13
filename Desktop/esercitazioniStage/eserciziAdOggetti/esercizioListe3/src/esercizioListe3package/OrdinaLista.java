package esercizioListe3package;
import java.util.Iterator;
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

public class OrdinaLista {
	public static LinkedList<Integer> mergeOrdinato(LinkedList <Integer> firstList, LinkedList <Integer> secondList){
		LinkedList <Integer> mergedList = new LinkedList <Integer>();
		
		if(firstList.getLast() >= secondList.getFirst()) {
			for(int i = 0; i < secondList.size(); i++) {
				firstList.add(secondList.get(i));
			}
			mergedList = firstList;
		}
		if(firstList.getLast() < secondList.getFirst()) {
			for(int i = 0; i < firstList.size(); i++) {
				secondList.add(firstList.get(i));
			}
			mergedList = secondList;
		}
		return mergedList;
	}
	
	public static LinkedList <Integer> creaRandom(int n, int max){
		LinkedList <Integer> lista = new LinkedList <Integer> ();
		
		for(int i = 0; i < n; i++) {
			lista.add(i, (int)(Math.random()*max));
		}
		
		return lista;
	}
	
	public static void stampa(LinkedList <Integer> lista) {
		Iterator <Integer> iter = lista.iterator();
		while(iter.hasNext()) {
			System.out.println("<" + iter.next() + ">");
		}
	}

}
