

class Barber implements Runnable {
    private String name;
    private Barberia barberia;

    public Barber(String name, Barberia barberia) {
        this.name = name;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getNom());
                client.tallarseElCabell();
                try {
                    Thread.sleep(900 + (int) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                synchronized (barberia.condBarber) {
                    try {
                        System.out.println("Ningú en espera");
                        System.out.println("Barber " + name + " dormint");
                        barberia.condBarber.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}