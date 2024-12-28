package org.example;

public class MainDemoFil extends Thread {
    public static void main(String[] args){
        Thread hiloMain = Thread.currentThread();//obtengo la referencia del hilo que se está ejecutando
        System.out.println("MainDemoFil.main:\n" +
                "Prioritat -> "+hiloMain.getPriority()+", Nom -> "+hiloMain.getName()+
                "\ntoString() -> " + hiloMain.toString() );
    }
}
