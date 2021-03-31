package esercizioInterfacce1package;

/*
Scrivere un programma che dato un numero intero in ingresso vengano restituiti un oggetto
rappresentativo del quadrato del numero dato e un oggetto rappresentativo del cubo del numero
assegnato.
Implementa l&#39;algoritmo attraverso l&#39;uso di una interfaccia comune.
*/

public class Cubo implements IPotenza {
	
	private int numero;
	
	public Cubo(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int calcolaRisultato() {
		return (int)(Math.pow(this.numero, 3));
	}

}
