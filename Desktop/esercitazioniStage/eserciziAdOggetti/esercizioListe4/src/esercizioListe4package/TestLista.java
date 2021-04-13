package esercizioListe4package;
import java.util.Iterator;
import java.util.LinkedList;

/*
1. Realizzare il metodo static LinkedList&lt;LinkedList&lt;Integer&gt; insiemeDiInsiemi(int n) che costruisce una
lista di liste così definita:
a. Il primo elemento della lista contiene una lista con il solo valore 0;
b. Il secondo elemento contiene una lista con gli elementi 0 e 1
c. Il terzo contiene una lista con gli elementi 0,1,2
d. … e così via fino ad n-1
2. Realizzare il metodo static void stampa(LinkedList &lt;LinkedList&lt;Integer&gt;&gt; a) in grado di stampare il
contenuto della lista
*/

public class TestLista {
	public static LinkedList<LinkedList<Integer>> insiemeDiInsiemi(int n){
		LinkedList<LinkedList<Integer>> finalList = new LinkedList <LinkedList<Integer>>();
		
		for(int i = 0; i < n; i++) {
			LinkedList<Integer> temp = new LinkedList <Integer>();
			for(int j = 0; j <= i; j++) {
				temp.add(j);
			}
			if(temp.contains(0)) {
				finalList.add(temp);
			}
		}
		
		return finalList;
	}
	
	public static void stampa(LinkedList <LinkedList<Integer>> lista) {
		Iterator <LinkedList<Integer>> iter = lista.iterator();
		while(iter.hasNext()) {
			System.out.println("<" + iter.next() + ">");
		}
	}
	
	public static void stampaFacile(LinkedList <Integer> lista) {
		Iterator <Integer> iter = lista.iterator();
		while(iter.hasNext()) {
			System.out.println("<" + iter.next() + ">");
		}
	}
	
	//Inizio del main ---------------------------------------------------------------------------
	
	public static void main(String[]args) {
		System.out.println("Primo test case");
		stampa(insiemeDiInsiemi(0));
		System.out.println("Secondo test case");
		stampa(insiemeDiInsiemi(5));
		System.out.println("Terzo test case");
		stampa(insiemeDiInsiemi(10));
	}

}
