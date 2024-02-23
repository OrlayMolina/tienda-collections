package collections.co.edu.uniquindio.estructura.datos.tienda.models;

public class DetalleVenta {

    private Integer cantidad;
    private Integer subtotal;

    public DetalleVenta(Integer cantidad, Integer subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleVenta()
    {

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
}
