package esercizio4Package;
import java.time.LocalDate;
import java.util.Scanner;

/*
Il gestore di un negozio associa a tutti i suoi Prodotti un codice a barre univoco, una descrizione
sintetica del prodotto e il suo prezzo unitario. Realizzare una classe Prodotti con le opportune
variabili d&#39;istanza e metodi get.
Aggiungere alla classe Prodotti un metodo applicaSconto che modifica il prezzo del prodotto
diminuendolo del 5%.
Aggiungere alla classe Prodotti un&#39;implementazione specifica dei metodi ereditati dalla
classe Object.
Il gestore del negozio vuole fare una distinzione tra i prodotti Alimentari e quelli Non Alimentari .
Ai prodotti Alimentari viene infatti associata una data di scadenza (si veda la classe Data), mentre a
quelli Non Alimentari il materiale principale di cui sono fatti. Realizzare le sottoclassi Alimentari e
NonAlimentari estendendo opportunamente la classe Prodotti.
Modificare le due sottoclassi dell&#39;esercizio specializzando il metodo applicaSconto in modo che nel
caso dei prodotti Alimentari venga applicato uno sconto del 20% se la data di scadenza è a meno di
10 giorni dalla data attuale (si usi il metodo getDifference della classe Data), mentre nel caso dei
prodotti Non Alimentari venga applicato uno sconto del 10% se il prodotto è composto da un
materiale riciclabile (carta, vetro o plastica).
Realizzare una classe ListaSpesa che chieda all&#39;utente di inserire i prodotti acquistati e calcoli il
totale della spesa applicando gli opportuni sconti se il cliente ha la tessera fedeltà.
*/

public class ListaSpesa {
	public static void main(String[]args) {
		Scanner tastiera = new Scanner(System.in);
		LocalDate giorno4Aprile = LocalDate.of(2021,  4, 5);
		LocalDate giorno13Giugno = LocalDate.of(2021, 6, 13);
		LocalDate giorno15Aprile = LocalDate.of(2021, 4, 15);
		Alimentari prodotto0 = new Alimentari(67284, 1.00, "Mele", giorno4Aprile);
		Alimentari prodotto1 = new Alimentari(23145, 2.15, "Fragole", giorno13Giugno);
		Alimentari prodotto2 = new Alimentari(12345, 3.00, "UvaBianca", giorno15Aprile);
		NonAlimentari prodotto3 = new NonAlimentari(14325, 4.00, "Bottiglia", "vetro");
		NonAlimentari prodotto4 = new NonAlimentari(15896, 50.00, "SetDiAttrezzi", "metallo");
		NonAlimentari prodotto5 = new NonAlimentari(19387, 20.00, "SetDaCucina", "ferro");
		NonAlimentari prodotto6 = new NonAlimentari(54835, 5.00, "FogliA4PerStampante", "carta");
		Prodotti prodotto7 = new Prodotti(27461, 25.00, "AutografoDiGerryScotti");
		Prodotti[]prodotti = {prodotto0, prodotto1, prodotto2, prodotto3, prodotto4, prodotto5, prodotto6, prodotto7};
		
		boolean found = false;
		
		System.out.println("Buongiorno, prima di inserire i prodotti acquistati, per caso possiede la tessera fedelta'?");
		String carta = tastiera.next();
		String risposta = "Si";
		
		while(!(risposta.equalsIgnoreCase("NO"))) {
			System.out.println("Inserisca la descrizione del prodotto.");
			risposta = tastiera.next();
			for(int i = 0; i < prodotti.length && !found; i++) {
				if(risposta.equalsIgnoreCase(prodotti[i].getDescrizione())) {
					found = true;
					System.out.println(prodotti[i].toString());
					if(carta.equalsIgnoreCase("Si")) {
						System.out.println("Con la tessera fedelta', questo prodotto lo paghera':	" + prodotti[i].applicaSconto());
					}
				}
			}
			if(!found) {
				System.out.println("La descrizione del prodotto da lei inserita non è presente in questo negozio.");
			}
			System.out.println("Deve pagare altri prodotti?");
			risposta = tastiera.next();
			found = false;
		}
		
		tastiera.close();
	}

}
