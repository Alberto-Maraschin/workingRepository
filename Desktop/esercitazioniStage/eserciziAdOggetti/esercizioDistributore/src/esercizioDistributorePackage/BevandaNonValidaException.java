package esercizioDistributorePackage;

/*
Il distributore di bevande è in grado di erogare alcuni tipi di bevande; ogni bevanda è
caratterizzata da un codice, nome ed un prezzo.
Ad esempio:

Codice Bevanda Prezzo
A Acqua 0.20
B Coca 0.30
C Birra 1.00

Il metodo aggiungiBevanda() permette di aggiungere la descrizione di una bevanda.
Il distributore permette di conoscere, dato il codice, il prezzo e il nome della bevanda tramite i
metodi getPrice() e getName() rispettivamente.
Quando si richiede un codice corrispondente ad una bevanda non disponibile, viene generata
un’eccezione di BevandaNonValida.
*/

public class BevandaNonValidaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BevandaNonValidaException() {
		super();
	}
	
	public BevandaNonValidaException(String message) {
		super(message);
	}

}
