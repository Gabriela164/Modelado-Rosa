/**
* Clase que define el menú diario adicional al estándar, de la cadena de restaurantes,
* @author Immerwahr
* @version 1.2
**/
import java.util.ArrayList;

public class MenuCambiante extends Menu{
	
	/**<code>menuCambiante</code> estructura de datos de tipo <code>ArrayList</code> que almacena los items en el menú**/
	private ArrayList<Platillo> menuCambiante;


	/**
	* Método constructor que genera un menú cambiante para la presentación de platillos 
	* adicionales a los distintivos de la cadena de restaurantes.
	* Inicializa el menú con tres items recomendados por la compania para 
	* su comercialización variable.
	**/
	public MenuCambiante(){
	menuCambiante = new ArrayList<Platillo>();
	Platillo hamburguesaConTocino = new Platillo("CN-2070","McBurgy bacon","Hamburguesa con tocino y queso, sin complementos",42.0,true,false);
	Platillo hamburguesaHawaiana = new Platillo("CN-2071","Hawaiian McBurgy","Hamburguesa con jamón, piña y queso, sin complementos",48,true,false);
	Platillo hamburguesadePollo = new Platillo("CN-2072","McChicken","Hamburguesa de pollo, sin complementos",35.0,false,false);
	this.addItem(hamburguesaConTocino);
	this.addItem(hamburguesaHawaiana);
	this.addItem(hamburguesadePollo);			
	}

	/**
	* Método que permite obtener la estrcutura de datos que almacena los platillos
	* en el menú.
	* @return objeto del tipo <code>ArrayList</code> que almacena
	* los distintos platillos en el menú cambiante.
	**/	
	public ArrayList<Platillo> getMenuCambiante(){
		return menuCambiante;
	}

	/**
	* Método que permite cambiar el menú almacenado.
	* @param nuevoMenu objeto de tipo <code>ArrayList</code> que almacena el nuevo menu.
	**/
	///Quien hace uso del método, debe garantizar que el nuevo menú no este vacío.
	public void setMenuCambiante(ArrayList<Platillo> nuevoMenu){
		if(nuevoMenu == null){
			System.out.println("Esa no es una entrada válida");
			return;
		}
		menuCambiante = nuevoMenu;
	}

	/**
	* Método que genera un iterador que permite recorrer la estructura de datos
	* donde se almacena el menú.	
	* @return el iterador recién creado, incializado en su forma base.
	**/
	@Override public IteradorMenuCambiante creaIterador(){
		IteradorMenuCambiante iteradorCambiante = new IteradorMenuCambiante(menuCambiante);
		return iteradorCambiante;
	}

	/**
	* Método que permite añadir un nuevo platillo al menu
	* siempre que este no se encuentre incluído ya dentro del mismo.
	* @param comidaNueva nueva adición al menú, objeto de la clase <code>Platillo</code>.	
	**/	
	@Override public void addItem(Platillo comidaNueva){		
		if(comidaNueva == null){
			System.out.println("Esa no es una entrada válida");
			return;
		}		
		if(menuCambiante.contains(comidaNueva)){
			System.out.println("El menú ya incluye ese platillo");
			return;
		}
		IteradorMenuCambiante iterador = this.creaIterador();
		Platillo comida;
		while(iterador.hasNext()){
			comida = iterador.next();
			if(comida.getNombre() == comidaNueva.getNombre() || comida.getId() == comidaNueva.getId()){
				System.out.println("Ya hay un platillo similar a ese en el menú: " + comida.getNombre() + " Clave " + comida.getId());
				System.out.println("Intenta con otra opcion.");
				return;
			}
		}
		menuCambiante.add(comidaNueva);	
	}

	/**
	* Método que permite remover un elemento del menú de elección diaria, siempre que exista alguno igual
	* al pasado como parámetro.
	* @param comidaAEliminar platillo que sera eliminado dentro del menu de elección diaria.
	**/	
	@Override public void removeItem(Platillo comidaAEliminar){
		if(comidaAEliminar == null){
			System.out.println("Esa no es una entrada valida");
			return;
		}
		if(menuCambiante.contains(comidaAEliminar) == false){
			System.out.println("El menú no incluye ese platillo");
			return;
		}		
		if(!menuCambiante.isEmpty()){
			menuCambiante.remove(comidaAEliminar);
			System.out.println("El platillo "+comidaAEliminar.getNombre()+", con clave "+comidaAEliminar.getId()+" fue eliminado del menu");
		}else{
			System.out.println("No hay más elementos en el menu");
			return;
		}
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
	


}