package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import collections.co.edu.uniquindio.estructura.datos.tienda.Main;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.DetalleVentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.VentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class VentaViewController {

    Tienda tienda;
    VentaController ventaControllerService;
    DetalleVentaController detalleVentaControllerService;
    ObservableList<VentaDto> listaVentasDto = FXCollections.observableArrayList();
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
    ObservableList<DetalleVentaDto> listaDetalles= FXCollections.observableArrayList();
    ObservableList<ProductoDto> listaProductos = FXCollections.observableArrayList();
    DetalleVentaDto detalleVentaDtoSeleccionado;
    VentaDto ventaDtoSeleccionado;

    @FXML
    private Button btnAgregarCarrito;

    @FXML
    private Button btnAgregarDetalle;

    @FXML
    private Button btnBuscarVenta;

    @FXML
    private Button btnCancelarFiltro;

    @FXML
    private Button btnCrearVenta;

    @FXML
    private Button btnEditarVenta;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnEliminarDetalle;

    @FXML
    private ComboBox<ClienteDto> cmbListaClientes;

    @FXML
    private ComboBox<ProductoDto> cmbProductos;

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
    private TableView<DetalleVentaDto> tableDetalles;

    @FXML
    private TableColumn<DetalleVentaDto, String> colProducto;

    @FXML
    private TableColumn<DetalleVentaDto, String> colCantidad;

    @FXML
    private TableColumn<DetalleVentaDto, String> colSubtotal;

    @FXML
    private TextField txfCantidad;

    @FXML
    private TextField txfCantidadProductos;

    @FXML
    private TextField txfCodigo;

    @FXML
    private TextField txfFechaVenta;

    @FXML
    private TextField txfSubtotal;

    @FXML
    private TextField txfTotalVenta;

    @FXML
    void agregarCarritoCliente(ActionEvent event) {

    }

    @FXML
    void agregarDetalle(ActionEvent event) {
        agregarDetalle();
    }

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
    void eliminarDetalle(ActionEvent event) {

    }

    @FXML
    void initialize() {
        tienda = new Tienda();
        detalleVentaControllerService = new DetalleVentaController();
        ventaControllerService = new VentaController();
        txfCodigo.setEditable(false);
        txfCodigo.setText(UUID.randomUUID().toString());
        initViewVenta();
        initView();

    }

    private void initView() {
        initDataBinding();
        txfSubtotal.setEditable(false);
        obtenerProductos();
        obtenerDetallesVenta();
        mostrarProductos();
        listaDetalles.clear();
        tableDetalles.setItems(listaDetalles);
        listenerSelection();
    }

    private void initViewVenta() {
        initDataBindingVenta();
        obtenerClientes();
        mostrarClientes();
        tableVenta.getItems().clear();
        tableVenta.setItems(listaVentasDto);
        listenerSelectionVentas();
    }

    private void initDataBinding() {
        colProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().producto().toString()));
        colCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cantidad().toString()));
        colSubtotal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().subtotal().toString()));

    }

    private void initDataBindingVenta() {
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
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

    private void listenerSelection() {
        tableDetalles.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            detalleVentaDtoSeleccionado = newSelection;
            mostrarInformacionDetalle(detalleVentaDtoSeleccionado);
        });
    }

    private void listenerSelectionVentas() {
        tableVenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            ventaDtoSeleccionado = newSelection;
            mostrarInformacionVenta(ventaDtoSeleccionado);
        });
    }

    private void mostrarInformacionVenta(VentaDto ventaDtoSeleccionado) {
        if(ventaDtoSeleccionado != null){
            txfCodigo.setText(ventaDtoSeleccionado.codigo());
            txfFechaVenta.setText(ventaDtoSeleccionado.fecha());
        }
    }

    private void agregarDetalle() {

        DetalleVentaDto detalleVentaDto = construirDetalleVentaDto();

        if(datosValidos(detalleVentaDto)){
            if(detalleVentaControllerService.agregarDetalleVenta(detalleVentaDto)){
                listaDetalles.add(detalleVentaDto);
                limpiarCamposDetalle();
                tableDetalles.refresh();

            }else{
                mostrarMensaje("Notificación detalle de venta", "Detalle de venta no creado", "El Detalle de venta no se fue creado", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación detalle de venta", "Detalle de venta no creado", "La información es incompleta", Alert.AlertType.ERROR);
        }

    }

    public void recargarInformacion(){
        tableVenta.getItems().clear();
        obtenerClientes();
        tableVenta.setItems(listaVentasDto);
    }

    private void crearVenta(){

        if(!listaDetalles.isEmpty()){

            VentaDto ventaDto = construirVentaDto();
            if(datosValidosVenta(ventaDto)){
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

    private void limpiarCamposVenta() {
        txfCantidad.setText("");
        txfCodigo.setText("");
        txfTotalVenta.setText("");
        txfFechaVenta.setText("");
    }

    private boolean datosValidosVenta(VentaDto ventaDto) {
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

    public void mostrarProductos(){
        cmbProductos.setItems(listaProductos);
    }

    private void obtenerProductos() {
        HashMap<String, ProductoDto> productos = detalleVentaControllerService.obtenerProductos();
        listaProductos.clear();
        listaProductos.addAll(productos.values());
    }

    private void obtenerDetallesVenta() {
        listaDetalles.addAll(detalleVentaControllerService.obtenerDetallesVenta());
    }

    private DetalleVentaDto construirDetalleVentaDto() {
        ProductoDto productodto = cmbProductos.getValue();
        Integer cantidad = Integer.valueOf(txfCantidad.getText());
        Integer subtotal = productodto.precio() * cantidad;
        txfSubtotal.setText(String.valueOf(subtotal));
        return new DetalleVentaDto( cantidad, subtotal, productodto);
    }

    private void limpiarCamposDetalle() {
        txfCantidad.setText("");
        txfSubtotal.setText("");
        cmbProductos.setValue(null);
    }

    private void mostrarInformacionDetalle(DetalleVentaDto detalleVentaDtoSeleccionado) {
        if(detalleVentaDtoSeleccionado != null){
            cmbProductos.setValue(detalleVentaDtoSeleccionado.producto());
            txfCantidad.setText(detalleVentaDtoSeleccionado.cantidad().toString());
            txfSubtotal.setText(detalleVentaDtoSeleccionado.subtotal().toString());


        }
    }

    private boolean datosValidos(DetalleVentaDto detalleVentaDto) {
        String mensaje = "";

        if(detalleVentaDto.cantidad() == null)
            mensaje += "La cantidad ingresada es invalida \n" ;
        if(detalleVentaDto.subtotal() == null)
            mensaje += "El subtotal del detalle agregado es invalido \n" ;
        if(detalleVentaDto.producto() == null || detalleVentaDto.producto() .equals(""))
            mensaje += "El producto agregado es invalido \n" ;

        if(mensaje.isEmpty()){
            return true;
        }else{
            System.out.print("Comprador no creado");
            return false;
        }
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

}
