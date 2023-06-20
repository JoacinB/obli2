
package Dominio;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import javax.swing.Icon;

public class Sistema extends Observable {
     private ArrayList<Producto> listaProducto;
     private ArrayList<DueñoPuesto> listaDueños;
     private ArrayList<Puesto> listaPuestos;
     private ArrayList<Mayorista> listaMayorista;
     private ArrayList<CompraProducto> listaCompra;
     private ArrayList<VentaProducto> listaVenta;
     private int MovimientoCompra;
     private int MovimientoVenta;
     
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
        setChanged();
        notifyObservers();
    }
    
    public ArrayList<VentaProducto> getListaVenta(){
        return listaVenta;
    }
    
    public void setListaVenta(ArrayList<VentaProducto> listaV){
        this.listaVenta = listaV;
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }
    
    public void agregarMayorista(Mayorista m){
        this.listaMayorista.add(m);
        setChanged();
        notifyObservers();
    }
    
    public void agregarCompra(CompraProducto cp){
        if(existeCompra(cp)){
            this.listaCompra.add(cp);
        }
        else{
            this.listaCompra.add(cp);
        }
    }
    
    public void agregarVenta(VentaProducto vp){
        this.listaVenta.add(vp);
               
        setChanged();
        notifyObservers();
    }
    
    //nombre único producto
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
    
    //rut único
    public boolean existeRut(String unNom){
        Mayorista m = new Mayorista();
        m.setRut(unNom);
        return listaMayorista.contains(m);
    }
    
    //nombre único dueño
    public boolean existeNombreD(String unNom){
        DueñoPuesto dp = new DueñoPuesto();
        dp.setNombre(unNom);
        return listaDueños.contains(dp);
    }
    
    //nombre único rut
    public boolean existeId(String unNom){
        Puesto p = new Puesto();
        p.setId(unNom);
        return listaPuestos.contains(p);
    }
    
//    public int nuevoMovCompra(){
//        MovimientoCompra++;
//        return MovimientoCompra;
//    }
//    
//    public int nuevoMovVenta(){
//        MovimientoVenta++;
//        return MovimientoVenta;
//    }
    
    //incrementar la cantidad de compras
    public int incrementarCompra(){
        int mov = 0;
        for(CompraProducto p: this.listaCompra){
            mov = p.getMovimientoCompra() + 1;
            p.setMovimiento(mov);
        }
        return mov;
    }
    
    //incrementar la cantidad de ventas
    public int incrementarVenta(){
        int mov = 0;
        for(VentaProducto p: this.listaVenta){
            mov = p.getMovimientoVenta() + 1;
            p.setMovimiento(mov);
        }
        return mov;
    }
    
    
    //lista de los productos de mayorista
    public ArrayList<Producto> productoDe(Mayorista m){
        ArrayList<Producto> listaP = new ArrayList<Producto>();
        Iterator<Producto> it = this.getListaProducto().iterator();
        while(it.hasNext()){
            Producto p = it.next();
            if(m != null){
                ArrayList<Producto> mp = m.getProducto();
                for(int i = 0; i< mp.size();i++){
                    if(mp.get(i).equals(p)){
                        listaP.add(p);
                    }
                }
            }
        }
        return listaP;
    }
    
    
    //lista de los productos comprados por el puesto
    public ArrayList<Producto> productoPuesto(Puesto p){
        ArrayList<Producto> listaProd = new ArrayList<Producto>();
        Iterator<CompraProducto> it = this.getListaCompra().iterator();
        while(it.hasNext()){
            CompraProducto prod = it.next();
            if(prod != null){
                if(prod.getPuesto().equals(p)){
                    if(prod.getCant() >= 1){
                        listaProd.add(prod.getProducto());
                    }
                }
            }
        }
        return listaProd;
    }
    
    //Existe compra del mismo producto, mismo puesto y mismo mayorista 
    public boolean existeCompra(CompraProducto c){
        boolean existe = false;
        Iterator<CompraProducto> it = this.getListaCompra().iterator();
        while(it.hasNext()){
            CompraProducto p = it.next();
            if(p != null){
                Producto prod = p.getProducto();
                Puesto pues = p.getPuesto();
                Mayorista m = p.getMayorista();
                int can = p.getCant();
                if(c.getPuesto().equals(pues) && c.getMayorista().equals(m) && c.getProducto().equals(prod)){
                    int nuevaCant = c.getCant();
                    int cant = can + nuevaCant;
                    p.setCantidad(can);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    public Producto obtenerNombreProd(String i){
        Producto nom = null;
        Iterator<CompraProducto> it = this.getListaCompra().iterator();
         while(it.hasNext()){
             CompraProducto p = it.next();
             if(p != null){
                 Producto prod = p.getProducto();
                 if(prod.getNombre().equals(i)){
                    nom = prod;
                 }
             }
         }
         return nom;
    }
    
    //Stock del producto seleccionado
    public boolean hayStock(String nom,int cant){

         boolean hay = false;
         Iterator<CompraProducto> it = this.getListaCompra().iterator();
         while(it.hasNext()){
             CompraProducto p = it.next();
             if(p != null){
                 Producto prod = p.getProducto();
                 if(prod.getNombre().equals(nom)){
                     if(p.getCant() >= cant){
                         hay = true;
                     }
                 }
             }
         }
         return hay;
    
    }
    
    // Obtener el precio minimo para un producto dado.
    public double obtenerPrecioMinimoVendido() {
        double minPrecio = Double.MAX_VALUE;
        for (VentaProducto venta : listaVenta) {
            double precio = venta.getPrecio();
            if (precio < minPrecio) {
                minPrecio = precio;
            }
        }
        return minPrecio == Double.MAX_VALUE ? 0 : minPrecio;
    }
    
    //Calcular total $ comprado entre todos los puestos para un producto dado.
    public int calcularTotalCompradoPorProducto(Producto producto) {
        int totalComprado = 0;
        for (CompraProducto compra : listaCompra) {
            if (compra.getProducto().equals(producto)) {
                totalComprado += compra.getPrecio() * compra.getCant();
            }
        }
        return totalComprado;
    }
    
    // Cantidad total comprada entre todos los puestos (unidad/kilo) para un producto dado.
    public int calcularCantidadTotalCompradaPorProducto(Producto producto) {
        int cantidadTotal = 0;
        for (CompraProducto compra : listaCompra) {
            if (compra.getProducto().equals(producto)) {
                cantidadTotal += compra.getCant();
            }
        }
        return cantidadTotal;
    }

    //Decrementar la cantidad de stock del producto al realizar una venta
    public void decrementar(String im,int cant){
        Iterator<CompraProducto> it = this.getListaCompra().iterator();
        while(it.hasNext()){
            CompraProducto p = it.next();
            if(p != null){
                Producto prod = p.getProducto();
                if(prod.getNombre().equals(im)){
                    int nuevo = p.getCant();
                    if(nuevo >= cant){
                         int nuevaCant= nuevo - cant;
                         p.setCantidad(nuevaCant);
                    }
                }
            }
        }
    }
    
}


