/**
 * 
 */
package vivero;


/**
 * @author federicoruiz 10 nov 2023 14:43:01
 */
class Productor extends Thread {
	 private String nombre;
	    private Almacen almacen;
	    private String tipoPlanta;
	    private int cantidad;

    public Productor(String nombre, Almacen almacen, String tipoPlanta, int cantidad) {
    	this.nombre = nombre;
        this.almacen = almacen;
        this.tipoPlanta = tipoPlanta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int tiempo = (int) (Math.random() * 5 + 9) * 1000;
                Thread.sleep(tiempo);
                almacen.agregarPlanta(nombre,tipoPlanta, cantidad);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
