/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCuatro;
/**
 *
 * @author ASUS
 */

public class Main {

    public static void main(String[] args) {

        Dispositivo[] dispositivos = {
            new Smartphone("Iphone", "16 Pro Max", 3000000, 48),
            new Smartphone("Xiaomi", "Redmi Note 14", 1200000, 200),
            new Camara("Sony", "Zv-E10K", 2819900, 24)
        };

        int mayorResolucion = 0;

        for (int i = 0; i < dispositivos.length; i++) {

            dispositivos[i].describir();

            if (dispositivos[i] instanceof fotografiable) {

                fotografiable f = (fotografiable) dispositivos[i];
                f.tomarFoto();

                if (f.getMegapixeles() > mayorResolucion) {
                    mayorResolucion = f.getMegapixeles();
                }
            }

            if (dispositivos[i] instanceof Llamable) {

                Llamable l = (Llamable) dispositivos[i];
                l.llamar("3242649790");
                l.colgar();
            }

            System.out.println();
        }

        System.out.println("Mayor resolución: " + mayorResolucion + " MP");
    }
}
