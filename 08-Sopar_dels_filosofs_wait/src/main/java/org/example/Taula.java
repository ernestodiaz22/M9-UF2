package org.example;

import java.util.ArrayList;
import java.util.List;

public class Taula {
    private List<Filosof> comensals;
    private List<Forquilla> forquilles;
    private int numFilosofs;

    public Taula(int numFilosofs) {
        this.numFilosofs = numFilosofs;
        forquilles = new ArrayList<>();
        for (int i = 0; i < numFilosofs; i++) {
            forquilles.add(new Forquilla(i));
        }
        comensals = new ArrayList<>();
        for (int i = 0; i < numFilosofs; i++) {
            comensals.add(new Filosof("fil" + i, forquilles.get(i), forquilles.get((i + 1) % numFilosofs)));
        }
    }

    public void showTaula() {
        System.out.println("Configuració de la taula:");
        for (Filosof filosof : comensals) {
            System.out.println("Comensal:" + filosof.getName() + " esq:" + filosof.getForquillaEsquerra().getNumero() + " dret:" + filosof.getForquillaDreta().getNumero());
        }
    }

    public void cridarTaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }
}