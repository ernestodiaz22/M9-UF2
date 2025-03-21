public class Main {
    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstance(3);
        Barber barber = new Barber("Pepe", barberia);

        Thread barberThread = new Thread(barber);
        barberThread.start();

        barberia.iniciar();
    }
}
