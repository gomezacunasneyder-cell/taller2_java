package com.taller.practico;

import java.util.Scanner;

public class Ejercicio1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int acumulador = 0;
        int contador = 0;

        System.out.print("Ingrese un número entero (-99 para terminar): ");
        int numero = sc.nextInt();

        while (numero != -99) {
            acumulador += numero;
            contador++;

            System.out.print("Ingrese un número entero (-99 para terminar): ");
            numero = sc.nextInt();
        }

        System.out.println("Total acumulado: " + acumulador);
        System.out.println("Cantidad de números procesados: " + contador);

        sc.close();
    }
}