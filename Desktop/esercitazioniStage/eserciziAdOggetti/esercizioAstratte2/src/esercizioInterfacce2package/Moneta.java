package esercizioInterfacce2package;

/*
Scrivere un programma che simuli il lancio di un dado e di una moneta stampandone il risultato; con e
senza l&#39;utilizzo di una classe astratta che rappresenti i comportamenti comuni degli oggetti dado e moneta
istanziati.
*/

public class Moneta extends GambleObject {
	
	public Moneta() {
		
	}
	
	public Moneta(int risultato) {
		super(risultato);
		if(risultato != 1 && risultato != 2) {
			System.out.println("Oggetto moneta non istanziato correttamente, inserire 1 per testa e 2 per croce.");
			System.exit(-1);
		}
	}
	
	@Override
	public int generaRisultato() {
		this.setRisultato((int)(Math.random()*2)+1);
		return this.getRisultato();
	}
	
	@Override
	public void stampaRisultato() {
		System.out.println("Ho lanciato una moneta e ho ottenuto:	" + this.generaRisultato());
	}

}
