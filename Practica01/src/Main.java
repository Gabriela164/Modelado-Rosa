import java.util.LinkedList;
import java.util.Random;
/**
* Clase Principal de la práctica 1. 
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class Main{
   
   public static void main (String[] args){ 
      PruebaKorby prueba1= new PruebaKorby();
      PruebaMeganMan prueba2= new PruebaMeganMan();
      PruebaDittu prueba3 = new PruebaDittu();

      LinkedList<Pruebas> listaDePruebas = new LinkedList<Pruebas>();
      listaDePruebas.add(prueba1);
      listaDePruebas.add(prueba2);
      listaDePruebas.add(prueba3);

      Random aleatorio = new Random();
      Pruebas aux = listaDePruebas.get(aleatorio.nextInt(listaDePruebas.size()));
      aux.pelea();
   }
}