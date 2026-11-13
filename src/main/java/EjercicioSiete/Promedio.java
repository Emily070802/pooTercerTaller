/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioSiete;

/**
 *
 * @author ASUS
 */

import java.util.Scanner;

public class Promedio {

    public static double promedio(double[] notas) {
        double suma = 0;

        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }

        return suma / notas.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("¿Cuántas notas? ");
            int n = Integer.parseInt(sc.nextLine());

            if (n <= 0) {
                System.out.println("Debe ingresar al menos una nota.");
                return;
            }

            double[] notas = new double[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese la nota " + (i + 1) + ": ");
                double nota = Double.parseDouble(sc.nextLine());

                if (nota < 0 || nota > 5) {
                    System.out.println("La nota debe estar entre 0 y 5.");
                    return;
                }

                notas[i] = nota;
            }

            System.out.printf("Promedio: %.2f%n", promedio(notas));

        } catch (NumberFormatException e) {
            System.out.println("Dato inválido. Debe ingresar un número.");

        } finally {
            sc.close();
        }
    }
}

