
import java.util.ArrayList;

public class DepositoDistribucion {
    public ArrayList<String> productos = new ArrayList<String>();
    private int capacidad;

    public DepositoDistribucion(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void almacenarProducto(String producto) {
        productos.add(producto);
        notifyAll();
    }

    public synchronized boolean sacarProducto(String id) {
        while (productos.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        for (int i = 0; i < productos.size(); i++) {
            String producto = productos.get(i);
            if (esProductoValido(id, producto)) {
                productos.remove(i);
                System.out.println("Distribuidor " + id + " distribuyó un producto de tipo " + producto);
                return producto.startsWith("FIN_");
            }
        }

        return false;
    }

    private boolean esProductoValido(String id, String producto) {
        return (id.equals("Azul") && (producto.equals("A") || producto.equals("FIN_A"))) ||
               (id.equals("Naranja") && (producto.equals("B") || producto.equals("FIN_B")));
    }

    public synchronized boolean lleno() {
        return productos.size() >= capacidad;
    }
}