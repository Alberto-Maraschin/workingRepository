package esercizio3Package;
import java.util.Scanner;

/*
Scrivere la classe Question i cui oggetti rappresentano domande di esami orali. Ogni quesito si
compone di una domanda, di una risposta corretta e di un punteggio, e mette a disposizione un
metodo ask() che stampa la domanda, legge la risposta dell’utente e restituisce il punteggio
conseguito (0 se la risposta dell’utente `e sbagliata).
Scrivere la classe QuestionYesNo che estende la classe Question in modo da rappresentare
domande a cui possa essere risposto solo si o no. Sovrascrivere il metodo ask() in modo da garantire
che l’utente risponda si o no (prima che venga restituito il punteggio conseguito).
Scrivere la classe NumericQuestion che estende la classe Question in modo da rappresentare
domande a cui possa essere risposto solo con un valore intero. Sovrascrivere il metodo ask() in
modo da garantire che l’utente risponda con un valore intero (prima che venga restituito il
punteggio conseguito).
Scrivere la classe MultipleQuestion che estende la classe NumericQuestion in modo da
rappresentare domande che offrono un certo numero di opzioni (prefissato) e alle quali possa essere
risposto solo con un valore intero positivo minore o uguale al numero di opzioni disponibili.
Sovrascrivere il metodo ask() in modo da garantire che l’utente risponda con un valore consentito
(prima che venga restituito il punteggio conseguito).
Scrivere il programma TestQuestion che riempie un array con quesiti di diversa natura e poi simula
un’interrogazione calcolando il punteggio totale ottenuto. A scelta, l’interrogazione può essere fatta
estraendo in modo casuale tre quesiti dall’array.

Per l’estrazione casuale usare il metodo nextInt(int n) della classe Random (importare
java.util.Random).
*/

public class MultipleQuestion extends NumericQuestion {
	Scanner tastiera = new Scanner(System.in);
	
	public MultipleQuestion(String domanda, String risposta, int punteggio) {
		super(domanda, risposta, punteggio);
		if(risposta.length() > 1) {
			System.out.println("Questa domanda può avere come risposta un numero da 1 a 4, inserisci solo una di queste cifre.");
			System.exit(-1);
		}
		if((!(risposta.equals("1"))) && (!(risposta.equals("2"))) && (!(risposta.equals("3"))) 
				&& (!(risposta.equals("4")))) {
			System.out.println("Questa domanda può avere come risposta un numero da 1 a 4.");
			System.exit(-1);
		}
	}
	
	@Override
	public void setRisposta(String risposta) {
		if(risposta.length() > 1) {
			System.out.println("Questa domanda può avere come risposta un numero da 1 a 4, inserisci solo una di queste cifre.");
			System.exit(-1);
		}
		if((!(risposta.equals("1"))) && (!(risposta.equals("2"))) && (!(risposta.equals("3"))) 
				&& (!(risposta.equals("4")))) {
			System.out.println("Questa domanda può avere come risposta un numero da 1 a 4.");
			System.exit(-1);
		}
		super.setRisposta(risposta);
	}
	
	@Override
	public int ask() {
		int punteggio = 0;
		System.out.println(getDomanda());
		String risposta = tastiera.next();
		
		while((!(risposta.equals("1"))) && (!(risposta.equals("2"))) && (!(risposta.equals("3"))) 
				&& (!(risposta.equals("4")))) {
			System.out.println("Questa domanda può avere come risposta un numero da 1 a 4, riprova.");
			risposta = tastiera.next();
		}
		
		if(this.getRisposta().equals(risposta)) {
			punteggio += this.getPunteggio();
		}
		return punteggio;
	}

}
