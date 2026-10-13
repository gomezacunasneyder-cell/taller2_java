package com.taller.practico;

import java.util.Scanner;

public class Reto3TarifasDescuentos {
    public static void main(String[] args) {
        // Inicializamos el Scanner para leer los datos ingresados por consola
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CÁLCULO DE TARIFAS Y DESCUENTOS ===");

        // Requisitos de Entrada interactivas
        System.out.print("Ingrese la edad del cliente: ");
        int edad = scanner.nextInt();

        System.out.print("¿Es miembro del club o estudiante? (true para sí / false para no): ");
        boolean esMiembro = scanner.nextBoolean();

        double tarifaBase = 20000.0; // Tarifa estándar
        double descuento = 0.0;
        String categoria = "";

        // Lógica de Descuentos y Tarifas basada en condiciones
        if (edad < 12) {
            categoria = "Tarifa Infantil";
            descuento = 0.50; // 50% de descuento
        } else if (edad >= 60) {
            categoria = "Tarifa Adulto Mayor";
            descuento = 0.40; // 40% de descuento
        } else {
            categoria = "Tarifa General";
            if (esMiembro) {
                descuento = 0.20; // 20% de descuento por membresía
            } else {
                descuento = 0.0;  // Sin descuento
            }
        }

        // Cálculo del valor final a pagar
        double valorFinal = tarifaBase - (tarifaBase * descuento);

        // Salida Esperada por consola
        System.out.println("\n----------------------------------------");
        System.out.println("Categoría: " + categoria);
        System.out.println("Tarifa Base: $" + tarifaBase);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Total a pagar: $" + valorFinal);
        System.out.println("----------------------------------------");

        // Cerramos el scanner
        scanner.close();
    }
}