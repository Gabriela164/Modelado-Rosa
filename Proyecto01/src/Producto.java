/**
* Clase que define los productos de la tienda
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Producto implements Item, Clonable{
    String nombre;
    String tipo;
    double precio;
    int codigoDeBarras;
    
    /**
     * Constructor de los productos
     * @param nombre el nombre del producto
     * @param tipo el departamentoal que pertenece producto
     * @param precio el precio del producto
     * @param codigoDeBarras el codigo de barras del producto
     */
    public Producto(String nombre, String tipo, double precio, int codigoDeBarras){
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.codigoDeBarras = codigoDeBarras;
    }

    /**
     * Constructor copia, útil para la clonación de un producto
     * @param prod el producto a clonar
     */
    private Producto(Producto prod){
        this.nombre = prod.getNombre();
        this.tipo = prod.getTipo();
        this.precio = prod.getPrecio();
        this.codigoDeBarras = prod.getCodigoDeBarras();
    }

    /**
     * Método que clona un producto
     * @return el nuevo producto (el clon)
     */
    @Override public Producto clonar(){
        return new Producto(this);
    }

    /**
     * Método que egresa el nombre del producto
     * @return el nombre del producto
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método que regresa el departamento al que pertenece el producto
     * @return el tipo del producto
     */
    public String getTipo(){
        return tipo;
    }

    /**
     * Método que regresa el precio del producto
     * @return el precio del producto
     */
    @Override public double getPrecio(){
        return precio;
    }

    /**
     * Método que regresa el código de barras del producto
     * @return entero con el código del producto
     */
    public int getCodigoDeBarras(){
        return codigoDeBarras;
    }

    /**
     * Método que asigna un nombre al producto
     * @param nombre el nuevo nombre del producto
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Método que asigna el tipo del producto
     * @param tipo el nombre del tipo del producto
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Método que signa el precio del producto
     * @param precio el nuevo precio del producto
     */
    public void setPrecio(double precio){        
        this.precio = precio;
    }


    /**
     * Método que asigna el cídigo del producto
     * @param codigoDeBarras el nuevo código del producto
     */
    public void setCodigoDeBarras(int codigoDeBarras){
        this.codigoDeBarras = codigoDeBarras;
    }

/**
     * Método que avisa que devuelve una descripción en formato para su lectura
     * @return la cadena con la descripción del contenido
     */
    @Override public String getDescripcion(){
        return "Producto: " + nombre + "\n Tipo: " + tipo + "\n Precio: " + precio + "\n Codigo de barras: " + codigoDeBarras + "\n";
    }

    /**
     * Método que verifica si la instancia de clase es un decorador o una implementación
     * concreta a decorar
     * @return false pues la clase se extiende exclusivamente por objetos decoradores
     */
    @Override public boolean esNucleo(){
        return true;
    }

    /**
     * Método que regresa el producto envuelto al que se le pueden modificar sus atributos
     * @return el producto envuelto
     */   
    @Override public Producto getCentro(){
        return this;
    }
     
     /**
     * Verifica si dos productos son iguales
     * @param prod el producto a comparar
     * @return true si todas sus atributos son iguales, false en cualquier otro caso
     */   
    public boolean sonIguales(Producto prod){
        return ((nombre==prod.getNombre())&&(tipo==prod.getTipo())&&(precio==prod.getPrecio())&&(codigoDeBarras==prod.getCodigoDeBarras()));
    }
} 