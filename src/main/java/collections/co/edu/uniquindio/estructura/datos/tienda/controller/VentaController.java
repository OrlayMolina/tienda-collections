package collections.co.edu.uniquindio.estructura.datos.tienda.controller;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;

import java.util.HashMap;
import java.util.List;

public class VentaController {

    ModelFactoryController modelFactoryController;

    public VentaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<DetalleVentaDto> obtenerDetallesVenta() {
        return modelFactoryController.obtenerDetallesVenta();
    }

    public boolean agregarVenta(VentaDto ventaDto) {
        return modelFactoryController.agregarVenta(ventaDto);
    }

    public HashMap<String, ClienteDto> obtenerClientes() {
        return modelFactoryController.obtenerClientes();
    }

    public boolean agregarHistorialVentas(VentaDto ventaDto) {
        return modelFactoryController.agregarHistorialVentas(ventaDto);
    }
}
