
package Dominio;

public class Mayorista {
    private String rut;
    private String nombre;
    private String direccion;
    private Producto p;
    
    public Mayorista(){
        this.setNombre("Sin nombre");
        this.setRut("Sin rut");
        this.setDire("Sin dirección");
    }
    
    public Mayorista(String unR,String nom,String dire,Producto p){
        this.setNombre(nom);
        this.setRut(unR);
        this.setDire(dire);
        this.setProducto(p);
    }
    
    //get y set
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String unNom){
        this.nombre = unNom;
    }
    
    public String getRut(){
        return this.rut;
    }

    public void setRut(String unR){
        this.rut = unR;
    }
    
    public String getDire(){
        return this.direccion;
    }

    public void setDire(String unDire){
        this.direccion = unDire;
    }
    
    public Producto getProd(){
        return p;
    }
    
    public Producto setProducto(Producto prod){
        return this.p = prod;
    }
    
}
