package com.example.a41587805.tp3.model;

import android.database.sqlite.SQLiteDatabase;

import com.example.a41587805.tp3.MainActivity;

/**
 * Created by 41587805 on 28/6/2016.
 */
public class Resultado {
    String nombre;
    String movimientos;
    int cantidad;

    public int getGanaste() {
        return ganaste;
    }

    public void setGanaste(int ganaste) {
        this.ganaste = ganaste;
    }

    int ganaste;




    public Resultado(String nombre, String movimientos, int cantidad, int ganaste) {
        this.nombre = nombre;
        this.movimientos = movimientos;
        this.cantidad = cantidad;
        this.ganaste= ganaste;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
