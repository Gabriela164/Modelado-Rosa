/**
* Clase que define el menú clásico de la cadena de restaurantes,
* incluye tres platillos tradicionales y distintivos de la marca.
* @author Immerwahr
* @version 1.2
**/

public class MenuStandar extends Menu{
	
	/**
	* Estructura de datos de tipo arreglo que almacena los items en el menu, se inicializa
	* con una cantidad fija de 4 localidades.
	**/
	private Platillo[] menuStandar = new Platillo[4];


	/**
	* Método constructor que genera un menu estándar para la presentación de platillos base al cliente,
	* inicializa el menú con cuatro items de base: hamburguesas sencilla, con queso y vegetariana además de papas fritas. 
	**/
	public MenuStandar(){
	Platillo hamburguesaClasica = new Platillo("EN-2064","McBurgy","Hamburguesa sencilla,sin queso ni complementos",35.0,false,false);
	Platillo hamburguesaConQueso = new Platillo("EN-2065","McBurgy con queso","Hamburguesa sencilla con queso, sin complementos",40.0,true,false);
	Platillo hamburguesaVegetariana = new Platillo("EN-2066","McVeggie","Hamburguesa vegetariana, con carne de soya y sin complementos",35.0,false,true);
	Platillo hamburguesaConSalchicha = new Platillo("EN-2067","McDog","Hamburguesa sencilla adicionada con salchichas en trozos",25.0,false,false);
	menuStandar[0] = hamburguesaClasica;
	menuStandar[1] = hamburguesaConQueso;
	menuStandar[2] = hamburguesaVegetariana;
	menuStandar[3] = hamburguesaConSalchicha;			
	}


	/**
	* Método que permite obtener la estructura de datos que almacena los platillos
	* en el menú.
	* @return arreglo que almacena objetos del tipo <code>Platillo</code> 
	* que definen las distintas opciones en el menú base.
	**/
	public Platillo[] getMenuStandar(){
		return menuStandar;
	}

	/**
	* Método que permite cambiar el menú almacenado.
	* @param nuevoMenu arreglo que almacena el nuevo menú siempre que este tenga 
	* una longitud predefinida de 4 localidades.
	**/
	///Quien hace uso del método, debe garantizar que el nuevo menú no este vacío.
	public void setMenuStandar(Platillo[] nuevoMenu){
		if(nuevoMenu == null || nuevoMenu.length != 4){
			System.out.println("Esa no es una entrada valida");
			return;
		}
		menuStandar = nuevoMenu;
	}

	/**
	* Método que genera un iterador que permite recorrer la estructura de datos
	* donde se almacena el menú.
	* @return el iterador recién creado, incializado en su forma base.
	**/
	@Override public IteradorMenuStandar creaIterador(){
		IteradorMenuStandar iteradorStandar = new IteradorMenuStandar(menuStandar);
		return iteradorStandar;
	}

	/**
	* Método para asignar un nuevo platillo al menú, siempre en la última posición del
	* arreglo que almacena los platillos.		
	* @param nuevaComida platillo que sera anadido dentro del menu. 
	**/
	@Override public void addItem(Platillo nuevaComida){
		cambiaItem(getMenuStandar()[3],nuevaComida);
	}


	/**
	* Método para remover un platillo del menú, su implementación en esta clase
	* en concreto solo consta de una advertencia para garantizar consistencia 
	* en el menú base de la cadena de restaurantes.
	* @param nuevaComida platillo que sera añadido dentro del menú. 
	**/
	@Override public void removeItem(Platillo platilloQuitado){
		System.out.println("Solo es valido cambiar un platillo viejo por uno nuevo");		
	}

	/**
	 * Método para buscar un platillo del menú según su id.
	 * @param id cadena que define el id del platillo buscado.
	 * @return el platillo buscado si el id coincide con alguno de los almacenados o null si no se 
	 * encuentra (aplica para entradas nulas o vacias).
	**/
	@Override public Platillo busquedaPorId(String id){
		return super.busquedaPorId(id);
	}

	/**
	* Método auxiliar que permite añadir un nuevo platillo al menu.
	* @param comidaNueva nueva adición al menú, objeto de la clase <code>Platillo</code>.
	* @param posicion entero que indica la posición dentro del arreglo donde se añadira 
	* el nuevo platillo.
	**/	
	private void addItemModificado(Platillo comidaNueva,int posicion){		
		if(comidaNueva == null || posicion <0 || posicion>= menuStandar.length){
			System.out.println("Ese no es un argumento valido");
			return;
		}
		IteradorMenuStandar iterador = new IteradorMenuStandar(menuStandar);
		while(iterador.hasNext()){
			if(iterador.next().equals(comidaNueva)){
				System.out.println("El menu ya contiene ese platillo, considere otra opcion");
				return;
			}
		}
		menuStandar[posicion] = comidaNueva;
	}

	/**
	* Método que permite cambiar un elemento del menú base, la cantidad de elementos en dicho menú
	* ha de ser constante e igual a 4.
	* @param viejoPlatillo platillo que sera reemplazado dentro del menú estandar.
	* @param nuevoPlatilo  nueva adición al menú.
	**/	
	public void cambiaItem(Platillo viejoPlatillo,Platillo nuevoPlatillo){
		if(viejoPlatillo == null || nuevoPlatillo == null){
			System.out.println("Ese no es un argumento valido");
			return;
		}		
		IteradorMenuStandar iterador2 = this.creaIterador();
		while(iterador2.hasNext()){
			if(iterador2.next().equals(viejoPlatillo)){
				addItemModificado(nuevoPlatillo, iterador2.getPosicionActual());
				System.out.println("El platillo " + nuevoPlatillo.getNombre()+ " fue añadido al menu.");
			}
		}
	}

}