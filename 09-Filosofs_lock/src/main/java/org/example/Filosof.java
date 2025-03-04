package org.example;

import java.util.concurrent.ThreadLocalRandom;

class Filosof extends Thread {
    private final int num;
    private final Forquilla esquerra, dreta;
    private long iniciGana;
    private long fiGana;
    private long gana;

    public Filosof(String name, int num, Forquilla esquerra, Forquilla dreta) {
        super(name);
        this.num = num;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() throws InterruptedException {
        iniciGana = System.currentTimeMillis();
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
    }

    private void menjar() throws InterruptedException {
        agafarForquilles();
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
        System.out.println("Fil" + num + " té forquilles esq(" + esquerra.getNum() + ") dreta(" + dreta.getNum() + ")");
        System.out.println("Fil" + num + " menja amb gana " + gana);
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
        resetGana();
        deixarForquilles();
    }

    private void agafarForquilles() throws InterruptedException {
        esquerra.agafar();
        if (!dreta.getBloqueig().tryLock()) {
            esquerra.deixar();
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1001));
            agafarForquilles();
        }
    }

    private void deixarForquilles() {
        dreta.deixar();
        esquerra.deixar();
        System.out.println("Fil" + num + " deixa les forquilles");
    }

    private void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
    }

    public Forquilla getDreta() {
        return dreta;
    }

    public Forquilla getEsquerra() {
        return esquerra;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}