package org.example;

import java.util.Random;

public class Motor extends Thread {
    private int potenciaobjectiu;
    private int potenciaActual;
    private final Random random = new Random();

    public Motor(String name) {
        super(name);
        this.potenciaActual = 0;
        this.potenciaobjectiu = 0;
    }

    public synchronized void setPotencia(int p) {
        this.potenciaobjectiu = p;
    }
    @Override
    public void run(){
        while(true){
            while(potenciaobjectiu != potenciaActual){
                String movimiento = "";
                try{
                    sleep(random.nextInt(2000) + 1);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                if (potenciaActual < potenciaobjectiu) {
                    potenciaActual++;
                    movimiento = "Incre.";
                } else if (potenciaActual > potenciaobjectiu) {
                    potenciaActual--;
                    movimiento = "Decre.";
                }

                if(potenciaActual == potenciaobjectiu){
                    movimiento = "FerRes";
                }
                System.out.printf("%s: %s Objectiu: %d Actual: %d\n", getName(), movimiento, potenciaobjectiu, potenciaActual);
            }
            try{
                sleep(random.nextInt(100));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            if (potenciaActual == 0){
                break;
            }
        }
    }
}