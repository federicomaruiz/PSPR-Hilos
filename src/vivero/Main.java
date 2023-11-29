/**
 * 
 */
package vivero;

/**
 * @author federicoruiz
 * 10 nov 2023 14:42:39
 */
public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(0, 100);

        Productor productor1 = new Productor("Productor1", almacen, "rosas", 40);
        Productor productor2 = new Productor("Productor2", almacen, "violetas", 35);
        Productor productor3 = new Productor("Productor3", almacen, "orquideas", 15);

        Consumidor consumidor1 = new Consumidor("Consumidor1", almacen, "rosas", 5);
        Consumidor consumidor2 = new Consumidor("Consumidor2", almacen, "violetas", 10);
        Consumidor consumidor3 = new Consumidor("Consumidor3", almacen, "orquideas", 5);
        Consumidor consumidor4 = new Consumidor("Consumidor4", almacen, "rosas", 3);

        productor1.start();
        productor2.start();
        productor3.start();
        consumidor1.start();
        consumidor2.start();
        consumidor3.start();
        consumidor4.start();
    }
}
