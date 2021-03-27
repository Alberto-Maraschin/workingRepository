package esercizio1Package;

/*
Creare una classe di nome Person con le variabili di istanza: surname, name, tax code e city di tipo
stringa.
La classe deve contenere un costruttore di default che inizializzi le variabili di istanza con NULL;
un costruttore parametrico; i metodi set e get ed un metodo chiamato bornYear che a partire dal
codice fiscale ricavi e restituisca l&#39;anno di nascita di una persona.
Creare un'applicazione Java che istanzi un oggetto della classe Person e ne visualizzi in seguito
nome, cognome ed anno di nascita.
Costruire una sottoclasse di Person, chiamata Stagista, che contiene 2 variabili di istanza entrambe
di tipo intero:
numberOfPresence, che registra il numero di ore di presenza
idNumber (numero identificativo).
La sottoclasse deve contenere un costruttore parametrico ed i metodi set e get.
Creare tre oggetti di tipo Stagista memorizzarli in un array e visualizzare lo Stagista più giovane.
 */

public class testPerson {
	public static void main (String[] args) {
		Person persona = new Person("Osvaldo", "Mobrei", "FRNSST75D50A717N", "Washington");
		System.out.println("Anno di nascita: " + persona.bornYear(persona.getTaxCode()) + " " + persona.toString());
	}
	
}
