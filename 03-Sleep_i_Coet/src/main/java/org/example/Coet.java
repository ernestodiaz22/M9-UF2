package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Coet {
    private static final Motor[] motores = new Motor[4];

    public static void main(String[] args) {
        for(int i = 0 ; i < motores.length;i++){
            motores[i] = new Motor("motor " + i);
        }
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("");
            int potencia = Integer.parseInt(bf.readLine());
            passaAPotencia(potencia);
            arrancar();
            while(potencia > 0){
                System.out.print("");
                potencia = Integer.parseInt(bf.readLine());
                passaAPotencia(potencia);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void arrancar(){
      for(Motor motor: motores){
          motor.start();
      }
    }

    public static boolean passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.err.println("La potencia estableciada no es válida (introduzca una potencia que esté entre 0 y 10).");
            return false;
        }

        for (Motor motor : motores) {
            motor.setPotencia(p);
        }

        return true;
    }
}