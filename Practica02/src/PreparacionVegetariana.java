/**
* Clase donde se define una sección de un algoritmo general que puede variar
* según lo estipulado por el patrón de diseño Template. En particular se define
* como cocinar la carne para el platillo según su tipo siendo éste, vegetariano.
* @author SanMa
* @version 1.1
**/
public class PreparacionVegetariana extends Preparacion{

    /**
    * Método para preparar carne para hamburguesa con proteína vegetal.
    **/
    @Override public void prepararCarne(){
		System.out.println("-> Se preparó la carne de Soja");
	}

	/**
    * Método para colocar carne hecha proteína vegetal dentro de la hamburguesa.
    **/
    @Override public void ponerCarne(){
		System.out.println("-> Se puso la carne de Soja en la Hamburguesa");
	}
}