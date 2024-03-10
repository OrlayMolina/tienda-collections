package collections.co.edu.uniquindio.estructura.datos.tienda.models;

import java.util.ArrayList;

public class DetalleVenta {

    private String codigo;
    private Producto producto;
    private Integer cantidad;
    private Integer subtotal;

    public DetalleVenta()
    {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
