package collections.co.edu.uniquindio.estructura.datos.tienda.controller;

import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.ClienteException;
import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.DetalleVentaException;
import collections.co.edu.uniquindio.estructura.datos.tienda.exceptions.VentaException;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.mappers.TiendaMapper;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Cliente;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.DetalleVenta;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Venta;
import collections.co.edu.uniquindio.estructura.datos.tienda.utils.Persistencia;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ModelFactoryController {

    Tienda tienda = new Tienda();
    TiendaMapper mapper = TiendaMapper.INSTANCE;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {

        cargarDatosDesdeArchivos();

        if(tienda == null){
            cargarDatosDesdeArchivos();
        }
    }

    public HashMap<String, ClienteDto> obtenerClientes() {
        return  mapper.getClienteDto(getTienda().getListaClientes());
    }

    public HashMap<String, ProductoDto> obtenerProductos() {
        return  mapper.getProductoDto(getTienda().getListaProductos());
    }

    public LinkedList<VentaDto> obtenerVentas() {
        return  mapper.getVentaHistorialDto(tienda.getListaHistorialVentas());
    }

    public boolean agregarHistorialVentas(VentaDto ventaDto) {
        try{
            if(!tienda.verificarVentaExistente(ventaDto.codigo())) {
                Venta venta = mapper.ventaDtoToVenta(ventaDto);
                getTienda().agregarHistorialVentas(venta);
            }
            return true;
        }catch (VentaException e){
            e.getMessage();
            return false;
        }

    }

    public List<DetalleVentaDto> obtenerDetallesVenta() {
        return  mapper.getDetalleVentaDto(tienda.getListaDetalleVentas());
    }

    public boolean agregarCliente(ClienteDto clienteDto) {
        try{
            if(!tienda.verificarClienteExistente(clienteDto.numeroIdentificacion())) {
                Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
                getTienda().agregarCliente(cliente);
            }
            return true;
        }catch (ClienteException e){
            e.getMessage();
            return false;
        }
    }

    public boolean agregarDetalleVenta(DetalleVentaDto detalleVentaDto) {
        try{
            if(!tienda.verificarDetalleVentaExistente(detalleVentaDto.producto().codigo())) {
                DetalleVenta detalleVenta = mapper.detalleVentaDtoToDetalleVenta(detalleVentaDto);
                getTienda().agregarDetalleVenta(detalleVenta);
            }
            return true;
        }catch (DetalleVentaException e){
            e.getMessage();
            return false;
        }
    }

    public boolean agregarVenta(VentaDto ventaDto) {
        try{
            if(!tienda.verificarVentaExistente(ventaDto.codigo())) {
                Venta venta = mapper.ventaDtoToVenta(ventaDto);
                getTienda().agregarVenta(venta);
            }
            return true;
        }catch (VentaException e){
            e.getMessage();
            return false;
        }
    }

    public boolean actualizarCliente(String numeroIdentificacion, ClienteDto clienteDto) {
        try {
            Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
            getTienda().actualizarCliente(numeroIdentificacion, cliente);
            return true;
        } catch (ClienteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getTienda().eliminarCliente(cedula);
        } catch (ClienteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }
    public Tienda getTienda() {
        return tienda;
    }

    private void cargarDatosDesdeArchivos() {
        tienda = new Tienda();
        try {
            Persistencia.cargarDatosArchivos(tienda);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
