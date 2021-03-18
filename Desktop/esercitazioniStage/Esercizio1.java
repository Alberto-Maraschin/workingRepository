class Esercizio1{
	public static void main(String[]args){
		//dato un array di interi, popolato casualmente, ordinarlo in ordine crescente e stampare a video il risultato di tale ordinamento.
		int [] array = new int [10];
		System.out.println("Ecco l'array originale.");
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*100)+1;
			System.out.print(array[i] + "	");
		}
		System.out.println();
		System.out.println("Ecco l'array ordinato.");
		
		Metodi.quickSort(array, 0, 9);
		
		Metodi.printArray(array);
	}
}