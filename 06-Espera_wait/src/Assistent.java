import java.util.Random;

public class Assistent  extends Thread{
    private Esdeveniment esdeveniment;
    private String nom;
    private Random rdn = new Random();

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    public String getNom() {
        return nom;
    }
    @Override
   public void run(){
        while(true){
                if(rdn.nextInt(10) < 7){
                    esdeveniment.ferReserva(this);
                }else{
                    esdeveniment.cancelaReserva(this);
                }
                try{
                    sleep(rdn.nextInt(1001));
                }catch (InterruptedException ei){
                    ei.printStackTrace();
                }

        }
    }

}
