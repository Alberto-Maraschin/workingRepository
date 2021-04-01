package esercizioInterfacce1package;

/*
Realizzare un programma che sia in grado di valutare il volume di oggetti tridimensionali come cilindri e
parallelepipedi basandosi sul valore della loro area e dell&#39;altezza. Delegare i metodi comuni, come il calcolo
e la stampa del volume ad una classe astratta.
*/

public class TestShapes {
	public static void main(String[]args) {
		Cilindro cilindro = new Cilindro(42, 20);
		Cubo cubo = new Cubo(84, 10);
		Parallelepipedo parallelepipedo = new Parallelepipedo(40, 30);
		
		cilindro.stampaVolume();
		cubo.stampaVolume();
		parallelepipedo.stampaVolume();
		
	}

}
