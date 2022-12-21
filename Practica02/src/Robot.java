
public class Robot{

	private EstadoRobot estadoActual;
	private Platillo hamburguesa;

	public Robot(){
		setState(new ModoSuspendido());
	}

	public void setState(EstadoRobot state){
		estadoActual = state;
		estadoActual.setRobot(this);
	}

	public void setPlatillo(Platillo hamburguesa){
		this.hamburguesa = hamburguesa;
	}

	public Platillo getPlatillo(){
		return this.hamburguesa;
	}

	public void activar(){
        this.estadoActual.activar();
    }
  
    public void caminar(){
    	this.estadoActual.caminar();
    }
  
    public void suspender(){
        this.estadoActual.suspender();
    }
  
    public void leerMenu(Menu menuEstandar, Menu menuEspecial, Menu menuCambiante){
          this.estadoActual.leerMenu(menuEstandar, menuEspecial, menuCambiante);
    }
  
    public void cocinar(){
        this.estadoActual.cocinar();
    }

    public void recibePedido() {
        this.estadoActual.recibePedido();
    }

    public void entregarPedido() {
    	this.estadoActual.entregarPedido();   
    }

    public void menus(Menu menuParaPresentar){
    	if(menuParaPresentar == null){
    		System.out.println("Necesito un menu ya cosntruido, ese no es válido");
    		return;
    	}
    	Iterador iteradorMenu = menuParaPresentar.creaIterador();
    	while (iteradorMenu.hasNext()) {
    		System.out.println(iteradorMenu.next().toString() + "\n");
    	}
    }
}