import java.util.Scanner;

/**
* Clase donde construimos la nave a partir de los componentes dados por el usuario según lo estipulado
* por el patrón builder y damos tres naves predefinidas:
* 1.- Nave individual de combate 
* 2.- Nave militar de transporte 
* 3.- Nave espacial de guerra 
* @author Immerwahr, SanMa, Gabby 
* @version 1.2 
**/

public class NaveDirector{

    /**
    * Metodo builder GENERAL. Puede generar cualquier nave a partir
    * de los componentes seleccionados.
    * @return objeto de tipo <code>Nave</code> que define la nave construida
    * con las piezas seleccionadas.
    **/
     public Nave prepararNave(){
        Nave nave = new Nave();    
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("***¿Que le quieres poner a tu Nave?***"
                        + "\n1.- Sistema de propulsion"
                        + "\n2.- Blindaje"
                        + "\n3.- Cabina"
                        + "\n4.- Armas"
                        + "\n0.- Salir");
            while (true){
               try {
                  String opcionUsuario = sc.nextLine();
                  opcion = Integer.parseInt(opcionUsuario);
                  break;
               }catch (NumberFormatException ex){
                  System.out.println("Por favor, ingresa una opcion valida."
                        + "\n1.- Sistema de propulsion"
                        + "\n2.- Blindaje"
                        + "\n3.- Cabina"
                        + "\n4.- Armas"
                        + "\n0.- Salir");
               }
            }
            switch(opcion){
               case 1:
                  nave.agregaPropulsores(preparaSistema());
                  break;
               case 2:
                  nave.agregaBlindaje(preparaBlindaje());
                  break;
               case 3:
                  nave.agregaCabina(preparaCabina());
                  break;
               case 4:
                  nave.agregaArma(preparaArma());
                  break;
               case 0:
                  break;
               default:
                  System.out.println("Ingresa una opcion valida.");
                  break;
            }
         }while(opcion != 0);
         return nave;
    }

    /** 
    * Método auxiliar que devuelve el componente que selecciono el usuario para el 
    * sistema de propulsion de su nave.
    * @return objeto de tipo <code>SistemaDePropulsion</code> que permitira a la nave
    * desplazarse por el espacio. 
    **/
    private SistemaDePropulsion preparaSistema(){

        Scanner sc = new Scanner(System.in);
        int opcion; 

        System.out.println("**¿Que tipo de sistema de propulsion quiere para su nave?**"
                            + "\n1.- Viaje intercontinental"
                            + "\n2.- Viaje intergalactico"
                            + "\n3.- Viaje interplanetario");
            while(true){
                try{
                    String opcionUsuario = sc.nextLine();
                    opcion = Integer.parseInt(opcionUsuario);
                    if((opcion > 0) && (opcion<4)){
                        break;
                    }else {
                        System.out.println("Por favor, ingresa una opcion valida."
                        + "\n1.- Viaje intercontinental"
                        + "\n2.- Viaje intergalactico"
                        + "\n3.- Viaje interplanetario");
                    }
                }catch (NumberFormatException ex){
                    System.out.println("Por favor, ingresa una opcion valida."
                    + "\n1.- Viaje intercontinental"
                    + "\n2.- Viaje intergalactico"
                    + "\n3.- Viaje interplanetario");
                }
            }

        if (opcion == 1)return new ViajeInterContinental();
        if (opcion == 2)return new ViajeInterGalactico();
        return new ViajeInterPlanetario();        
    }


    /** 
    * Método auxiliar que devuelve el componente que selecciono el usuario para el 
    * blindaje de su nave.
    * @return objeto de tipo <code>Blindaje</code> que permite a la nave protegerse
    * de ataques enemigos.
    **/
    private Blindaje preparaBlindaje(){
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("**¿Que tipo de blindaje quiere para su nave?**"
                            + "\n1.- Blindaje simple"
                            + "\n2.- Blindaje reforzado"
                            + "\n3.- Blindaje fortaleza");
        while(true){
            try{
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if((opcion > 0) && (opcion<4)){
                    break;
                }else {
                    System.out.println("Por favor, ingresa una opcion valida."
                    + "\n1.- Blindaje simple"
                    + "\n2.- Blindaje reforzado"
                    + "\n3.- Blindaje fortaleza");
                }
            }catch (NumberFormatException ex){
                System.out.println("Por favor, ingresa una opcion valida."
                + "\n1.- Blindaje ligero"
                + "\n2.- Blindaje pesado"
                + "\n3.- Blindaje de titanio");
            }
        }
        if (opcion == 1)return new Simple();
        if (opcion == 2)return new Reforzado();
        return new Fortaleza();        
    }

    /**
    * Método auxiliar que devuelve el componente que selecciono el usuario 
    * para la cabina de su nave.
    * @return objeto de tipo <code>Cabina</code> que permite a la nave transportar
    * a una tripulación que puede variar en número.
    **/
    private Cabina preparaCabina(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("**¿Que tipo de cabina quiere para su nave?**"
                           + "\n1.- Cabina con un piloto"
                           + "\n2.- Cabina con una tripulacion pequena"
                           + "\n3.- Cabina con un ejercito");
        while(true){
            try{
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if((opcion > 0) && (opcion<4)){
                    break;
                }else {
                    System.out.println("Por favor, ingresa una opcion valida."
                    + "\n1.- Cabina con un piloto"
                    + "\n2.- Cabina con una tripulacion pequena"
                    + "\n3.- Cabina con un ejercito");
                }
            }catch(NumberFormatException ex){
                System.out.println("Por favor, ingresa una opcion valida."
                + "\n1.- Cabina con un piloto"
                + "\n2.- Cabina con una tripulacion pequena"
                + "\n3.- Cabina con un ejercito");
            }
        }
        if (opcion == 1)return new UnPiloto();
        if (opcion == 2)return new TripulacionPequena();
        return new Ejercito();        
    }


    /**
    * Método auxiliar que devuelve el componente que selecciono el usuario 
    * para las armas de su nave.
    * @return objeto de tipo <code>Arma</code> que permite a la nave atacar
    * aquellas de los enemigos.
    **/
    private Arma preparaArma(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("**¿Que tipo de arma quiere para su nave?**"
                           + "\n1.- Laser simple"
                           + "\n2.- Misiles de plasma"
                           + "\n3.- Laser destructor de planetas"); 
        while(true){
            try{
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if((opcion > 0) && (opcion<4)){
                    break;
            }else {
                System.out.println("Por favor, ingresa una opcion valida."
                + "\n1.- Laser simple"
                + "\n2.- Misiles de plasma"
                + "\n3.- Laser destructor de planetas");
            }
        }catch(NumberFormatException ex){
            System.out.println("Por favor, ingresa una opcion valida."
            + "\n1.- Laser simple"
            + "\n2.- Misiles de plasma"
            + "\n3.- Laser destructor de planetas");
           }
        }
        if (opcion == 1)return new LaserSimple();
        if (opcion == 2)return new MisilesPlasma();
        return new LaserDestructorDePlanetas();        
    }

    /**
    * Método builder para la nave individual de combate
    * Consiste en una nave con 
    * Sistema de propolsion -> viaje interplanetario 
    * Bindaje -> simple 
    * Cabina  -> un piloto 
    * Arma    -> laser simple 
    * @return <code>Nave</code> ya construida con las características 
    * antes definidas.
    **/
    public Nave naveIndividualDeCombate(){
        Nave nave = new Nave();
        nave.agregaPropulsores(new ViajeInterPlanetario());
        nave.agregaBlindaje(new Simple());
        nave.agregaCabina(new UnPiloto());
        nave.agregaArma(new LaserSimple());
        return nave;
    }

    /**
    * Método builder para la nave militar de transporte 
    * cosiste en una nave con
    * sistema de propolsion -> viaje intercontinental 
    * blindaje -> reforzado
    * cabina  -> tripulacion pequeña 
    * Arma    -> Misiles de plasma
    * @return <code>Nave</code> ya construida con las características 
    * antes definidas.
    **/
    public Nave naveMilitarDeTransporte(){
        Nave nave = new Nave();
        nave.agregaPropulsores(new ViajeInterContinental());
        nave.agregaBlindaje(new Reforzado());
        nave.agregaCabina(new TripulacionPequena());
        nave.agregaArma(new MisilesPlasma());
        return nave;
    } 

    /**
    * Método builder para la nave base espacial de guerra
    * Consiste en una nave con
    * sistema de propolsion -> viaje intergalactico
    * bindaje -> fortaleza
    * Cabina  -> Ejercito 
    * Arma    -> laser destructor de planetas 
    * @return <code>Nave</code> ya construida con las características 
    * antes definidas.
    **/
    public Nave naveBaseEspacialDeGuerra(){
        Nave nave = new Nave();
        nave.agregaPropulsores(new ViajeInterGalactico());
        nave.agregaBlindaje(new Fortaleza());
        nave.agregaCabina(new Ejercito());
        nave.agregaArma(new LaserDestructorDePlanetas()); 
        return nave; 
    }


    


}
