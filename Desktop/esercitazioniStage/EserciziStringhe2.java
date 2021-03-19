import java.util.Scanner;
class EserciziStringhe2{
	public static void main(String[]args){
		Scanner tastiera = new Scanner(System.in);
		/*Scrivere un programma / metodo che data una stringa in input ne stampi le sole vocali. Per esempio, se si
		immette la stringa "Viva Java", il programma stampa "iaaa".
		*/
		System.out.println("Per favore, inserire una stringa.");
		String answer = tastiera.nextLine();
		String justVowels = "";
		
		for(int i = 0; i < answer.length(); i++){
			switch(answer.charAt(i)){
				case 'a':
				justVowels += 'a';
				break;
				
				case 'A':
				justVowels += 'A';
				break;
				
				case 'e':
				justVowels += 'e';
				break;
				
				case 'E':
				justVowels += 'E';
				break;
				
				case 'i':
				justVowels += 'i';
				break;
				
				case 'I':
				justVowels += 'I';
				break;
				
				case 'o':
				justVowels += 'o';
				break;
				
				case 'O':
				justVowels += 'O';
				break;
				
				case 'u':
				justVowels += 'u';
				break;
				
				case 'U':
				justVowels += 'U';
				break;
			}
		}
		System.out.println("Ecco la stringa contando solo le vocali:	" +justVowels);
	}
}