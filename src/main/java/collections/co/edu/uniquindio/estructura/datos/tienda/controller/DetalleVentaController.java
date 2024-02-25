package collections.co.edu.uniquindio.estructura.datos.tienda.controller;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;

import java.util.HashMap;

public class DetalleVentaController {

    ModelFactoryController modelFactoryController;

    public DetalleVentaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public HashMap<String, ProductoDto> obtenerProductos() {
        return modelFactoryController.obtenerProductos();
    }
}
