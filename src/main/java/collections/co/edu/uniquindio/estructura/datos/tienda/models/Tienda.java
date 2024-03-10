package collections.co.edu.uniquindio.estructura.datos.tienda.models;

import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.ClienteException;
import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.DetalleVentaException;
import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.VentaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Tienda {

    private String nombre;
    private String nit;
    private HashMap<String, Cliente> listaClientes = new HashMap<>();
    private HashMap<String, Producto> listaProductos = new HashMap<>();
    private ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();

    private LinkedList<Venta> listaVentas = new LinkedList<>();
    private ArrayList<Venta> listaVenta = new ArrayList<>();

    public Tienda(){

    }

    public void agregarHistorialVentas(Venta ventaHistorial) throws VentaException{
        String fechaNuevaVenta = ventaHistorial.getFecha();

        int indice = 0;
        while (indice < getListaHistorialVentas().size() &&
                fechaNuevaVenta.compareTo(getListaHistorialVentas().get(indice).getFecha()) > 0) {
            indice++;
        }

        getListaHistorialVentas().add(indice, ventaHistorial);

    }

    public void agregarCliente(Cliente nuevoCliente) throws ClienteException{
        getListaClientes().put(nuevoCliente.getNumeroIdentificacion(), nuevoCliente);
    }

    public void agregarDetalleVenta(DetalleVenta nuevoDetalleVenta) throws DetalleVentaException {
        getListaDetalleVentas().add(nuevoDetalleVenta);
    }

    public void agregarVenta(Venta nuevoVenta) throws VentaException {
        getListaVentas().add(nuevoVenta);
    }

    public boolean actualizarCliente(String numeroIdentificacion, Cliente cliente) throws ClienteException {
        Cliente clienteActual = obtenerCliente(numeroIdentificacion);
        if (clienteActual == null) {
            throw new ClienteException("El Cliente a actualizar no existe");
        } else {
            clienteActual.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setDireccion(cliente.getDireccion());
            return true;
        }
    }


    public boolean eliminarCliente(String cedula) throws ClienteException {
        Cliente cliente = obtenerCliente(cedula);
        if (cliente == null) {
            throw new ClienteException("El Cliente a eliminar no existe");
        } else {
            listaClientes.remove(cedula);
            return true;
        }
    }

    public Cliente obtenerCliente(String numeroIdentificacion) {
        return listaClientes.get(numeroIdentificacion);
    }

    public boolean verificarClienteExistente(String numeroIdentificacion) throws ClienteException {
        if(clienteExiste(numeroIdentificacion)){
            throw new ClienteException("El cliente con documento: "+numeroIdentificacion+" ya existe");
        }else{
            return false;
        }
    }

    public boolean verificarDetalleVentaExistente(String codigo) throws DetalleVentaException {
        if(detalleVentaExiste(codigo)){
            throw new DetalleVentaException("El producto con codigo: "+codigo+" ya existe");
        }else{
            return false;
        }
    }

    public boolean verificarVentaExistente(String codigo) throws VentaException {
        if(ventaExiste(codigo)){
            throw new VentaException("El producto con codigo: "+codigo+" ya existe");
        }else{
            return false;
        }
    }

    public boolean clienteExiste(String numeroIdentificacion) {
        return listaClientes.containsKey(numeroIdentificacion);
    }

    public boolean detalleVentaExiste(String codigo) {
        boolean detalleEncontrado = false;
        for (DetalleVenta detalle : getListaDetalleVentas()) {
            if(detalle.getProducto().getCodigo().equalsIgnoreCase(codigo)){
                detalleEncontrado = true;
                break;
            }
        }
        return detalleEncontrado;
    }

    public boolean ventaExiste(String codigo) {
        boolean ventaEncontrado = false;
        for (Venta venta : getListaVentas()) {
            if(venta.getCodigo().equalsIgnoreCase(codigo)){
                ventaEncontrado = true;
                break;
            }
        }
        return ventaEncontrado;
    }

    public HashMap<String, Cliente> getListaClientes() {
        return listaClientes;
    }

    public HashMap<String, Producto> getListaProductos() {
        return listaProductos;
    }

    public ArrayList<DetalleVenta> getListaDetalleVentas() {
        return listaDetalleVenta;
    }

    public LinkedList<Venta> getListaHistorialVentas() {
        return listaVentas;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVenta;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
