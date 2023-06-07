package com.example.proyecto_iweb.models.beans;

public class ComprasVentas {

    private int idComprasVentas;
    private double precioTotal;
    private int fecha;
    private String descripcionEstado;
    private int cantidad;
    private Estados estados;
    private Juegos juegos;
    private int compraVenta;
    private String descripcionJuego;

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionJuego() {
        return descripcionJuego;
    }

    public void setDescripcionJuego(String descripcionJuego) {
        this.descripcionJuego = descripcionJuego;
    }

    public int getCompraVenta() {
        return compraVenta;
    }

    public void setCompraVenta(int compraVenta) {
        this.compraVenta = compraVenta;
    }

    public int getIdComprasVentas() {
        return idComprasVentas;
    }

    public void setIdComprasVentas(int idComprasVentas) {
        this.idComprasVentas = idComprasVentas;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getDate() {
        return fecha;
    }

    public void setDate(int date) {
        this.fecha = date;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Juegos getJuegos() {
        return juegos;
    }

    public void setJuegos(Juegos juegos) {
        this.juegos = juegos;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }
}
