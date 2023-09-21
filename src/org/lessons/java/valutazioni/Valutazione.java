package org.lessons.java.valutazioni;

import java.util.Scanner;

public class Valutazione {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numStudenti = 20;
    Studente[] studenti = new Studente[numStudenti];
    int studentiPromossi = 0;

    for (int i = 0; i < numStudenti; i++) {
        System.out.println("Inserisci i dati dello studente " + (i + 1) + ":");
        System.out.print("Numero di assenze (da 0 a 100): ");
        int assenze = sc.nextInt();

        System.out.print("Media dei voti (da 0 a 5): ");
        double mediaVoti = sc.nextDouble();

        studenti[i] = new Studente(assenze, mediaVoti);

        if (studenti[i].isPromosso()) {
            studentiPromossi++;
        }
    }

    sc.close();

    // Array studenti promosso + bocciati
    Studente[] promossi = new Studente[studentiPromossi];
    Studente[] bocciati = new Studente[numStudenti - studentiPromossi];

    int promossiIndex = 0;
    int bocciatiIndex = 0;

    for (int i = 0; i < numStudenti; i++) {
        if (studenti[i].isPromosso()) {
            promossi[promossiIndex++] = studenti[i];
        } else {
            bocciati[bocciatiIndex++] = studenti[i];
        }
    }

    // Stampa studenti promossi
    System.out.println("Studenti promossi:");
    for (Studente studente : promossi) {
        System.out.println("ID: " + studente.getID());
        System.out.println("Assenze: " + studente.getAssenze());
        System.out.println("Media dei voti: " + studente.getMediaVoti());
        System.out.println("-----------------------------");
    }

    // Stampa studenti bocciati
    System.out.println("Studenti bocciati:");
    for (Studente studente : bocciati) {
        System.out.println("ID: " + studente.getID());
        System.out.println("Assenze: " + studente.getAssenze());
        System.out.println("Media dei voti: " + studente.getMediaVoti());
        System.out.println("-----------------------------");
    }

    // promosso & voto + alto
    Studente studenteConVotoPiuAlto = null;
    double votoPiuAlto = -1;

    for (Studente studente : promossi) {
        if (studente.getMediaVoti() > votoPiuAlto) {
            votoPiuAlto = studente.getMediaVoti();
            studenteConVotoPiuAlto = studente;
        }
    }

    // bocciato & voto + basso
    Studente studenteConVotoPiuBasso = null;
    double votoPiuBasso = 6; // Settato a un valore superiore al massimo

    for (Studente studente : bocciati) {
        if (studente.getMediaVoti() < votoPiuBasso) {
            votoPiuBasso = studente.getMediaVoti();
            studenteConVotoPiuBasso = studente;
        }
    }

    // ID studente promosso & voto + alto
    System.out.println("ID dello studente con il voto più alto tra i promossi: " + studenteConVotoPiuAlto.getID());

    // ID studente bocciato & voto + basso
    System.out.println("ID dello studente con il voto più basso tra i bocciati: " + studenteConVotoPiuBasso.getID());
}
}
