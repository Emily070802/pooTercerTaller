/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioOnce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 *
 * @author ASUS
 */

public class Main {

    public static void main(String[] args) {

        int procesados = 0;
        int errores = 0;
        int numeroLinea = 1;

        try (
            BufferedReader lector = new BufferedReader(
                    new FileReader("estudiantes.csv",
                            StandardCharsets.UTF_8));

            PrintWriter escritor = new PrintWriter(
                    new FileWriter("reporte.csv",
                            StandardCharsets.UTF_8))
        ) {

            lector.readLine();

            escritor.println("codigo,nombre,promedio,estado");

            String linea;

            while ((linea = lector.readLine()) != null) {

                numeroLinea++;

                try {

                    String[] datos = linea.split(",", -1);

                    if (datos.length != 5) {
                        throw new IllegalArgumentException("Cantidad incorrecta de columnas");
                    }

                    String codigo = datos[0];
                    String nombre = datos[1];

                    double nota1 = Double.parseDouble(datos[2]);
                    double nota2 = Double.parseDouble(datos[3]);
                    double nota3 = Double.parseDouble(datos[4]);

                    if (nota1 < 0 || nota1 > 5 ||
                        nota2 < 0 || nota2 > 5 ||
                        nota3 < 0 || nota3 > 5) {

                        throw new IllegalArgumentException(
                                "Las notas deben estar entre 0 y 5");
                    }

                    double promedio = (nota1 + nota2 + nota3) / 3;

                    String estado;

                    if (promedio >= 3.0) {
                        estado = "APROBADO";
                    } else {
                        estado = "REPROBADO";
                    }

                    escritor.printf(Locale.US,
                            "%s,%s,%.2f,%s%n",
                            codigo, nombre, promedio, estado);

                    procesados++;

                } catch (NumberFormatException e) {

                    errores++;

                    System.out.println("Error en la línea " + numeroLinea + ": nota no numérica");

                } catch (IllegalArgumentException e) {

                    errores++;

                    System.out.println("Error en la línea " + numeroLinea + ": " + e.getMessage());
                }
            }

            System.out.println();
            System.out.println("Estudiantes procesados: " + procesados);
            System.out.println("Filas con errores: " + errores);
            System.out.println("Reporte generado correctamente.");

        } catch (IOException e) {

            System.out.println("Error al trabajar con archivos: "
                    + e.getMessage());
        }
    }
}

