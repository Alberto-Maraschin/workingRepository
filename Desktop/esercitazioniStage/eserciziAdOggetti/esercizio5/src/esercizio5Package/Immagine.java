package esercizio5Package;

/*
Un Elemento Multimediale è una Immagine, un Filmato o una registrazione Audio identificato da
un titolo (una stringa non vuota).
Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un metodo play().
Una registrazione Audio è riproducibile e ha associato anche un volume (un valore positivo di tipo
int) e i metodi weaker() e louder() per regolarlo.
Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una
sequenza di punti esclamativi di lunghezza pari al volume (una stampa per riga).
Un Filmato è riproducibile e ha associato un volume regolabile analogo a quello delle registrazioni
audio e anche una luminosità (un valore positivo di tipo int) e i metodi brighter() e darker() per
regolarla.
Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una
sequenza di punti esclamativi di lunghezza pari al volume e poi a una sequenza di asterischi di
lunghezza pari alla luminosità (una stampa per riga).
Una Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella dei filmati e
un metodo show() che stampa il titolo concatenato a una sequenza di asterischi di lunghezza pari
alla luminosità.

Eseguire un oggetto multimediale significa invocarne il metodo show() se è un&#39;immagine o il
metodo play() se è riproducibile.

Organizzare opportunamente con classi astratte, interfacce e classi concrete il codice di un lettore
multimediale che memorizza 5 elementi (creati con valori letti da tastiera) in un array e poi chiede
ripetutamente all&#39;utente quale oggetto eseguire (leggendo un intero da 1 a 5 oppure 0 per finire) e
dopo ogni esecuzione fornisce la possibilità di regolarne eventuali parametri (volume / luminosità).
*/

public class Immagine extends ElementoMultimediale {
	private int luminosita;
	
	public Immagine(String titolo, int durata, int luminosita) {
		super(titolo, durata);
		if(luminosita <= 0 || durata != 0) {
			System.out.println("Oggetto Immagine non istanziato correttamente");
			System.exit(-1);
		}
		else {
			this.luminosita = luminosita;
		}
	}
	
	@Override
	public void setDurata(int durata) {
		if(durata == 0) {
			super.setDurata(durata);
		}
		else {
			System.out.println("Oggetto Immagine non inizializzato correttamente.");
			System.exit(-1);
		}
	}
	
	@Override
	public int getLuminosita() {
		return this.luminosita;
	}
	
	public void setLuminosita(int luminosita) {
		if(luminosita > 0) {
			this.luminosita = luminosita;
		}
		else {
			System.out.println("Oggetto Immagine non istanziato correttamente.");
			System.exit(-1);
		}
	}
	
	@Override
	public int darker() {
		if(this.getLuminosita() == 1) {
			System.out.println("Non è possibile diminuire ulteriormente la luminosita'.");
			return this.getLuminosita();
		}
		else {
			this.setLuminosita(getLuminosita()-1);
			return this.getLuminosita();
		}
	}
	
	@Override
	public int brighter() {
			this.setLuminosita(getLuminosita()+1);
			return this.getLuminosita();
	}
	
	@Override
	public void show() {
		System.out.print(this.getTitolo() + "	");
		for(int i = this.getLuminosita(); i > 0; i--) {
			System.out.print("*	");
		}
		System.out.println();
	}

}
