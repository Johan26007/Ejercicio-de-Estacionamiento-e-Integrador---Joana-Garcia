package ejercicioestacionamiento;
import java.util.Scanner;
import java.util.InputMismatchException;

public class EjercicioEstacionamiento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contadorPorHora = 0, contadorMediaJornada = 0, contadorJornadaCompleta = 0;
        double totalPorHora = 0, totalMediaJornada = 0, totalJornadaCompleta = 0, ingresosTotales = 0;

        while (true) {
            try {
                System.out.println("**** SISTEMA COBRO DE ESTACIONAMIENTO ****");
                System.out.println("Ingrese la patente del vehiculo o 'FIN' para cerrar el sistema: ");
                String patenteVehiculo = scanner.nextLine();

                if (patenteVehiculo.equalsIgnoreCase("FIN")) {
                    System.out.println("Terminando el programa");
                    break;
                }

                System.out.println("Tipos de estacionamientos disponibles:");
                System.out.println("1. Por hora");
                System.out.println("2. Media jornada");
                System.out.println("3. Jornada completa");
                System.out.println("Ingrese el numero de la opcion elejida");

                int opcion = scanner.nextInt();
                scanner.nextLine();
                Estacionamiento estacionamiento;

                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingrese la cantidad de horas en las que utilizo el estacionamiento:");
                        double horas = scanner.nextDouble();
                        scanner.nextLine();
                        estacionamiento = new PorHora(patenteVehiculo, horas);
                        
                        contadorPorHora++;
                        totalPorHora += estacionamiento.calcularCostoFinal();
                    }

                    case 2 -> {
                        estacionamiento = new MediaJornada(patenteVehiculo);
                        
                        contadorMediaJornada++;
                        totalMediaJornada += estacionamiento.calcularCostoFinal();
                    }

                    case 3 -> {
                        estacionamiento = new JornadaCompleta(patenteVehiculo);
                        
                        contadorJornadaCompleta++;
                        totalJornadaCompleta += estacionamiento.calcularCostoFinal();
                    }

                    default -> throw new IllegalArgumentException("Ingreso una opcion invalida");
                }
                estacionamiento.mostrarDetalles();
                double costoFinalIndividual = estacionamiento.calcularCostoFinal();
                ingresosTotales += costoFinalIndividual;

                System.out.println("**********************************************");
                System.out.println("RESUMEN :");
                System.out.println("Patente del vehiculo: " + estacionamiento.getPatente());
                System.out.println("Opcion ingresada: " + estacionamiento.getTipoEstacionamiento());
                System.out.println("Costo final: " + costoFinalIndividual + " USD");
                System.out.println("**********************************************");

            } catch (InputMismatchException e) {
                System.err.println("Error: Debe ingresar un valor numerico valido.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        System.out.println("**********************************************");
        System.out.println("RESUMEN DEL DIA:");
        System.out.println("Estacionamientos por hora: " + contadorPorHora);
        System.out.println("Total de ingresos para estacionamiento por hora: " + totalPorHora + " USD");
        System.out.println("Estacionamientos por media jornada: " + contadorMediaJornada);
        System.out.println("Total de ingresos para estacionamiento por media jornada: " + totalMediaJornada + " USD");
        System.out.println("Estacionamientos por jornada completa: " + contadorJornadaCompleta);
        System.out.println("Total de ingresos para estacionamiento por jornada completa: " + totalJornadaCompleta + " USD");
        System.out.println("**********************************************");
        System.out.println("SUMA TOTAL DE INGRESOS: " + ingresosTotales + " USD");
        System.out.println("**********************************************");
    }
}