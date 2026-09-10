package ejercicioestacionamiento;
public abstract class Estacionamiento {
    protected String patente;
    
    public Estacionamiento(){
        this.patente = "";
    }
    public Estacionamiento(String patente){
        this.patente = patente;
    }
    
    public String getPatente(){
        return patente;
    }
    public void setPatente(String patente){
        if (patente == null || patente.trim().isEmpty()) {
            throw new IllegalArgumentException("La patente del vehiculo no puede estar vacia...");
        }
        this.patente = patente;
    }
    
    public abstract double calcularCostoFinal();
    public abstract void mostrarDetalles();
    public abstract String getTipoEstacionamiento(); 
}
