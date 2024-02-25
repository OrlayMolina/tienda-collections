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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    }

    @FXML
    void crearVenta(ActionEvent event) {

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
        listaClientes.add(new ClienteDto("1094952205", "Orlay Andrés", "Molina Gómez", "Mza 2 casa 24, Los Quindos"));
    }

}
