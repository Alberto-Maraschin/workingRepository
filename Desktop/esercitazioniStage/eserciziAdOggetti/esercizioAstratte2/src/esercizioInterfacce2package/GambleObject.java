package esercizioInterfacce2package;

/*
Scrivere un programma che simuli il lancio di un dado e di una moneta stampandone il risultato; con e
senza l&#39;utilizzo di una classe astratta che rappresenti i comportamenti comuni degli oggetti dado e moneta
istanziati.
*/

public abstract class GambleObject {
	private int risultato;
	
	public GambleObject() {
		
	}
	
	public GambleObject(int risultato) {
		this.risultato = risultato;
	}
	
	public int getRisultato() {
		return this.risultato;
	}
	
	public void setRisultato(int risultato) {
		this.risultato = risultato;
	}
	
	public int generaRisultato() {
		return 0;
	}
	
	public void stampaRisultato() {
		
	}

}
