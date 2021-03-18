class Esercizio4{
	public static void main(String[]args){
		/*Data una matrice effettuare la trasposta della stessa.
		Definizione trasposta : data una matrice A si dice trasposta una matrice At che abbia le colonne al posto delle righe e viceversa.
		*/
		int [][] matrix = new int [5][4];
		int [][] transpose = new int [4][5];
		Metodi.fillMatrix(matrix);
		System.out.println("Ecco la matrice originale:	");
		Metodi.printMatrix(matrix);
		System.out.println("Ecco la matrice trasposta:	");
		
		for(int i = 0; i < matrix[0].length; i++){
			for(int j = 0; j < matrix.length; j++){
				transpose[i][j] = matrix[j][i];
			}
		}
		
		Metodi.printMatrix(transpose);
	}
}