class EserciziArray3{
	public static void main(String[]args){
		/*Scrivere un programma / metodo che preveda un array di 10 numeri interi contenente valori random e che
		stampi la dicitura "Tre valori consecutivi uguali" contiene tre valori uguali in tre posizioni
		consecutive,qualora la condizione non dovesse essere verificata dovrà stampare "NO".
		*/
		int[]array = new int [10];
		for(int i = 0; i < 10; i++){
			array[i] = (int)(Math.random()*10)+1;
		}
		for(int i = 0; i < 8; i++){
			if(array[i] == array[i+1] && array[i+1] == array[i+2]){
				System.out.println("Tre valori consecutivi uguali");
				Metodi.printArray(array);
				System.exit(0);
			}
		}
		System.out.println("NO");
	}
}