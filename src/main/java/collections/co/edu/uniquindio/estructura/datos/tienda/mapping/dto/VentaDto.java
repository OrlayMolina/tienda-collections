package collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto;

import java.util.ArrayList;

public record VentaDto(
        String fecha,
        String codigo,
        Integer total,
        String cantidad,
        ClienteDto cliente,
        ArrayList<DetalleVentaDto> detalleVentas) {

}