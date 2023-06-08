package com.example.proyecto_iweb.models.beans;

public class JuegosVendidosNuevos {
    private int ventaid;
    private int precio;
    private String fecha_sudida;
    private int cantidad;
    private boolean tipo;
    private String descripcion;

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha_sudida() {
        return fecha_sudida;
    }

    public void setFecha_sudida(String fecha_sudida) {
        this.fecha_sudida = fecha_sudida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
