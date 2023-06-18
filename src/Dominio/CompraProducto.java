
package Dominio;

public class CompraProducto {
    //Atributos
    private Puesto puesto;
    private Mayorista mayorista;
    private Producto producto;
    private int precio;
    private int cantidad;
    
    //Constructor
    public CompraProducto(){
        this.setPrecio(0);
        this.setCantidad(0);
    }
    
    public CompraProducto(Puesto unp,Mayorista m,Producto unP,int precio,int cant){
        this.setPuesto(unp);
        this.setProducto(unP);
        this.setMayorista(m);
        this.setPrecio(precio);
        this.setCantidad(cant);
    }
    
    //get y set
    
    public Puesto getPuesto(){
        return this.puesto;
    }
    
    public void setPuesto(Puesto p){
        this.puesto = p;
    }
    
    
    public Mayorista getMayorista(){
        return this.mayorista;
    }
    
    public void setMayorista(Mayorista m){
        this.mayorista = m;
    }
    
    public Producto getProducto(){
        return this.producto;
    }
    
    public void setProducto(Producto prod){
        this.producto = prod;
    }
    
    public int getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(int p){
        this.precio = p;
    }
    
    public int getCant(){
        return this.cantidad;
    }
    
    public void setCantidad(int can){
        this.cantidad = can;
    }
    
    @Override
    public String toString(){
        return this.getPuesto() + "-" + this.getMayorista() + "-" + this.getProducto() + "-" + this.getPrecio() + "-" + this.getCant();
    }
    
}
