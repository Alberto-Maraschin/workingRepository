class EserciziStringhe3{
	public static void main(String[]args){
		/*Scrivere un programma / metodo che data una sequenza di stringhe, conclusa dalla stringa vuota, stampi
		la somma delle lunghezze delle stringhe che iniziano con una lettera maiuscola. Per esempio, se si
		immettono le stringhe "Albero", "foglia", "Radici", "Ramo", "fiore" (e poi "" per finire), il programma stampa 16.
		*/
		String string1 = "Albero	";
		String string2 = "fogliA	";
		String string3 = "RadIci	";
		String string4 = "RamO	";
		String string5 = "fIore	";
		String string6 = "";
		String sequence = string1 + string2 + string3+ string4 +string5 + string6;
		int result = 0;
		
		for(int i = 0; i < sequence.length(); i++){
			if((sequence.charAt(i) >= 'A' && sequence.charAt(i) <= 'Z') && (i == 0 || sequence.charAt(i-1) == '	')){
				//Se i è uguale a 0 oppure se i-1 è uguale a tab allora nella posizione i-esima inizia una parola.
				for(int j = i; (j < sequence.length() && sequence.charAt(j) != '	'); j++){
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}