/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioOcho;

/**
 *
 * @author ASUS
 */


public class MontoInvalidoException extends Exception {

    public MontoInvalidoException() {
        super("El monto debe ser mayor que cero.");
    }
}

