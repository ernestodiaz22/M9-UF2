import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private int placesMaximes;
    private int placesDisponibles;
    private List<Assistent> asistentes = new ArrayList<>();

    public Esdeveniment(int places) {
        this.placesMaximes = places;
        this.placesDisponibles = places;

    }

    public List<Assistent> getAsistentes() {
        return asistentes;
    }

    public synchronized void ferReserva(Assistent asistente){
            if(placesDisponibles == 0 && !asistentes.isEmpty()){
                try{
                    this.wait();
                }catch (InterruptedException ei){
                    ei.printStackTrace();
                }
            }else{
                asistentes.add(asistente);
                placesDisponibles--;
                System.out.println(asistente.getNom() + " Ha fet una reserva. Places disponibles: " + placesDisponibles);
            }
    }

    public synchronized void cancelaReserva(Assistent asistente){
            int indx = -1;
           for(int i = 0; i < asistentes.size();i++){
               if(asistentes.get(i).getNom().equals(asistente.getNom())){
                   indx = i;
               }
           }
            if(indx != -1){
                asistentes.remove(indx);
                placesDisponibles++;
                System.out.println(asistente.getNom() + " Ha pogut cancel.lar una reserva. Places disponibles: " + placesDisponibles);
            }else{
                System.out.println(asistente.getNom() + " No ha pogut cancel.lar una reserva inexistent. Places disponibles: " + placesDisponibles);
            }

            if(placesDisponibles < placesMaximes){
                notifyAll();
            }
    }
}

