package vivero;

import java.util.HashMap;
import java.util.Map;

class Almacen {
    private Map<String, Integer> plantas;
    private int capacidad;

    public Almacen(int almacenDeposito, int capacidad) {
        this.capacidad = capacidad;
        this.plantas = new HashMap<>();
        plantas.put("rosas", 30);
        plantas.put("violetas", 15);
        plantas.put("orquideas", 25);
    }

    public synchronized void agregarPlanta(String nombre, String tipoPlanta, int cantidad) throws InterruptedException {
        int stockTotal = getStockTotal();
        if (stockTotal + cantidad <= capacidad) {
            System.out.println("El " + nombre + " añadió " + cantidad + " " + tipoPlanta + " al almacén");
            plantas.put(tipoPlanta, plantas.getOrDefault(tipoPlanta, 0) + cantidad);
            notifyAll(); // Aviso a los consumidores que hay plantas
        } else {
            System.out.println("El almacén está lleno, debes esperar");
        }
    }

    public synchronized void retirarPlanta(String nombre, String tipoPlanta, int cantidad) throws InterruptedException {
        try {
            while (cantidad > plantas.getOrDefault(tipoPlanta, 0)) {
                System.out.println("No hay suficientes " + tipoPlanta + " en stock para retirar esa cantidad, debes esperar");
                wait();
            }
            System.out.println("El " + nombre + " retiró " + cantidad + " " + tipoPlanta + " del almacén");
            plantas.put(tipoPlanta, plantas.get(tipoPlanta) - cantidad);
            System.out.println("Quedan " + plantas.get(tipoPlanta) + " " + tipoPlanta + " en el almacén");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getStockTotal() {
        return plantas.values().stream().mapToInt(Integer::intValue).sum();
    }
}

