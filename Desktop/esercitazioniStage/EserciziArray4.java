class EserciziArray4{
	public static void main(String[]args){
		/*Scrivere un programma / metodo che date due sequenze di stringhe, ciascuna di 5 elementi, stampi il
		messaggio "OK" se almeno una stringa della prima sequenza compare anche nella seconda, altrimenti sarà
		stampato il messaggio "KO". Qualora vengano trovate due stringhe uguali i confronti tra le sequenze
		devono essere interrotti.
		*/
		String [] firstSequence = {"Ciao", "Buongiorno", "Buonasera", "Arrivederci"};
		String [] secondSequence = {"Pasta", "Pizza", "Tonno", "Cia", "Arrivederc", "Buongiorno"};
		
		for(int i = 0; i < firstSequence.length; i++){
			for(int j = 0; j < secondSequence.length; j++){
				if(firstSequence[i].equals(secondSequence[j])){
					System.out.println("OK");
					System.exit(0);
				}
			}
		}
		System.out.println("KO");
	}
}