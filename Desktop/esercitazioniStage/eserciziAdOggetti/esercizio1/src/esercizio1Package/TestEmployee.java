package esercizio1Package;

/*
Scrivere una classe Employee (dipendente) che estende la classe Person.
Ogni dipendente ha un proprio anno di assunzione e un proprio stipendio. Si definiscano costruttori
e vari metodi get e set opportuni. Si ridefinisca inoltre il metodo visualize() opportunamente.
Si definisca inoltre un metodo gainsMore che prende come parametro un altro oggetto Employee e
restituisce true se l’oggetto corrente ha uno stipendio maggiore di quello ricevuto come parametro,
o false altrimenti.
Per testare la classe, scrivere un programma TestEmployee che crea tre oggetti della classe
Employee e li visualizza in ordine di stipendio (usando il nuovo metodo per confrontare gli
stipendi).
*/

public class TestEmployee {
	public static void main(String[]args) {
		Employee A = new Employee("Luca", "Franchi", "FRNSST99D50A877N", "Muggio'", 2018, 3000);
		Employee B = new Employee("Matteo", "Barzan", "DFNFGS01F50A577N", "Padova", 2019, 2000);
		Employee C = new Employee("Lorenzo", "Brazo", "ASJFAD98J50A742N", "Napoli", 2017, 1500);
		
		Employee[]array = {A, B, C};
		Employee[]sortedArray = new Employee[3];
		boolean maxFound = false;
		boolean mediumFound = false;
		boolean minFound = false;

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				for(int v = 0; v < array.length; v++) {
					if(array[i].gainsMore(array[j]) && array[i].gainsMore(array[v]) && !maxFound 
							&& array[i] != array[j] && array[i] != array[v] && array[j] != array[v]) {
						sortedArray[0] = array[i];
						maxFound = true;
						v = 3;
						j = 3;
					}
					else if((array[i].gainsMore(array[j]) || array[i].gainsMore(array[v])) && !mediumFound 
							&& array[i] != array[j] && array[i] != array[v] && array[j] != array[v]){
						sortedArray[1] = array[i];
						mediumFound = true;
						v = 3;
						j = 3;
					}
					else if(!minFound && array[i] != array[j] && array[i] != array[v] && array[j] != array[v]){
						sortedArray[2] = array[i];
						minFound = true;
					}
				}
			}
		}
		
		for(int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i].toString() + "	");
		}
		
	}

}
