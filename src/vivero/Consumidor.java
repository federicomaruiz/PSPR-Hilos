/**
 * 
 */
package vivero;

/**
 * @author federicoruiz 10 nov 2023 14:43:10
 */
public class Consumidor extends Thread {

	private String nombre;
	private Almacen almacen;
	private int cantidad;

	public Consumidor(String nombre, Almacen almacen, int cantidad) {
		this.nombre = nombre;
		this.almacen = almacen;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int tiempo = (int) ((Math.random() * 2 + 3) * 1000); // Número aleatorio
				Thread.sleep(tiempo); // Simulo tiempo entre consumos
				almacen.retirarPlanta(nombre, cantidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
