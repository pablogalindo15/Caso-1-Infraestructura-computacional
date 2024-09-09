import java.util.ArrayList;

public class DepositoProduccion {
    ArrayList<String> productos = new ArrayList<String>();
    int capacidad;

    public DepositoProduccion(int capacidad){
        this.capacidad = capacidad;
    }

    public synchronized void almacenarProducto(String producto, String idProductor){
        while(productos.size() >= capacidad){
            try{
                System.out.println("Deposito lleno, Productor "+idProductor+" esperando");
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        productos.add(producto);
        System.out.println("Se almaceno un producto " + producto);
        //System.out.println("Productor "+idProductor+" produjo un producto de tipo "+producto);
    }

    public synchronized String sacarProducto(){
        String producto = productos.get(0);
        productos.remove(0);
        System.out.println("Operario 1 retiro producto "+ producto);
        notify();
        return producto;

    }

    public synchronized int tam(){
        return(productos.size());
    }

}
