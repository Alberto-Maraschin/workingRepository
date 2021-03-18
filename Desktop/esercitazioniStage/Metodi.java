class Metodi{
	public static int partition(int[] array, int begin, int end) {
		int pivot = end;
		int counter = begin;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[pivot]) {
				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[counter];
		array[counter] = temp;
		return counter;
	}

	public static void quickSort(int[]array, int begin, int end) {
		if (end <= begin) return; //caso base
		int pivot = partition(array, begin, end);
		quickSort(array, begin, pivot-1);
		quickSort(array, pivot+1, end);
	}
	
	public static void printArray(int[]array){
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + "	");
		}
		System.out.println();
	}
	
	public static boolean palindroma(String stringa){
		int j = stringa.length()-1;
		if(stringa.length()%2 == 1){ //Se la stringa è ha una lunghezza dispari allora non può essere palindroma
			System.out.println("Una stringa di lunghezza dispari non puo' essere palindroma.");
			return false;
		}
		for(int i = 0; i < stringa.length()/2; i++){
			if(stringa.charAt(i) == stringa.charAt(j)){
				j--;
			}
			else
				return false;
		}
		return true;
	}
	
	public static void fillMatrix(int[][]matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = (int)(Math.random()*10)+1;
			}
		}
	}
	
	public static void printMatrix(int[][]matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println("");
		}
	}
}