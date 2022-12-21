/**
* Clase que define un tipo de comportamiento a asumir por el robot,
* en concreto, el comportamiento que asume cuando se dispone a entregar un pedido.
* @author Gabby
* @version 1.2
**/
public class ModoEntregandoPedido implements EstadoRobot{
   
    /**
    * <code>robot</code> el robot que asume el rol definido por esta clase.
    **/
    private Robot robot;

    /**
    * Método que permite al robot pasar a su estado activo,
    * dado que ya esta activado, informa tal hecho.
    **/
    @Override public void activar(){
        System.out.println("El robot ya esta activado");
    }

    /**
    * Método que informa que el robot está entregando un pedido y por lo tanto
    * no puede entrar en reposo.
    **/
    @Override public void suspender(){
        System.out.println("El robot no puede suspenderse, esta atendiendo al cliente");
    }

    /**
    * Método que informa que el robot se encuentra brindando atención al cliente y 
    * por ello no puede moverse de su sitio aún.
    **/
    @Override public void caminar(){
        System.out.println("El robot no puede caminar, esta atendiendo al cliente");
    }    

    /**
    * Método que informa que el robot ya ha leído el menú y precisamente por ello
    * no es preciso que lo vuelva a leer hasta que sea oportuno.
    * @param menuEstandar menu base que ofrece la cadena de restaurantes.
    * @param menuEspecial menu de lujo para clientes selectos.
    * @param menuCambiante menu que cambia diariamente para ofrecer así algunas novedades.
    **/
    @Override public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante){
        System.out.println("El robot ya ha leído el menú");
    }

    /**
    * Método que informa que el robot ya ha recibido un pedido, mismo que se encuentra atendiendo y por
    * ende no puede tomar más pedidos de momento.
    **/
    @Override public void recibePedido() {
        System.out.println("El robot ya ha recibido el pedido");
    }

    /**
    * Método mediante el cual, el robot hace entrega del pedido que ya ha preparado y dispuesto,
    * una vez entregado el pedido, el robot pasa a su estado de reposo
    **/
    @Override public void entregarPedido() {
        System.out.println("Aquí tiene su pedido: ");
        System.out.println(robot.getPlatillo().toString());
        System.out.println("Espero le haya sido de su agrado mi servicio, si me necesita estaré suspendido");
        robot.setState(new ModoSuspendido());
    }

    /**
    * Método que informa que el robot ya ha preparado el platillo solicitado
    * y en consecuencia sólo debe esperarse que haga entrega del mismo.
    **/
    @Override public void cocinar(){
        System.out.println("El robot ya ha cocinado el pedido");
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