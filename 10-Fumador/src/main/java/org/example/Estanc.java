package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Estanc  extends Thread{
    private List<Tabac> cigarretes;
    private List<Llumi> llumins;
    private List<Paper> papers;
    private Random rnd;
    private boolean estado;

    public Estanc() {
        this.cigarretes = new ArrayList<>();
        this.llumins = new ArrayList<>();
        this.papers = new ArrayList<>();
        this.rnd = new Random();
        this.estado = true;
    }

    public synchronized void addTabac(){
        cigarretes.add(new Tabac());
        System.out.println("Afegint Tabac");
        notifyAll();
    }

    public synchronized void addLlumi(){
        llumins.add(new Llumi());
        System.out.println("Afegint Llumi");
        notifyAll();
    }

    public synchronized void addPaper(){
        papers.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public void nouSubministrament(){
        int probabilidad = rnd.nextInt(3)+1;
        if(probabilidad == 3){
            addTabac();
        }else if(probabilidad == 2){
            addLlumi();
        }else{
            addPaper();
        }
    }

    public synchronized Paper venPapper(){
        while (papers.isEmpty() && estado) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        if (!papers.isEmpty()) {
            return papers.remove(0);
        }
        return null;
    }

    public synchronized Tabac venTabac(){
        while (cigarretes.isEmpty() && estado) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        if (!cigarretes.isEmpty()) {
            return cigarretes.remove(0);
        }
        return null;
    }

    public synchronized Llumi venLlumi(){
        while (llumins.isEmpty() && estado) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        if (!llumins.isEmpty()) {
            return llumins.remove(0);
        }
        return null;
    }

    public synchronized  void  tancarEstanc(){
        setEstado(false);
        notifyAll();
    }

    @Override
    public void run(){
        while(estado){
            nouSubministrament();
            try{
                sleep(rnd.nextInt(500,1501));
            }catch(InterruptedException ie){
                ie.printStackTrace();

            }
        }
    }

    public synchronized void setEstado(boolean estado){
        this.estado = estado;
    }
    public synchronized List<Llumi> getLlumins(){
        return llumins;
    }
    public synchronized List<Paper> getPapers(){
        return papers;
    }
    public synchronized List<Tabac> getCigarretes(){
        return cigarretes;
    }

}
