package collections.co.edu.uniquindio.estructura.datos.tienda.controller;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;

import java.util.HashMap;

public class VentaController {

    ModelFactoryController modelFactoryController;

    public VentaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public HashMap<String, ClienteDto> obtenerClientes() {
        return modelFactoryController.obtenerClientes();
    }
}
