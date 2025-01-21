public class Administracio {
    private static int num_poblacio_activa = 50;
    private static Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];
    public static void main(String[] args){
        for(int i = 0; i < num_poblacio_activa; i++){
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
        for (Treballador trabajador  : poblacio_activa){
            trabajador.start();
            try{
                trabajador.join();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println( trabajador.getName() + " -> edat: "+trabajador.getEdat_actual()+"  total: " + trabajador.getCobrat());
        }


    }

}
