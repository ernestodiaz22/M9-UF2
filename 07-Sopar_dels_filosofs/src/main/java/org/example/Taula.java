package org.example;

import java.util.ArrayList;
import java.util.List;

public class Taula {
    private static List<Filosof>  comensals;
    private List<Forquilla> forquilles;
    private int numFislosofs;

    public Taula(int numFilosofs) {
        this.numFislosofs = numFilosofs;
        List<Forquilla> forquilles = new ArrayList<>();
        for(int i = 0; i < numFilosofs; i++){
            forquilles.add(new Forquilla(i));
        }
        this.forquilles = forquilles;
        List<Filosof> comensals = new ArrayList<>();
        for(int i = 0; i < numFilosofs; i++){
            comensals.add(new Filosof("fil" + i));
            if(i < numFilosofs - 1){
                comensals.get(i).setForquillaEsquerra(forquilles.get(i));
                comensals.get(i).setForquillaDreta(forquilles.get(i + 1));
            }else{
                comensals.get(i).setForquillaEsquerra(forquilles.get(i));
                comensals.get(i).setForquillaDreta(forquilles.get(0));
            }
        }
        this.comensals = comensals;
    }

    public void showTaula(){
        for(Filosof filosof : comensals ){
            System.out.println("Comensal:" + filosof.getName() + " esq:" + filosof.getForquillaEsquerra().getNumero() + " dret:" + filosof.getForquillaDreta().getNumero());
        }
    }

    public void cridarTaula(){
        for(Filosof filosof: comensals){
            filosof.start();
        }
    }

}
