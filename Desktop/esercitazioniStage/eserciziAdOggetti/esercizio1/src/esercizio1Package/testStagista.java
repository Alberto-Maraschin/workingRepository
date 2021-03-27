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

public class testStagista {
	public static void main (String[]args) {
		Stagista stagista1 = new Stagista("Luca", "Franchi", "FRNSST99D50A717N", "Muggio'", 56, 272727);
		Stagista stagista2 = new Stagista("Matteo", "Barzan", "DFNFGS01F50A717N", "Padova", 42, 374737);
		Stagista stagista3 = new Stagista("Lorenzo", "Brazo", "ASJFAD98J50A717N", "Napoli", 76, 346273);
		Stagista[]array = {stagista1, stagista2, stagista3};
		
		int min = array[0].bornYear(array[0].getTaxCode());
		
		for(int i = 1; i < array.length; i++) {
			if(array[i].bornYear(array[i].getTaxCode()) > min) {
				min = array[i].bornYear(array[i].getTaxCode());
			}
		}
		for(int i = 0; i < array.length; i++) {
			if(min == array[i].bornYear(array[i].getTaxCode())) {
				System.out.println("Anno di nascita: " + array[i].bornYear(array[i].getTaxCode()) + " " + array[i].toString());
				System.exit(0);
			}
		}
		
		
	}

}
