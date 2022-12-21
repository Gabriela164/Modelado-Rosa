/**
* Clase abstracta a extender por aquellas clases que definen secciones
* particulares del algoritmo general que puede variar. Esta clase sigue 
* el patrón de diseño Template.
* @author SanMa
* @version 1.1
**/
public abstract class Preparacion {
	
	/**
	* <code>hamburguesa</code> objeto sobre el cual se aplica
	* el algoritmo variable. 
	**/
	protected Platillo hamburguesa;

	/**
	* Método de acceso al objeto sobre el cual se opera.
	* @return objeto de la clase <code>Platillo</code>. 
	**/
	public Platillo getPlatillo(){
		return this.hamburguesa;
	}

	/**
	* Método para ajustar el objeto sobre el cual se opera.
	* @param hamburguesa nuevo objeto de la clase <code>Platillo</code>
	* sobre el cual se ha de operar. 
	**/
	public void setPlatillo(Platillo hamburguesa){
		this.hamburguesa = hamburguesa;
	}

	/**
	* Método que permite iniciar el proceso de elaboración
	* de una hamburguesa, objeto del tipo <code>Platillo</code>.
	**/
	public void ponerPanInferior(){
		System.out.println("-> Se puso el pan inferior de la Hamburguesa");
	}

	/**
	* Método para añadir un tipo de aderezo a la hamburguesa, en concreo
	* la mayonesa. Segunda etapa en el proceso de elaboración de una hamburguesa,
	* que es un objeto del tipo <code>Platillo</code>.
	**/
	public void ponerMayonesa(){
		System.out.println("-> Se puso mayonesa en el pan inferior de la Hamburguesa");
	}

	/**
	* Método para añadir un tipo de aderezo a la hamburguesa, en concreo
	* la mostaza. Tercera etapa en el proceso de elaboración de una hamburguesa,
	* que es un objeto del tipo <code>Platillo</code>.
	**/
	public void ponerMostaza(){
		System.out.println("-> Se puso Mostaza en el pan Inferior de la Hamburguesa");
	}

	/**
	* Declaración de un método abstracto que corresponde a una parte variable
	* del algortimo general, según lo dictado por el patrón de diseño Template.
	* Ha de definir como cocinar la carne (Y de que tipo) para la hamburguesa.
	* Cuarta etapa del proceso de elaboración de una hamburguesa,
	* que es un objeto del tipo <code>Platillo</code>.
	**/
	public abstract void prepararCarne();

	/**
	* Declaración de un método abstracto que corresponde a una parte variable
	* del algortimo general, según lo dictado por el patrón de diseño Template.
	* Ha de definir como colocar la carne (Y de que tipo) para la hamburguesa.
	* Quinta etapa del proceso de elaboración de una hamburguesa,
	* que es un objeto del tipo <code>Platillo</code>.
	**/
	public abstract void ponerCarne();


	/**
	* Método que define como colocar el queso sobre la carne
	* de la hamburguesa. Sexta etapa del proceso de elaboración de 
	* una hamburguesa, que es un objeto del tipo <code>Platillo</code>.
	**/
	public void ponerQueso(Platillo hamburguesa){
		if (hamburguesa.getConQueso()) {
			System.out.println("-> Se agregó queso a tu Hamburguesa");
		}
	}

	/**
	* Método que define como colocar vegetales sobre la carne de la 
	* hamburguesa. Septima etapa del proceso de elaboración de 
	* una hamburguesa, que es un objeto del tipo <code>Platillo</code>.
	**/
	public void ponerVegetales(){
		System.out.println("-> Se agregaron vegetales a la Hamburguesa");
	}

	/**
	* Método para añadir un tipo de aderezo a la hamburguesa, en concreto
	* la catpsup. Octava etapa en el proceso de elaboración de una hamburguesa,
	* que es un objeto del tipo <code>Platillo</code>.
	**/
	public void ponerCatsup(){
		System.out.println("-> Se puso catsup en la Hamburguesa");
	}

	/**
	* Método para añadir la tapa superior del pan a la hamburguesa.
	* Novena y última etapa en el proceso de elaboración de una hamburguesa,
	* que es un objeto del tipo <code>Platillo</code>.
	**/
	public void ponerPanSuperior(){
		System.out.println("-> Finalmente, se puso su pan superior.");
		System.out.println("Disfrute su orden :D ");
	}

	/**
	* Método que aglutina las distintas partes en el proceso
	* de elaboración de una hamburguesa siguiendo el orden descrito en cada etapa.
	* Para esta implementación simple, no hay un control sobre el orden más allá
	* del que permite implementar este método.
	**/
	public void preparacion(Platillo hamburguesa){
		ponerPanInferior();
		ponerMayonesa();
		ponerMostaza();
		prepararCarne();
		ponerCarne();
		ponerQueso(hamburguesa);
		ponerVegetales();
		ponerCatsup();
		ponerPanSuperior();
	}
}