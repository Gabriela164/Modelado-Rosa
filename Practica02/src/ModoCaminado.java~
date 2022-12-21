
/**
* Clase que define un tipo de comportamiento a asumir por el robot,
* en concreto, el comportamiento que asume cuando se encuentra desplazándose dentro del establecimiento.
* @author Gabby
* @version 1.2
**/
public class ModoCaminado implements EstadoRobot{
    
    /**
    * <code>robot</code> el robot que asume el rol definido por esta clase.
    **/
    private Robot robot;

    /**
    * Método que permite al robot pasar a su estado activo,
    * dado que ya esta activado, informa tal hecho.
    **/
    @Override public void activar(){
        System.out.println("El robot ya está activado, está caminando");
    }

    /**
    * Método que permite al robot entrar en reposo. 
    **/
    @Override public void suspender(){
        System.out.println("El robot se ha suspendido");
        robot.setState(new ModoSuspendido());
    }
   
    /**
    * Método que permite al robot desplazarse dentro del establecimiento, puesto que ya se ha desplazado 
    * así lo informa 
    **/
    @Override public void caminar(){
        System.out.println("El robot ya se encuentra caminando");
    }

    /**
    * Método que permite al robot leer el menú a los comensales, dado que ya camino hacia la mesa, se 
    * prepara para recibir el pedido.
    * @param menuEstandar menu base que ofrece la cadena de restaurantes.
    * @param menuEspecial menu de lujo para clientes selectos.
    * @param menuCambiante menu que cambia diariamente para ofrecer así algunas novedades.
    **/
    @Override public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante){
        System.out.println(" ");
        System.out.println("Hola seré su robot cocinero el día de hoy, el menú es el siguiente: ");
        System.out.println(" ");
        System.out.println("*****MENU ESTANDAR*****");
        robot.menus(menuEstandar);
        System.out.println(" ");
        System.out.println("*****MENU ESPECIAL*****");
        robot.menus(menuEspecial);
        System.out.println(" ");
        System.out.println("*****MENU DEL DIA*****");
        robot.menus(menuCambiante);
        robot.setState(new ModoRecibiendoPedido());
    }

    /**
    * Método mediante el cual, el robot recibe un pedido,
    * mismo que posteriormente cocinará. Ya que se haya desplazado a la mesa de los clientes
    * y haya leído los menús, puede recoger sus pedidos.
    **/
    @Override public void recibePedido() {
        System.out.println("Modo caminando: El robot no puede recibir pedidos");
    }

    /**
    * Método según el cual, el robot hace entrega del platillo
    * una vez que éste ha sido cocinado. Hasta que no reciba una pedido
    * no podrá hacer entrega.
    **/
    @Override public void entregarPedido() {
        System.out.println("Modo caminando: El robot no puede entregar pedidos");
    }

    /**
    * Método que el robot emplea para preparar los distintos platillos en el menú.
    * Sólo puede entregar una vez ha recibido y cocinado el pedido, dado que se encuentra caminando,
    * por seguridad no puede cocinar nada.
    **/  
    @Override public void cocinar(){
        System.out.println("El robot no puede cocinar sin un pedido");
    }   

    /**
    * Método que permite asignar un robot que ejerce distintos roles
    * siguiendo así el patrón de diseño state. 
    * @param robot robot que ejercera un determinado rol.
    **/
    @Override public void setRobot(Robot robot){
        this.robot = robot;
    }
}
