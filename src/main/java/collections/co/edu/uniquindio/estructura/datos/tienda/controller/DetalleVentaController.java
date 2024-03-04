package collections.co.edu.uniquindio.estructura.datos.tienda.controller;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetalleVentaController {

    ModelFactoryController modelFactoryController;

    public DetalleVentaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public HashMap<String, ProductoDto> obtenerProductos() {
        return modelFactoryController.obtenerProductos();
    }

    public List<DetalleVentaDto> obtenerDetallesVenta() {
        return modelFactoryController.obtenerDetallesVenta();
    }
    public boolean agregarDetalleVenta(DetalleVentaDto detalleVentaDto) {
        return modelFactoryController.agregarDetalleVenta(detalleVentaDto);
    }
}
