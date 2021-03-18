class Esercizio3{
	public static void main(String[]args){
		//Scrivere un metodo che mostri i primi 50 numeri della serie di fibonacci (i primi due numeri di fibonacci sono 0 e 1 i successivi si calcolano come somma dei 2 precedenti).
		long [] fibo = new long [51]; //Inizia da 0 e finisce con il 50
		fibo[0] = 0;
		fibo[1] = 1;
		System.out.println(fibo[0]);
		System.out.println(fibo[1]);
		
		for(int i = 2; i <= 50; i++){
			fibo[i] = fibo[i-1]+fibo[i-2];
			System.out.println(fibo[i]);
		}
	}
}