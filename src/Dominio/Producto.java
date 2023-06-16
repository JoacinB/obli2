
package Dominio;


public class Producto implements Comparable<Producto> {

        //Atributos
        private String nombre;
        private String descripcion;
        private String tipo;
        private String formaVenta;
        private String imagen;
        
        //Constructor
        public Producto(){
            this.setNombre("sin nombre");
            this.setDescripcion("sin descripción");
            this.setTipo("sin tipo");
            this.setFormaVenta("sin forma venta");
            this.setImag("Sin imagen");
        }
        
        public Producto(String unNom,String unaDes,String unTipo,String unaVen,String img){
            this.setNombre(unNom);
            this.setDescripcion(unaDes);
            this.setTipo(unTipo);
            this.setFormaVenta(unaVen);
            this.setImag(img);
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
        
        public String getImag(){
            return this.imagen;
        }
        
        public void setImag(String imag){
            this.imagen = imag;
        }
        
        public boolean equals(Object o){
            return this.getNombre().equalsIgnoreCase(((Producto)o).getNombre());
        }
        
        @Override
        public String toString(){
            return this.getNombre();
        }
        
        //Nombre distinto
        @Override
        public int compareTo(Producto o) {
            return this.nombre.compareToIgnoreCase(o.getNombre());
        }
    
}
