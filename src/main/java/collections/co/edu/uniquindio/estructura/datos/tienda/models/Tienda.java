package collections.co.edu.uniquindio.estructura.datos.tienda.models;

import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.ClienteException;

import java.util.ArrayList;
import java.util.HashMap;

public class Tienda {

    private String nombre;
    private String nit;
    private HashMap<String, Cliente> listaClientes = new HashMap<>();
    private HashMap<String, Producto> listaProductos = new HashMap<>();

    public Tienda(){

    }

    public void agregarCliente(Cliente nuevoCliente) throws ClienteException{
        getListaClientes().put(nuevoCliente.getNumeroIdentificacion(), nuevoCliente);
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

    public boolean clienteExiste(String numeroIdentificacion) {
        return listaClientes.containsKey(numeroIdentificacion);
    }

    public HashMap<String, Cliente> getListaClientes() {
        return listaClientes;
    }

    public HashMap<String, Producto> getListaProductos() {
        return listaProductos;
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
