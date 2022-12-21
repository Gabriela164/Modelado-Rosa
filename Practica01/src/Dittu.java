/**
* Clase del peleador Dittu, encargada de irle haciendo los cambios a las estadístidas de Dittu.
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class Dittu extends Peleador{

    //Objeto especial que irá cambianndo conforme vayan agarrando objetos especiales en la batalla
    private ObjetoEspecialDittu powerUp;

    /**
     * Constructor de la clase Dittu, encargado de darle valores enteros a la vida, defensa y ataque.
     */
    public Dittu(){
        super();
    }

    /**
     * Método encargado de avisar la defensa, y la nueva vida de Dittu. 
     */
    @Override
    public void defensa(){
        System.out.println("Dittu tiene una defensa de " + this.getDefensa() + "\n" +
                            "Por lo que su vida incrementa +" + this.getDefensa() + " unidades");

    }

    /**
     * Método encargado de avisar cuando Dittu hace un ataque, mostrando el daño en un entero.
     */
    @Override
    public void ataque(){
        System.out.println("Dittu hizo un ataque de " + this.getDanio() + " de daño");
    }

    /**
     * Método encargado de avisar cuando Dittu recibe daño, además muestra cuánto recibió.
     */
    @Override
    public void recibeDanio(int n){
        System.out.println("Dittu recibió " + n + " de daño");
        this.setVida(this.getVida() - n);

    }

    /**
     * Método encargado de regresar el actual powerUp del personaje.
     * @return powerUp, el ObjetoEspecial de Dittu en ese momento. 
     */
    public ObjetoEspecialDittu getObjetoEspecial(){
        return powerUp;
    }

    /**
     * Método encargado de asignar un nuevo ObjetoEspecial para las estadísticas de Dittu
     * @param nuevo el nuevo ObjetoEspecial a asignar.
     */
    public void setObjetoEspecial(ObjetoEspecialDittu nuevo){
        this.setDanio(nuevo.getAtaqueNuevo());
        this.setVida(nuevo.getDefensaNuevo() + this.getVida());

    }
}
