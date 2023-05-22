
package Dominio;


public class DueñoPuesto {
    //Atributos
    private String nombre;
    private int edad;
    private int experiencia;
    
    //Constructor
    public DueñoPuesto(){
        this.setNombre("Sin nombre");
        this.setEdad(0);
        this.setExperiencia(0);
    }
    
    public DueñoPuesto(String unNom,int edad,int años){
        this.setNombre(unNom);
        this.setEdad(edad);
        this.setExperiencia(años);
    }
    
    //get y set
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String unNom){
        this.nombre = unNom;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public void setEdad(int unaedad){
        this.edad = unaedad;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public void setExperiencia(int años){
        this.experiencia = años;
    }
    
    public boolean equals(Object o){
        return this.getNombre().equalsIgnoreCase(((DueñoPuesto)o).getNombre());
    }
    
    @Override
    public String toString(){
        return "Nombre " + this.getNombre();
    }
}
