package ejercicioestacionamiento;

class JornadaCompleta extends Estacionamiento {

    private final double VALOR_BASE = 30.0;
    private final double DESCUENTO = 0.10;

    public JornadaCompleta(String patente) {
        super(patente);
    }

    @Override
    public double calcularCostoFinal() {
        return VALOR_BASE - (VALOR_BASE * DESCUENTO);
    }

    @Override
    public void mostrarDetalles() {
        double costoDescuento;
        costoDescuento = VALOR_BASE * DESCUENTO;
        System.out.println("*****************************************");
        System.out.println("SISTEMA DE MEDIA JORNADA:");
        System.out.println("Usted posee con un 5% de descuento");
        System.out.println("Costo a pagar (sin descuento): " + VALOR_BASE + " USD");
        System.out.println("Costo del descuento: " + costoDescuento + " USD");
        System.out.println("*****************************************");
    }

    @Override
    public String getTipoEstacionamiento() {
        return "Jornada completa";
    }
}
