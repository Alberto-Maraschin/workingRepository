class EserciziArray2{
	public static void main(String[]args){
		/*Scrivere un programma / metodo che preveda un array di 10 numeri interi contenente valori random. Tale
		programma dovrà stampare la dicitura "Pari e dispari uguali"; se la somma dei numeri in posizioni pari
		dell’array è uguale alla somma dei numeri in posizioni dispari, altrimenti il programma dovrà stampare la
		dicitura "Pari e dispari diversi".
		*/
		int[]array = new int [10];
		int sommaPari = 0;
		int sommaDispari = 0;
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*100)+1;
		}
		for(int i = 0; i < 10; i++){
			if(i%2 == 0){
				sommaPari += array[i];
			}
			else{
				sommaDispari += array[i];
			}
		}
		if(sommaPari == sommaDispari){
			System.out.print("Pari e dispari uguali");
		}
		else if(sommaPari != sommaDispari){
			System.out.print("Pari e dispar diversi");
		}
	}
}