package collections.co.edu.uniquindio.estructura.datos.tienda.controller;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;

import java.util.HashMap;
import java.util.List;

public class ClienteController {

    ModelFactoryController modelFactoryController;

    public ClienteController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public HashMap<String, ClienteDto> obtenerClientes() {
        return modelFactoryController.obtenerClientes();
    }

    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactoryController.agregarCliente(clienteDto);
    }
}
