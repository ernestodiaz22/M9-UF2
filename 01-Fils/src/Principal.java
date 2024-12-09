public class Principal {
    public static void main(String[] args) {
        Fil h1 = new Fil("Juan");
        Fil h2 = new Fil("Pepe");
        h2.start();
        h1.start();
        System.out.println("Termina thread main");
    }
}
