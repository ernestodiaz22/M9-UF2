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
        cobrat += sou_anual_btut / 12;
    }
    public void pagaImpostos(){
        cobrat -= sou_anual_btut / 12 * 0.24f;
    }
    @Override
    public void run(){
        int mesesTotales = edat_fi_treball * 12;
        for(int i = 0; i < mesesTotales; i++){
            if(i%12 == 0){
                edat_actual++;
            }
            if(edat_actual > edat_inici_treball){
                cobrar();
                pagaImpostos();
            }
            try{
                sleep(rnd.nextInt(101));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

}
