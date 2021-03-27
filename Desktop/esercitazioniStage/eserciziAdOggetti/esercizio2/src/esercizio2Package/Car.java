package esercizio2Package;

/*
Scrivere una classe Vehicle (veicolo) che prevede una targa, una marca e un modello.
La classe prevede anche una variabile booleana che descrive se il veicolo è guasto.
Aggiungere un costruttore opportuno e vari metodi get e set opportuni.

Scrivere la classi Car e Motocycle che estendono la classe Vehicle. La classe Car prevede una
stringa che ne descrive la tipologia (&quot;utilitaria&quot;,&quot;station wagon&quot;, &quot;SUV&quot;,....) mentre la classe
Motocycle prevede un numero che ne descrive la cilindrata (50, 125, ....).
Per testare le classi, scrivere un programma TestVehicles che crea un array inizializzato con veicoli
delle varie tipologie. Alcuni dei veicoli inseriti nell’array dovranno diventare guasti. Il programma
deve stampare la lista delle targhe dei veicoli guasti.
*/

public class Car extends Vehicle {
	private String type;
	
	public Car(String targa, String marca, String modello, boolean outOfOrder, String type) {
		super(targa, marca, modello, outOfOrder);
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}

}
