public class Assosiacio {
    private int numSocis = 1000;
    private Soci[] socis = new Soci[numSocis];

    public Assosiacio(Compte compte) {
        for(int i = 0; i < numSocis; i++){
            socis[i] = new Soci(compte,"Socio " + i);
        }
    }

    public void iniciaCompteTempsSocis(){
        for(Soci socio : socis){
            socio.start();
        }
    }
    public void esperaPeriodeSocis(){
        for(Soci socio : socis){
            try{
                socio.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void mostraBalancComptes(){
        System.out.println("El balance de la asociación es " + socis[0].getCompte().getSaldo());
    }
}
