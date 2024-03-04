package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import collections.co.edu.uniquindio.estructura.datos.tienda.Main;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.ClienteController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.VentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Cliente;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class VentaViewController {

    Tienda tienda;
    VentaController ventaControllerService;
    ObservableList<VentaDto> listaVentasDto = FXCollections.observableArrayList();
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();

    ObservableList<DetalleVentaDto> listaDetallesDto = FXCollections.observableArrayList();
    Main main = new Main();

    @FXML
    private Button btnBuscarVenta;

    @FXML
    private Button btnCancelarFiltro;

    @FXML
    private Button btnCrearVenta;

    @FXML
    private Button btnDetalleVenta;

    @FXML
    private Button btnEditarVenta;

    @FXML
    private Button btnEliminar;

    @FXML
    private ComboBox<ClienteDto> cmbListaClientes;

    @FXML
    private TableColumn<VentaDto, String> colCantidadProducto;

    @FXML
    private TableColumn<VentaDto, String> colCliente;

    @FXML
    private TableColumn<VentaDto, String> colCodigo;

    @FXML
    private TableColumn<VentaDto, String> colFecha;

    @FXML
    private TableColumn<VentaDto, String> colTotalVenta;

    @FXML
    private TableView<VentaDto> tableVenta;

    @FXML
    private TextField txfCantidad;

    @FXML
    private TextField txfCodigo;

    @FXML
    private TextField txfFechaVenta;

    @FXML
    private TextField txfTotalVenta;

    @FXML
    void buscarVenta(ActionEvent event) {

    }

    @FXML
    void cancelarFiltro(ActionEvent event) {
        recargarInformacion();
    }

    @FXML
    void crearVenta(ActionEvent event) {
        crearVenta();
    }

    @FXML
    void editarVenta(ActionEvent event) {

    }

    @FXML
    void mostrarDetalleVenta(ActionEvent event) {
        main.cargarVentanaDetalleVenta();
    }

    @FXML
    void initialize() {
        tienda = new Tienda();
        ventaControllerService = new VentaController();
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        obtenerDetallesVenta();
        mostrarClientes();
        tableVenta.getItems().clear();
        tableVenta.setItems(listaVentasDto);

    }
    private void initDataBinding() {
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
        colCantidadProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cantidad()));
        colCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cliente().toString()));
        colTotalVenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().total().toString()));
    }
    public void mostrarClientes(){
        cmbListaClientes.setItems(listaClientes);
    }

    private void obtenerClientes() {
        HashMap<String, ClienteDto> clientes = ventaControllerService.obtenerClientes();
        listaClientes.clear();
        listaClientes.addAll(clientes.values());
    }

    public void recargarInformacion(){
        tableVenta.getItems().clear();
        obtenerClientes();
        tableVenta.setItems(listaVentasDto);
    }

    private void crearVenta(){
        VentaDto ventaDto = construirVentaDto();

        if(!listaVentasDto.isEmpty()){
            if(datosValidos(ventaDto)){
                if(ventaControllerService.agregarVenta(ventaDto)){
                    listaVentasDto.add(ventaDto);
                    limpiarCamposVenta();
                    tableVenta.refresh();

                }else{
                    mostrarMensaje("Notificación detalle de venta", "Detalle de venta no creado", "El Detalle de venta no se fue creado", Alert.AlertType.ERROR);
                }
            }else{
                mostrarMensaje("Notificación detalle de venta", "Detalle de venta no creado", "La información es incompleta", Alert.AlertType.ERROR);
            }

        }else {
            mostrarMensaje("Notificación venta", "Venta no creada", "No hay detalles de venta para crear la venta", Alert.AlertType.ERROR);
        }
    }

    private VentaDto construirVentaDto() {
        String codigo = txfCodigo.getText();
        String fecha =  txfFechaVenta.getText();
        Integer total = Integer.valueOf(txfTotalVenta.getText());
        String cantidad = txfCantidad.getText();
        ClienteDto clienteDto = cmbListaClientes.getValue();
        ArrayList<DetalleVentaDto> listaDetalles = new ArrayList<>(ventaControllerService.obtenerDetallesVenta());
        return new VentaDto( fecha, codigo, total, cantidad, clienteDto, listaDetalles);
    }

    private void obtenerDetallesVenta() {
        listaDetallesDto.addAll(ventaControllerService.obtenerDetallesVenta());
    }

    private void limpiarCamposVenta() {
        txfCantidad.setText("");
        txfCodigo.setText("");
        txfTotalVenta.setText("");
        txfFechaVenta.setText("");
    }

    private boolean datosValidos(VentaDto ventaDto) {
        String mensaje = "";

        if(ventaDto.cantidad() == null)
            mensaje += "La cantidad ingresada es invalida \n" ;
        if(ventaDto.codigo() == null)
            mensaje += "El subtotal del detalle agregado es invalido \n" ;
        if(ventaDto.fecha() == null || ventaDto.fecha().isEmpty())
            mensaje += "El producto agregado es invalido \n" ;
        if(ventaDto.cliente() == null)
            mensaje += "El producto agregado es invalido \n" ;
        if(mensaje.isEmpty()){
            return true;
        }else{
            System.out.print("Comprador no creado");
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

}
