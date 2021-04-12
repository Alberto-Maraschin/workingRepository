package esercizioDistributorePackage;

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

public class Bevanda {
	private String codice;
	private String nome;
	private int prezzo;
	private String descrizione;
	
	public Bevanda(String codice, String nome, int prezzo) {
		if(codice.length() == 0 || codice.equals("0") || nome.equals("") || prezzo == 0) {
			System.out.println("Oggetto bevanda non istanziato correttamente.");
			System.exit(-1);
		}
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public void setCodice(String codice) {
		if(codice.equals("0")) {
			System.out.println("Non puoi inserire 0 come codice.");
			System.exit(-1);
		}
		this.codice = codice;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
