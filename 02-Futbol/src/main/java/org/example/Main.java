package org.example;

public class Main {
    public static void main(String[] args) {
        String[] nombresJugador = {"Messi","Alberto Ronaldo","Zidane","Roberto Carlos","Ronaldinho","Pepe","David Villa","Juan Carlos","Alberto Manuel","Jerico Philips","Nombre Falso"};
        Futbolista[] futbolistas = new Futbolista[Futbolista.getNUM_JUGADORS()];
        System.out.println("Inici dels xuts --------------------");
        for(int i = 0; i< nombresJugador.length; i++){
            futbolistas[i] = new Futbolista(nombresJugador[i]);
            futbolistas[i].start();
        }
        //espero a que todos los hilos terminen
        for(int i = 0; i< futbolistas.length;i++){
            try{
                futbolistas[i].join();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");
        for(int i = 0; i < futbolistas.length; i++){
            System.out.println(futbolistas[i].getName() + "->" + futbolistas[i].getNgols());
        }
    }
}