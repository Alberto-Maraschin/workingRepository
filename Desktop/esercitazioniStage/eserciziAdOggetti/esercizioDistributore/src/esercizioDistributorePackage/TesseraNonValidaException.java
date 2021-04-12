package esercizioDistributorePackage;

/*
Il distributore può essere utilizzato con delle tessere di credito. Ogni tessera è caratterizzata da
un codice (un numero intero) e da un credito disponibile. I crediti vengono definiti tramite il
metodo caricaTessera(). In qualsiasi istante è possibile conoscere il credito residuo di una
tessera tramite il metodo leggiCredito() che riceve come parametro il codice della tessera; in
caso di codice di tessera non valido viene restituita un’eccezione di TesseraNonValida.
Esempio di tessere:

Codice Credito
12 5.5
21 10.0
99 0.75
*/

public class TesseraNonValidaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TesseraNonValidaException() {
		super();
	}
	
	public TesseraNonValidaException(String message) {
		super(message);
	}

}
