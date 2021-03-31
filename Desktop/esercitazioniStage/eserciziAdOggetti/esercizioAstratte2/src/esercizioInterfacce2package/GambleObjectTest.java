package esercizioInterfacce2package;

/*
Scrivere un programma che simuli il lancio di un dado e di una moneta stampandone il risultato; con e
senza l&#39;utilizzo di una classe astratta che rappresenti i comportamenti comuni degli oggetti dado e moneta
istanziati.
*/

public class GambleObjectTest {
	public static void main(String[]args) {
		Moneta m = new Moneta();
		Dado d = new Dado();
	
		System.out.println("Tiro subito un dado:	" + ((int)(Math.random()*6)+1));
		System.out.println("Tiro subito una moneta:	" + ((int)(Math.random()*2)+1));
		
		System.out.print("Tiro un dado legato ad una classe astratta:	");
		d.stampaRisultato();
		
		System.out.print("Tiro una moneta legata ad una classe astratta:	");
		m.stampaRisultato();
	}

}
