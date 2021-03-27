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

public class RegistrazioneAudio extends ElementoMultimediale {
	private int volume;
	
	public RegistrazioneAudio(String titolo, int durata, int volume) {
		super(titolo, durata);
		if(durata <= 0) {
			System.out.println("Oggetto RegistrazioneAudio/Filmato non istanziato correttamente.");
			System.exit(-1);
		}
		else if(volume > 0) {
			this.volume = volume;
		}
		else {
			System.out.println("Oggetto RegistrazioneAudio/Filmato non istanziato correttamente.");
			System.exit(-1);
		}
	}
	
	@Override
	public int getVolume() {
		return this.volume;
	}
	
	public void setVolume(int volume) {
		if(volume > 0) {
			this.volume = volume;
		}
		else {
			System.out.println("Oggetto RegistrazioneAudio/Filmato non istanziato correttamente.");
			System.exit(-1);
		}
	}
	
	@Override
	public int weaker() {
		if(this.getVolume() == 1) {
			System.out.println("Non è possibile abbassare ulteriormente il volume.");
			return this.getVolume();
		}
		else {
			this.setVolume(this.getVolume()-1);
			return this.getVolume();
		}
	}
	
	@Override
	public int louder() {
		this.setVolume(this.getVolume()+1);
		return this.getVolume();
	}
	
	@Override
	public void play() {
		for(int i = this.getDurata(); i > 0; i--) {
			System.out.println(this.getTitolo());
		}
		for(int i = this.getVolume(); i > 0; i--) {
			System.out.println("!");
		}
	}

}
