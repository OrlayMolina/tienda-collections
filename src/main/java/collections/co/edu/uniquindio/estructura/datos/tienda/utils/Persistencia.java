package collections.co.edu.uniquindio.estructura.datos.tienda.utils;

import collections.co.edu.uniquindio.estructura.datos.tienda.models.Producto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que permite la persistencia de los datos de la tienda
 */
public class Persistencia {

    public static final String RUTA_ARCHIVO_PRODUCTOS = "src/main/resources/persistencia/archivos/archivoProductos.txt";

    /**
     * Este método carga los datos de los archivos de la tienda
     * @param tienda
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void cargarDatosArchivos(Tienda tienda) throws FileNotFoundException, IOException {
        HashMap<String, Producto> productosCargados = cargarProductos();
        if (!productosCargados.isEmpty())
            tienda.getListaProductos().putAll(productosCargados);
    }

    /**
     * Este método guarda los productos en el archivo
     * @param listaProductos
     * @throws IOException
     */
    public static void guardarProducto(HashMap<String, Producto> listaProductos) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (Producto producto : listaProductos.values()) {
            contenido.append(producto.getCodigo()).append("@@").append(producto.getNombre()).append("@@")
                    .append(producto.getPrecio()).append("@@").append(producto.getCantidad()).append("\n");
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido.toString(), false);
    }

    /**
     * Este método carga los productos del archivo
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static HashMap<String, Producto> cargarProductos() throws FileNotFoundException, IOException {
        HashMap<String, Producto> productos = new HashMap<>();
        HashMap<Integer, String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
        for (String linea : contenido.values()) {
            String[] partes = linea.split("@@");
            if (partes.length >= 4) {
                Producto producto = new Producto();
                producto.setCodigo(partes[0]);
                producto.setNombre(partes[1]);
                producto.setPrecio(Integer.valueOf(partes[2]));
                producto.setCantidad(Integer.valueOf(partes[3]));
                productos.put(producto.getCodigo(), producto);
            }
        }
        return productos;
    }
}
