public class Administracio {
    private static int num_poblacio_activa = 50;
    private static Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];
    public static void main(String[] args){
        for(int i = 0; i < poblacio_activa.length; i++){
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
        for (Treballador trabajador  : poblacio_activa){
            trabajador.start();
        }
    }

}
