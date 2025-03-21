import java.util.LinkedList;
import java.util.Queue;
class Barberia {
    private Queue<Client> salaEspera;
    private int maxCadires;
    public final Object condBarber = new Object();
    private static Barberia instancia;

    public Barberia(int maxCadires) {
        this.salaEspera = new LinkedList<>();
        this.maxCadires = maxCadires;
    }

    public static Barberia getInstance(int maxCadires) {
        if (instancia == null) {
            instancia = new Barberia(maxCadires);
        }
        return instancia;
    }

    public synchronized Client seguentClient() {
        return salaEspera.poll();
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client);
                System.out.println(client.getNom() + " en espera");
                condBarber.notify();
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    public void iniciar() {
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                entrarClient(new Client(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 11; i <= 20; i++) {
                entrarClient(new Client(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}