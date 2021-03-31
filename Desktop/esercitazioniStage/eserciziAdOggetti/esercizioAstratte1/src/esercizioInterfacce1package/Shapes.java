package esercizioInterfacce1package;

/*
Realizzare un programma che sia in grado di valutare il volume di oggetti tridimensionali come cilindri e
parallelepipedi basandosi sul valore della loro area e dell&#39;altezza. Delegare i metodi comuni, come il calcolo
e la stampa del volume ad una classe astratta.
*/

public abstract class Shapes {
	private int altezza;
	private int area;
	
	public Shapes(int altezza, int area) {
		if(altezza > 0 && area > 0) {
			this.altezza = altezza;
			this.area = area;
		}
		else {
			System.out.println("Non può esistere un solido con altezza e/o area minore o uguale a zero.");
			System.exit(-1);
		}
	}
	
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	
	public int getAltezza() {
		return this.altezza;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public int getArea() {
		return this.area;
	}
	
	public int calcolaVolume() {
		return 0;
	}
	
	public void stampaVolume() { 
		
	}

}
