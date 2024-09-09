import java.util.ArrayList;

public class Cinta {

    private int capacidad =20;
    public ArrayList<String> productos = new ArrayList<String>();


    public synchronized void PonerEnCinta(String producto){
        
            productos.add(producto);
  
        }

    public synchronized String SacarDeCinta(){
        
        String prod = productos.get(0);
        productos.remove(0);
        return (prod);
    }

    public synchronized boolean lleno(){
        return (productos.size()>=capacidad);
    }
    public synchronized int tam(){
        return(productos.size());
    }
}
