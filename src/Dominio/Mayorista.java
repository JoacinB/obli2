// Autores: Julieta Lopez (295568) y Joaquin Borges (284675)
package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class Mayorista{
    //Atributo
    private String rut;
    private String nombre;
    private String direccion;
    private ArrayList<Producto> productos;
    
    //Constructor
    public Mayorista(){
        this.setNombre("Sin nombre");
        this.setRut("Sin rut");
        this.setDire("Sin dirección");
    }
    
    public Mayorista(String unR,String nom,String dire,ArrayList<Producto> p){
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
    
    public ArrayList<Producto> getProducto() {
        return productos;
    }

    public void setProducto(ArrayList<Producto> Prod) {
        this.productos = Prod;
    }
    
    //metodos
    public void agregarProducto(Producto p){
        this.productos.add(p);

    }
    
    public boolean equals(Object o){
        return this.getRut().equalsIgnoreCase(((Mayorista)o).getRut());
    }
    
    @Override
    public String toString(){
        return this.getNombre() + "-" + this.getRut() + "-" + this.getDire();
    }
    
    //Rut único
    public int compareTo(Mayorista o) {
        return this.rut.compareToIgnoreCase(o.getRut());
    }
}
