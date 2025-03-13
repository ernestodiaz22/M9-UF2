package org.example;

public class Barri {
    public static void main(String[] args) {
        Estanc estanc = new Estanc();
        Fumador[] fumadors = new Fumador[3];
        for (int i = 0; i < fumadors.length; i++) {
            fumadors[i] = new Fumador(estanc, i);
        }
        for (Fumador fumador : fumadors) {
            fumador.start();
        }
        estanc.start();
        System.out.println("Estanc obert");

        boolean todosHanTerminado = false;
        while (!todosHanTerminado) {
            todosHanTerminado = true;
            for (Fumador fumador : fumadors) {
                if (fumador.getNumFumades() < 3) {
                    todosHanTerminado = false;
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        estanc.tancarEstanc();
        System.out.println("Estanc tancat");
    }
}