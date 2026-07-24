package ejercicioestacionamiento;
import java.util.Scanner;

public class EjercicioEstacionamiento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion, contadorPorHora = 0, contadorMediaJornada = 0, contadorJornadaCompleta = 0;
        double valor, horas, costoFinalIndividual = 0, descuento = 0, costoDescuento = 0, ingresosTotales = 0, totalPorHora = 0,
                totalMediaJornada = 0, totalJornadaCompleta = 0;
        String patenteVehiculo, opcionElegida = "";

        while (true) {
            System.out.println("**** SISTEMA COBRO DE ESTACIONAMIENTO ****");
            System.out.println("Ingrese la patente del vehiculo o 'FIN' para cerrar el sistema: ");
            patenteVehiculo = scanner.nextLine();
            if (patenteVehiculo.equalsIgnoreCase("FIN")) {
                System.out.println("Terminando el programa");
                break;
            }

            System.out.println("Tipos de estacionamientos disponibles:");
            System.out.println("1. Por hora");
            System.out.println("2. Media hora");
            System.out.println("3. Jornada completa");
            System.out.println("Ingrese el numero de la opcion elejida");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de horas en las que utilizo el estacionamiento:");
                    horas = scanner.nextDouble();
                    scanner.nextLine();
                    if (horas <= 0) {
                        System.out.println("No puede ingresar un valor menor o igual a 0");
                    } else {
                        opcionElegida = "Por hora";
                        valor = 3;
                        costoFinalIndividual = horas * valor;

                        System.out.println("*****************************************");
                        System.out.println("SISTEMA POR HORA:");
                        System.out.println("Cantidad de horas ingresadas: " + horas + " hrs");
                        System.out.println("Costo a pagar por hora: " + valor + " USD");
                        System.out.println("*****************************************");

                        contadorPorHora++;
                        totalPorHora += costoFinalIndividual;
                    }
                    break;
                case 2:
                    opcionElegida = "Media Jornada";
                    valor = 15;
                    descuento = 0.05;
                    costoDescuento = valor * descuento;
                    costoFinalIndividual = valor - costoDescuento;
                    System.out.println("*****************************************");
                    System.out.println("SISTEMA DE MEDIA JORNADA:");
                    System.out.println("Usted posee con un 5% de descuento");
                    System.out.println("Costo a pagar (sin descuento): " + valor + " USD");
                    System.out.println("Costo del descuento: " + costoDescuento + " USD");
                    System.out.println("*****************************************");
                    
                    contadorMediaJornada++;
                    totalMediaJornada += costoFinalIndividual;
                    break;
                case 3:
                    opcionElegida = "Jornada completa";
                    valor = 30;
                    descuento = 0.10;
                    costoDescuento = valor * descuento;
                    costoFinalIndividual = valor - costoDescuento;
                    System.out.println("*****************************************");
                    System.out.println("SISTEMA DE JORNADA COMPLETA:");
                    System.out.println("Usted posee con un 10% de descuento");
                    System.out.println("Costo a pagar (sin descuento): " + valor + " USD");
                    System.out.println("Costo del descuento: " + costoDescuento + " USD");
                    System.out.println("*****************************************");
                    
                    contadorJornadaCompleta++;
                    totalJornadaCompleta += costoFinalIndividual;
                    break;
                default:
                    System.out.println("Ingreso una opcion invalida");
            }
            
            ingresosTotales += costoFinalIndividual;
            System.out.println("**********************************************");
            System.out.println("RESUMEN :");
            System.out.println("Patente del vehiculo: " + patenteVehiculo);
            System.out.println("Opcion ingresada: " + opcionElegida);
            System.out.println("Costo final: " + costoFinalIndividual + " USD");
            System.out.println("**********************************************");
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
