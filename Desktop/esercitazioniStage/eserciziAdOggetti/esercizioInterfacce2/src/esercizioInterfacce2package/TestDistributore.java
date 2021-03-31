package esercizioInterfacce2package;
import java.util.Scanner;

/*
Scrivere un programma che sia in grado di istanziare degli oggetti &#39;distributori di benzina&#39; di cui sia nota la
città, il proprietario, la capacità e la benzina attualmente contenuta nel distributore. Dell&#39;oggetto
Distributore, deve essere possibile simulare le operazioni di erogazione del carburante e dei corrispondenti
incassi. Implementa una interfaccia Comparable, in modo da consentire il confronto tra 2 distributori in
base alla capacità del serbatoio di carburante.
*/

public class TestDistributore {
	public static void main(String[]args) {
		Scanner tastiera = new Scanner(System.in);
		DistributoreBenzina primo = new DistributoreBenzina("Napoli", "Carcarlo", 500, 400);
		DistributoreBenzina secondo = new DistributoreBenzina("Roma", "Gianpiero", 800, 800);
		
		System.out.println("Vuole fare benzina?");
		String risposta = tastiera.next();
		String distributore = "";
		
		if(risposta.equalsIgnoreCase("SI")) {
			System.out.println("Da quale distributore vuole fare benzina? Da:	" + primo.getProprietario() 
			+ "	oppure da:	" + secondo.getProprietario());
			
			primo.compare(secondo);
			
			distributore = tastiera.next();
			while(!(distributore.equalsIgnoreCase(primo.getProprietario())) && !(distributore.equalsIgnoreCase(secondo.getProprietario()))) {
				System.out.println("Questo distributore non esiste, per favore, riprovi.");
				distributore = tastiera.next();
			}
			System.out.println("Di quanti litri ha bisogno?");
			risposta = tastiera.next();
			for(int i = 0; i < risposta.length(); i++) {
				if(risposta.charAt(i) < '0' || risposta.charAt(i) > '9') {
					System.out.println("Non è stato inserito un numero intero, per favore riprovare.");
					i = 0;
					risposta = tastiera.next();
				}
			}
			if(distributore.equalsIgnoreCase(primo.getProprietario())) {
				System.out.println(primo.erogazione(Integer.parseInt(risposta)));
			}
			else {
				System.out.println(secondo.erogazione(Integer.parseInt(risposta)));
			}
			
			
		}
		
		
		
		tastiera.close();
	}

}
