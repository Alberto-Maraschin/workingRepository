package esercizio4Package;
import java.time.LocalDate;

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

public class Alimentari extends Prodotti {
	private LocalDate dataScadenza;
	
	public Alimentari(int codiceBarre, double prezzo, String descrizione, LocalDate dataScadenza) {
		super(codiceBarre, prezzo, descrizione);
		this.dataScadenza = dataScadenza;
	}
	
	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	public LocalDate getDataScadenza() {
		return this.dataScadenza;
	}
	
	@Override
	public String toString() {
		return super.toString() + "	Data di scadenza:	" + this.getDataScadenza();
	}
	
	@Override
	public double applicaSconto() {
		String today = LocalDate.now().toString();
		String expiry = dataScadenza.toString();
		boolean stop = false;
		
		int day = Integer.parseInt(today.substring(8));
		int expiryDay = Integer.parseInt(expiry.substring(8));
		int month = Integer.parseInt(today.substring(5, 7));
		int expiryMonth = Integer.parseInt(expiry.substring(5, 7));
		for(int i = 0; i < 10 && !stop; i++) {
			if(day == expiryDay) {
				stop = true;
			}
			day++;
			if((month == 9 || month == 11 || month == 6 || month == 4) && day == 31) {
				day = 1;
			}
			else if(month == 2 && day == 29) {
				day = 1;
			}
			else if(day == 32) {
				day = 1;
			}
		}
		
		if(!stop) {
			return this.getPrezzo();
		}
		
		System.out.println(month + "	" + expiryMonth);
		if(month != expiryMonth && month+1 != expiryMonth) {
			return this.getPrezzo();
		}
		
		int year = Integer.parseInt(today.substring(0, 4));
		int expiryYear = Integer.parseInt(expiry.substring(0, 4));
		if(year != expiryYear) {
			//Se gli anni sono diversi, o il prodotto è scaduto, o il prodotto scadrà sicuramente fra più di 10 giorni, avendo fatto i precedenti controlli
			return this.getPrezzo();
		}
		
		this.setPrezzo((this.getPrezzo() - (this.getPrezzo()*20)/100));
		
		return this.getPrezzo();
	}

}
