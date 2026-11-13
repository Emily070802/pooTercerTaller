/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioOcho;

/**
 *
 * @author ASUS
 */

public class CuentaBancaria {

    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {

        if (monto <= 0 || !Double.isFinite(monto)) {
            throw new MontoInvalidoException();
        }

        saldo += monto;
    }

    public void retirar(double monto)
            throws MontoInvalidoException, SaldoInsuficienteException {

        if (monto <= 0 || !Double.isFinite(monto)) {
            throw new MontoInvalidoException();
        }

        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }

        saldo -= monto;
    }
}
