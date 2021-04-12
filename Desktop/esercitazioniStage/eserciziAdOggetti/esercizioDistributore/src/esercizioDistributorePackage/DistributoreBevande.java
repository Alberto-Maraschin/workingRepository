package esercizioDistributorePackage;
import java.util.Scanner;

/*
Il distributore di bevande è in grado di erogare alcuni tipi di bevande; ogni bevanda è
caratterizzata da un codice, nome ed un prezzo.
Ad esempio:

Codice Bevanda Prezzo
A Acqua 0.20
B Coca 0.30
C Birra 1.00

Il metodo aggiungiBevanda() permette di aggiungere la descrizione di una bevanda.
Il distributore permette di conoscere, dato il codice, il prezzo e il nome della bevanda tramite i
metodi getPrice() e getName() rispettivamente.
Quando si richiede un codice corrispondente ad una bevanda non disponibile, viene generata
un’eccezione di BevandaNonValida.
*/

public class DistributoreBevande {
	Scanner tastiera = new Scanner(System.in);
	Bevanda[]bevandeDisponibili = new Bevanda[4];
	
	public DistributoreBevande() {
		String codice = "";
		String nome = "";
		String prezzo = "";
		
		for(int i = 0; i < bevandeDisponibili.length; i++) {
			System.out.println("Inserisci il nome di una bevanda che desideri essere nel distributore:	" 
					+ (bevandeDisponibili.length -i) + "	bevande mancanti per riempire il distributore.");
			
			nome = tastiera.next();
			while(nome.equals("")) {
				System.out.println("Inserisci una stringa non vuota.");
				nome = tastiera.next();
			}
			System.out.println("Inserisci il codice della bevanda.");
			codice = tastiera.next();
			while(codice.length() == 0 || codice.equals("0")) {
				System.out.println("Inserisci almeno un carattere e che sia diverso da zero.");
				codice = tastiera.next();
			}
			for(int j = 0; j < i; j++) {
				if(codice.equals(bevandeDisponibili[j].getCodice())) {
					System.out.println("Questo codice e' gia' stato assegnato ad una bibita diversa.");
					System.exit(-1);
				}
			}
			System.out.println("Inserisci il prezzo della bevanda.");
			prezzo = tastiera.next();
			while(prezzo.length() > 1 || prezzo.charAt(0) <= '0' || prezzo.charAt(0) > '9') {
				System.out.println("Una bevanda può solamente avere come prezzo un numero intero maggiore di zero e minore o uguale a 9.");
				prezzo = tastiera.next();
			}
			bevandeDisponibili[i] = new Bevanda(codice, nome, Integer.parseInt(prezzo));
		}
		
	}
	
	public Bevanda[] getBevandeDisponibili() {
		return bevandeDisponibili;
	}
	
	public Bevanda getBevandaDisponibile(int i) {
		return bevandeDisponibili[i];
	}

	public void setBevandeDisponibili(Bevanda[] bevandeDisponibili) {
		this.bevandeDisponibili = bevandeDisponibili;
	}

	public void aggiungiBevanda(Bevanda b) {
		System.out.println("Quale descrizione vuoi assegnare a	" + b.getNome());
		b.setDescrizione(tastiera.next());
	}
	
	public int getPrice(String codice) throws BevandaNonValidaException {
		boolean found = false;
		if(bevandeDisponibili[0] == null) {
			System.out.println("Il distributore è vuoto.");
			System.exit(0);
		}
		for(int i = 0; i < bevandeDisponibili.length && !found; i++) {
			if(codice.equals(bevandeDisponibili[i].getCodice())){
				found = true;
				return bevandeDisponibili[i].getPrezzo();
			}
		}
		throw new BevandaNonValidaException();
		
	}
	
	public String getName(String codice) throws BevandaNonValidaException {
		boolean found = false;
		int i = 0;
		if(bevandeDisponibili[0] == null) {
			System.out.println("Il distributore è vuoto.");
			System.exit(0);
		}
		for(i = 0; i < bevandeDisponibili.length && !found; i++) {
			if(codice.equals(bevandeDisponibili[i].getCodice())){
				found = true;
				return bevandeDisponibili[i].getNome();
			}
		}
		
		if(i == bevandeDisponibili.length-1) {
			throw new BevandaNonValidaException();
		}
		
		return "";
	}

}
