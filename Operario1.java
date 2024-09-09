public class Operario1 extends Thread{
    Fabrica fabrica;
    int termino;
    int pActual = 0;
    
    public Operario1(Fabrica fabrica){
        this.fabrica = fabrica;
        this.termino = 0;
    }

    public synchronized void moverACinta(){
        while (termino<4){
            while(fabrica.depositoProduccion.tam()<=0||pActual!=0){
                Thread.yield();
            }
            String producto = fabrica.depositoProduccion.sacarProducto();
            pActual = 1;
            while(fabrica.cinta.tam()==1){
                Thread.yield();
            }
            fabrica.cinta.PonerEnCinta(producto);
            pActual = 0;
            System.out.println("Operario 1 movio producto "+producto+" a la cinta");

            if (producto == "FIN_A" || producto == "FIN_B"){
                termino++;
            }
        }
        
    }
    public void run(){
        moverACinta();
        System.out.println("\nOperario 1 acabo\n");
    }
       




}
