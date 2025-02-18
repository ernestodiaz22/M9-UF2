package org.example;

import java.util.Random;

public class Filosof  extends Thread{
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;
    private int gana;
    private Random rnd;

    public Filosof(String name) {
        super(name);
        this.forquillaDreta = null;
        this.forquillaEsquerra = null;
        this.rnd = new Random();
        this.gana = 0;
    }

    @Override
    public void run(){
        while(true){
            if(rnd.nextInt(2) != 0){

                boolean comer = true;

                if(!forquillaEsquerra.isEnUs()){
                    System.out.println("Filòsof:" + getName() + " agafa la forquilla esquerra "+ forquillaEsquerra.getNumero());
                }else{
                    System.out.println("Filòsof:" + getName() + " espera (esquerra ocupada)");
                    comer = false;
                }

                if(!forquillaDreta.isEnUs() && comer){
                    System.out.println("Filòsof:" + getName() + " agafa la forquilla dreta "+ forquillaDreta.getNumero());
                }else if(forquillaDreta.isEnUs() && comer){
                    System.out.println("Filòsof:" + getName() + " deixa l'esquerra("+forquillaEsquerra.getNumero()+") i espera (dretra ocupada)");
                    comer = false;
                }

                if(!comer){
                    gana++;
                    System.out.println("Filòsof:" + getName() + " gana=" + gana);
                    try{
                        sleep(rnd.nextInt(501)+ 500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    if(gana != 0){
                        gana--;
                    }
                    System.out.println("Filòsof:" + getName() + " menja");
                    menjar();
                    System.out.println("Filòsof:" + getName() + " ha acabat de menjar");
                }
            }else{
                pensar();
            }
        }
    }

    public void menjar(){
        try{
            forquillaEsquerra.setEnUs(true);
            forquillaDreta.setEnUs(true);
            sleep(rnd.nextInt(1001) + 1000);
            forquillaEsquerra.setEnUs(false);
            forquillaDreta.setEnUs(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void pensar(){
        try{
            System.out.println("Filòsof:" + getName() + " pensant");
            sleep(rnd.nextInt(1001) + 1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public int getGana() {
        return gana;
    }

    public void setGana(int gana) {
        this.gana = gana;
    }

}
