public class Productor extends Thread {
    private String id;
    private Fabrica fabrica;
    private int numProductos;


    public Productor(String id, Fabrica fabrica, int numProductos){
        this.id = id;
        this.fabrica= fabrica;
        this.numProductos= numProductos;
    }
    private synchronized void producir(){
        while(numProductos>1){
            if(this.id == "Azul"){
                System.out.println("Productor "+this.id+" produjo un producto de tipo A");
                this.fabrica.depositoProduccion.almacenarProducto("A",id);
                numProductos--;
            }
            else if(this.id == "Naranja"){
                System.out.println("Productor "+this.id+" produjo un producto de tipo B");
                this.fabrica.depositoProduccion.almacenarProducto("B", id);
                numProductos--;
            }
        }
        if(numProductos==1){
            if(id == "Azul" ){
                System.out.println("Productor "+this.id+" produjo un producto de tipo FIN_A");
                this.fabrica.depositoProduccion.almacenarProducto("FIN_A", id);
            }
            else if(id == "Naranja"){
                System.out.println("Productor "+this.id+" produjo un producto de tipo FIN_B");
                this.fabrica.depositoProduccion.almacenarProducto("FIN_B", id);
                }
            }
    }
    @Override
    public void run(){
        producir();
        System.out.println("\nProductor "+this.id+" acabó.\n");
    }

       
}



