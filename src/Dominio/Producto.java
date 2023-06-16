
package Dominio;

import java.awt.Image;


public class Producto implements Comparable<Producto> {

        //Atributos
        private String nombre;
        private String descripcion;
        private String tipo;
        private String formaVenta;
        private Image image;
        
        //Constructor
        public Producto(){
            this.setNombre("sin nombre");
            this.setDescripcion("sin descripción");
            this.setTipo("sin tipo");
            this.setFormaVenta("sin forma venta");
        }
        
        public Producto(String unNom,String unaDes,String unTipo,String unaVen){
            this.setNombre(unNom);
            this.setDescripcion(unaDes);
            this.setTipo(unTipo);
            this.setFormaVenta(unaVen);
        }
        
        //get y set
        public String getNombre(){
            return this.nombre;
        }
        
        public void setNombre(String unNom){
            this.nombre = unNom;
        }
        
        public String getDescripcion(){
            return this.descripcion;
        }
        
        public void setDescripcion(String unDes){
            this.descripcion = unDes;
        }
        
        public String getTipo(){
            return this.tipo;
        }
        
        public void setTipo(String unTipo){
            this.tipo = unTipo;
        }
        
        public String getFormaVenta(){
            return this.formaVenta;
        }
        
        public void setFormaVenta(String unVent){
            this.formaVenta = unVent;
        }
        
        public Image getImage() {
            return image;
        }
        
        public void setImage(Image image) {
            this.image = image;
        }
        
        public boolean equals(Object o){
            return this.getNombre().equalsIgnoreCase(((Producto)o).getNombre());
        }
        
        @Override
        public String toString(){
            return this.getNombre();
        }

    @Override
    public int compareTo(Producto o) {
        return this.nombre.compareToIgnoreCase(o.getNombre());
    }
    
}
