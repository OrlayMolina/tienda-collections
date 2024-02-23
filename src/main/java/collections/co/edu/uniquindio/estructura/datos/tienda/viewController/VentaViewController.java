package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VentaViewController {

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
    private ComboBox<?> cmbListaClientes;

    @FXML
    private TableColumn<?, ?> colCantidadProducto;

    @FXML
    private TableColumn<?, ?> colCliente;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colTotalVenta;

    @FXML
    private TableView<?> tableVenta;

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

    }

}
