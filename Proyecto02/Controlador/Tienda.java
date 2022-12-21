package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

/**
* Clase que define una tienda para controlar el acceso a recursos varios que el usuario
* puede adquirir con el fin de mejorar su experiencia.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Tienda{
	private LinkedList<MiniJuego> juegosEnVenta = new LinkedList<>();
	private LinkedList<Apariencia> aparienciasEnVenta = new LinkedList<>();

	
    /**
    * Constructor por defecto de la clase.
    **/
	public Tienda(){
		juegosEnVenta.add(new JuegoGato());
		aparienciasEnVenta.add(new ConejoLunar());
	}

	/**
	* Método que gestiona la operación de la tienda para poder acceder
	* a los productos de forma segura.
	* @param tama <code>Tamagotchi</code> al cuál se le proporcionaran los productos
	* aquiridos.
	**/
	public void operacionTienda(Tamagotchi tama){
		System.out.println("\u001B[36m" + "Bienvenido a la tienda :D" + "\u001B[0m");
		if (juegosEnVenta.isEmpty()) {
			System.out.println("\u001B[36m" + " ");
			System.out.println("Por el momento no hay más minijuegos disponibles :(" + "\u001B[0m");
		}else{
			System.out.println("\u001B[36m" + " ");
			System.out.println("Los minijuegos que están a la venta son: " + "\u001B[0m");
			for (int i = 0; i < juegosEnVenta.size(); i++) {
				System.out.println("\u001B[36m" + (i + 1)+ ".- " + juegosEnVenta.get(i).getNombre()+ " Precio: " + juegosEnVenta.get(i).precio() + " monedas" + "\u001B[0m");
			}
		}
		if (aparienciasEnVenta.isEmpty()) {
			System.out.println("\u001B[36m" + " ");
			System.out.println("Por el momento no hay más apariencias disponibles :(" + "\u001B[0m");
		}else{
			System.out.println("\u001B[36m" + " ");
			System.out.println("Las apariencias que están a la venta son: " + "\u001B[0m");
			for (int i = 0; i < aparienciasEnVenta.size(); i++) {
				System.out.println("\u001B[36m" + (i + 1) + ".- " + aparienciasEnVenta.get(i).getNombre() +" Precio: " + aparienciasEnVenta.get(i).precio() + " monedas" + "\u001B[0m");
			}
		}
		if (aparienciasEnVenta.isEmpty() && juegosEnVenta.isEmpty()) {
			System.out.println("\u001B[36m" + "Hasta luego" + "\u001B[0m");
		}else{
			System.out.println("\u001B[36m" + " ");
			System.out.println("Tu presupuesto es: " + tama.getMonedas() + " monedas");
			System.out.println(" ");
			System.out.println("¿Te gustaría comprar algo? S/N" + "\u001B[0m");
			int bandera = 0;
			while (bandera != 1) {
				System.out.print("\u001B[36m" + "--> " + "\u001B[0m");
				Scanner scanner = new Scanner(System.in);
				char opcion = scanner.next().charAt(0);
				opcion = Character.toLowerCase(opcion);
				switch (opcion) {
				case 's': 
					menuCompra(tama); 
					break;
				case 'n': 
					System.out.println("\u001B[36m" + "Hasta pronto!" + "\u001B[0m");
					bandera = 1;
					break;
				default: 
					System.out.println("\u001B[36m" + "Opcion no válida" + "\u001B[0m");
				}
			}
		}
	}

	/**
	* Método que muestra un menú para elegir que clase de prodcutos se desean adquirir.
	* @param tama <code>Tamagotchi</code> al cuál se le proporcionaran los productos aquiridos.
	**/
	public void menuCompra(Tamagotchi tama){
		System.out.println("\u001B[36m" + "************************************");
		System.out.println("¿Qué quieres comprar?");
		System.out.println("1- Skins");
		System.out.println("2- Minijuegos" + "\u001B[0m");
		int opcion = auxiliar(1,2);
		switch (opcion) {
			case 1:
				System.out.println("\u001B[36m" + "Por favor ingresa el número del producto" + "\u001B[0m");
				int skinNueva = auxiliar(1, aparienciasEnVenta.size());
				concretarCompra(tama, 1, skinNueva - 1);
				break;
			case 2:
				System.out.println("\u001B[36m" + "Por favor ingresa el número del producto" + "\u001B[0m");
				int juegoNuevo = auxiliar(1, juegosEnVenta.size());
				concretarCompra(tama, 2, juegoNuevo - 1);
				break;
		}
	}

	/**
	* Método auxiliar que permite cerrar la compra.
	* @param tama <code>Tamagotchi</code> al cuál se le proporcionaran los productos aquiridos.
	* @param opcion elegida por el usuario respecto al tipo de producto a aquirir.
	* @param productoElegido el producto que se desea adquirir.
	**/
	public void concretarCompra(Tamagotchi tama, int opcion, int productoElegido){
		if (opcion == 1) {
			Apariencia skinNueva = aparienciasEnVenta.get(productoElegido);
			if (tama.getMonedas() >= skinNueva.precio()) {
				tama.setMonedas(tama.getMonedas() - skinNueva.precio());
				aparienciasEnVenta.remove(productoElegido);
				tama.skinsDisponibles().getLista().add(skinNueva);
				System.out.println("\u001B[36m" + "Se concretó la compra exitosamente");
				System.out.println("¿Quieres comprar otra cosa? S/N" + "\u001B[0m");
			}else{
				System.out.println("\u001B[36m" + " ");
				System.out.println("No tienes monedas suficientes para este producto");
				System.out.println("¿Te interesa comprar otra cosa? S/N" + "\u001B[0m");
			}
		}

		else if (opcion == 2) {
			MiniJuego juegoNuevo = juegosEnVenta.get(productoElegido);
			if (tama.getMonedas() >= juegoNuevo.precio()) {
				tama.setMonedas(tama.getMonedas() - juegoNuevo.precio());
				juegosEnVenta.remove(productoElegido);
				tama.juegosDisponibles().getLista().add(juegoNuevo);
				System.out.println("\u001B[36m" + "Se concretó la compra exitosamente");
				System.out.println("¿Quieres comprar otra cosa? S/N" + "\u001B[0m");
			}else{
				System.out.println("\u001B[36m" + " ");
				System.out.println("No tienes monedas suficientes para este producto");
				System.out.println("¿Te interesa comprar otra cosa? S/N" + "\u001B[0m");
			}
		}
	}

	/**
    * Declaración del método que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin COta superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
    private int auxiliar(int inicio, int fin)throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int opcion = -100;
        boolean bandera = false;

        do{
            try {
                System.out.print("\u001B[36m" + "---> " + "\u001B[0m");
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if (opcion >= inicio && opcion <= fin) {
                    break;  
                }
                else{
                    System.out.println("\u001B[36m" + "Ingresa una opción válida" + "\u001B[0m");
                }
            }catch (NumberFormatException ex){
                System.out.println("\u001B[36m" + "Ingresa un NUMERO valido" + "\u001B[0m");
            }       
        }while(bandera == false);
        return opcion;
    }
}