
package Dominio;

public class VentaProducto {
    //Atributo
    private Puesto puesto;
    private Producto producto;
    private int cantCompra;
    private int precio;
    private int movimientoVenta;
    
    //Constructor
    public VentaProducto(){
        this.setCant(0);
        this.setPrecio(0);
    }
    
    public VentaProducto(Puesto p, Producto prod, int cant, int precio){
        this.setPuesto(p);
        this.setProducto(prod);
        this.setCant(cant);
        this.setPrecio(precio);
    }
    
    //get y set
    public Puesto getPuesto(){
        return this.puesto;
    }
    
    public void setPuesto(Puesto p){
        this.puesto = p;
    }
    
    public Producto getProd(){
        return this.producto;
    }
    
    public void setProducto(Producto p){
        this.producto = p;
    }
    
    public int getCantcom(){
        return this.cantCompra;
    }
    
    public void setCant(int c){
        this.cantCompra = c;
    }
    
    public int getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(int p){
        this.precio = p;
    }
    
    public int getMovimientoVenta() {
        return this.movimientoVenta;
    }

    public void setMovimientoV(int mov) {
        this.movimientoVenta = mov;
    }
    
    @Override
    public String toString(){
        return this.getPuesto() + "-" + this.getProd() + "-" + this.getCantcom() + "-" + this.getPrecio();
    }

}
