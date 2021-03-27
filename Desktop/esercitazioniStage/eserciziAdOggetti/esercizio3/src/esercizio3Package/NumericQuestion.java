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

public class NumericQuestion extends Question {
	Scanner tastiera = new Scanner(System.in);
	
	public NumericQuestion(String domanda, String risposta, int punteggio) {
		super(domanda, risposta, punteggio);
		for (int i = 0; i < risposta.length(); i++){
			if(!(risposta.charAt(i) >= '0' && risposta.charAt(i) <= '9')) {
				System.out.println("Questa domanda deve avere come risposta un numero intero.");
				System.exit(-1);
			}
		}
	}
	
	@Override
	public void setRisposta(String risposta) {
		for (int i = 0; i < risposta.length(); i++){
			if(!(risposta.charAt(i) >= '0' && risposta.charAt(i) <= '9')) {
				System.out.println("Questa domanda deve avere come risposta un numero intero.");
				System.exit(-1);
			}
		}
		super.setRisposta(risposta);
	}
	
	public int ask() {
		int punteggio = 0;
		System.out.println(getDomanda());
		String risposta = tastiera.next();
		
		for (int i = 0; i < risposta.length(); i++){
			if(!(risposta.charAt(i) >= '0' && risposta.charAt(i) <= '9')) {
				System.out.println("Questa domanda deve avere come risposta un numero intero, riprova.");
				risposta = tastiera.next();
			}
		}
		if(risposta.equalsIgnoreCase(this.getRisposta())) {
			punteggio += this.getPunteggio();
		}
		return punteggio;
	}

}
