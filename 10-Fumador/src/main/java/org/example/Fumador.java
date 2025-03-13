package org.example;

import java.util.Random;

public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int numFumades;
    private Random rnd;


    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        this.rnd = new Random();
        this.tabac = null;
        this.llumi = null;
        this.paper = null;
        this.numFumades = 0;
    }

    public void fuma(){
        if(tabac != null && paper != null && llumi != null){
            try {
                sleep(rnd.nextInt(500, 1001));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            tabac = null;
            llumi = null;
            paper = null;
            numFumades++;
            System.out.println("Fumador "+id+" fumant");
            System.out.println("Fumador "+id+" ha fumat "+numFumades+" vegades");
        }
    }
    public synchronized void comprarTabac(){
        synchronized (estanc){
            tabac = estanc.venTabac();
            System.out.println("Fumador "+id+" comprant Tabac");
        }
    }
    public synchronized  void comprarPaper(){
        synchronized (estanc) {
            paper = estanc.venPapper();
            if (paper != null) {
                System.out.println("Fumador " + id + " comprant Paper");
            }
        }
    }
    public synchronized  void comprarLlumi(){
        synchronized (estanc) {
            llumi = estanc.venLlumi();
            if (llumi != null) {
                System.out.println("Fumador " + id + " comprant Llumi");
            }
        }

    }

    public int getNumFumades(){
        return numFumades;
    }

    public boolean compNumFumades(Fumador[] fumadors){
        for(Fumador fumador : fumadors){
            if (fumador.getNumFumades() == 3) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run(){
        for(int i = 0; i < 3; i++){
            comprarTabac();
            comprarPaper();
            comprarLlumi();
            fuma();
        }
    }
}
