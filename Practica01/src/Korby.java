/**
* Clase del peleador Korby encargada de irle haciendo los cambios a las estadístidas de Korby
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class Korby  extends Peleador {

    //Objeto especial que irá cambaindo conforme vayan agarrando objetos especiales en la batalla
    private ObjetoEspecialKorby powerUp;

    /**
     * Constructor de la clase Korby, encargado de darle valores enteros a la vida, defensa y ataque.
     */
    public Korby(){
        super();
    }

    /**
     * Método encargado de avisar la defensa, y la nueva vida de Korby. 
     */
    @Override
    public void defensa(){
        System.out.println("Korby tiene una defensa de " + this.getDefensa() + "\n" +
                            "Por lo que su vida incrementa +" + this.getDefensa() + " unidades");
    }

    /**
     * Método encargado de avisar cuando Korby hace un ataque, mostrando el daño en un entero.
     */
    @Override
    public void ataque(){
        System.out.println("Korby hizo un ataque de " + this.getDanio() + " de daño");
    }

    /**
     * Método encargado de avisar cuando Korby recibe daño, además muestra cuánto recibió.
     */
    @Override
    public void recibeDanio(int n){
        System.out.println("Korby recibió " + n + " de daño");
        this.setVida(this.getVida() - n);
    }

    /**
     * Método encargado de regresar el actual powerUp del personaje.
     * @return powerUp, el ObjetoEspecial de Korby en ese momento. 
     */
    public ObjetoEspecialKorby getObjetoEspecial(){
        return powerUp;
    }

    /**
     * Método encargado de asignar un nuevo ObjetoEspecial para las estadísticas de Korby.
     * @param nuevo, el nuevo ObjetoEspecial a asignar.
     */
    public void setObjetoEspecial(ObjetoEspecialKorby nuevo){
        this.setDanio(nuevo.getAtaqueNuevo());
        this.setVida(nuevo.getDefensaNuevo() + this.getVida());
    }
     
}
