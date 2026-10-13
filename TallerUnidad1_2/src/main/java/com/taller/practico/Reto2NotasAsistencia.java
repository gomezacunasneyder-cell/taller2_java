package com.taller.practico;

import java.util.Scanner;

public class Reto2NotasAsistencia {
    public static void main(String[] args) {
        // Inicializamos el Scanner para leer los datos ingresados por consola
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE EVALUACIÓN DE RENDIMIENTO ACADÉMICO ===");

        // Requisitos de Entrada interactivos
        System.out.print("Ingrese la calificación final (0.0 a 100.0): ");
        double calificacionFinal = scanner.nextDouble();

        System.out.print("Ingrese el porcentaje de asistencia (0 a 100): ");
        int porcentajeAsistencia = scanner.nextInt();

        System.out.print("¿Entregó el proyecto final? (true para sí / false para no): ");
        boolean entregoProyectoFinal = scanner.nextBoolean();

        String dictamen;

        // Condiciones Lógicas del Reto 2
        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            dictamen = "Aprobado";
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            dictamen = "Pendiente de Examen Extraordinario";
        } else {
            dictamen = "Reprobado";
        }

        // Salida Esperada por consola
        System.out.println("\n----------------------------------------");
        System.out.println("Calificación Registrada: " + calificacionFinal);
        System.out.println("Asistencia Registrada: " + porcentajeAsistencia + "%");
        System.out.println("Proyecto Final Entregado: " + entregoProyectoFinal);
        System.out.println(" Dictamen Académico: " + dictamen);
        System.out.println("----------------------------------------");

        // Cerramos el scanner para liberar recursos
        scanner.close();
    }
}