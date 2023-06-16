
package Dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;

public class Sistema extends Observable {
     private ArrayList<Producto> listaProducto;
     private ArrayList<DueñoPuesto> listaDueños;
     private ArrayList<Puesto> listaPuestos;
     private ArrayList<Mayorista> listaMayorista;
     private ArrayList<CompraProducto> listaCompra;
     private ArrayList<VentaProducto> listaVenta;
     
     //Constructor
     public Sistema(){
         listaProducto = new ArrayList<>();
         listaDueños = new ArrayList<>();
         listaPuestos = new ArrayList<>();
         listaMayorista = new ArrayList<>();
         listaCompra = new ArrayList<>();
         listaVenta = new ArrayList<>();
     }
     
     //get y set
    public ArrayList<Producto> getListaProducto() {
        Collections.sort(listaProducto);
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        Collections.sort(this.listaProducto);
        this.listaProducto = listaProducto;
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<Mayorista> getListaMayorista() {
        return listaMayorista;
    }

    public void setListaMayorista(ArrayList<Mayorista> listaMayorista) {
        this.listaMayorista = listaMayorista;
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<CompraProducto> getListaCompra(){
        return listaCompra;
    }
    
    public void setListaCompra(ArrayList<CompraProducto> listaC){
        this.listaCompra = listaC;
    }
    
    public ArrayList<VentaProducto> getListaVenta(){
        return listaVenta;
    }
    
    public void setListaVenta(ArrayList<VentaProducto> listaV){
        this.listaVenta = listaV;
    }
    
    //Métodos
    public void agregarProducto(Producto p){
        this.listaProducto.add(p);
        setChanged();
        notifyObservers();
    }
    
    public void agregarDueño(DueñoPuesto d){
        this.listaDueños.add(d);
    }
    
    public void agregarPuestos(Puesto p){
        this.listaPuestos.add(p);
    }
    
    public void agregarMayorista(Mayorista m){
        this.listaMayorista.add(m);
        setChanged();
        notifyObservers();
    }
    
    public void agregarCompra(CompraProducto cp){
        this.listaCompra.add(cp);
    }
    
    public void agregarVenta(VentaProducto vp){
        this.listaVenta.add(vp);
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
    
    //Productos de mayorista
    public ArrayList<Producto> productoDe(Mayorista m){
        ArrayList<Producto> listaP = new ArrayList<Producto>();
        Iterator<Producto> it = this.getListaProducto().iterator();
        while(it.hasNext()){
            Producto p = it.next();
            if(m.equals(p)){
                listaP.add(p);
            }
        }
        return listaP;
    }
    
    //Lista de productos que se compraron
//    public ArrayList<String> productoComprados(CompraProducto p){
//        ArrayList<String> listap = new ArrayList<String>();
//        Iterator<Producto> it = this.getListaProducto().iterator();
//        while(it.hasNext()){
//            Producto prod = it.next();
//            if(p.getProducto().equals(prod.getNombre())){
//                listap.add(prod.getNombre());
//            }
//        }
//        return listap;
//    }
    
    //Productos comprados por el puesto
    public ArrayList<Producto> productoPuesto(Puesto p){
        ArrayList<Producto> listaProd = new ArrayList<Producto>();
        Iterator<CompraProducto> it = this.getListaCompra().iterator();
        while(it.hasNext()){
            CompraProducto prod = it.next();
            if(prod.getPuesto().equals(p)){
                if(prod.getCant() >= 1){
                    listaProd.add(prod.getProducto());
                }
            }
        }
        return listaProd;
    }

}


