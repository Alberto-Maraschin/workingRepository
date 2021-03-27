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

public class Vehicle {
	private String targa;
	private String marca;
	private String modello;
	private boolean outOfOrder;
	
	public Vehicle(String targa, String marca, String modello, boolean outOfOrder) {
		this.targa = targa;
		if(targa.length() != 7) {
			System.out.println("Targa non valida!");
			System.exit(-1);
		}
		for(int i = 0; i < targa.length(); i++) {
			if(targa.charAt(i) >= 'a' && targa.charAt(i) <= 'z') {
				System.out.println("Non sono ammesse lettere minuscole!");
				System.exit(-1);
			}
		}
		this.marca = marca;
		this.modello = modello;
		this.outOfOrder = outOfOrder;
	}
	
	public void setTarga (String targa) {
		if(targa.length() != 7) {
			System.out.println("Targa non valida!");
			System.exit(-1);
		}
		for(int i = 0; i < targa.length(); i++) {
			if(targa.charAt(i) >= 'a' && targa.charAt(i) <= 'z') {
				System.out.println("Non sono ammesse lettere minuscole!");
				System.exit(-1);
			}
		}
		this.targa = targa;
	}
	
	public String getTarga () {
		return this.targa;
	}
	
	public void setMarca (String marca) {
		this.marca = marca;
	}
	
	public String getMarca () {
		return this.marca;
	}
	
	public void setModello (String modello) {
		this.modello = modello;
	}
	
	public String getModello () {
		return this.modello;
	}
	
	public void setOutOfOrder (boolean outOfOrder) {
		this.outOfOrder = outOfOrder;
	}
	
	public boolean getOutOfOrder () {
		return this.outOfOrder;
	}

}
