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

public abstract class ElementoMultimediale {
	private String titolo;
	private int durata;
	
	public ElementoMultimediale(String titolo, int durata){
		if(!(titolo.equals("")) && durata >= 0) {
			this.titolo = titolo;
			this.durata = durata;
		}
		else {
			System.out.println("Oggetto Elemento Multimediale non istanziato correttamente.");
			System.exit(-1);
		}
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public void setTitolo(String titolo) {
		if(!(titolo.equals(""))){
			this.titolo = titolo;
		}
		else {
			System.out.println("Oggetto Elemento Multimediale non inizializzato correttamente.");
			System.exit(-1);
		}
	}
	
	public int getDurata() {
		return this.durata;
	}
	
	public void setDurata(int durata) {
		if(durata >= 0) {
			this.durata = durata;
		}
		else {
			System.out.println("Oggetto Elemento Multimediale non inizializzato correttamente.");
			System.exit(-1);
		}
	}
	
	public int getLuminosita() {
		return 0;
	}
	
	public int getVolume() {
		return 0;
	}
	
	public void play() {
		
	}
	
	public void show() {
		
	}
	
	public int louder() {
		return 0;
	}
	
	public int weaker() {
		return 0;
	}
	
	public int brighter() {
		return 0;
	}
	
	public int darker() {
		return 0;
	}

}
