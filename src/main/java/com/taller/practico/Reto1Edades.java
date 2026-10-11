package com.taller.practico;

import java.util.Scanner;

public class Reto1Edades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la edad del usuario: ");
        int edadUsuario = sc.nextInt();

        String categoria;
        String perfilAcceso;

        if (edadUsuario < 12) {
            categoria = "Infante";
            perfilAcceso = "Requiere tutor de cuenta";
        } else if (edadUsuario <= 17) {
            categoria = "Adolescente";
            perfilAcceso = "Acceso restringido a foros comunitarios";
        } else if (edadUsuario <= 64) {
            categoria = "Adulto";
            perfilAcceso = "Acceso a funcionalidades estándar";
        } else {
            categoria = "Adulto Mayor";
            perfilAcceso = "Acceso con interfaz adaptada";
        }

        System.out.println("Edad: " + edadUsuario);
        System.out.println("Categoría asignada: " + categoria);
        System.out.println("Perfil de acceso activado: " + perfilAcceso);

        sc.close();
    }
}