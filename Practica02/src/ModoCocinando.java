/**
* Clase que define un tipo de comportamiento a asumir por el robot,
* en concreto, el comportamiento que asume cuando se encuentra cocinando un platillo.
* @author Gabby
* @version 1.2
**/

public class ModoCocinando implements EstadoRobot{
    /**
    * <code>robot</code> el robot que asume el rol definido por esta clase.
    **/
    private Robot robot;

    
    /**
    * Método que permite al robot pasar a su estado activo,
    * dado que ya esta activado y cocinando, informa tal hecho.
    **/   
    @Override public void activar(){
        System.out.println("Modo chef: El robot está activado pues está cocinando jeje");
    }

    /**
    * Método que informa que el robot se encuentra cocinando y por seguridad
    * no puede entrar en reposo.
    **/
    @Override public void suspender(){
        System.out.println("El robot no se puede suspender, esta cocinando");
    }
    
    /**
    * Método que informa que el robot se encuentra cocinando y por seguridad
    * no se puede mover.
    **/
    @Override public void caminar(){
        System.out.println("Modo chef: El robot NO puede caminar mientras cocina");
    }
    
    /**
    * Método que informa que el robot se encuentra cocinando y por seguridad
    * no puede dirigirse a leer el menú.
    * @param menuEstandar menu base que ofrece la cadena de restaurantes.
    * @param menuEspecial menu de lujo para clientes selectos.
    * @param menuCambiante menu que cambia diariamente para ofrecer así algunas novedades.
    **/      
    @Override public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante){
          System.out.println("El robot no puede leer el menu al cliente mientras esta cocinando");
    }

    /**
    * Método que informa que el robot se encuentra cocinando y por seguridad, además de eficiencia,
    * no puede tomar más pedidos de momento.
    **/
    @Override public void recibePedido() {
        System.out.println("Modo chef: El robot no puede recibir pedidos cuando esta cocinando");
        
    }
    
    /**
    * Método que informa que el robot se encuentra cocinando aún el platillo
    * y por lo tanto no lo puede entregar.
    **/
    @Override public void entregarPedido() {
        System.out.println("Modo chef: El robot no puede entregar pedidos cuando esta cocinando");
    }
  
    /**
    * Método que pone en marcha al robot para que este cocine alguna de las opciones
    * dentro del menú.
    **/ 
    @Override public void cocinar(){
        System.out.println("El robot ya esta cocinando");
        Preparacion prep;
        if (robot.getPlatillo().getVegetariano()) {
            prep = new PreparacionVegetariana();
            prep.preparacion(robot.getPlatillo());
            robot.setState(new ModoEntregandoPedido());
        }
        else{
            prep = new PreparacionConCarne();
            prep.preparacion(robot.getPlatillo());
            robot.setState(new ModoEntregandoPedido());
        }
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
