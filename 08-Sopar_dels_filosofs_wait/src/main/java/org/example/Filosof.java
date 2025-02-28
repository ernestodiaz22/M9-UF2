package org.example;

import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    private Random rnd;

    public Filosof(String name, Forquilla esquerra, Forquilla dreta) {
        super(name);
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.rnd = new Random();
        this.gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                agafarForquilles();
                menjar();
                deixarForquilles();
                pensar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void agafarForquilles() throws InterruptedException {
        synchronized (forquillaEsquerra) {
            forquillaEsquerra.agafar((int) getId());
            System.out.println("Filosof: " + getName() + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());
            synchronized (forquillaDreta) {
                if (forquillaDreta.getPropietari() == Forquilla.LLIURE) {
                    forquillaDreta.agafar((int) getId());
                    System.out.println("Filosof: " + getName() + " agafa la forquilla dreta " + forquillaDreta.getNumero());
                } else {
                    System.out.println("Filosof: " + getName() + " deixa l'esquerra (" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
                    forquillaEsquerra.deixar();
                    gana++;
                    System.out.println("Filosof: " + getName() + " gana=" + gana);
                    Thread.sleep(rnd.nextInt(501) + 500);
                    agafarForquilles();
                }
            }
        }
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filosof: " + getName() + " menja");
        Thread.sleep(rnd.nextInt(1001) + 1000);
    }

    private void deixarForquilles() {
        forquillaDreta.deixar();
        System.out.println("Filosof: " + getName() + " deixa la forquilla dreta " + forquillaDreta.getNumero());
        forquillaEsquerra.deixar();
        System.out.println("Filosof: " + getName() + " deixa la forquilla esquerra " + forquillaEsquerra.getNumero());
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosof: " + getName() + " pensant");
        Thread.sleep(rnd.nextInt(1001) + 1000);
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }
}
