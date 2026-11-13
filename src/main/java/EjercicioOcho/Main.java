/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioOcho;

import java.util.Scanner;
/**
 *
 * @author ASUS
 */


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria("Emily Iglesias", 357000);

        int opcion = 0;

        try {
            do {
                System.out.println("\n--- CAJERO AUTOMÁTICO ---");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Retirar");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                try {
                    opcion = Integer.parseInt(sc.nextLine());

                    switch (opcion) {

                        case 1:
                            System.out.println("Saldo actual: $" + cuenta.getSaldo());
                            break;

                        case 2:
                            System.out.print("Monto a depositar: ");
                            double deposito = Double.parseDouble(sc.nextLine());

                            cuenta.depositar(deposito);
                            System.out.println("Depósito realizado correctamente.");
                            break;

                        case 3:
                            System.out.print("Monto a retirar: ");
                            double retiro = Double.parseDouble(sc.nextLine());

                            cuenta.retirar(retiro);
                            System.out.println("Retiro realizado correctamente.");
                            break;

                        case 4:
                            System.out.println("Gracias por utilizar el cajero.");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un número.");

                } catch (MontoInvalidoException e) {
                    System.out.println(e.getMessage());

                } catch (SaldoInsuficienteException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Dinero faltante: $" + e.getFaltante());
                }

            } while (opcion != 4);

        } finally {
            sc.close();
        }
    }
}
