package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
* Clase que define un minijuego, en concreto el juego conocido como gato
* en paises de habla hispana o tic tac toe en paises de habla inglesa,
* para que el usuario tenga una experiencia más entretenida.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class JuegoGato implements MiniJuego{
    private final int FILAS = 3;
    private final int COLUMNAS = 3;
    private final char JUGADOR_X = 'X';
    private final char JUGADOR_O = 'O';
    private final char JUGADOR_CPU_O = JUGADOR_O;
    private final char ESPACIO_VACIO = ' ';
    private final int CONTEO_PARA_GANAR = 3;
    private final int JUGADOR_CPU = 2;
    private final Scanner sc = new Scanner(System.in);
    private final static String NOMBRE = "Juego Gato";

    /**
    * Método que permite conocer el nombre del juego.
    * @return una cadena con el nombre que identifica al juego.
    **/
    @Override
    public String getNombre(){
        return this.NOMBRE;
    }

    /**
    * Método que permite conocer el precio del juego.
    * @return un entero con el costo en moneda virtual del juego.
    **/
    @Override
    public int precio(){
        return 5;
    }

    /**
    * Método que permite clonar el tablero sobre el cuál
    * tiene lugar la partida.
    * @param tableroOriginal el tablero a clonar
    * @return un arreglo de caracteres en 2 dimensiones con el tablero.
    **/ 
    public char[][] clonarMatriz(char[][] tableroOriginal) {
        char[][] copia = new char[FILAS][COLUMNAS];
        for (int y = 0; y < FILAS; y++) {
            for (int x = 0; x < COLUMNAS; x++) {
                copia[y][x] = tableroOriginal[y][x];
            }
        }
        return copia;
    }

    /**
    * Método que ajusta el tablero a un estado inicial predefinido.
    * @param tablero el tablero a ajustar 
    **/  
    public void limpiarTablero(char[][] tablero) {
        int y;
        for (y = 0; y < FILAS; y++) {
            int x;
            for (x = 0; x < COLUMNAS; x++) {
                tablero[y][x] = ESPACIO_VACIO;
            }
        }
    }

    /**
    * Método que muestra el tablero en su estado actual.
    * @param tablero el tablero a mostrar en terminal.
    **/  
    public void imprimirTablero(char[][] tablero) {
        System.out.print("\n");
        int y;
        int x;
        // Imprimir encabezado
        System.out.print("| ");
        for (x = 0; x < COLUMNAS; x++) {
            System.out.printf("|%d", x + 1);
        }
        System.out.print("|\n");
        for (y = 0; y < FILAS; y++) {
            System.out.printf("|%d", y + 1);
            for (x = 0; x < COLUMNAS; x++) {
                System.out.printf("|%c", tablero[y][x]);
            }
            System.out.print("|\n");
        }
    }

    /** Metodo que dice si una casilla en el tablero está vacía o no.
    * @param y coordenada y u ordenada en el tablero.
    * @param x coordenada x o abscisa en el tablero.
    * @param tablero en el cuál se ha de buscar.
    * @return respuesta en formato booleano sobre el estado actual de
    * la casilla en cuestión (vacía = TRUE, llena = FALSE). 
    **/ 
    public boolean coordenadasVacias(int y, int x, char[][] tablero) {
        return tablero[y][x] == ESPACIO_VACIO;
    }

    /** Metodo que coloca una "ficha" sobre el tablero.
    * @param y coordenada y u ordenada en el tablero.
    * @param x coordenada x o abscisa en el tablero.
    * @param pieza carácter a ser colocado, puede ser X ó O.
    * @param tablero lugar donde se efectua la partida.   
    **/ 
    public void colocarPieza(int y, int x, char pieza, char[][] tablero) {
        if (y < 0 || y >= FILAS) {
            System.out.print("Fila incorrecta");
            return;
        }

        if (x < 0 || x >= COLUMNAS) {
            System.out.print("Columna incorrecta");
            return;
        }
        if (pieza != JUGADOR_O && pieza != JUGADOR_X) {
            System.out.printf("La pieza debe ser %c o %c", JUGADOR_O, JUGADOR_X);
            return;
        }
        if (!coordenadasVacias(y, x, tablero)) {
            System.out.print("Coordenadas ya ocupadas");
            return;
        }
        tablero[y][x] = pieza;
    }

    /*Funciones de conteo. Cuentan cuántas piezas del mismo jugador están alineadas*/
    /** Metodo que cuenta cuantas fichas del jugador están alineadas en dirección vertical
    * sobre una columna respecto a cierta posición.
    * @param y coordenada y u ordenada en el tablero.
    * @param x coordenada x o abscisa en el tablero.
    * @param jugador ficha elegida por el jugador.
    * @param tablero en el cuál se ha de buscar.
    * @return número de piezas alineadas al momento. 
    **/ 
    public int contarHaciaArriba(int x, int y, char jugador, char[][] tablero) {
        int yInicio = (y - CONTEO_PARA_GANAR >= 0) ? y - CONTEO_PARA_GANAR + 1 : 0;
        int contador = 0;
        for (; yInicio <= y; yInicio++) {
            if (tablero[yInicio][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
        }
        return contador;
    }

    /** Metodo que cuenta cuantas fichas del jugador están alineadas en dirección horizontal/derecha
    * sobre una fila respecto a cierta posición.
    * @param y coordenada y u ordenada en el tablero.
    * @param x coordenada x o abscisa en el tablero.
    * @param jugador ficha elegida por el jugador.
    * @param tablero en el cuál se ha de buscar.
    * @return número de piezas alineadas al momento. 
    **/ 
    public int contarHaciaDerecha(int x, int y, char jugador, char[][] tablero) {
        int xFin = (x + CONTEO_PARA_GANAR < COLUMNAS) ? x + CONTEO_PARA_GANAR - 1 : COLUMNAS - 1;
        int contador = 0;
        for (; x <= xFin; x++) {
            if (tablero[y][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
        }
        return contador;
    }

    /** Metodo que cuenta cuantas fichas del jugador están alineadas en dirección vertical hacia arriba/derecha
    * respecto a cierta posición.
    * @param y coordenada y u ordenada en el tablero.
    * @param x coordenada x o abscisa en el tablero.
    * @param jugador ficha elegida por el jugador.
    * @param tablero en el cuál se ha de buscar.
    * @return número de piezas alineadas al momento. 
    **/   
    public int contarHaciaArribaDerecha(int x, int y, char jugador, char[][] tablero) {
        int xFin = (x + CONTEO_PARA_GANAR < COLUMNAS) ? x + CONTEO_PARA_GANAR - 1 : COLUMNAS - 1;
        int yInicio = (y - CONTEO_PARA_GANAR >= 0) ? y - CONTEO_PARA_GANAR + 1 : 0;
        int contador = 0;
        while (x <= xFin && yInicio <= y) {
            if (tablero[y][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
            x++;
            y--;
        }
        return contador;
    }

    /** Metodo que cuenta cuantas fichas del jugador están alineadas en dirección vertical hacia abajo/derecha
    * respecto a cierta posición.
    * @param y coordenada y u ordenada en el tablero.
    * @param x coordenada x o abscisa en el tablero.
    * @param jugador ficha elegida por el jugador.
    * @param tablero en el cuál se ha de buscar.
    * @return número de piezas alineadas al momento. 
    **/ 
    public int contarHaciaAbajoDerecha(int x, int y, char jugador, char[][] tablero) {
        int xFin = (x + CONTEO_PARA_GANAR < COLUMNAS) ? x + CONTEO_PARA_GANAR - 1 : COLUMNAS - 1;
        int yFin = (y + CONTEO_PARA_GANAR < FILAS) ? y + CONTEO_PARA_GANAR - 1 : FILAS - 1;
        int contador = 0;
        while (x <= xFin && y <= yFin) {
            if (tablero[y][x] == jugador) {
                contador++;
            } else {
                contador = 0;
            }
            x++;
            y++;
        }
        return contador;
    }

    /** Metodo que verifica si el jugador o el adversario virtual
    * han alineado ya las suficientes piezas para ganar la partida 
    * después de su último movimiento.
    * @param jugador ficha elegida por el jugador.
    * @param tablero en el cuál se ha de buscar.
    * @return respuesta en formato booleano respecto al estado actual de la partida, 
    * es decir, el último jugador en mover ficha ganó o no.
    **/ 
    public boolean comprobarSiGana(char jugador, char[][] tablero) {
        int y;
        for (y = 0; y < FILAS; y++) {
            int x;
            for (x = 0; x < COLUMNAS; x++) {
                if (
                        contarHaciaArriba(x, y, jugador, tablero) >= CONTEO_PARA_GANAR ||
                            contarHaciaDerecha(x, y, jugador, tablero) >= CONTEO_PARA_GANAR ||
                                contarHaciaArribaDerecha(x, y, jugador, tablero) >= CONTEO_PARA_GANAR ||
                                    contarHaciaAbajoDerecha(x, y, jugador, tablero) >= CONTEO_PARA_GANAR) {
                    return true;
                }
            }
        }
        // Terminamos de recorrer y no conectó
        return false;
    }

    /**
    * Método que indica la ficha que mueve el adversario del jugador pasada como parámetro
    * @param jugador ficha del jugador a verificar
    * @return caractér con la ficha del adversario. 
    **/
    public char oponenteDe(char jugador) {
        if (jugador == JUGADOR_O) {
            return JUGADOR_X;
        } else {
            return JUGADOR_O;
        }
    }

    /**
    * Método que nos brinda un mensaje emitido por la
    * máquina al participar del juego.
    * @param mensaje cadena que indica lo que la máquina ha de decir.
    * @param jugador caracter que mueve la máquina o el usuario. 
    **/
    public void hablar(String mensaje, char jugador) {
        System.out.printf("\nCPU (%c) dice: %s\n\n", jugador, mensaje);
    }

    public boolean empate(char[][] tableroOriginal) {
        int y;
        for (y = 0; y < FILAS; y++) {
            int x;
            for (x = 0; x < COLUMNAS; x++) {
                // Si hay al menos un espacio vacío se dice que no hay empate
                if (tableroOriginal[y][x] == ESPACIO_VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
    * Método que genera un número entero aleatorio dentro de un rango determinado.
    * @param minimo número que establece la cota inferior en el conjunto.
    * @param maximo número que establece la cota superior en el conjunto. 
    * @return entero aleatorio dentro del rango que definen los parámetros.
    **/
    public int aleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    /**
    * Método que devuelve coordenadas de una ficha cualquiera dentro del tablero
    * @param jugador ficha a buscar dentro del tablero.
    * @param tableroOriginal tablero donde se efectuara la busqueda.
    * @return arreglo de enteros con las coordenadas generadas. 
    **/
    public int[] obtenerCoordenadasAleatorias(char jugador, char[][] tableroOriginal) {
        int x, y;
        do {
            x = aleatorioEnRango(0, COLUMNAS - 1);
            y = aleatorioEnRango(0, FILAS - 1);
        } while (!coordenadasVacias(y, x, tableroOriginal));
        return new int[]{x, y};
    }

    /**
    * Método que devuelve unas coordenadas útiles al usuario para triunfar en el juego.
    * @param jugador ficha a buscar dentro del tablero.
    * @param tableroOriginal tablero donde se efectuara la busqueda.
    * @return arreglo de enteros con las coordenadas generadas ó [-1,-1] si no hay una respuesta satisfactoria. 
    **/
    public int[] coordenadasParaGanar(char jugador, char[][] tableroOriginal) {
        int y, x;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                char[][] copiaTablero = clonarMatriz(tableroOriginal);
                if (coordenadasVacias(y, x, copiaTablero)) {
                    colocarPieza(y, x, jugador, copiaTablero);
                    if (comprobarSiGana(jugador, copiaTablero)) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    /** Método que cuenta el mayor puntaje obtenido, pero no indica en cuál X ni cuál Y. Está pensada
    * para ser llamada desde otra función que lleva cuenta de X e Y.
    * @param jugador ficha a buscar dentro del tablero.
    * @param copiaTablero tablero donde se efectuara la busqueda.
    * @return entero que indica el número de victorias. 
    **/
    public int contarSinSaberCoordenadas(char jugador, char[][] copiaTablero) {
        int conteoMayor = 0;
        int x, y;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                // Colocamos y contamos el puntaje
                int conteoTemporal;
                conteoTemporal = contarHaciaArriba(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }
                conteoTemporal = contarHaciaArribaDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }

                conteoTemporal = contarHaciaDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }

                conteoTemporal = contarHaciaAbajoDerecha(x, y, jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                }
            }
        }
        return conteoMayor;
    }

    /**
    * Método complementa a <code>contarSinSaberCoordenadas</code>. Indica en qué X e Y el jugador [jugador]
    * obtendrá el mayor puntaje si pone ahí su pieza.
    * @param jugador ficha a buscar dentro del tablero.
    * @param tableroOriginal tablero donde se efectuara la busqueda.
    * @return arreglo de enteros con las coordenadas generadas. 
    **/
    public int[] coordenadasParaMayorPuntaje(char jugador, char[][] tableroOriginal) {
        int y, x;
        int conteoMayor = 0,
                xConteoMayor = -1,
                yConteoMayor = -1;
        for (y = 0; y < FILAS; y++) {
            for (x = 0; x < COLUMNAS; x++) {
                char[][] copiaTablero = clonarMatriz(tableroOriginal);
                if (!coordenadasVacias(y, x, copiaTablero)) {
                    continue;
                }
                // Colocamos y contamos el puntaje
                colocarPieza(y, x, jugador, copiaTablero);
                int conteoTemporal = contarSinSaberCoordenadas(jugador, copiaTablero);
                if (conteoTemporal > conteoMayor) {
                    conteoMayor = conteoTemporal;
                    yConteoMayor = y;
                    xConteoMayor = x;
                }
            }
        }
        return new int[]{conteoMayor, xConteoMayor, yConteoMayor};
    }

    /**
    * Método que permite al ordenador elegir coordenadas para mover su pieza.   
    * @param jugador ficha a buscar dentro del tablero.
    * @param tablero tablero donde se efectuara la busqueda.
    * @return arreglo de enteros con las coordenadas generadas. 
    **/
    public int[] elegirCoordenadasCpu(char jugador, char[][] tablero) {
        hablar("Estoy pensando...", jugador);
    /*
    El orden en el que el CPU infiere las coordenadas que toma es:
    1. Ganar si se puede
    2. Hacer perder al oponente si está a punto de ganar
    3. Tomar el mejor movimiento del oponente (en donde obtiene el mayor puntaje)
    4. Tomar mi mejor movimiento (en donde obtengo mayor puntaje)
    5. Elegir la de la esquina superior izquierda (0,0)
    6. Coordenadas aleatorias
    */
        int y, x, conteoJugador, conteoOponente;
        int yOponente, xOponente;
        int[] coordenadas = new int[2];
        char oponente = oponenteDe(jugador);
        // 1
        coordenadas = coordenadasParaGanar(jugador, tablero);
        x = coordenadas[0];
        y = coordenadas[1];
        if (y != -1 && x != -1) {
            hablar("Ganar", jugador);
            return new int[]{x, y};
        }
        // 2
        coordenadas = coordenadasParaGanar(oponente, tablero);
        x = coordenadas[0];
        y = coordenadas[1];
        if (y != -1 && x != -1) {
            hablar("Tomar victoria de oponente", jugador);
            return new int[]{x, y};
        }
        // 3
        int[] coordenadasJugador = coordenadasParaMayorPuntaje(jugador, tablero);
        int[] coordenadasOponente = coordenadasParaMayorPuntaje(oponente, tablero);
        conteoJugador = coordenadasJugador[0];
        x = coordenadasJugador[1];
        y = coordenadasJugador[2];
        conteoOponente = coordenadasOponente[0];
        xOponente = coordenadasOponente[1];
        yOponente = coordenadasOponente[2];
        if (conteoOponente > conteoJugador) {
            hablar("Tomar puntaje mayor del oponente", jugador);
            return new int[]{xOponente, yOponente};
        } else if (conteoJugador > 0) {
            hablar("Tomar mi mayor puntaje", jugador);
            return new int[]{x, y};
        }
        // 4
        if (coordenadasVacias(0, 0, tablero)) {
            hablar("Tomar columna superior izquierda", jugador);
            return new int[]{0, 0};
        }
        // 5
        hablar("Coordenadas aleatorias", jugador);
        coordenadas = obtenerCoordenadasAleatorias(jugador, tablero);
        return coordenadas;
    }

    /**
    * Método que devuelve alguna de las fichas posibles dentro del juego.
    * @return caracter que indica una ficha aleatoria, sea X ó O. 
    **/
    public char jugadorAleatorio() {
        if (aleatorioEnRango(0, 1) == 0) {
            return JUGADOR_O;
        } else {
            return JUGADOR_X;
        }
    }
    
    /**
    * Método que gestiona el acceso al juego y sus opciones,
    * además se encarga de devolver los puntos obtenidos al jugar.
    * @return entero con los puntos obtenidos en una partida del juego.
    **/
    @Override
    public int minijuego() {
      
        // Para que salgan cosas aleatorias
        // Iniciar tablero de juego
        char[][] tablero = new char[FILAS][COLUMNAS];
        // Y limpiarlo
        limpiarTablero(tablero);
        int modo = JUGADOR_CPU;
        // Elegir jugador que inicia al azar
        char jugadorActual = jugadorAleatorio();
        System.out.println("********* Holaaa! Bienvenido al juego del Gato ^-^ ********* \n"
        + "Serás tú vs la maquina, ¿listo? \n"
        + "Tú serás X \n"
        + "Y la maquina será O");
        System.out.printf("El jugador que inicia es: %c\n", jugadorActual);
        int x = 0, y = 0;
        // Y allá vamos
        int[] coordenadas = new int[2];
        while (true) {
            imprimirTablero(tablero);
            if (modo == JUGADOR_CPU && jugadorActual == JUGADOR_X) {
               
                System.out.printf("Jugador %c. Ingresa coordenadas (x,y) para colocar la pieza\n", jugadorActual);
                do {
                    x = solicitarNumeroValido("Ingresa X: ", 1, COLUMNAS);
                    y = solicitarNumeroValido("Ingresa Y: ", 1, FILAS);
                    if (!coordenadasVacias(y - 1, x - 1, tablero)) {
                        System.out.println("Coordenadas ocupadas. Intenta de nuevo");
                    }
                } while (!coordenadasVacias(y - 1, x - 1, tablero));
                // Al usuario se le solicitan números comenzando a contar en 1, pero en los arreglos comenzamos desde el 0
                // así que necesitamos restar uno en ambas variables
                x--;
                y--;
            } else if (jugadorActual == JUGADOR_CPU_O) {
                // Si es modo CPU contra CPU o es el turno del CPU, dejamos que las coordenadas las elija
                // el programa
                coordenadas = elegirCoordenadasCpu(jugadorActual, tablero);
                x = coordenadas[0];
                y = coordenadas[1];
            }
            // Sin importar cuál modo haya sido, colocamos la pieza según las coordenadas elegidas

            colocarPieza(y, x, jugadorActual, tablero);
            // Puede que después de colocar la pieza el jugador gane o haya un empate, así que comprobamos
            if (comprobarSiGana(jugadorActual, tablero)) {
                imprimirTablero(tablero);
                System.out.printf("El jugador %c gana\n", jugadorActual);
                if(jugadorActual == JUGADOR_CPU_O){
                    return -1;
                }else{
                    return 1;
                }
            } else if (empate(tablero)) {
                imprimirTablero(tablero);
                System.out.println("Empate");
                return 0;
            }
            // Si no, es turno del otro jugador
            jugadorActual = oponenteDe(jugadorActual);
        }
    }

    /**
    * Método que solicita un número dentro de un rango determinado hasta que
    * se entregue una entrada satisfactoria.
    * @param minimo número que establece la cota inferior en el conjunto.
    * @param maximo número que establece la cota superior en el conjunto. 
    * @return entero ingresado desde entrada estándar.
    **/
    public int solicitarNumeroValido(String mensaje, int minimo, int maximo) {
        int numero;
        while (true) {
            System.out.print(mensaje + " ");
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                } else {
                    System.out.println("Número fuera de rango. Intente de nuevo");
                }
            } else {
                sc.next();
            }
        }
    }
}
