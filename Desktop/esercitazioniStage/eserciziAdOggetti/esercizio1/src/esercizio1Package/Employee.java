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

public class Employee extends Person {
	private int hireYear;
	private int salary;
	
	public Employee(String name, String surname, String taxCode, String city, int hireYear, int salary){
		super(name, surname, taxCode, city);
		this.hireYear = hireYear;
		this.salary = salary;
	}
	
	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}
	
	public int getHireYear() {
		return this.hireYear;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Anno di assunzione: " + this.getHireYear() + " Stipendio: " + salary;
	}
	
	public boolean gainsMore(Employee E) {
		if(this.getSalary() > E.getSalary()) {
			return true;
		}
		else {
			return false;
		}
	}

}
