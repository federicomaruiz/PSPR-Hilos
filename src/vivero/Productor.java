/**
 * 
 */
package vivero;


/**
 * @author federicoruiz 10 nov 2023 14:43:01
 */
public class Productor extends Thread {

	private String nombre;
	private Almacen almacen;
	private int cantidad;

	public Productor(String nombre, Almacen almacen, int cantidad) {

		this.nombre = nombre;
		this.almacen = almacen;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int tiempo = (int) (Math.random() * 5 + 5) * 1000;
				Thread.sleep(tiempo);
				almacen.agregarPlanta(nombre, cantidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
