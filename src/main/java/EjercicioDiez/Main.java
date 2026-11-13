/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDiez;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
/**
 *
 * @author ASUS
 */


public class Main {

    public static void main(String[] args) {

        Bitacora bitacora = new Bitacora();

        try {
            bitacora.registrar("Usuario inició sesión");
            bitacora.registrar("ERROR: la contraseña es incorrecta");
            bitacora.registrar("El usuario realizó una consulta");
            bitacora.registrar("ERROR: conexión interrumpida");

            System.out.println("--- EVENTOS REGISTRADOS ---");

            List<String> eventos = bitacora.leer();

            for (String evento : eventos) {
                System.out.println(evento);
            }

            System.out.println();
            System.out.println("Eventos con ERROR: " + bitacora.contar("ERROR"));

            try {
                FileReader archivo = new FileReader( "noexiste.txt", StandardCharsets.UTF_8);
                archivo.close();

            } catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo noexiste.txt");
            }

        } catch (IOException e) {
            System.out.println("Error al trabajar con archivos: "+ e.getMessage());
        }
    }
}
