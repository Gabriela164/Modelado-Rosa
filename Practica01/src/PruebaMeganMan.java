import java.util.LinkedList;
import java.util.Random;

/**
* Clase de la prueba a presentar, donde siemper gana MeganMan
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class PruebaMeganMan extends Pruebas{
	
	/**
	 * Cosntructor vacio de la clase que genera las pruebas de MeganMan
	 */
	public PruebaMeganMan(){
		
	}

	/**
	 * Método encargado de generar la batalla donde gana MeganMan
	 */
	public void pelea(){

      //Objetos para las transformaciones de Korby
      ObjetoEspecialKorby ataqueEspada = new ObjetoEspecialKorby(3, 1, "EspaKorby");
      ObjetoEspecialKorby automovil = new ObjetoEspecialKorby(2, 2, "AutoKorby");
      ObjetoEspecialKorby roca = new ObjetoEspecialKorby(1, 3, "Rocky");
      //lista que guardará los objetos de korby
      LinkedList<ObjetoEspecialKorby> listaDeObjetosKorby = new LinkedList<ObjetoEspecialKorby>();
      listaDeObjetosKorby.add(roca);
      listaDeObjetosKorby.add(ataqueEspada);
      listaDeObjetosKorby.add(automovil);

      //Objetos para las transformaciones de Meganman
      ObjetoEspecialMeganMan snakeMan = new ObjetoEspecialMeganMan(3, 1, "SnakeMan");
      ObjetoEspecialMeganMan shadowMan = new ObjetoEspecialMeganMan(2, 2, "ShadowMan");
      ObjetoEspecialMeganMan hardMan = new ObjetoEspecialMeganMan(1, 3, "HardMan");
      //lista que guardará los objetos de MeganMan
      LinkedList<ObjetoEspecialMeganMan> listaDeObjetosMeganMan = new LinkedList<ObjetoEspecialMeganMan>();
      listaDeObjetosMeganMan.add(snakeMan);
      listaDeObjetosMeganMan.add(shadowMan);
      listaDeObjetosMeganMan.add(hardMan);

      //Objetos para las transformaciones de Dittu
      ObjetoEspecialDittu charmandor = new ObjetoEspecialDittu(3, 1, "Charmandor");
      ObjetoEspecialDittu pokachu = new ObjetoEspecialDittu(2, 2, "Pokachu");
      ObjetoEspecialDittu zquirtle = new ObjetoEspecialDittu(1, 3, "Zquirtle");
      //lista que guardará los objetos de Dittu
      LinkedList<ObjetoEspecialDittu> listaDeObjetosDittu = new LinkedList<ObjetoEspecialDittu>();
      listaDeObjetosDittu.add(charmandor);
      listaDeObjetosDittu.add(pokachu);
      listaDeObjetosDittu.add(zquirtle);

      Dittu dittu = new Dittu();
      MeganMan meganman = new MeganMan();
      Korby korby = new Korby();
      LinkedList<Espectadores> lista = new LinkedList<Espectadores>();
      Combate combate1 = new Combate(korby, dittu, meganman, lista); 
      Espectadores esp1 = new Espectadores("AwuitaDeAyuda", dittu, combate1);
      Espectadores esp2 = new Espectadores("AwuitaDeNo", korby, combate1);
      Espectadores esp3 = new Espectadores("AwuitaDeEntiendo", meganman, combate1);
      Espectadores esp4 = new Espectadores("AwuitaDeObserver", dittu, combate1);
      combate1.agregarObservador(esp1);
      combate1.agregarObservador(esp2);
      combate1.agregarObservador(esp3);
      combate1.agregarObservador(esp4);

      //**********************************************Empieza el combate***********************************************
      //Pelea en la que ganará MeganMan
      System.out.println("Aparecen los tres Peleadores");
      while(korby.getVida() > 0 && dittu.getVida() > 0){
         meganman.ataque();
         korby.recibeDanio(meganman.getDanio());
         dittu.recibeDanio(meganman.getDanio());
         System.out.println("Apareció un PowerUp");
         Random aleatorio = new Random();
         ObjetoEspecialMeganMan aux = listaDeObjetosMeganMan.get(aleatorio.nextInt(listaDeObjetosMeganMan.size()));
         System.out.println(aux.toString());
         meganman.setObjetoEspecial(aux);
         meganman.ataque();
         korby.recibeDanio(meganman.getDanio());
         dittu.recibeDanio(meganman.getDanio());

         Random aleatorio2 = new Random();
         ObjetoEspecialDittu aux2 = listaDeObjetosDittu.get(aleatorio2.nextInt(listaDeObjetosDittu.size()));
         System.out.println(aux2.toString());
         dittu.setObjetoEspecial(aux2);
         dittu.ataque();
         meganman.recibeDanio(dittu.getDanio());

         Random aleatorio3 = new Random();
         ObjetoEspecialKorby aux3 = listaDeObjetosKorby.get(aleatorio3.nextInt(listaDeObjetosKorby.size()));
         System.out.println(aux3.toString());
         korby.setObjetoEspecial(aux3);
         korby.ataque();
         meganman.recibeDanio(korby.getDanio());
      }
      System.out.println("MeganMan obtuvo el poder del Guión y obtiene +10 de vida.");
      meganman.setVida(meganman.getVida() + 10);
      System.out.println("Ganó meganman con una vida sobrante de " + meganman.getVida());
      combate1.setGanadorDelCombate(meganman);
   }
}