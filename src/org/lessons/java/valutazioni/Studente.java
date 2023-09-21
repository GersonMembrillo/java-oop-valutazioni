package org.lessons.java.valutazioni;

public class Studente extends Valutazione {
    private int id;
    private int assenze;
    private double mediaVoti;

    private static int contatoreID = 1;

    public Studente(int assenze, double mediaVoti) {
        this.id = contatoreID++;
        this.assenze = assenze;
        this.mediaVoti = mediaVoti;
    }

    public int getID() {
        return id;
    }

    public int getAssenze() {
        return assenze;
    }

    public double getMediaVoti() {
        return mediaVoti;
    }

    public boolean isPromosso() {
        if (assenze > 50) {
            return false;
        } else {
            return mediaVoti >= 2;
        } 
    }
    
}
     

    
