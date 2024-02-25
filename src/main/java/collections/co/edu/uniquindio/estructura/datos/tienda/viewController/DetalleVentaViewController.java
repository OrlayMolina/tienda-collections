package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import collections.co.edu.uniquindio.estructura.datos.tienda.controller.ClienteController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.DetalleVentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.controller.VentaController;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ProductoDto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;

public class DetalleVentaViewController {

    Tienda tienda;
    DetalleVentaController detalleVentaControllerService;
    ObservableList<ProductoDto> listaProductos = FXCollections.observableArrayList();

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
    private TableColumn<?, ?> colCantidad;

    @FXML
    private TableColumn<?, ?> colProducto;

    @FXML
    private TableColumn<?, ?> colSubtotal;

    @FXML
    private TableView<?> tableDetalles;

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

        obtenerProductos();
        mostrarProductos();

    }

    public void mostrarProductos(){
        cmbProductos.setItems(listaProductos);
    }

    private void obtenerProductos() {
        HashMap<String, ProductoDto> clientes = detalleVentaControllerService.obtenerProductos();
        listaProductos.clear();
        listaProductos.addAll(clientes.values());
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

}
