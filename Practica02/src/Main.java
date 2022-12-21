/**
* Clase de ejecución donde se pone a prueba la implementación de tres patrones de diseño: State, Template e Iterator
* mediante un programa que modela a un robot mesero/cocinero de la cadena de restaurantes McBurguer.
* @author SanMa
* @version 1.1
**/

import java.util.Scanner;


/**
* Entrada en ejecución del método <code>Main</code> donde se implementa la interfaz de usuario
* a través de la cual el usuario puede interactuar con el robot y solicitar un pedido si así lo desea.
**/
public class Main{
	public static void main(String[] args) {
		Robot robot = new Robot();
		Menu menuCamb = new MenuCambiante();
		Menu menuEsp = new MenuEspecial();
		Menu menuSta = new MenuStandar();

		Scanner sc = new Scanner(System.in);
		int opcion;

		System.out.println("***BIENVENIDO AL SISTEMA DEL ROBOT COCINERO.***"
						+ "\nPor favor elige la acción que quieras que el robot haga.");

		do{
			System.out.print(
				"1.- Activar.\n" +
				"2.- Suspender.\n" + 
				"3.- Caminar.\n" + 
				"4.- Leer el Menú.\n" +
				"5.- Ordenar.\n" +
				"6.- Cocinar.\n" +
		        "7.- Recoger el pedido.\n" +
				"0.- Salir\n" +
				"----> ");

				while (true){
					try {
						String opcionUsuario = sc.nextLine();
						opcion = Integer.parseInt(opcionUsuario);
						break;
					}catch (NumberFormatException ex){
						System.out.print("Ingresa un NUMERO valido.\n" + 
							"1.- Activar.\n" +
				            "2.- Suspender.\n" + 
				            "3.- Caminar.\n" + 
				            "4.- Leer el Menú.\n" +
				            "5.- Ordenar.\n" +
				            "6.- Cocinar.\n" +
		                    "7.- Recoger el pedido.\n" +
				            "0.- Salir\n" +
				            "----> ");
					}
				}

				switch(opcion){
					case 1:
						robot.activar();
						break;

					case 2:
						robot.suspender();
						break;

					case 3:
						robot.caminar();
						break;

					case 4:
						robot.leerMenu(menuSta, menuEsp, menuCamb);
						break;

					case 5:
						robot.recibePedido();
						break;

					case 6:
						robot.cocinar();
						break;

					case 7:
						robot.entregarPedido();
						break;

					case 0:
						break;

					default:
						System.out.println("Ingresa un número valido.");
						break;

				}

		}while(opcion != 0);

	}
}