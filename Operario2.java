public class Operario2 extends Thread{

    Fabrica fabrica;
    int termino;
    
    public Operario2(Fabrica fabrica){
        this.fabrica = fabrica;
        this.termino = 0;
    }

    public void moverADeposito(){
        while (termino<4){
            while(fabrica.cinta.tam()==0){
                Thread.yield();
            }
            String producto = fabrica.cinta.SacarDeCinta();
            System.out.println("Operario 2 retiro producto "+producto+" de la cinta");
            while(fabrica.depositoDistribucion.lleno()){
                Thread.yield();
            }
            fabrica.depositoDistribucion.almacenarProducto(producto);
            System.out.println("Operario 2 movio producto "+producto+" al depDIST");

            if (producto == "FIN_A" || producto== "FIN_B"){
                termino++;
            }
        }
    }
    public void run(){
        moverADeposito();
        System.out.println("\nOperario 2 termino\n");
    }
                        
}
       



