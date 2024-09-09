public class Operario1 extends Thread{
    Fabrica fabrica;
    int termino;
    
    public Operario1(Fabrica fabrica){
        this.fabrica = fabrica;
        this.termino = 0;
    }

    public void moverACinta(){
        while (termino<4){
            while(fabrica.depositoProduccion.tam()<=0){
                Thread.yield();
            }
            String producto = fabrica.depositoProduccion.sacarProducto();
            while(fabrica.cinta.lleno()){
                Thread.yield();
            }
            fabrica.cinta.PonerEnCinta(producto);

            System.out.println("Operario 1 movio producto "+producto+" a la cinta\n");

            if (producto == "FIN_A" || producto == "FIN_B"){
                termino++;
            }
        }
        
    }
    public void run(){
        moverACinta();
        System.out.println("\nOperario 1 acabo");
    }
       




}
