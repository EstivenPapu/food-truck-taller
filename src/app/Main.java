package app;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {

    static final Scanner NS = new Scanner(System.in);
    static final double META_VENTAS = 500_000;
    public static void main(String[] args) {
        double total = 0;
        double[] totalVendidoProducto = {0,0,0};
        String[] productos = {"Hamburguesas","Perros Calientes","Papas Fritas"};
        String[] turnos = {"Almuerzo","Tarde","Noche", "Madrugada"};
        double[][] ventas = new double[productos.length][turnos.length];

        registrarVentas(productos, turnos, ventas);
        total = calcularReporte(productos, turnos, ventas, totalVendidoProducto, total);
        mostrarReporte(total, productos, totalVendidoProducto, META_VENTAS);
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

    static double calcularReporte(String[] productos, String[] turnos, double[][] ventas, double[] totalVentasProducto, double total){
        double suma = 0;

        for (int i = 0; i < productos.length; i++){
            for (int j = 0; j < turnos.length; j++){
                suma += ventas[i][j];
                total += ventas[i][j];
            }
            totalVentasProducto[i] = suma;
            suma = 0;
        }
        return total;
    }

    static void mostrarReporte(double total, String[] productos, double[] totalVentasProducto, double META_VENTAS){

        System.out.println(" ");
        mostrarMensaje("TOTAL VENDIDO POR PRODUCTOS");
        System.out.println(" ");
        for (int i = 0; i < totalVentasProducto.length; i++){
            System.out.println(productos[i] + ": $" + totalVentasProducto[i]);
        }

        System.out.println(" ");
        mostrarMensaje("TOTAL VENDIDO");
        System.out.println(" ");
        System.out.println("$" + total);

        if (total >= META_VENTAS){
            mostrarMensaje("Meta de ventas alcanzada");
        }else{
            mostrarMensaje("Meta no alcanzada");
        }

    }



}
