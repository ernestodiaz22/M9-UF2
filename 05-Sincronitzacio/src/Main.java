public class Main {
    public static void main(String[] args) {
        Compte compte1 = Compte.getCompte(0.0f);
        Assosiacio assosiacio = new Assosiacio(compte1);
        assosiacio.iniciaCompteTempsSocis();
        assosiacio.esperaPeriodeSocis();
        assosiacio.mostraBalancComptes();
    }
}