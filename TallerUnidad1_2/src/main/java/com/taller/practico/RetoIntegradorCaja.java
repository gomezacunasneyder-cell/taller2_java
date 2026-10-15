package com.taller.practico;

import java.util.Locale;
import java.util.Scanner;

public class RetoIntegradorCaja {

    // Constantes del negocio (reglas de la guía)
    static final double PRECIO_UNITARIO = 250.00;
    static final double IVA = 0.16;
    static final double DESCUENTO_CUPON = 50.00;
    static final double MONTO_MINIMO_CUPON = 500.00;
    static final String CODIGO_CUPON = "PROMO1 año";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ENTRADA DE DATOS
        System.out.print("Cantidad de licencias: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpia el salto de línea pendiente

        System.out.print("Tipo de cliente (VIP / REGULAR / NUEVO): ");
        String tipoCliente = sc.nextLine().trim().toUpperCase();

        System.out.print("Cupón (deje vacío si no tiene): ");
        String cupon = sc.nextLine().trim();

        // 1. SUBTOTAL BASE
        double subtotalBase = cantidad * PRECIO_UNITARIO;

        // 2. DESCUENTO POR CATEGORÍA (switch)
        double porcentajeDescuento = switch (tipoCliente) {
            case "VIP" -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO" -> 0.05;
            default -> 0.0;
        };
        double descuentoCliente = subtotalBase * porcentajeDescuento;
        double subtotalConDescuento = subtotalBase - descuentoCliente;

        // 3. CUPÓN (if-else + operador lógico &&)
        double descuentoCupon;
        if (cupon.equals(CODIGO_CUPON) && subtotalConDescuento >= MONTO_MINIMO_CUPON) {
            descuentoCupon = DESCUENTO_CUPON;
        } else {
            descuentoCupon = 0.00;
        }

        // 4. IMPUESTOS Y TOTAL
        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * IVA;
        double total = baseImponible + iva;

        // SALIDA
        System.out.println("\n===== FACTURA =====");
        System.out.printf(Locale.US, "Subtotal base:           $%.2f%n", subtotalBase);
        System.out.printf(Locale.US, "Descuento cliente (%s):  -$%.2f%n", tipoCliente, descuentoCliente);
        System.out.printf(Locale.US, "Subtotal con descuento:  $%.2f%n", subtotalConDescuento);
        System.out.printf(Locale.US, "Descuento cupón:         -$%.2f%n", descuentoCupon);
        System.out.printf(Locale.US, "Base imponible:          $%.2f%n", baseImponible);
        System.out.printf(Locale.US, "IVA (16%%):               +$%.2f%n", iva);
        System.out.printf(Locale.US, "Total a pagar = $%.2f%n", total);
    }
}

/*
 * CASOS DE PRUEBA
 * Caso A: cantidad = 3, tipoCliente = VIP,   cupon = PROMO1 año -> Total a pagar = $638.00
 * Caso B: cantidad = 1, tipoCliente = NUEVO, cupon = PROMO1 año -> Total a pagar = $275.50
 */