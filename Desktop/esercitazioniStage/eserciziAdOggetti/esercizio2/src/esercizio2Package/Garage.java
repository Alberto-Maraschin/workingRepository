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

public class Garage {
	
	public int repair(Vehicle V) {
		int prezzo = 50; //prezzo per la visita dal meccanico
		
		if(V.getOutOfOrder()) {
			V.setOutOfOrder(false);
			prezzo += 50; //prezzo per effettiva riparazione
		}
		
		//Riparare un auto costa di più
		//Per capire se il veicolo é una macchina o una moto utilizzo la targa che so contenere sempre 7 caratteri
		//Un auto ha come ultimi 2 caratteri delle lettere, una moto ha 2 numeri
		
		if(V.getTarga().charAt(5) >= 'A' && V.getTarga().charAt(5) <= 'Z' && V.getTarga().charAt(6) >= 'A' && V.getTarga().charAt(6) <= 'Z') {
			//Il veicolo è una macchina
			prezzo += 100;
		}
		else if(V.getTarga().charAt(5) > '0' && V.getTarga().charAt(5) < '9' && V.getTarga().charAt(6) > '0' && V.getTarga().charAt(6) < '9') {
			//Il veicolo è una moto
			prezzo += 50;
		}
		else {
			System.out.println("Veicolo sconosciuto con la targa:	" + V.getTarga());
			System.exit(-1);
		}
		return prezzo;
	}

}
