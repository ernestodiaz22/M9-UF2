public class Organitzador {
    public static void main(String[] args){

        Esdeveniment esdeveniment = new Esdeveniment(5);

        int numAsistentes = 10;

        Assistent[] asistentes = new Assistent[numAsistentes];
        for(int i = 0; i < 10; i++){
            asistentes[i] = new Assistent("Asistente " + i, esdeveniment);
        }

        for(Assistent asistente: asistentes){
            asistente.start();
        }

    }
}
