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

//Tuttavia uso solo questa classe per fare un unico main per i 4 esercizi riguardanti il distributore

public class TestBevande {
	public static void main(String[]args) 
			throws BevandaNonValidaException, TesseraNonValidaException, CreditoInsufficienteExcpetion, BevandaEsauritaException {
		Scanner tastiera = new Scanner(System.in);
		String [][] distributoreAMatrice;
		DistributoreBevande distributore = new DistributoreBevande();
		boolean found = false;
		int temp = 0;
		Tessera [] databaseTessere = {new Tessera(12345, 50), new Tessera(42424, 80), 
				new Tessera(28342, 100), new Tessera(12042, 1), new Tessera(98765, 5)};
		
		System.out.println("Vuoi aggiungere una descrizione ad una qualche bevanda? Se sì, digiti il codice della bevanda, altrimenti digiti 0.");
		
		String risposta = tastiera.next();
		for(int i = 0; i < distributore.bevandeDisponibili.length && !found && !(risposta.equals("0")); i++) {
			if(risposta.equals(distributore.bevandeDisponibili[i].getCodice())) {
				distributore.aggiungiBevanda(distributore.bevandeDisponibili[i]);
				found = true;
			}
		}
		
		found = false;
		
		System.out.println("Inserisci il codice di una bevanda e restituiro' il loro nome e il loro prezzo, altrimenti digiti 0");
		risposta = tastiera.next();
		
		if(!(risposta.equals("0"))) {
			System.out.println(distributore.getPrice(risposta));
			System.out.println(distributore.getName(risposta));
		}
		
		// ----------------------------------------- Parte della tessera - Esercizio 2
		
		System.out.println("Se possiede una tessera di credito, puo' conoscere il credito residuo, "
				+ "se desidera farlo allora inserisca il codice della sua tessera, altrimenti digiti 0."); //Anche un codice non valido conta come 0
		
		String codiceTessera = tastiera.next();
		boolean tesseraValida = false; // questa variabile servirà per la parte di erogazione
		
		if(!(codiceTessera.equals("0"))) {
			if(controllaInput(codiceTessera)) {
				temp = Integer.parseInt(codiceTessera);
				for(int i = 0; i < databaseTessere.length && !found; i++) {
					if(temp == databaseTessere[i].getCodice()) {
						databaseTessere[i].leggiCredito(temp);
						databaseTessere[i].caricaTessera();
						tesseraValida = true;
					}
				}
			}
		}
		
		// ----------------------------------------- Parte dell'approvvigionamento - Esercizio 3
		
		distributoreAMatrice = new String[4][3];
		System.out.println("");
		System.out.println("DISTRIBUTORE");
		
		for(int i = 0; i < 4; i++) {
			distributoreAMatrice[i][0] = "" + (i+1);
			System.out.print(distributoreAMatrice[i][0] + "	");
			distributoreAMatrice[i][1] = distributore.bevandeDisponibili[i].getNome();
			System.out.print(distributoreAMatrice[i][1] + "	");
			distributoreAMatrice[i][2] = "" + (int)(Math.random()*10)+1;
			System.out.print(distributoreAMatrice[i][2] + "	");
			System.out.println();
		}
		
		System.out.println("Dato il codice di una bibita sono in grado di dire quante lattine di essa sono disponibili"
				+ "	inserisca il codice della lattina, altrimenti digiti 0.");
		
		String code = tastiera.next();
		if(!(code.equals("0"))) {
			for(int i = 0; i < distributore.getBevandeDisponibili().length; i++) {
				if(code.equals(distributore.getBevandaDisponibile(i).getCodice())) {
					lattineDisponibili(code);
					System.out.println(distributoreAMatrice[i][2] + "	lattine.");
				}
			}
		}
		
		System.out.println("C'è per caso bisogno di rifornire una qualche bibita, "
				+ "in caso digiti il codice della bevanda; se la risposta e' no allora digitare 0.");
		
		String codice = tastiera.next();
		
		if(!(codice.equals("0"))) {
			System.out.println("Input ricevuto, che numero di lattine vuole impostare?");
			String nuoveLattine = tastiera.next();
			while(!controllaInput(nuoveLattine)) {
				System.out.println("Non è stato inserito un numero intero maggiore o uguale a zero, per favore, riprovare.");
				nuoveLattine = tastiera.next();
			}
			for(int i = 0; i < distributore.getBevandeDisponibili().length; i++) {
					if(distributore.getBevandaDisponibile(i).getCodice().equals(codice)) {
						distributoreAMatrice[i][2] = aggiornaColonna(2, codice, nuoveLattine);
					}
			}
			
			System.out.println("Ecco il distributore aggiornato.");
			
			for(int i = 0; i < 4; i++) {
				System.out.print(distributoreAMatrice[i][0] + "	");
				System.out.print(distributoreAMatrice[i][1] + "	");
				System.out.print(distributoreAMatrice[i][2] + "	");
				System.out.println();
			}
		}
		
		// ------------------------------------------------------------------------------ Parte dell'erogazione, esercizio 4
		
		if(!tesseraValida) {
			System.out.println("Non possedendo una tessera non può procedere con l'erogazione.");
		}
		else {
			System.out.println("Inserisca il codice della bibita che vuole prelevare altrimenti digiti 0 per terminare il programma.");
			code = tastiera.next();
			if(code.equals("0")) {
				System.exit(0);
			}
			tastiera.close();
			
			for(int i = 0; i < distributore.getBevandeDisponibili().length; i++) {
				if(code.equals(distributore.getBevandaDisponibile(i).getCodice())) {
					System.out.println("La bibita scelta si chiama:	" + distributore.getBevandaDisponibile(i).getNome());
					
					for(int j = 0; j < databaseTessere.length; j++) {
						if(Integer.parseInt(codiceTessera) == databaseTessere[j].getCodice()) {
							if(databaseTessere[j].getCredito() <= distributore.getBevandaDisponibile(i).getPrezzo()) {
								throw new CreditoInsufficienteExcpetion();
							}
							else {
								distributoreAMatrice[i][2] = eroga(distributoreAMatrice[i][2]);
								databaseTessere[j].setCredito(databaseTessere[j].getCredito()-distributore.getBevandaDisponibile(i).getPrezzo());
								System.out.println("Erogazione riuscita, il suo credito rimanente è:	" 
										+ databaseTessere[j].getCredito());
								System.out.println("Ecco il distributore aggiornato.");
								for(int z = 0; z < 4; z++) {
									System.out.print(distributoreAMatrice[z][0] + "	");
									System.out.print(distributoreAMatrice[z][1] + "	");
									System.out.print(distributoreAMatrice[z][2] + "	");
									System.out.println();
								}
								System.exit(0);
							}
						}
					}
				}
			}
		}
		
		
	}
	
	public static boolean controllaInput(String input) {
		//Controlla se nella stringa in input sono presenti caratteri che non sono numeri
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	public static String aggiornaColonna(int colonna, String bevanda, String nuoveLattineDisponibili) {
		return nuoveLattineDisponibili;
	}
	
	public static void lattineDisponibili(String code) {
		System.out.print("Sono disponibili:	");
	}
	
	public static String eroga(String bevande) throws BevandaEsauritaException{
		int numero = Integer.parseInt(bevande) -1;
		if(numero < 0) {
			throw new BevandaEsauritaException();
		}
		return "" + numero;
	}

}
