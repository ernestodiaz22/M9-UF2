import java.util.Random;

public class Treballador extends Thread{
    private float sou_anual_btut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd = new Random();

    public Treballador(String name, float sou_anual_btut, int edat_inici_treball, int edat_fi_treball) {
        super(name);
        this.sou_anual_btut = sou_anual_btut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_actual = 0;
        this.edat_fi_treball = edat_fi_treball;
        this.cobrat = 0.0f;
    }
    //getters
    public float getCobrat(){
        return cobrat;
    }
    public int getEdat_actual(){
        return edat_actual;
    }
    //métodos
    public void cobrar(){

    }
    public void pagaImpostos(){

    }
    @Override
    public void run(){

    }

}
