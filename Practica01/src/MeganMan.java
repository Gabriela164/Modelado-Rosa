/**
* Clase del peleador MeganMan encargada de irle haciendo los cambios a las estadístidas de MeganMan
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class MeganMan extends Peleador{

    private ObjetoEspecialMeganMan powerUp;

    /**
     * Constructor de la clase MeganMan, encargado de darle valores enteros a la vida, defensa y ataque.
     */
    public MeganMan(){
        super();
    }

    /**
     * Método encargado de avisar la defensa, y la nueva vida de MeganMan. 
     */
    @Override
    public void defensa(){
        System.out.println("MeganMan tiene una defensa de " + this.getDefensa() + "\n" +
                            "Por lo que su vida incrementa +" + this.getDefensa() + " unidades");
    }

    /**
     * Método encargado de avisar cuando MeganMan hace un ataque, mostrando el daño en un entero.
     */
    @Override
    public void ataque(){
        System.out.println("MeganMan hizo un ataque de " + this.getDanio() + " de daño");
    }

    /**
     * Método encargado de avisar cuando MeganMan recibe daño, además muestra cuánto recibió.
     */
    @Override
    public void recibeDanio(int n){
        System.out.println("MeganMan recibió " + n + " de daño");
        this.setVida(this.getVida() - n);
    }

    /**
     * Método encargado de regresar el actual powerUp del personaje.
     * @return powerUp, el ObjetoEspecial de MeganMan en ese momento. 
     */
    public ObjetoEspecialMeganMan getObjetoEspecial(){
        return powerUp;
    }

    /**
     * Método encargado de asignar un nuevo ObjetoEspecial para las estadísticas de MeganMan
     * @param nuevo, el nuevo ObjetoEspecial a asignar.
     */
    public void setObjetoEspecial(ObjetoEspecialMeganMan nuevo){
        this.setDanio(nuevo.getAtaqueNuevo());
        this.setVida(nuevo.getDefensaNuevo() + this.getVida());
    }
}