package com.example.proyecto;

public class Item {
    private int icono;
    private String titulo;

    public Item(int icono, String titulo) {
        this.icono = icono;
        this.titulo = titulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
