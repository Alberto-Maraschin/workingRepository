package esercizioInterfacce1package;

/*
Realizzare un programma che sia in grado di valutare il volume di oggetti tridimensionali come cilindri e
parallelepipedi basandosi sul valore della loro area e dell&#39;altezza. Delegare i metodi comuni, come il calcolo
e la stampa del volume ad una classe astratta.
*/

public class Parallelepipedo extends Shapes {
	
	public Parallelepipedo (int altezza, int area) {
		super(altezza, area);
	}
	
	@Override
	public int calcolaVolume() {
		return ( this.getAltezza() * this.getArea() );
	}
	
	@Override
	public void stampaVolume() {
		System.out.println("Ecco il volume del parallelepipedo:	" + this.calcolaVolume());
	}

}
