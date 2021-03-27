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

public class TestVehicles {
	public static void main(String[]args) {
		Car auto1 = new Car("HD567FD", "Opel", "Zafira", false, "Utilitarian");
		Car auto2 = new Car("FD532JD", "Opel", "Insigna", true, "Utilitarian");
		Motorcycle moto1 = new Motorcycle("AA12345", "Kymko", "RoadSter", true, 150);
		Motorcycle moto2 = new Motorcycle("AL82O27", "Kymko", "Agility16", false, 125);
		Motorcycle moto3 = new Motorcycle("SD57284", "Kymko", "Like125sport", false, 125);
	
		Vehicle[]array = {auto1, auto2, moto1, moto2, moto3};
	
		for(int i = 0; i < array.length; i++) {
			if(array[i].getOutOfOrder()) {
				System.out.println(array[i].getTarga());
			}
		}
		
	}
}
