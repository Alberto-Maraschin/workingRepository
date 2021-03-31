package esercizioInterfacce2package;

/*
Scrivere un programma che sia in grado di istanziare degli oggetti &#39;distributori di benzina&#39; di cui sia nota la
città, il proprietario, la capacità e la benzina attualmente contenuta nel distributore. Dell&#39;oggetto
Distributore, deve essere possibile simulare le operazioni di erogazione del carburante e dei corrispondenti
incassi. Implementa una interfaccia Comparable, in modo da consentire il confronto tra 2 distributori in
base alla capacità del serbatoio di carburante.
*/

public interface Comparable {
	public static final int Icapacita = 0;
	
	public void compare(DistributoreBenzina other);

}
