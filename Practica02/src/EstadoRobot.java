/**
* interfaz a implementar por aquellas clases que modelan los distintos roles
* que puede ejercer la clase central dentro del patrón state.
* @author Gabby
* @author SanMa
* @version 1.1
**/
public interface EstadoRobot{
    
    /**
    * Declaración del método que define la activación
    * del robot. 
    **/
    public void activar();
    
    /**
    * Declaración del método que define la entrada en estado
    * de reposo por parte del robot. 
    **/
    public void suspender();

    /**
    * Declaración del método que permite al robot desplazarse
    * dentro del establecimiento. 
    **/
    public void caminar();

    /**
    * Declaración del método que permite al robot leer el menú a 
    * los comensales. 
    * @param menuEstandar menu base que ofrece la cadena de restaurantes.
    * @param menuEspecial menu de lujo para clientes selectos.
    * @param menuCambiante menu que cambia diariamente para ofrecer así algunas novedades.
    **/
    public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante);
    
    /**
    * Declaración del método mediante el cual, el robot recibe un pedido,
    * mismo que posteriormente cocinará. 
    **/
    public void recibePedido();
    
    /**
    * Declaración del método según el cual, el robot hace entrega del platillo
    * una vez que éste ha sido cocinado.
    **/
    public void entregarPedido();
    
    /**
    * Declaración del método que el robot emplea para preparar
    * los distintos platillos en el menú.
    **/
    public void cocinar();
    
    /**
    * Declaración del método que permite asignar un robot que ejerce distintos roles
    * siguiendo así el patrón de diseño state. 
    * @param robot robot que ejercera un determinado rol.
    **/
    public void setRobot(Robot robot);
}
