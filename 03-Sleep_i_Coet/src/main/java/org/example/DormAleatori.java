package org.example;
import java.util.Random;

public class DormAleatori extends Thread{
    private long comienzo;
    private int intervalo;
    private Random random = new Random();

    public  DormAleatori (String name){
        super(name);
        comienzo = System.currentTimeMillis();
    }
    @Override
    public void run(){
        long tiempoTotal;
        for(int i = 0; i < 10; i++){
            intervalo = random.nextInt(1001);
            tiempoTotal = System.currentTimeMillis() - comienzo;
            System.out.printf("%s (%d) %dms  %dms \n", getName(), i,intervalo, tiempoTotal);
            try{
                sleep(intervalo);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
