/**
* Clase que define un tipo de comportamiento a asumir por el robot,
* en concreto, el comportamiento que asume cuando se dispone a recibir un pedido.
* @author Gabby
* @version 1.2
**/
import java.util.Scanner;
public class ModoRecibiendoPedido implements EstadoRobot{
    
    /**
    * <code>robot</code> el robot que asume el rol definido por esta clase.
    **/
    private Robot robot;

    /**
    * Método que permite al robot pasar a su estado activo,
    * dado que ya esta activado, informa tal hecho.
    **/
    @Override public void activar(){
        System.out.println("El robot ya esta activado, esta atendiendo al cliente");
    }

    /**
    * Método que informa que el robot se encuentra atendiendo un pedido y por lo tanto
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
    * Método que habilita al robot para tomar un pedido, solicitará al cliente que elija alguno
    * de los platillos en el menú y lo identifique con su respectiva clave alfanúmerica.
    **/
    @Override public void recibePedido() {
        System.out.println("Por favor ingrese el ID de su pedido");
        Scanner in = new Scanner(System.in);
        String pedido = in.nextLine();
        Menu menuEspecial = new MenuEspecial();
        Menu menuEstandar = new MenuStandar();
        Menu menuCambiante = new MenuCambiante();
        Platillo hamburguesa;
        hamburguesa = menuEspecial.busquedaPorId(pedido); 
        if (hamburguesa == null) {
            hamburguesa = menuCambiante.busquedaPorId(pedido);
            if (hamburguesa == null) {
                hamburguesa = menuEstandar.busquedaPorId(pedido);
            }
        }
        if (hamburguesa == null) {
            System.out.println("No se ha encontrado ese ID en ningún menu");
            recibePedido();
        }else{
            robot.setPlatillo(hamburguesa);
            robot.setState(new ModoCocinando());
        }
    }

    /**
    * Método que informa que el robot aún no prepara el platillo aunque ya se encuentra
    * registrando la orden.
    **/
    @Override public void entregarPedido() {
        System.out.println("Modo recibiendo el pedido: Al robot le falta cocinar el pedido");        
    }

    /**
    * Método que informa que el robot aún no prepara el platillo pues se encuentra a la espera
    * de que el cliente haga su elección.
    **/
    @Override public void cocinar(){
        System.out.println("El robot está atentiendo el cliente, aún NO recibe el pedido");
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
