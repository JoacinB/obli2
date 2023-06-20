// Autores: Julieta Lopez (295568) y Joaquin Borges (284675)
package Dominio;


public class Puesto {
    //Atributos
    private String identificacion;
    private String dueño;
    private String ubicacion;
    private int cantEmpleado;
    
    //Constructor
    public Puesto(){
        this.setId("Sin identificación");
        this.setDueño("Sin dueño");
        this.setUbicacion("Sin ubicación");
        this.setCantE(0);
    }
    
    public Puesto(String id,String d,String ubi,int cant){
        this.setId(id);
        this.setDueño(d);
        this.setUbicacion(ubi);
        this.setCantE(cant);
    }
    
    //get y set
    public String getId(){
        return this.identificacion;
    }
    
    public void setId(String Id){
        this.identificacion = Id;
    }
    
    public String getDueño(){
        return this.dueño;
    }
    
    public void setDueño(String d){
        this.dueño = d;
    }
    
    public String getUbicacion(){
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubi){
        this.ubicacion = ubi;
    }
    
    public int getCantE(){
        return this.cantEmpleado;
    }
    
    public void setCantE(int e){
        this.cantEmpleado = e;
    }
    
    public boolean equals(Object o){
        return this.getId().equalsIgnoreCase(((Puesto)o).getId());
    }

    //ID distinto
    public int compareTo(Puesto o) {
        return this.identificacion.compareToIgnoreCase(o.getId());
    }

    @Override
    public String toString(){
        return this.getId() + "-" + this.getDueño() + "-" + this.getUbicacion();
    }
}
