import java.util.Scanner;
/**
* Clase de ejecución que controla la interacción con el usuario
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Main{

	/**
	 * Método auxiliar que crea clientes y los agrega al catálogo
	 * Los clientes ya están creados
	 * @param catalogoClien la esctructura donde se guardarán los clientes
	 */
	public static void agregarClientes(CatalogoDeClientes catalogoClien){
		Cliente Arturo = new Cliente("Arturo", "MEX", "AlfredoAdameTKM", 315161718);
		Cliente Rosa = new Cliente("Rosa", "USA", "HolaJapon789", 308091011);
		Cliente Itzel = new Cliente("Itzel", "ESP", "AdiosMundo123", 326272829);
		Cliente Fernando = new Cliente("Fernando", "ESP", "HolaMundo123", 218192021);
		Monedero deArturo = new Monedero(25000, Arturo, 1234);
		Monedero deRosa = new Monedero(25000, Rosa, 2468);
		Monedero deItzel = new Monedero(25000, Itzel, 1379);
		Monedero deFernando = new Monedero(25000, Fernando, 6789);
		Arturo.setMonedero(deArturo);
		Rosa.setMonedero(deRosa);
		Itzel.setMonedero(deItzel);
		Fernando.setMonedero(deFernando);
		catalogoClien.addCliente(Arturo);
		catalogoClien.addCliente(Rosa);
		catalogoClien.addCliente(Itzel);
		catalogoClien.addCliente(Fernando);

	}

	/**
	 * Método que se encarga de crear productos para agregarlos al catalogo de la tienda
	 * y posteriormente los clona 5 veces
	 * @param catalogoProd el catálogo de la tienda
	 */
	public static void agregaProductos(CatalogoDeProductos catalogoProd){
		Producto arreglo [] = new Producto[21];
		Producto pan = new Producto ("Pan Bombi", "alimento" , 25.0, 111101);
		arreglo[0] = pan;
		Producto carne = new Producto ("Carne fresca", "alimento", 225.0, 111102);
		arreglo[1] = carne;
		Producto cereales = new Producto ("Cereales Kilogs", "alimento", 55.0, 111103);
		arreglo[2] = cereales;
		Producto leche = new Producto ("Leche Lola", "alimento", 25.0, 111104);
		arreglo[3] = leche;
		Producto galletas = new Producto ("Galletas Chukis", "alimento", 17.0, 111105);
		arreglo[4] = galletas;
		Producto mantequilla = new Producto ("Mantequilla con nutella", "alimento", 13.0, 111106);
		arreglo[5] = mantequilla;
		Producto helado = new Producto ("Helado de birria", "alimento", 89.0, 111107);
		arreglo[6] = helado;
		Producto microondas = new Producto ("Microondas", "electrodomésticos", 560.0, 222201);
		arreglo[7] = microondas;
		Producto refrigerador = new Producto ("Refrigerador", "electrodomésticos", 2500.0, 222202);
		arreglo[8] = refrigerador;
		Producto estufa = new Producto ("Estufa", "electrodomésticos", 2000.0, 222203);
		arreglo[9] = estufa;
		Producto lavadora = new Producto ("Lavadora", "electrodomésticos", 2800.0, 222204);
		arreglo[10] = lavadora;
		Producto freidoraDeAire = new Producto ("Freidora de Aire", "electrodomésticos", 1200.0, 222205);
		arreglo[11] = freidoraDeAire;
		Producto licuadora = new Producto ("Licuadora", "electrodomésticos", 800.0, 222206);
		arreglo[12] = licuadora;
		Producto secadora = new Producto ("Secadora", "electrodomésticos", 1300.0, 222207);
		arreglo[13] = secadora;
		Producto tv = new Producto ("Televisión 24k", "electronica", 12000.50, 333301);
		arreglo[14] = tv;
		Producto celular = new Producto ("Aifon 23", "electronica", 10000000000000000.99, 333302);
		arreglo[15] = celular;
		Producto celular2 = new Producto ("Sumsang B52", "electronica", 5600.0, 333303);
		arreglo[16] = celular2;
		Producto computadora = new Producto ("Xtrema Pc", "electronica", 18000.50, 333304);
		arreglo[17] =computadora;
		Producto laptop = new Producto ("Laptop Lonuevo", "electronica", 13000.0, 333305);
		arreglo[18] =laptop;
		Producto reloj = new Producto ("Galaxia watch", "electronica", 3200.0 , 333306);
		arreglo[19] =reloj;
		Producto audifonos = new Producto ("Airepods", "electronica", 6000.0, 333307);
		arreglo[20] =audifonos;

		for (Producto p : arreglo) {
			for (int i = 0; i < 5 ; i++) {
				catalogoProd.addProducto(p.clonar());
			}
		}

	}

	public static void main(String [] args){

		CatalogoDeProductos catalogoProd = new CatalogoDeProductos();
		CatalogoDeClientes catalogoClien = new CatalogoDeClientes();	
		Tienda tienda = new Tienda(catalogoProd, catalogoClien);
		agregarClientes(catalogoClien);
		agregaProductos(catalogoProd);
		Scanner lector = new Scanner(System.in);
		int identificador;
		String contrasena;
		int contador = 0;
		boolean accesoConcedido = false;
		Cliente clienteNuevo = null;
		AsistenteVirtual asistente = null;
		while(contador < 4){
			try{
				System.out.println("Id: ");
				identificador = lector.nextInt();
				System.out.println("password: ");
				contrasena = lector.next();				
			}catch(Exception io){
				lector = new Scanner(System.in);
				contador++;
				continue;
			}
			clienteNuevo = tienda.getClientes().busquedaPorId(identificador);
			if(clienteNuevo == null){
				contador++;				
			}else{
				if(clienteNuevo.getContrasena().equals(contrasena)){				
				accesoConcedido = true;							
				break;
				}
			}	
					
		}
		if(accesoConcedido == true){
			switch(clienteNuevo.getRegion()){
				case "USA":
					asistente = new AsistenteVirtual(new RegionUSA(), clienteNuevo, tienda);					
					break;
				case "MEX":
					asistente = new AsistenteVirtual(new RegionMex(), clienteNuevo, tienda);					
					break;
				case "ESP":
					asistente = new AsistenteVirtual(new RegionEsp(), clienteNuevo, tienda);					
					break;
				default:
					asistente = new AsistenteVirtual(new RegionMex(), clienteNuevo, tienda);					
					break;
			}			
			asistente.bienvenida();
			asistente.ofertas();			
			int opcionMenu;
			Carrito carritoNuevo = new Carrito();
			boolean salidaConcedida = false;
			while(true){
				try{
					asistente.primerMenu();
					opcionMenu = lector.nextInt();
				}catch(Exception exception){
					lector = new Scanner(System.in);
					continue;
				}
				switch(opcionMenu){
					case 1:
						asistente.leeCatalogo();
						break;
					case 2:
						asistente.venta(carritoNuevo);
						break;
					case 3:
						int result = asistente.concretaCompra(carritoNuevo);
						if(result == -4 || result == -3 || result == -1){
							System.out.println(asistente.getRegion().mensajeCompraFallida());
						}else{
							salidaConcedida = true;
							asistente.despedida();
						}
						break;																	
					case 4:
						salidaConcedida = true;
						asistente.despedida();
						break;
					default:
						System.out.println(asistente.getRegion().mensajeOpcionInvalida());
						break;
				}
				if(salidaConcedida)break;
			}		
		}			

	}
	

}
