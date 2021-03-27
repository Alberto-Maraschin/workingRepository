package esercizio5Package;
import java.util.Scanner;

/*
Un Elemento Multimediale è una Immagine, un Filmato o una registrazione Audio identificato da
un titolo (una stringa non vuota).
Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un metodo play().
Una registrazione Audio è riproducibile e ha associato anche un volume (un valore positivo di tipo
int) e i metodi weaker() e louder() per regolarlo.
Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una
sequenza di punti esclamativi di lunghezza pari al volume (una stampa per riga).
Un Filmato è riproducibile e ha associato un volume regolabile analogo a quello delle registrazioni
audio e anche una luminosità (un valore positivo di tipo int) e i metodi brighter() e darker() per
regolarla.
Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una
sequenza di punti esclamativi di lunghezza pari al volume e poi a una sequenza di asterischi di
lunghezza pari alla luminosità (una stampa per riga).
Una Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella dei filmati e
un metodo show() che stampa il titolo concatenato a una sequenza di asterischi di lunghezza pari
alla luminosità.

Eseguire un oggetto multimediale significa invocarne il metodo show() se è un&#39;immagine o il
metodo play() se è riproducibile.

Organizzare opportunamente con classi astratte, interfacce e classi concrete il codice di un lettore
multimediale che memorizza 5 elementi (creati con valori letti da tastiera) in un array e poi chiede
ripetutamente all&#39;utente quale oggetto eseguire (leggendo un intero da 1 a 5 oppure 0 per finire) e
dopo ogni esecuzione fornisce la possibilità di regolarne eventuali parametri (volume / luminosità).
*/

public class TestElementoMultimediale {
	public static void main(String[]args) {
		Scanner tastiera = new Scanner(System.in);
		
		ElementoMultimediale[]playlist = new ElementoMultimediale[5];
		String risposta = "";
		String modifica = "";
		String titolo = "";
		String durata = "";
		String volume = "";
		String luminosita = "";
		String[]tipologie = new String[5]; //Array che utilizzero' in seguito per capire di che tipo di oggetto stiamo parlando
		
		System.out.println("Benvenuto in LettoreMultimediale2000, per cominciare, desidera inserire in playlist: un filmato, un'immagine o un audio?");
		
		//Ciclo per riempire la playlist
		for(int i = 0; i < 5; i++) {
			System.out.println("Digiti 1 per inserire un filmato, digiti 2 per un'immagine oppure digiti 3 per un audio.");
			risposta = tastiera.next();
			titolo = "";
			durata = "";
			volume = "";
			luminosita = "";
			
			//FILMATO
			if(risposta.equals("1")) {
				System.out.println("Per favore inserire il titolo del FILMATO.");
				titolo = tastiera.next();
				System.out.println("Per favore inserire la durata del FILMATO.");
				durata = tastiera.next();
				while(!(controllaInput(durata))) {
					System.out.println("Input non valido, riprova.");
					durata = tastiera.next();
				}
				System.out.println("Per favore inserire il volume del FILMATO.");
				volume = tastiera.next();
				while(!(controllaInput(volume))) {
					System.out.println("Input non valido, riprova.");
					volume = tastiera.next();
				}
				System.out.println("Per favore inserire la luminosita' del FILMATO.");
				luminosita = tastiera.next();
				while(!(controllaInput(luminosita))) {
					System.out.println("Input non valido, riprova.");
					luminosita = tastiera.next();
				}
				playlist[i] = new Filmato(titolo, Integer.parseInt(durata), Integer.parseInt(volume), Integer.parseInt(luminosita));
				tipologie[i] = "1";
			}
			//CHIUSURA FILMATO
			
			//IMMAGINE
			else if(risposta.equals("2")) {
				System.out.println("Per favore inserire il titolo dell' IMMAGINE.");
				titolo = tastiera.next();
				System.out.println("Per favore inserire la luminosita' dell'IMMAGINE.");
				luminosita = tastiera.next();
				while(!(controllaInput(luminosita))) {
					System.out.println("Input non valido, riprova.");
					luminosita = tastiera.next();
				}
				//Per ridurre la possibilità di input non validi da parte dell'utente, in caso di immagine imposto la durata a 0 in automatico
				playlist[i] = new Immagine(titolo, 0, Integer.parseInt(luminosita));
				tipologie[i] = "2";
			}
			//CHIUSURA IMMAGINE
			
			//AUDIO
			else if(risposta.equals("3")) {
				System.out.println("Per favore inserire il titolo dell' AUDIO.");
				titolo = tastiera.next();
				System.out.println("Per favore inserire la durata dell' AUDIO.");
				durata = tastiera.next();
				while(!(controllaInput(durata))) {
					System.out.println("Input non valido, riprova.");
					durata = tastiera.next();
				}
				System.out.println("Per favore inserire il volume dell' AUDIO.");
				volume = tastiera.next();
				while(!(controllaInput(volume))) {
					System.out.println("Input non valido, riprova.");
					volume = tastiera.next();
				}
				playlist[i] = new RegistrazioneAudio(titolo, Integer.parseInt(durata), Integer.parseInt(volume));
				tipologie[i] = "3";
			}
			//CHIUSURA AUDIO
			
			else {
				System.out.println("Input non valido, per favore inserisca soltanto: 1, 2 oppure 3.");
				i--;
			}
		}
		//Conclusione ciclo, playlist completata
		
		
		
		//Avvio della fase riproduttiva degli elementi multimediali
		System.out.println("Playlist completata, quale elemento volete riprodurre: 1, 2, 3, 4 oppure 5?");
		
		do {
			System.out.println("Inserire: 1, 2, 3, 4 oppure 5 per riprodurre, in alternativa digitare 0 per uscire.");
			risposta = tastiera.next();
			if(risposta.equalsIgnoreCase("0")) {
				System.out.println("Arrivederci");
				System.exit(0);
			}
			while(!(controllaInput(risposta))) {
				System.out.println("Per favore inserisca solo caratteri numerici.");
				risposta = tastiera.next();
			}
			switch(risposta) {
				case "1":
					if(playlist[0].getDurata() != 0) {
						playlist[0].play();
					}
					else {
						playlist[0].show();
					}
					switch(tipologie[0]) {
						case "1":
							System.out.println("Riproduzione Filmato terminata, desidera modificare il volume o la luminosita'?");
							modifica = tastiera.next();
							if(modifica.equalsIgnoreCase("SI")) {
								System.out.println("Desidera modificare il volume o la luminosita?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("volume")) && !(modifica.equalsIgnoreCase("luminosita"))) {
									System.out.println("Input non valido, inserisca: volume oppure luminosita");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("volume")) {
									System.out.println("Desidera abbassare o alzare il volume?");
									modifica = tastiera.next();
									while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
										System.out.println("Input non valido, inserisca: alzare oppure abbassare");
										modifica = tastiera.next();
									}
									if(modifica.equalsIgnoreCase("alzare")) {
										playlist[0].louder();
										System.out.println("Ora il volume e':	" + playlist[0].getVolume());
									}
									else {
										playlist[0].weaker();
										System.out.println("Ora il volume e':	" + playlist[0].getVolume());
									}
								}
								else {
									System.out.println("Desidera abbassare o alzare la luminosita'?");
									modifica = tastiera.next();
									while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
										System.out.println("Input non valido, inserisca: alzare oppure abbassare");
										modifica = tastiera.next();
									}
									if(modifica.equalsIgnoreCase("alzare")) {
										playlist[0].brighter();
										System.out.println("Ora la luminosita' e':	" + playlist[0].getLuminosita());
									}
									else {
										playlist[0].darker();
										System.out.println("Ora la luminosita' e':	" + playlist[0].getLuminosita());
									}
								}
							}
							break;
						case "2":
							System.out.println("Riproduzione Immagine terminata, desidera modificare la luminosita'?");
							modifica = tastiera.next();
							if(modifica.equalsIgnoreCase("SI")) {
								System.out.println("Desidera abbassare o alzare la luminosita'?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[0].brighter();
									System.out.println("Ora la luminosita' e':	" + playlist[0].getLuminosita());
								}
								else {
									playlist[0].darker();
									System.out.println("Ora la luminosita' e':	" + playlist[0].getLuminosita());
								}
							}
							break;
						case "3":
							System.out.println("Riproduzione Audio terminata, desidera modificare il volume?");
							modifica = tastiera.next();
							if(modifica.equalsIgnoreCase("SI")) {
								System.out.println("Desidera abbassare o alzare il volume?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[0].louder();
									System.out.println("Ora il volume e':	" + playlist[0].getVolume());
								}
								else {
									playlist[0].weaker();
									System.out.println("Ora il volume e':	" + playlist[0].getVolume());
								}
							}
							break;
					}
					break;
				
				case "2":
					if(playlist[1].getDurata() != 0) {
						playlist[1].play();
					}
					else {
						playlist[1].show();
					}
					switch(tipologie[1]) {
					case "1":
						System.out.println("Riproduzione Filmato terminata, desidera modificare il volume o la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera modificare il volume o la luminosita?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("volume")) && !(modifica.equalsIgnoreCase("luminosita"))) {
								System.out.println("Input non valido, inserisca: volume oppure luminosita");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("volume")) {
								System.out.println("Desidera abbassare o alzare il volume?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[1].louder();
									System.out.println("Ora il volume e':	" + playlist[1].getVolume());
								}
								else {
									playlist[1].weaker();
									System.out.println("Ora il volume e':	" + playlist[1].getVolume());
								}
							}
							else {
								System.out.println("Desidera abbassare o alzare la luminosita'?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[1].brighter();
									System.out.println("Ora la luminosita' e':	" + playlist[1].getLuminosita());
								}
								else {
									playlist[1].darker();
									System.out.println("Ora la luminosita' e':	" + playlist[1].getLuminosita());
								}
							}
						}
						break;
					case "2":
						System.out.println("Riproduzione Immagine terminata, desidera modificare la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare la luminosita'?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[1].brighter();
								System.out.println("Ora la luminosita' e':	" + playlist[1].getLuminosita());
							}
							else {
								playlist[1].darker();
								System.out.println("Ora la luminosita' e':	" + playlist[1].getLuminosita());
							}
						}
						break;
					case "3":
						System.out.println("Riproduzione Audio terminata, desidera modificare il volume?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare il volume?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[1].louder();
								System.out.println("Ora il volume e':	" + playlist[1].getVolume());
							}
							else {
								playlist[1].weaker();
								System.out.println("Ora il volume e':	" + playlist[1].getVolume());
							}
						}
						break;
				}
					break;
					
				case "3":
					if(playlist[2].getDurata() != 0) {
						playlist[2].play();
					}
					else {
						playlist[2].show();
					}
					switch(tipologie[2]) {
					case "1":
						System.out.println("Riproduzione Filmato terminata, desidera modificare il volume o la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera modificare il volume o la luminosita?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("volume")) && !(modifica.equalsIgnoreCase("luminosita"))) {
								System.out.println("Input non valido, inserisca: volume oppure luminosita");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("volume")) {
								System.out.println("Desidera abbassare o alzare il volume?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[2].louder();
									System.out.println("Ora il volume e':	" + playlist[2].getVolume());
								}
								else {
									playlist[2].weaker();
									System.out.println("Ora il volume e':	" + playlist[2].getVolume());
								}
							}
							else {
								System.out.println("Desidera abbassare o alzare la luminosita'?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[2].brighter();
									System.out.println("Ora la luminosita' e':	" + playlist[2].getLuminosita());
								}
								else {
									playlist[2].darker();
									System.out.println("Ora la luminosita' e':	" + playlist[2].getLuminosita());
								}
							}
						}
						break;
					case "2":
						System.out.println("Riproduzione Immagine terminata, desidera modificare la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare la luminosita'?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[2].brighter();
								System.out.println("Ora la luminosita' e':	" + playlist[2].getLuminosita());
							}
							else {
								playlist[2].darker();
								System.out.println("Ora la luminosita' e':	" + playlist[2].getLuminosita());
							}
						}
						break;
					case "3":
						System.out.println("Riproduzione Audio terminata, desidera modificare il volume?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare il volume?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[2].louder();
								System.out.println("Ora il volume e':	" + playlist[2].getVolume());
							}
							else {
								playlist[2].weaker();
								System.out.println("Ora il volume e':	" + playlist[2].getVolume());
							}
						}
						break;
				}
					break;
					
				case "4":
					if(playlist[3].getDurata() != 0) {
						playlist[3].play();
					}
					else {
						playlist[3].show();
					}
					switch(tipologie[3]) {
					case "1":
						System.out.println("Riproduzione Filmato terminata, desidera modificare il volume o la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera modificare il volume o la luminosita?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("volume")) && !(modifica.equalsIgnoreCase("luminosita"))) {
								System.out.println("Input non valido, inserisca: volume oppure luminosita");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("volume")) {
								System.out.println("Desidera abbassare o alzare il volume?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[3].louder();
									System.out.println("Ora il volume e':	" + playlist[3].getVolume());
								}
								else {
									playlist[3].weaker();
									System.out.println("Ora il volume e':	" + playlist[3].getVolume());
								}
							}
							else {
								System.out.println("Desidera abbassare o alzare la luminosita'?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[3].brighter();
									System.out.println("Ora la luminosita' e':	" + playlist[3].getLuminosita());
								}
								else {
									playlist[3].darker();
									System.out.println("Ora la luminosita' e':	" + playlist[3].getLuminosita());
								}
							}
						}
						break;
					case "2":
						System.out.println("Riproduzione Immagine terminata, desidera modificare la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare la luminosita'?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[3].brighter();
								System.out.println("Ora la luminosita' e':	" + playlist[3].getLuminosita());
							}
							else {
								playlist[3].darker();
								System.out.println("Ora la luminosita' e':	" + playlist[3].getLuminosita());
							}
						}
						break;
					case "3":
						System.out.println("Riproduzione Audio terminata, desidera modificare il volume?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare il volume?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[3].louder();
								System.out.println("Ora il volume e':	" + playlist[3].getVolume());
							}
							else {
								playlist[3].weaker();
								System.out.println("Ora il volume e':	" + playlist[3].getVolume());
							}
						}
						break;
				}
					break;
					
				case "5":
					if(playlist[4].getDurata() != 0) {
						playlist[4].play();
					}
					else {
						playlist[4].show();
					}
					switch(tipologie[4]) {
					case "1":
						System.out.println("Riproduzione Filmato terminata, desidera modificare il volume o la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera modificare il volume o la luminosita?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("volume")) && !(modifica.equalsIgnoreCase("luminosita"))) {
								System.out.println("Input non valido, inserisca: volume oppure luminosita");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("volume")) {
								System.out.println("Desidera abbassare o alzare il volume?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[4].louder();
									System.out.println("Ora il volume e':	" + playlist[4].getVolume());
								}
								else {
									playlist[4].weaker();
									System.out.println("Ora il volume e':	" + playlist[4].getVolume());
								}
							}
							else {
								System.out.println("Desidera abbassare o alzare la luminosita'?");
								modifica = tastiera.next();
								while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
									System.out.println("Input non valido, inserisca: alzare oppure abbassare");
									modifica = tastiera.next();
								}
								if(modifica.equalsIgnoreCase("alzare")) {
									playlist[4].brighter();
									System.out.println("Ora la luminosita' e':	" + playlist[4].getLuminosita());
								}
								else {
									playlist[4].darker();
									System.out.println("Ora la luminosita' e':	" + playlist[4].getLuminosita());
								}
							}
						}
						break;
					case "2":
						System.out.println("Riproduzione Immagine terminata, desidera modificare la luminosita'?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare la luminosita'?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[4].brighter();
								System.out.println("Ora la luminosita' e':	" + playlist[4].getLuminosita());
							}
							else {
								playlist[4].darker();
								System.out.println("Ora la luminosita' e':	" + playlist[4].getLuminosita());
							}
						}
						break;
					case "3":
						System.out.println("Riproduzione Audio terminata, desidera modificare il volume?");
						modifica = tastiera.next();
						if(modifica.equalsIgnoreCase("SI")) {
							System.out.println("Desidera abbassare o alzare il volume?");
							modifica = tastiera.next();
							while(!(modifica.equalsIgnoreCase("alzare")) && !(modifica.equalsIgnoreCase("abbassare"))) {
								System.out.println("Input non valido, inserisca: alzare oppure abbassare");
								modifica = tastiera.next();
							}
							if(modifica.equalsIgnoreCase("alzare")) {
								playlist[4].louder();
								System.out.println("Ora il volume e':	" + playlist[4].getVolume());
							}
							else {
								playlist[4].weaker();
								System.out.println("Ora il volume e':	" + playlist[4].getVolume());
							}
						}
						break;
				}
					break;
					
				case "0":
					break;
					
				default:
					System.out.println("Non avete inserito un numero compreso nell'intervallo [0, 5].");
					break;
					
			}
		} while(risposta != "0");
		
		//Conclusione
		tastiera.close();
	}
	
	public static boolean controllaInput(String input) {
		//Metodo che controlla se nella stringa ci sono caratteri che non sono dei numeri
		for(int i = 0; i < input.length(); i++) {
			if(i == 0 && input.charAt(i) == '0') {
				//Escludo lo zero perché solo la durata di un'Immagine puo' essere zero e comunque e' un campo che riempio in automatico
				//In pratica questo if serve a impedire un numero che inizi con 0 come input
				return false;
			}
			if(!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
				//Escludo lo zero perché solo la durata di un'Immagine puo' essere zero e comunque e' un campo che riempio in automatico
				return false;
			}
		}
		return true;
	}

}
