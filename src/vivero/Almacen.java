/**
 * 
 */
package vivero;

/**
 * @author federicoruiz 10 nov 2023 14:43:20
 */
public class Almacen {

	private int stock;
	private int capacidad;

	public Almacen(int almacenDeposito, int capacidad) {
		this.capacidad = capacidad;
		this.stock = almacenDeposito;

	}

	public synchronized void agregarPlanta(String nombre,int cantidad) throws InterruptedException {
	     if (cantidad + stock < capacidad ) {
	    	 System.out.println("El " + nombre + " añado " + cantidad + " plantas al almacen");
	    	 stock = stock + cantidad;
			 notifyAll(); // Aviso a los consumidores que hay plantas
		}else {
			System.out.println("El almacen esta lleno, debes esperar");
	
		}
	 
	}

	public synchronized void retirarPlanta(String nombre, int cantidad) throws InterruptedException {
		try {
			while (cantidad > stock) {
				System.out.println("No hay suficientes plantas en stock para retirar esa cantidad, debes esperar");
				wait(); // Congelo el hilo ya que la cantidad a retirar excede al stock
			}
			System.out.println("El " + nombre + " ha extraido " + cantidad + " plantas");
			stock = stock - cantidad;
			System.out.println("Quedan " + stock + " plantas en el almacen");
		} catch (InterruptedException e) {

		}

	}

}
