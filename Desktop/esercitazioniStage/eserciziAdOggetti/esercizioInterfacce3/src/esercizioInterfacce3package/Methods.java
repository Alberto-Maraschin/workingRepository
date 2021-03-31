package esercizioInterfacce3package;

/*
Definire una interfaccia &#39;operazione&#39; e le sue classi derivate( sub. div, mul) in modo che da ciascuna sia
possibile eseguire la corrispondente operazione aritmetica (di addizione, divisione, moltiplicazione)
istanziando un oggetto di classe &#39;operazione&#39; e due operandi. Realizzare anche, una classe astratta che
implementi le funzionalità comuni come la stampa a video del risultato.
*/

public abstract class Methods {
	private double operando1;
	private double operando2;
	
	public double getOperando1() {
		return operando1;
	}

	public void setOperando1(double operando1) {
		this.operando1 = operando1;
	}

	public double getOperando2() {
		return operando2;
	}

	public void setOperando2(double operando2) {
		this.operando2 = operando2;
	}
	
	public double calcolaRisultato() {
		return 0;
	}

	public void show() {
		System.out.print("Il risultato è:	");
	}

}
