package esercizio4Package;

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

public class NonAlimentari extends Prodotti{
	private String material;
	
	public NonAlimentari(int codiceBarre, double prezzo, String descrizione, String material) {
		super(codiceBarre, prezzo, descrizione);
		this.material = material;
	}
	
	public void setMatrial(String material) {
		this.material = material;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	@Override
	public String toString() {
		return super.toString() + "	Materiale:	" + this.getMaterial();
	}
	
	@Override
	public double applicaSconto() {
		if(this.getMaterial().equalsIgnoreCase("carta") || this.getMaterial().equalsIgnoreCase("vetro") 
				|| this.getMaterial().equalsIgnoreCase("plastica")) {
			this.setPrezzo((this.getPrezzo() - (this.getPrezzo()*10)/100));
		}
		
		return this.getPrezzo();
	}

}
