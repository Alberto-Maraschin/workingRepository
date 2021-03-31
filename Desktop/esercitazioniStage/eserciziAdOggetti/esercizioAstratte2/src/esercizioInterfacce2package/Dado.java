package esercizioInterfacce2package;

/*
Scrivere un programma che simuli il lancio di un dado e di una moneta stampandone il risultato; con e
senza l&#39;utilizzo di una classe astratta che rappresenti i comportamenti comuni degli oggetti dado e moneta
istanziati.
*/

public class Dado extends GambleObject {
	
	public Dado() {
		
	}
	
	public Dado(int risultato) {
		super(risultato);
		if(risultato < 1 || risultato > 6) {
			System.out.println("Oggetto dado non istanziato correttamente, inserire un numero da 1 a 6.");
			System.exit(-1);
		}
	}
	
	@Override
	public void setRisultato(int risultato) {
		if(risultato < 1 || risultato > 6) {
			System.out.println("Oggetto dado non istanziato correttamente, inserire un numero da 1 a 6.");
			System.exit(-1);
		}
		else {
			super.setRisultato(risultato);
		}
	}
	
	@Override
	public int generaRisultato() {
		this.setRisultato((int)(Math.random()*6)+1);
		return this.getRisultato();
	}
	
	@Override
	public void stampaRisultato() {
		System.out.println("Ho lanciato un dado e ho ottenuto:	" + this.generaRisultato());
	}

}
