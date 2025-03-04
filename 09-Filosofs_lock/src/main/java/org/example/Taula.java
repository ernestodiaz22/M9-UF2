package org.example;

class Taula {
    private final Filosof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            filosofs[i] = new Filosof("Fil" + i, i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (Filosof f : filosofs) {
            System.out.println("Comensal:" + f.getName() + " esq:" + f.getEsquerra().getNum() + " dret:" + f.getDreta().getNum());
        }
        System.out.println("-----------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }
}