/**
* Clase que define un tipo de comportamiento a asumir por el robot,
* en concreto, el comportamiento que asume cuando entra en estado de reposo.
* @author Gabby
* @version 1.2
**/
public class ModoSuspendido implements EstadoRobot{
    
    /**
    * <code>robot</code> el robot que asume el rol definido por esta clase.
    **/
    private Robot robot;

    /**
    * Método que permite al robot pasar a su estado activo toda vez
    * que se encuentra en reposo.
    **/    
    @Override public void activar(){
        System.out.println("MODO SUSPENDIDO: El robot pasa a estar activado y se dirige al cliente");
        robot.setState(new ModoActivado());
    }

    /**
    * Método que informa que el robot ya se encuentra suspendido.
    **/
    @Override public void suspender(){
        System.out.println("El robot ya está suspendido");
    }
    
    /**
    * Método que informa que no es posible para el robot
    * desplazarse puesto que está en reposo.
    **/
    @Override public void caminar(){
        System.out.println("El robot esta suspendido, no puede caminar");
    }  
   
    /**
    * Método que informa que no es posible para el robot
    * leer el menú puesto que está en reposo.
    * @param menuEstandar menu base que ofrece la cadena de restaurantes.
    * @param menuEspecial menu de lujo para clientes selectos.
    * @param menuCambiante menu que cambia diariamente para ofrecer así algunas novedades.
    **/
    @Override public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante){
        System.out.println("El robot está suspendido, no puede leer el menu al cliente");
    }

    /**
    * Método que informa que no es posible para el robot
    * atender al cliente pues está en reposo.
    **/    
    @Override public void recibePedido() {
        System.out.println("Modo suspendido: El robot no puede recibir pedidos si está suspendido");
    }


    /**
    * Método que informa que no es posible para el robot
    * atender al cliente pues está en reposo.
    **/  
    @Override public void entregarPedido() {
        System.out.println("Modo suspendido: El robot no puede entregar pedidos si está suspendido");
        
    }

    /**
    * Método que informa que no es posible para el robot
    * preparar platillos pues está en reposo.
    **/  
    @Override public void cocinar(){
        System.out.println("El robot está suspendido, no puede cocinar");
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
