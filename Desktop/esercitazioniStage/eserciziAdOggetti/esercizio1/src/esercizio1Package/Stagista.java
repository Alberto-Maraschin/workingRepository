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

public class Stagista extends Person {
	private int numberOfPresence;
	private int idNumber;
	
	public Stagista(String name, String surname, String taxCode, String city, int numberOfPresence, int idNumber){
		super(name, surname, taxCode, city);
		this.numberOfPresence = numberOfPresence;
		this.idNumber = idNumber;
	}
	
	public void setNumberOfPresence(int numberOfPresence) {
		this.numberOfPresence = numberOfPresence;
	}
	
	public int getNumberOfPresence() {
		return this.numberOfPresence;
	}
	
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public int getIdNumber() {
		return this.idNumber;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Numero di presenze: " + this.getNumberOfPresence() + " Numero ID:" + this.getIdNumber();
	}

}
