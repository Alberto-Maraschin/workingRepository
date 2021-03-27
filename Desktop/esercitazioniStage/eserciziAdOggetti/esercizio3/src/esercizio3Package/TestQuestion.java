package esercizio3Package;
import java.util.Random;
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

public class TestQuestion {
	public static void main(String[]args) {
		Scanner tastiera = new Scanner(System.in);
		int questionsRemaining = 0;
		int punteggioFinale = 0;
		Random number = new Random();
		int temp = 0;
		boolean stop = false;
		int [] answeredQuestions = {5, 5, 5, 5, 5};
		
		Question domanda1 = new Question("Che tipo di linguaggio è JAVA?", "Imperativo", 10);
		NumericQuestion domanda2 = new NumericQuestion("Quando è iniziata la seconda guerra mondiale?", "1939", 3);
		QuestionYesNo domanda3 = new QuestionYesNo("La risposta alla domanda fondamentale è 42?", "Si", 8);
		MultipleQuestion domanda4 = new MultipleQuestion("Quanto fa 42 - 38 + 35 - 38?", "1", 5);
		MultipleQuestion domanda5 = new MultipleQuestion
				("Chi ha portato la pasta in europa? 1: Marco polo, 2: Indiana Jones, 3: Pensiero Profondo, 4: Jack Sparrow", "1", 4);
		Question[]questions = {domanda1, domanda2, domanda3, domanda4, domanda5};
		
		System.out.println("Buongiorno, vuole eseguire il quiz per intero oppure preferisce rispondere solo a 3 domande casuali?");
		System.out.println("Digiti 1 per il quiz completo oppure digiti 2 per le tre domande casuali.");
		String risposta = tastiera.next();
		while(!(risposta.equals("1") || risposta.equals("2"))) {
			System.out.println("Input non valido, puoi inserire solo 1 oppure 2.");
			risposta = tastiera.next();
		}
		if(risposta.equals("1")) {
			questionsRemaining = 5;
		}
		else {
			questionsRemaining = 3;
		}
		
		while(questionsRemaining > 0) {
			temp = number.nextInt(5); //Il 5 è escluso, genererà un numero da 0 a 4
			
			//Faccio ora un verifica per essere sicuro di non chiedere 2 volte la stessa domanda
			
			for(int i = 0; i < answeredQuestions.length && !stop; i++) {
				if(answeredQuestions[i] == 5) {
					//Se la casella i-esima contiene 5, allora significa che c'è ancora almeno una domanda a cui l'utente non ha risposto
					//Sovrascivo il 5 con il numero della domanda che il programma sta per fare e faccio in modo che la domanda non venga chiesta di nuovo
					answeredQuestions[i] = temp;
					stop = true;
				}
				else if(answeredQuestions[i] == temp) {
					i = 5;
				}
			}
			if(stop) {
				temp = questions[temp].ask();
				punteggioFinale += temp;
				questionsRemaining--;
				stop = false;
			}
		}
		
		System.out.println("Hai totalizzato il punteggio di: " + punteggioFinale);
		tastiera.close();
	}

}
