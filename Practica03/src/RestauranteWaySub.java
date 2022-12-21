import java.util.Scanner;
import java.util.ArrayList;

/**
* Clase que muestra el comportamiento de los patrones diseñados.
* En concreto, esta clase es un menú interactivo donde se muestra en terminal el menu de un restaurante de Baguettes y pizzas
* @author SanMa
* @version 1.1 
**/
public class RestauranteWaySub{

    public static void main (String[] args){
        System.out.println("Bienvenido, ¿Qué se le ofrece?");
        System.out.println("1- Baguette");
        System.out.println("2- Pizza");
        int opcion = auxiliar(1,2);
        switch (opcion) {
            case 1:
                System.out.println("¿Qué tipo de pan le gustaría en su Baguette?");
                System.out.println("1- Pan integral");
                System.out.println("2- Pan Blanco");
                System.out.println("3- Pan Avena-Miel");
                int opcion2 = auxiliar(1,3);
                switch (opcion2) {
                    case 1:
                        Pan_Integral panInt = new Pan_Integral();
                        opcionBaguette(panInt);
                        break;
                    case 2:
                        Pan_Blanco panBlan = new Pan_Blanco();
                        opcionBaguette(panBlan);
                        break;
                    case 3:
                        Pan_AvenaMiel pan = new Pan_AvenaMiel();
                        opcionBaguette(pan);
                        break;
                }
                break;
            case 2:
                opcionPizza();
                break;
        }
    }

    /**
    * Declaración del método que se encarga de imprimir en terminal el comportamiento
    * del patrón Decorator en Baguettes
    * @param pan El tipo de pan que tendrá como núcleo el Baguette
    **/
    private static void opcionBaguette(Baguette pan){
        int bandera1 = 0;
        int bandera2 = 0;
        int bandera3 = 0;
        int bandera4 = 0;
        int bandera5 = 0;
        int bandera6 = 0;
        int bandera7 = 0;
        int bandera8 = 0;
        int bandera9 = 0;

        if (pan instanceof Pan_Blanco) {
            pan = (Pan_Blanco)pan;
        }
        else if (pan instanceof Pan_Integral) {
            pan = (Pan_Integral)pan;
        }
        else{
            pan = (Pan_AvenaMiel)pan;
        }
        int opcion = 100;
        while(opcion != 0){
            System.out.println("¿Qué ingrediente quieres agregar?");
            System.out.println("1- Jitomate");
            System.out.println("2- Catsup");
            System.out.println("3- Cebolla");
            System.out.println("4- Pollo");
            System.out.println("5- Mostaza");
            System.out.println("6- Pepperoni");
            System.out.println("7- Mayonesa");
            System.out.println("8- Lechuga");
            System.out.println("9- Jamón");
            System.out.println("0- Recibir ticket");
            opcion = auxiliar(0,9);
            switch (opcion) {
                case 1:
                    if (bandera1 <= 2) {
                        pan = new Jitomate(pan);
                        bandera1++;   
                    }   
                    
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 2:
                    
                    if (bandera2 <= 2) {
                        pan = new Catsup(pan);
                        bandera2++; 
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 3:
                    
                    if (bandera3 <= 2) {
                        pan = new Cebolla(pan);
                        bandera3++; 
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 4:
                    if (bandera4 <= 2) {
                        pan = new Pollo(pan);
                        bandera4++;  
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 5:
                    if (bandera5 <= 2) {
                        pan = new Mostaza(pan);
                        bandera5++;  
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 6:
                    if (bandera6 <= 2) { 
                        pan = new Pepperoni(pan);
                        bandera6++;
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 7:
                    if (bandera7 <= 2) {
                        pan = new Mayonesa(pan);
                        bandera7++;
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 8:
                    if (bandera8 <= 2) {
                        pan = new Lechuga(pan);
                        bandera8++;  
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 9:
                    if (bandera9 <= 2) {
                        pan = new Jamon(pan);
                        bandera9++;  
                    }
                    else{
                        System.out.println("Haz alcanzado el máximo de ese ingrediente");
                    }
                    break;
                case 0:
                    System.out.println("*****Ticket*****");
                    System.out.println("Tu Baguette tiene las siguientes Características: " + pan.getDescripcion());
                    System.out.println("Total a pagar: " + pan.getPrecio());
            }
        }
    }

    /**
    * Declaración del método que se encarga de imprimir en terminal el comportamiento
    * del patrón Adapater en terminar
    **/
    private static void opcionPizza(){
        System.out.println("¿Qué tipo de Pizza quieres?");
        System.out.println("1- Banda elastica, $35.0");
        System.out.println("2- Desiaparicion, $30.0");
        System.out.println("3- Capitan Magma, $31.0");
        System.out.println("4- Carrerin, $27.0");
        System.out.println("5- Sirenoman, $40.5");
        int opcion = auxiliar(1,5);
        AdaptadorPizza adaptador;
        Pizza pizza;

        switch (opcion) {
            case 1:
                pizza = new Pizza("Banda elastica");
                adaptador = new AdaptadorPizza(pizza);
                System.out.println("*****Ticket*****");
                System.out.println(adaptador.getDescripcion());
                System.out.println("Total a pagar: " + adaptador.getPrecio());
                break;
            case 2:
                pizza = new Pizza("Desiaparicion");
                adaptador = new AdaptadorPizza(pizza);
                System.out.println("*****Ticket*****");
                System.out.println(adaptador.getDescripcion());
                System.out.println("Total a pagar: " + adaptador.getPrecio());
                break;
            case 3:
                pizza = new Pizza("Capitan Magma");
                adaptador = new AdaptadorPizza(pizza);
                System.out.println("*****Ticket*****");
                System.out.println(adaptador.getDescripcion());
                System.out.println("Total a pagar: " + adaptador.getPrecio());
                break;
            case 4:
                pizza = new Pizza("Carrerin");
                adaptador = new AdaptadorPizza(pizza);
                System.out.println("*****Ticket*****");
                System.out.println(adaptador.getDescripcion());
                System.out.println("Total a pagar: " + adaptador.getPrecio());
                break;
            case 5:
                pizza = new Pizza("Sirenoman");
                adaptador = new AdaptadorPizza(pizza);
                System.out.println("*****Ticket*****");
                System.out.println(adaptador.getDescripcion());
                System.out.println("Total a pagar: " + adaptador.getPrecio());
                break;
        }
    }

    /**
    * Declaración del método que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin COta superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
     private static int auxiliar(int inicio, int fin) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        int opcion = -100;
        boolean bandera = false;

        do{
            try {
                System.out.print("---> ");
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if (opcion >= inicio && opcion <= fin) {
                    break;  
                }
                else{
                    System.out.println("Ingresa una opción válida");
                }
            }catch (NumberFormatException ex){
                System.out.println("Ingresa un NUMERO valido");
            }       
        }while(bandera == false);
        return opcion;
    }
}
