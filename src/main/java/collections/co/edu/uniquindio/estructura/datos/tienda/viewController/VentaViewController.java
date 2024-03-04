package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import collections.co.edu.uniquindio.estructura.datos.tienda.Main;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.ClienteController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.VentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.VentaDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Cliente;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Collection;
import java.util.HashMap;

public class VentaViewController {

    Tienda tienda;
    VentaController ventaControllerService;
    ObservableList<VentaDto> listaVentasDto = FXCollections.observableArrayList();
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
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
    private TableColumn<VentaDto, Integer> colTotalVenta;

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
        mostrarClientes();
        tableVenta.getItems().clear();
        tableVenta.setItems(listaVentasDto);

    }
    private void initDataBinding() {
        colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        colCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
        colCantidadProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cantidad()));
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
        if(!listaVentasDto.isEmpty()){
            mostrarMensaje("Notificación venta", "Venta creada", "Hay detalles", Alert.AlertType.ERROR);
        }else {
            mostrarMensaje("Notificación venta", "Venta no creada", "No hay detalles de venta para crear la venta", Alert.AlertType.ERROR);
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
