package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import collections.co.edu.uniquindio.estructura.datos.tienda.controller.ClienteController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.DetalleVentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.VentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.DetalleVentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class DetalleVentaViewController {

    Tienda tienda;
    DetalleVentaController detalleVentaControllerService;
    ObservableList<DetalleVentaDto> listaDetalles= FXCollections.observableArrayList();
    ObservableList<ProductoDto> listaProductos = FXCollections.observableArrayList();
    DetalleVentaDto detalleVentaDtoSeleccionado;

    @FXML
    private Button btnAceptarDetalle;

    @FXML
    private Button btnCancelarDetalle;

    @FXML
    private Button btnAgregarCarrito;

    @FXML
    private Button btnAgregarDetalle;

    @FXML
    private Button btnEditarDetalle;

    @FXML
    private Button btnEliminarDetalle;

    @FXML
    private ComboBox<ProductoDto> cmbProductos;

    @FXML
    private TableColumn<DetalleVentaDto, String> colCantidad;

    @FXML
    private TableColumn<DetalleVentaDto, String> colProducto;

    @FXML
    private TableColumn<DetalleVentaDto, String> colSubtotal;

    @FXML
    private TableView<DetalleVentaDto> tableDetalles;

    @FXML
    private TextField txfCantidad;

    @FXML
    private TextField txfSubtotal;

    @FXML
    void aceptarDetalle(ActionEvent event) {
        cerrarVentana(btnAceptarDetalle);
    }

    @FXML
    void agregarCarritoCliente(ActionEvent event) {

    }

    @FXML
    void agregarDetalle(ActionEvent event) {
        agregarDetalle();
    }

    @FXML
    void cancelar(ActionEvent event) {
        cerrarVentana(btnCancelarDetalle);
    }

    @FXML
    void editarDetalle(ActionEvent event) {

    }

    @FXML
    void eliminarDetalle(ActionEvent event) {

    }

    @FXML
    void initialize() {
        tienda = new Tienda();
        detalleVentaControllerService = new DetalleVentaController();
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

    private void initDataBinding() {
        colProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().producto().toString()));
        colCantidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cantidad().toString()));
        colSubtotal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().subtotal().toString()));

    }

    private void listenerSelection() {
        tableDetalles.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            detalleVentaDtoSeleccionado = newSelection;
            mostrarInformacionDetalle(detalleVentaDtoSeleccionado);
        });
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
        String codigo = "";
        ProductoDto productodto = cmbProductos.getValue();
        Integer cantidad = Integer.valueOf(txfCantidad.getText());
        Integer subtotal = productodto.precio() * cantidad;
        txfSubtotal.setText(String.valueOf(subtotal));
        return new DetalleVentaDto( codigo, cantidad, subtotal, productodto);
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
