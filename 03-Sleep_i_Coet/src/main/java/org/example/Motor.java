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
    public void run() {
        boolean enMarcha = true;

        while (enMarcha) {

            synchronized (this) {
                while (potenciaActual == potenciaobjectiu) {
                    try {
                        wait(); // Espera hasta que haya un cambio en la potencia
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            inicioMotores();

            if(potenciaActual == 0 && potenciaobjectiu == 0){
                enMarcha = false;
            }
        }
    }

    private void inicioMotores() {
        String movimiento = "FerRes";
        int intervalo = random.nextInt(2000) + 1;

        try {
            Thread.sleep(intervalo); // Simula el tiempo necesario para ajustar la potencia
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
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
            notify(); // notifica a los otros hilos
        }
    }
}