/**
* Clase que define un tipo de comportamiento a asumir por el robot,
* en concreto, el comportamiento que asume cuando se encuentra activado.
* @author Gabby
* @version 1.2
**/
public class ModoActivado implements EstadoRobot{

    /**
    * <code>robot</code> el robot que asume el rol definido por esta clase.
    **/
    private Robot robot;    
      
    /**
    * Método que permite al robot pasar a su estado activo,
    * dado que ya esta activado, informa tal hecho.
    **/
    @Override public void activar(){
        System.out.println("Modo activado: el robot ya ha sido activado");
    }
    
    /**
    * Método que permite al robot entrar en reposo. 
    **/
    @Override public void suspender(){
        System.out.println("Modo activado: El robot se suspende");
        robot.setState(new ModoSuspendido());
    }

    /**
    * Método que permite al robot desplazarse dentro del establecimiento. 
    **/
    @Override public void caminar(){
        System.out.println("Modo activado: El robot empieza a caminar");
        for (int i = 0; i < 3 ;i++) {
            System.out.println("***CAMINANDO***");
        }
        robot.setState(new ModoCaminado());
    }      
    
    /**
    * Método que permite al robot leer el menú a los comensales, no puede leer hasta que no camine
    * hacia la mesa de los clientes. 
    * @param menuEstandar menu base que ofrece la cadena de restaurantes.
    * @param menuEspecial menu de lujo para clientes selectos.
    * @param menuCambiante menu que cambia diariamente para ofrecer así algunas novedades.
    **/
    @Override public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante){
        System.out.println("El robot no puede leer el menú en este momento");
    }

    /**
    * Método mediante el cual, el robot recibe un pedido,
    * mismo que posteriormente cocinará. Sólo puede recibir una vez
    * que ha caminado hacia la mesa de los clientes.
    **/
    @Override public void recibePedido() {
        System.out.println("El robot no puede recibir pedidos en este momento");
    }

    /**
    * Método según el cual, el robot hace entrega del platillo
    * una vez que éste ha sido cocinado. Hasta que no reciba una pedido
    * no podrá hacer entrega.
    **/
    @Override public void entregarPedido() {
        System.out.println("El robot no tiene un pedido qué entregar");     
    }

    /**
    * Método que el robot emplea para preparar los distintos platillos en el menú.
    * Sólo puede entregar una vez ha recibido y cocinado el pedido.
    **/  
    @Override public void cocinar(){
        System.out.println("El robot no puede cocinar si no tiene un pedido");
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
