package esercizioListe1package;
import java.util.LinkedList;
import java.util.Iterator;

/*
Realizzare il metodo static LinkedList&lt;Integer&gt; creaRandom(int n, int max) che genera una lista costituita
da n valori interi random tra 0 e max-1.
Suggerimento : Per la generazione dei valori casuali far riferimento alla classe java.util.Random ed in
particolare al metodo nextInt(int). In alternativa si può usare il metodo Math.random() che però restituisce
un valore double tra 0 e 1 che andrà opportunamente scalato e convertito ad intero.
Parte 2
Realizzare il metodo static void stampa(Iterator&lt;Integer&gt; i) che stampa gli elementi dell’iteratore nella
forma &lt;elem1&gt;,&lt;elem2&gt;,…., &lt;elemN&gt;
Parte 3
Realizzare il metodo static void provaEx1() che, utilizzando i metodi appena creati, crei un vettore di 20
elementi random (sia ordinato che non) e li stampa. Questo metodo andrà poi chiamato dal main per i test
di correttezza.
Riassunto :
ripetere gli esercizi utilizzando l’ArrayList al posto della LinkedList.
Quali metodi devono essere modificati?
*/

public class RandomNumber {
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
