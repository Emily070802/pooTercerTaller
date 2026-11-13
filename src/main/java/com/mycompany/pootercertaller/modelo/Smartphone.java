/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pootercertaller.modelo;

/**
 *
 * @author ASUS
 */

import com.mycompany.pootercertaller.Interfaces.Llamable;
import com.mycompany.pootercertaller.Interfaces.fotografiable;

public class Smartphone extends Dispositivo implements Llamable, fotografiable {

    private int megapixeles;

    public Smartphone(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    @Override
    public void describir() {
        System.out.println("Smartphone " + marca + " " + modelo
                + " - $" + precio + " - " + funcion());
    }

    @Override
    public void llamar(String numero) {
        System.out.println(marca + " llamando a " + numero);
    }

    @Override
    public void colgar() {
        System.out.println(marca + " finalizó la llamada");
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomó una foto de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }

    @Override
    public String funcion() {
        return "Llamadas y fotografía";
    }
}