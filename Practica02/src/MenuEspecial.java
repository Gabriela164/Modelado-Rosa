/**
* Clase que define el menú de productos de lujo con el que cuenta la cadena de restaurantes,
* para ser considerado un producto de lujo, debe costar 65 o mas pumadolares.
* @author Immerwahr
* @version 1.2
**/
import java.util.Hashtable;

public class MenuEspecial extends Menu{
	
	/**Estructura de datos de tipo <code>Hashtable</code> que almacena los items en el menú**/
	private Hashtable<String, Platillo> menuEspecial;


	/**
	* Método constructor que genera un menú para los platillos de lujo 
	* adicionales a los distintivos de la cadena de restaurantes y al menu del dia.
	* Inicializa el menú con tres items recomendados por la compañia para 
	* su comercialización como platillos de lujo.
	**/
	public MenuEspecial(){
	menuEspecial = new Hashtable<String,Platillo>();
	Platillo hamburguesaConTrufas = new Platillo("DL-345","McBurguer special","Hamburguesa con salsa de trufas, jamón de bellota y cebollas caramelizadas",65.0,false,false);
	Platillo hamburguesaWagyu= new Platillo("DL-346","Wagyu burguer","Hamburguesa hecha a base de filete wagyu, en pan brioche, servida con ensalada de col rizada",65.0,false,false);
	Platillo hamburguesaTriple = new Platillo("DL-347","TriBurguer","Hamburguesa triple con carne de res, pollo y cerdo, panceta de cerdo y jamón serrano",75,false,false);
	this.addItem(hamburguesaConTrufas);
	this.addItem(hamburguesaWagyu);
	this.addItem(hamburguesaTriple);			
	}

	/**
	* Método que permite obtener la estrcutura de datos que almacena los platillos
	* en el menú.
	* @return objeto del tipo <code>Hashtable</code> que almacena el menú de lujo.
	**/
	public Hashtable<String, Platillo> getMenuEspecial(){
		return menuEspecial;
	}

	/**
	* Método que permite cambiar el menu almacenado
	* @param nuevoMenu objeto del tipo <code>Hashtable</code> que almacena el nuevo 
	* menú de lujo.
	**/
	///Quien hace uso del método, debe garantizar que el nuevo menú no este vacio.
	public void setMenuEspecial(Hashtable<String, Platillo> nuevoMenu){
		if(nuevoMenu == null){
			System.out.println("Esa no es una entrada válida");
			return;
		}
		menuEspecial = nuevoMenu;
	}

	/**
	* Método que genera un iterador que permite recorrer la estructura de datos
	* donde se almacena el menu especial.	
	* @return el iterador recien creado, incializado en su forma base con hamburguesas de carne wagyu, 
	* hamburguesas con trufas y hamburguesas triples.
	**/
	@Override public IteradorMenuEspecial creaIterador(){		
		IteradorMenuEspecial iteradorEspecial = new IteradorMenuEspecial(menuEspecial);
		return iteradorEspecial;
	}

	/**
	* Método que permite anadir un nuevo platillo al menu de lujo
	* siempre que este no se encuentre incluido ya dentro del mismo.
	* @param comidaNueva nueva adición al menu, objeto de la clase <code>Platillo</code>.	
	**/	
	@Override public void addItem(Platillo comidaNueva){
		if(comidaNueva == null){
			System.out.println("Ese no es un argumento válido");
			return;
		}		
		if(menuEspecial.contains(comidaNueva)){
			String clave = menuEspecial.get(comidaNueva).getId();
			System.out.println("El menú ya incluye ese platillo, tiene por clave: " + clave);
			return;
		}
		if(menuEspecial.containsKey(comidaNueva.getId())){
			Platillo productoYaAsignado = menuEspecial.get(comidaNueva.getId());
			System.out.println("Ese id ya fue asignado al platillo " + productoYaAsignado.getNombre() + ", elige otro id");
			return;
		}
		if(comidaNueva.getPrecio()<65){
			System.out.println("Ese no es un producto de lujo, intenta añadirlo al menu cambiante o al estandar");
			return;
		}
		menuEspecial.put(comidaNueva.getId(),comidaNueva);
				
	}

	/**
	* Método que permite remover un elemento del menú de lujo, siempre que exista alguno.
	* @param comidaAEliminar platillo que sera eliminado dentro del menú de elección diaria.
	**/	
	@Override public void removeItem(Platillo comidaAEliminar){
		if(comidaAEliminar == null){
			System.out.println("Ese no es un argumento válido");
			return;
		}
		if(menuEspecial.contains(comidaAEliminar) == false){
			System.out.println("El menu no incluye ese platillo");
			return;
		}		
		if(!menuEspecial.isEmpty()){
			menuEspecial.remove(comidaAEliminar.getId(),comidaAEliminar);
			System.out.println("El platillo "+comidaAEliminar.getNombre()+", con clave "+comidaAEliminar.getId()+" fue eliminado del menú");
		}else{
			System.out.println("No hay platillos en el menú");
			return;
		}
	}

	/**
	 * Método para buscar un platillo del menú según su id.
	 * @param id cadena que define el id del platillo buscado.
	 * @return el platillo buscado si el id coincide con alguno de los almacenados o null si no se 
	 * encuentra (aplica para entradas nulas o vacías).
	**/
	@Override public Platillo busquedaPorId(String id){
		return super.busquedaPorId(id);
	}


}