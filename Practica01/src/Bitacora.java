import java.util.LinkedList; 
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
* Clase Bitacora encargada de generar las bitacoras que se otorgarán a los espectadores.
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class Bitacora{

    /*
     * Metodo que crea un archivo de texto con el nombre de cada uno de los espectadores 
     * y personaje que apoya durante la pelea 
     */
    public static void crearArchivo(LinkedList<Espectadores> listaDeEspectadores){
         FileWriter fichero = null;
         try{
               fichero = new FileWriter("C:\\Users\\Usuario\\Desktop\\espectadores.txt");
               BufferedWriter bw = new BufferedWriter(fichero);
               for(Espectadores espectador: listaDeEspectadores){
                     bw.write("Espectador " + espectador.getNombre() + "," + "el personaje que apoyas para este pelea es " +
                     espectador.getApoyaPersonaje() + " despues de la pelea tu personaje resultó"  );
                     bw.newLine();
               }
         }catch(Exception e){
                e.printStackTrace();
    } finally{
        if(fichero != null){
            try{
                fichero.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
  }
}
