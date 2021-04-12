package esercizioDistributorePackage;
import java.util.Scanner;

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

public class Tessera {
	Scanner tastiera = new Scanner(System.in);
	private int codice;
	private int credito;
	
	public Tessera(int codice, int credito) {
		this.codice = codice;
		this.credito = credito;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	public void caricaTessera() {
		System.out.println("Desideri prelevare o depositare?");
		String numero = "";
		String risposta = tastiera.next();
		if(risposta.equalsIgnoreCase("Prelevare")) {
			System.out.println("Per favore inserire la cifra che si intende prelevare, "
					+ "sapendo che il suo credito disponibile e':	" + this.getCredito());
			numero = tastiera.next();
			while(!(TestBevande.controllaInput(numero))) {
				System.out.println("Non e' stato inserito un numero intero.");
				numero = tastiera.next();
			}
			if(Integer.parseInt(numero) > this.getCredito()) {
				System.out.println("Non e' possibile effettuare l'operazione.");
			}
			else {
				this.setCredito(this.getCredito()-Integer.parseInt(numero));
				System.out.println("Il suo credito ora e':	" + this.getCredito());
			}
		}
		
		else if(risposta.equalsIgnoreCase("Depositare")) {
			System.out.println("Per favore inserire la cifra che si intende depositare.");
			numero = tastiera.next();
			while(!(TestBevande.controllaInput(numero))) {
				System.out.println("Non e' stato inserito un numero intero.");
				numero = tastiera.next();
			}
			this.setCredito(this.getCredito()+Integer.parseInt(numero));
			System.out.println("Il suo credito ora e':	" + this.getCredito());
		}
		
		else {
			System.out.println("Arrivederci.");
		}
	}
	
	public void leggiCredito(int codice) throws TesseraNonValidaException {
		if(this.getCodice() == codice) {
			System.out.println("Credito residuo:	" + this.getCredito());
		}
		else if(this.getCodice() == codice) {
			throw new TesseraNonValidaException();
		}
	}

}
