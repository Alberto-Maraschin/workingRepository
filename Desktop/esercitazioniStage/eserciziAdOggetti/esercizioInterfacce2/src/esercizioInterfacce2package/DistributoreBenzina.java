package esercizioInterfacce2package;

/*
Scrivere un programma che sia in grado di istanziare degli oggetti &#39;distributori di benzina&#39; di cui sia nota la
città, il proprietario, la capacità e la benzina attualmente contenuta nel distributore. Dell&#39;oggetto
Distributore, deve essere possibile simulare le operazioni di erogazione del carburante e dei corrispondenti
incassi. Implementa una interfaccia Comparable, in modo da consentire il confronto tra 2 distributori in
base alla capacità del serbatoio di carburante.
*/

public class DistributoreBenzina implements Comparable{
	private String citta;
	private String proprietario;
	private int capacita;
	private int quantitaBenzina;
	
	public DistributoreBenzina(String citta, String proprietario, int capacita, int quantitaBenzina) {
		if(capacita < quantitaBenzina) {
			System.out.println("Oggetto DistributoreBenzina non istanziato correttamente.");
			System.exit(-1);
		}
		this.citta = citta;
		this.proprietario = proprietario;
		this.capacita = capacita;
		this.quantitaBenzina = quantitaBenzina;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getCapacita() {
		return capacita;
	}

	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}

	public int getQuantitaBenzina() {
		return quantitaBenzina;
	}

	public void setQuantitaBenzina(int quantitaBenzina) {
		if(this.capacita < quantitaBenzina) {
			System.out.println("Oggetto DistributoreBenzina non istanziato correttamente.");
			System.exit(-1);
		}
		this.quantitaBenzina = quantitaBenzina;
	}
	
	public double erogazione(double litri) {
		if(this.quantitaBenzina < litri) {
			System.out.println("Non abbiamo abbastanza benzina per effettuare l'operazione.");
			System.exit(0);
		}
		else {
			this.quantitaBenzina -= litri;
		}
		System.out.println("Sto erogando:	" + litri + "	litri.");
		System.out.print("Prezzo:	");
		return litri*1.25;
	}
	
	public void compare(DistributoreBenzina other) {
		if(this == other) {
			System.out.println("I due distributori in input sono in realta' lo stesso oggetto.");
		}
		else {
			System.out.println("La capacita' del primo distributore e':	" + this.capacita 
					+ "	mentre la capacita' del secondo distributore e':	" + other.capacita);
		}
	}

}
