package org.example;

import java.util.Random;

public class Futbolista extends Thread{
    private final static int NUM_JUGADORS = 11;
    private final int NUM_TIRADES = 20;
    private final float PROBABILITAT = 0.5f;
    private Random acierto = new Random();
    private  int ngols = 0;
    private int ntirades = 0;

    public Futbolista(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i = 0; i < NUM_TIRADES; i++){
            if(acierto.nextFloat() < PROBABILITAT){
                ngols++;
            }
            ntirades++;
        }
    }

    public static int getNUM_JUGADORS() {
        return NUM_JUGADORS;
    }

    public int getNUM_TIRADES() {
        return NUM_TIRADES;
    }

    public float getPROBABILITAT() {
        return PROBABILITAT;
    }

    public Random getAcierto() {
        return acierto;
    }

    public void setAcierto(Random acierto) {
        this.acierto = acierto;
    }

    public int getNgols() {
        return ngols;
    }

    public void setNgols(int ngols) {
        this.ngols = ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public void setNtirades(int ntirades) {
        this.ntirades = ntirades;
    }
}

