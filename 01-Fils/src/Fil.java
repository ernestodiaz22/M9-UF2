public class Fil extends Thread {
    public Fil(String nombre) {
        setName(nombre);
    }
    @Override
    public void run(){
        for(int i = 1; i < 10; i++){
            System.out.println(getName() + " " + i);
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Termina el fil " + getName());
    }
}
