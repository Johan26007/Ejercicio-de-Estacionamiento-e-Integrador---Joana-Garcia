package ejercicioestacionamiento;

class PorHora extends Estacionamiento {

    private double horas;
    private final double VALOR_HORA = 3.0;

    public PorHora(String patente, double horas) {
        super(patente);
        setHoras(horas);
    }

    public double getHoras() {
        return horas;
    }

    public final void setHoras(double horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("No puedes ingresar un valor menor o igual a 0...");
        }
        this.horas = Math.round(horas);
    }

    @Override
    public double calcularCostoFinal() {
        return horas * VALOR_HORA;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("*****************************************");
        System.out.println("SISTEMA POR HORA:");
        System.out.println("Cantidad de horas ingresadas: " + horas + " hrs");
        System.out.println("Costo a pagar por hora: " + VALOR_HORA + " USD");
        System.out.println("*****************************************");
    }
    
    @Override
    public String getTipoEstacionamiento(){
        return "Por hora";
    }

}
