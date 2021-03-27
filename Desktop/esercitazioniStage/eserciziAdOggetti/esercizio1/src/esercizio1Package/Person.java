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

public class Person {
	private String name;
	private String surname;
	private String taxCode;
	private String city;
	
	public Person() {
		name = null;
		surname = null;
		taxCode = null;
		city = null;
	}
	
	public Person(String name, String surname, String taxCode, String city) {
		this.name = name;
		this.surname = surname;
		this.taxCode = taxCode;
		this.city = city;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	
	public String getTaxCode() {
		return taxCode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.getName() + " Surname: " + this.getSurname() + " TaxCode: " + this.getTaxCode() + " City: " + this.getCity();
	}
	
	public int bornYear(String taxCode) {
		int year = Integer.parseInt(taxCode.substring(6, 8)); 
		//il carattere in posizione 6 e quello in posizione 7 del codice fiscale sono quelli che determinano l'anno di nascita
		if(year > 21) {
			year += 1900;
		}
		else {
			year += 2000;
		}
		return year;
	}

}
