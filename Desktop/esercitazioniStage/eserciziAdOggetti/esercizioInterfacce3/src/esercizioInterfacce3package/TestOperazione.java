package esercizioInterfacce3package;

/*
Definire una interfaccia &#39;operazione&#39; e le sue classi derivate( sub. div, mul) in modo che da ciascuna sia
possibile eseguire la corrispondente operazione aritmetica (di addizione, divisione, moltiplicazione)
istanziando un oggetto di classe &#39;operazione&#39; e due operandi. Realizzare anche, una classe astratta che
implementi le funzionalità comuni come la stampa a video del risultato.
*/

public class TestOperazione {
	public static void main(String[]args) {
		Addizione addizione = new Addizione();
		addizione.setOperando1(42.5);
		addizione.setOperando2(84.3);
		Divisione divisione = new Divisione();
		divisione.setOperando1(80.5);
		divisione.setOperando2(40.2);
		Moltiplicazione moltiplicazione = new Moltiplicazione();
		moltiplicazione.setOperando1(30);
		moltiplicazione.setOperando2(2);
		
		addizione.show();
		moltiplicazione.show();
		divisione.show();
	
	}

}
