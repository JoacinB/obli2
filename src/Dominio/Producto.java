
package Dominio;


public class Producto {

        //Atributos
        private String nombre;
        private String descripcion;
        private String tipo;
        private String formaVenta;
        
        //Constructor
        public Producto(){
            this.setNombre(tipo);
        }
        
        public Producto(String unNom,String unaDes,String unTipo,String unaVen){
            
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
        
        public boolean equals(Object o){
            return this.getNombre().equalsIgnoreCase(((Producto)o).getNombre());
        }
        
        @Override
        public String toString(){
            return this.getNombre();
        }
    
}
