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
