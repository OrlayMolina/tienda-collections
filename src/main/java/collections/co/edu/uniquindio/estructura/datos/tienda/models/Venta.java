package collections.co.edu.uniquindio.estructura.datos.tienda.models;

import java.util.ArrayList;

public class Venta {

    private String fecha;
    private String codigo;
    private Integer total;
    private String cantidad;
    private Cliente cliente;
    private ArrayList<DetalleVenta> detalleVentas;

    public Venta(){

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(ArrayList<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
}
