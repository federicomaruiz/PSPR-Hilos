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
    	
    	// El amacen tiene una capacidad maxima de 100 plantas y el stock al momento de inciar es 70
        Almacen almacen = new Almacen(100,100);

        
        // Cree los valores fijos cada prodcutor/ consumidor tiene su nombre y la cantidad que añade/retira de plantas
        
        Productor productor1 = new Productor("Productor1",almacen,40);
        Productor productor2 = new Productor("Productor2",almacen,5);
        Productor productor3 = new Productor("Productor3",almacen,15);
        Consumidor consumidor1 = new Consumidor("Consumidor1",almacen, 2);
        Consumidor consumidor2 = new Consumidor("Consumidor2",almacen, 10);
        Consumidor consumidor3 = new Consumidor("Consumidor3",almacen, 5);
        Consumidor consumidor4 = new Consumidor("Consumidor4",almacen, 8);

        // Inicio los hilos
      
        productor1.start();
        productor2.start();
        productor3.start();
        consumidor1.start();
        consumidor2.start();
        consumidor3.start();
        consumidor4.start();
    }
}
