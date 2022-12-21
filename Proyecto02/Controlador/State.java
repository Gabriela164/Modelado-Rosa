package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/
import Modelo.*;
import Vista.*;

/**
* Interfaz que define la estructura de los cambios de estado a efectuar por el tamagotchi,
* lo anterior de acuerdo al patrón de diseño State.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public interface State {

    /**
    * Declaración del método que define la respuesta del tamagotchi cuando se le solicita que juegue con el usuario
    * dependiendo de su estado actual.
    **/
    void jugar();

    /**
    * Definición del método que define la respuesta del tamagotchi cuando se le trata de 
    * alimentar dependiendo de su estado actual.
    **/
    void alimentar();
     
    /**
    * Definición del método que define la respuesta del tamagotchi cuando se trata de hacerle dormir
    * dependiendo de su estado actual.
    **/
    void dormir();

    /**
    * Definición del método que define la respuesta del tamagotchi cuando se intenta darle un baño
    * dependiendo de su estado actual.
    **/
    void baniar();

    /**
    * Definición del método que nos da una descripción del estado actual del tamagotchi.
    **/
    void comoEstas();

    /**
    * Definición del método que permite asignar un tamagotchi del cuál se manipulara su estado.
    * @param tamagotchi la mascota virtual de la cuál se cambia el estado. 
    **/
    void setTamagotchi(Tamagotchi tamagotchi);
}
