package org.example;

public class Forquilla {
    private int propietari;
    private int numero;
    public static final int LLIURE = -1;

    public Forquilla(int numero) {
        this.propietari = LLIURE;
        this.numero = numero;
    }

    public synchronized void agafar(int filosofId) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = filosofId;
    }

    public synchronized void deixar() {
        propietari = LLIURE;
        notifyAll();
    }

    public int getPropietari() {
        return propietari;
    }

    public int getNumero() {
        return numero;
    }
}