import java.util.Random;

public class Soci extends Thread{
    private Compte compte;
    private float aportacio;
    private int esperaMax;
    private Random random = new Random();
    private int maxAnys;
    private String nombre;

    public Soci(Compte compte, String nombre) {
        this.nombre = nombre;
        this.aportacio = 10f;
        this.compte = compte;
        this.esperaMax = 100;
        this.maxAnys = 10;
    }

    public Compte getCompte() {
        return compte;
    }
    @Override
    public void run(){
        for(int i = 0; i < maxAnys; i++){
            for(int j = 1; j < 13; j++){
                float saldo = 0;
                if (j % 2 == 0){
                    saldo = compte.getSaldo() + 10;
                    compte.setSaldo(saldo);
                }else{
                    saldo = compte.getSaldo() - 10;
                    compte.setSaldo(saldo);
                }
                try{
                    sleep(random.nextInt(101));
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
}
