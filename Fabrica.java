import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Fabrica {
    public int capacidadDepositoProduccion;
    public int capacidadDepositoDistribuicion;
    public DepositoProduccion depositoProduccion;
    public Cinta cinta;
    public DepositoDistribucion depositoDistribucion;
    static int productosProducidos = 0;
    static int productosDistribuidos = 0;   
    static int productosPasadosPorCinta = 0;

    public Fabrica(int capacidadDepositoProduccion, int capacidadDepositoDistribuicion){

        this.capacidadDepositoProduccion = capacidadDepositoProduccion;
        this.depositoProduccion = new DepositoProduccion(capacidadDepositoProduccion);
        this.cinta = new Cinta();
        this.depositoDistribucion = new DepositoDistribucion(capacidadDepositoDistribuicion);
    }

    public static synchronized void sumaProductos(){
        productosProducidos++;
    }

    public static synchronized void sumaProductosDistribuidos(){
        productosDistribuidos++;
    }

    public static synchronized void sumaProductosPasadosPorCinta(){
        productosPasadosPorCinta++;
    }
    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n*********** Bienvenido a la Fabrica de Productos ***********");

        System.out.println("\nIngrese el numero de Productos: ");
        int cantidadProductos = Integer.parseInt(br.readLine());

        System.out.println("Ingrese la capacidad Deposito Produccion: ");
        int capacidadDepositoProduccion = Integer.parseInt(br.readLine());

        System.out.println("Ingrese la capacidad Deposito Distribuicion: ");
        int capacidadDepositoDistribuicion = Integer.parseInt(br.readLine());
        System.out.println(" ");

        //Creacion Fabrica
        Fabrica fabrica = new Fabrica(capacidadDepositoProduccion, capacidadDepositoDistribuicion);

        Productor productorA = new Productor("Azul", fabrica, cantidadProductos);
        Productor productorA2 = new Productor("Azul", fabrica, cantidadProductos);
        Productor productorB = new Productor("Naranja", fabrica, cantidadProductos);
        Productor productorB2 = new Productor("Naranja", fabrica, cantidadProductos);
        Operario1 operario1 = new Operario1(fabrica);
        Operario2 operario2 = new Operario2(fabrica);
        Distribuidor distribuidorA = new Distribuidor("Azul", fabrica);
        Distribuidor distribuidorA2 = new Distribuidor("Azul", fabrica);
        Distribuidor distribuidorB = new Distribuidor("Naranja", fabrica);
        Distribuidor distribuidorB2 = new Distribuidor("Naranja", fabrica);

        productorA.start();
        productorB.start();
        productorA2.start();
        productorB2.start();
        operario1.start();
        operario2.start();
        distribuidorA.start();
        distribuidorA2.start();
        distribuidorB.start();
        distribuidorB2.start();


        productorA.join();
        productorA2.join();
        productorB.join();
        productorB2.join();
        operario1.join();
        operario2.join();
        distribuidorA.join();
        distribuidorA2.join();
        distribuidorB.join();
        distribuidorB2.join();

        System.out.println("**************************************************************");
        System.out.println("\nSe produjeron un total de "+productosProducidos+" productos\nIncluyendo los Productos de tipo FIN.");
        System.out.println("\nSe distribuyeron un total de "+productosDistribuidos+" productos.");
        System.out.println("\nSe pasaron por la cinta un total de "+productosPasadosPorCinta+" productos.");


        System.out.println("\nTamanio final Deposito produccion: "+fabrica.depositoProduccion.productos.size());
        System.out.println("Tamanio final Deposito distribuicion: "+fabrica.depositoDistribucion.productos.size());
        System.out.println("Tamanio final Cinta: "+fabrica.cinta.productos.size());
        System.out.println("\n**************************************************************");
        System.out.println("\nFINAL PROGRAMA\n");

        

     







        
    }
}
