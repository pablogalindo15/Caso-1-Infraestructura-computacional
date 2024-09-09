public class Distribuidor extends Thread {
    private String id;
    private Fabrica fabrica;

    boolean termino = false;

    public Distribuidor(String id, Fabrica fabrica){
        this.id = id;
        this.fabrica= fabrica;
    }
    private void distribuir(){
        while(termino == false){
        termino = fabrica.depositoDistribucion.sacarProducto(id);
        }
    }
    @Override
    public void run(){
        distribuir();
        System.out.println("\nDistribuidor "+this.id+" acabó.\n");
    }

       
}

    
