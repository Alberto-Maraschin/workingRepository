class EserciziArray1{
	public static void main(String[]args){
		/*Scrivere un programma / metodo che preveda un array di 10 numeri interi contenente valori a piacere e ne
		stampa gli elementi secondo il seguente ordine: il primo, l’ultimo, il secondo, il penultimo, il terzo, il
		terz’ultimo, ecc.
		*/
		int[]array={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int j = 9;
		for(int i = 0; i < 5; i++){
			System.out.print(array[i] + "	");
			System.out.print(array[j] + "	");
			j--;
		}
	}
}