/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDiez;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 *
 * @author ASUS
 */

public class Bitacora {

    private String ruta = "bitacora.txt";

    public void registrar(String mensaje) throws IOException {

        LocalDateTime fecha = LocalDateTime.now();

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String evento = "[" + fecha.format(formato) + "] " + mensaje + System.lineSeparator();

        Files.writeString(
                Paths.get(ruta),
                evento,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    public List<String> leer() throws IOException {
        return Files.readAllLines(
                Paths.get(ruta),
                StandardCharsets.UTF_8
        );
    }

    public int contar(String palabra) throws IOException {

        int cantidad = 0;

        List<String> eventos = leer();

        for (String evento : eventos) {

            if (evento.toLowerCase().contains(palabra.toLowerCase())) {
                cantidad++;
            }
        }

        return cantidad;
    }
}

