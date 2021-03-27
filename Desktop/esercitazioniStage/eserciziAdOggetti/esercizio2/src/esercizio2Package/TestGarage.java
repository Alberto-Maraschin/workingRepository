package esercizio2Package;

/*
Scrivere una classe Garage che prevede solo un metodo repair() che utilizza veicoli (come definiti
nell’esercizio precedente). Tale metodo prende un veicolo come parametro, ne cambia (se
necessario) il valore della variabile booleana che descrive lo stato di guasto e restituisce come
risultato il prezzo dell’intervento. Il prezzo deve variare a seconda che il veicolo fosse guasto o
meno, e a seconda della tipologia di veicolo.
Per testare le classi, scrivere un programma TestGarage che crea un certo numero di veicoli e un
oggetto di tipo Garage, e usa il metodo repair() varie volte su oggetti diversi (guasti o meno)
stampando i prezzi ottenuti.
 */

public class TestGarage {
	public static void main(String[]args) {
		Car auto1 = new Car("HD567FD", "Opel", "Zafira", false, "Utilitarian");
		Car auto2 = new Car("FD532JD", "Opel", "Insigna", true, "Utilitarian");
		Motorcycle moto1 = new Motorcycle("AA12345", "Kymko", "RoadSter", true, 150);
		Motorcycle moto2 = new Motorcycle("AL82O27", "Kymko", "Agility16", false, 125);
		Motorcycle moto3 = new Motorcycle("SD57284", "Kymko", "Like125sport", false, 125);
	
		Vehicle[]array = {auto1, auto2, moto1, moto2, moto3};
		
		Garage g = new Garage();
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(g.repair(array[i]));
		}
		
	}

}
