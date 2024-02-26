package collections.co.edu.uniquindio.estructura.datos.tienda.utils;

import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;

import java.util.function.Predicate;

public class ClienteUtil {

    public static Predicate<ClienteDto> buscarPorNumeroIdentificacion(String numeroIdentificacion){
        return clienteDto -> clienteDto.numeroIdentificacion().contains(numeroIdentificacion);
    }

    public static Predicate<ClienteDto> buscarPorNombres(String nombres){
        return clienteDto -> clienteDto.nombre().contains(nombres);
    }

    public static Predicate<ClienteDto> buscarPorApellidos(String apellidos){
        return clienteDto -> clienteDto.apellido().contains(apellidos);
    }

    public static Predicate<ClienteDto> buscarPorDireccion(String direccion){
        return clienteDto -> clienteDto.direccion().contains(direccion);
    }
    public static Predicate<ClienteDto> buscarPorTodo(String numeroIdentificacion, String nombres, String apellidos,
                                                         String direccion) {

        Predicate<ClienteDto> predicado = clienteDto -> true;

        if( numeroIdentificacion != null && !numeroIdentificacion.isEmpty() ){
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroIdentificacion));
        }
        if( nombres != null && !nombres.isEmpty() ){
            predicado = predicado.and(buscarPorNombres(nombres));
        }
        if( apellidos != null && !apellidos.isEmpty() ){
            predicado = predicado.and(buscarPorApellidos(apellidos));
        }
        if( direccion != null && !direccion.isEmpty() ){
            predicado = predicado.and(buscarPorDireccion(direccion));
        }

        return predicado;
    }
}
