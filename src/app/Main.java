package app;

import java.util.Scanner;

public class Main {

    static final Scanner NS = new Scanner(System.in);
    static final double META_VENTAS = 500_000;
    public static void main(String[] args) {
        String[] productos = {"Hamburguesas","Perros Calientes","Papas Fritas"};
        String[] turnos = {"Almuerzo","Tarde","Noche", "Madrugada"};
        double[][] ventas = new double[productos.length][turnos.length];

        registrarVentas(productos, turnos, ventas);

    }

    static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    static void registrarVentas(String[] productos, String[] turnos,double[][] ventas){
        for (int i = 0; i < productos.length; i++){
            for (int j = 0; j < turnos.length; j++){
                mostrarMensaje("Ingrese las ventas de " + productos[i] + " en el turno " + turnos[j] + ": ");
                ventas[i][j] = leerDato();
            }
        }
    }

    static double leerDato(){
        while(true) {
            System.out.println("Dijite un numero");

            if (!NS.hasNextDouble()){
                mostrarMensaje("Erro: ingrese un valor numerico valido");
                NS.next();
                continue;
            }

            double venta = NS.nextDouble();
            if(venta < 0) {
                mostrarMensaje("Error, el valor no puede ser negativo. Intente de nuevo");
                continue;
            }

            return venta;
        }
    }
}
