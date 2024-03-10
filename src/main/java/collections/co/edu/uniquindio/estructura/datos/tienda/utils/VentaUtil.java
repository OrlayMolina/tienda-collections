package collections.co.edu.uniquindio.estructura.datos.tienda.utils;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;

import java.util.function.Predicate;

public class VentaUtil {

    public static Predicate<DetalleVentaDto> buscarPorCodigo(String codigo){
        return detalleVentaDto -> detalleVentaDto.codigo().contains(codigo);
    }

    public static Predicate<DetalleVentaDto> buscarPorTodo(String codigo) {

            Predicate<DetalleVentaDto> predicado = ventaDto -> true;

            if( codigo != null && !codigo.isEmpty() ){
                predicado = predicado.and(buscarPorCodigo(codigo));
            }

            return predicado;
    }
}
