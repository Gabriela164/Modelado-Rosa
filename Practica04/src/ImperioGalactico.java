import java.util.Scanner;
import java.lang.IllegalArgumentException;

/**
* Clase que define un menú interactivo para que el usuario pueda construir una nave, ya sea que ésta sea de un tipo predefinido
* o bien quiera construirla desde cero.  
* @author Immerwahr, SanMa, Gabby 
* @version 1.2
**/

public class ImperioGalactico{
	
	public static void main(String[]args){

		Scanner lector = new Scanner(System.in);
        double presupuesto;       
        Nave nuevaNave = null;
        NaveDirector director = new NaveDirector();        
        System.out.println("Bienvenido a la galería del imperio galáctico.");		
        ///Lectura del presupuesto hasta que se ingrese un presupuesto válido.
		while(true){
			System.out.println("¿Cuál es tu presupuesto?");
            while (true){
                try {
                    String valorIngresado = lector.nextLine();
                    presupuesto = Double.parseDouble(valorIngresado);
                    if(presupuesto<0){
                    	System.out.println("Ingresa una cantidad valida.");
                    }else{
                    	 break;
                    }                   
                }catch (NumberFormatException ex){
                    System.out.println("Ingresa una cantidad valida.");
                }
       		}
            
            int opcionConstruir;
            int navePredefinida;
            ///Primer submenú para elegir entre una nave predefinida o construir una desde cero mientras.
            while(true){
                System.out.println("¿Desea construir una nave desde cero o elegir una de nuestras opciones predefinidas?" 
                        + "\n1.- Construir nave desde cero."
                        + "\n2.- Construir nave predefinida."
                        + "\n3.- Salir.");
                try {
                    String datoLeido = lector.nextLine();
                    opcionConstruir = Integer.parseInt(datoLeido);
                    if(opcionConstruir == 3 || opcionConstruir == 1)break; 
                    if(opcionConstruir == 2){                  
                         ///Segundo submenú para elegir entre tres clases de nave predefinida.
                        while(true){
                            try{
                                System.out.println("¿Cuál de nuestras opciones prefiere?" 
                                + "\n1.- Nave individual de combate."
                                + "\n2.- Nave Militar de transporte."
                                + "\n3.- Base espacial de guerra."
                                + "\n4.- Salir al menú anterior.");                         
                                String opcionElegida = lector.nextLine();
                                navePredefinida = Integer.parseInt(opcionElegida);                                
                                boolean rompeCiclo = false;                                    
                                switch(navePredefinida){
                                    case 1:
                                        nuevaNave = director.naveIndividualDeCombate();                                                                                                             
                                        break;
                                    case 2:
                                        nuevaNave = director.naveMilitarDeTransporte();                                                                      
                                        break;
                                    case 3:
                                        nuevaNave = director.naveBaseEspacialDeGuerra();                                                                       
                                        break;
                                    case 4:
                                        rompeCiclo = true;
                                        break;
                                    default:
                                        System.out.println("Esa no es una opción valida.");
                                }
                                if(rompeCiclo)break;
                                if(nuevaNave != null && (nuevaNave.getPrecioTotal() <= presupuesto)){                            
                                    System.out.println("Tu nave está lista.");
                                    System.out.println(nuevaNave.descripcion());
                                    break; 
                                } 
                                if(nuevaNave != null && (nuevaNave.getPrecioTotal() > presupuesto)){
                                    System.out.println("El costo de la nave, excede tu presupuesto.");
                                    break;   
                                }                     
                          
                            }catch(NumberFormatException excepcion){
                                System.out.println("Esa no es una opción valida.");
                            }                            
                        }    
                    }else{
                        System.out.println("Esa no es una opción valida.");
                    }                 
                                                   
                }catch (NumberFormatException ex){
                    System.out.println("Ingresa una opción valida.");
                }
            }
       		///Tercer submenú para construir una nave desde cero.
            if(opcionConstruir == 1){
                nuevaNave = director.prepararNave();
                if(nuevaNave.getPrecioTotal() > presupuesto){
                    System.out.println("El costo de la nave, excede tu presupuesto.");                                   
                }else{
                    if(!nuevaNave.estaTerminada()){
                        System.out.println("Tu nave no se terminó de construir.");
                    }else{
                        System.out.println("Tu nave está lista");
                        System.out.println(nuevaNave.descripcion()); 

                    }                     
                } 
            }
       		///Cuarto submenú para decidir si seguir con la ejecución o salir finalmente.
            System.out.println("¿No hay algo más qué quiera hacer?" 
                        + "\n1.- Construir una nave."
                        + "\n2.- Salir de la galeria.");
            int opcion;
       		while(true){
       			try {
                	String valorIngresado = lector.nextLine();
                	opcion = Integer.parseInt(valorIngresado);
                	if(opcion == 1)break;  
                	if(opcion == 2){
                   		System.out.println("Adios, vuelva pronto.");
                    	break;
                	}
                                                   
            	}catch (NumberFormatException ex){
            		System.out.println("Ingresa una opción valida.");
           		}  

       		}
       		if(opcion == 2)break;

		}

	}

}
