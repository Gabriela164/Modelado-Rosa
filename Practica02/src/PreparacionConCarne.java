/**
* Clase donde se define una sección de un algoritmo general que puede variar
* según lo estipulado por el patrón de diseño Template. En particular se define
* como cocinar la carne para el platillo según su tipo siendo éste, no vegetariano.
* @author SanMa
* @version 1.1
**/
public class PreparacionConCarne extends Preparacion{

    /**
    * Método para preparar carne para hamburguesa con proteína animal.
    **/
    @Override public void prepararCarne(){
		System.out.println("-> Se preparó la carne de Res");
	}
    
    /**
    * Método para colocar carne hecha proteína animal dentro de la hamburguesa.
    **/
    @Override public void ponerCarne(){
		System.out.println("-> Se puso la carne de res en la Hamburguesa");
	}
}