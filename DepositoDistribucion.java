
import java.util.ArrayList;

public class DepositoDistribucion {
    ArrayList<String> productos = new ArrayList<String>();
    int capacidad;

    public DepositoDistribucion(int capacidad){
        this.capacidad = capacidad;
    }

    public synchronized void almacenarProducto(String producto){
        productos.add(producto);
        notifyAll();
    }

    public synchronized boolean sacarProducto(String id){
        boolean termino = false;
        boolean found=false;
        while(productos.size()==0){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for(int i = 0; i < productos.size() && !found; i++){
            String producto = productos.get(i);

        if(id == "Azul" && (producto == "A")){
            productos.remove(0);
            System.out.println("Distribuidor "+id+" distribuyó un producto de tipo "+producto);
            found=true;
        }
        else if(id == "Naranja" && (producto == "B")){
            productos.remove(0);
            System.out.println("Distribuidor "+id+" distribuyó un producto de tipo "+producto);
            found=true;

        }
        else if(id == "Azul" && (producto == "FIN_A")){
            productos.remove(0);
            System.out.println("Distribuidor "+id+" distribuyó un producto de tipo "+producto);
            termino=true;
            found=true;
        }
        else if(id == "Naranja" && (producto == "FIN_B")){
            productos.remove(0);
            System.out.println("Distribuidor "+id+" distribuyó un producto de tipo "+producto);
            termino=true;
            found=true;
            }
        }
        return(termino);
    }

    public boolean lleno(){
        return(productos.size()>=capacidad);
    }



}