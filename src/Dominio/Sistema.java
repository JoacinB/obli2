
package Dominio;

import java.util.ArrayList;

public class Sistema {
     private ArrayList<Producto> listaProducto;
     private ArrayList<DueñoPuesto> listaDueños;
     private ArrayList<Puesto> listaPuestos;
     private ArrayList<Mayorista> listaMayorista;
     
     //Constructor
     public Sistema(){
         listaProducto = new ArrayList<>();
         listaDueños = new ArrayList<>();
         listaPuestos = new ArrayList<>();
         listaMayorista = new ArrayList<>();
     }
     
     //get y set
    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public ArrayList<DueñoPuesto> getListaDueños() {
        return listaDueños;
    }

    public void setListaDueños(ArrayList<DueñoPuesto> listaDueños) {
        this.listaDueños = listaDueños;
    }
    
    public ArrayList<Puesto> getListaPuesto() {
        return listaPuestos;
    }

    public void setListaPuestos(ArrayList<Puesto> listaP) {
        this.listaPuestos = listaP;
    }
    
    public ArrayList<Mayorista> getListaMayorista() {
        return listaMayorista;
    }

    public void setListaMayorista(ArrayList<Mayorista> listaMayorista) {
        this.listaMayorista = listaMayorista;
    }
    
    //Métodos
    public void agregarProducto(Producto p){
        this.listaProducto.add(p);
    }
    
    public void agregarDueño(DueñoPuesto d){
        this.listaDueños.add(d);
    }
    
    public void agregarPuestos(Puesto p){
        this.listaPuestos.add(p);
    }
    
    public void agregarMayorista(Mayorista m){
        this.listaMayorista.add(m);
    }
    
    //nombre único
    public boolean existeNombre(String unNom){
        Producto p = new Producto();
        p.setNombre(unNom);
        return listaProducto.contains(p);
    }
    
    //Campo vacios
    public boolean campoVacio(String texto){
        boolean vacio = false;
        if(texto.length() == 0){
            vacio = true;
        }
        return vacio;
    }
     
}


