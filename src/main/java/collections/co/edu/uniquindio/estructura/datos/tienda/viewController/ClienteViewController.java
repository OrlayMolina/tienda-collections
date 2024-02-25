package collections.co.edu.uniquindio.estructura.datos.tienda.viewController;

import collections.co.edu.uniquindio.estructura.datos.tienda.controller.ClienteController;
import collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto.ClienteDto;
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
import java.util.Optional;

public class ClienteViewController {

    Tienda tienda;
    ClienteController clienteControllerService;
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
    ClienteDto clienteDtoSeleccionado;

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private Button btnCancelarFiltro;

    @FXML
    private Button btnCrearCliente;

    @FXML
    private Button btnEditarCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<ClienteDto, String> colApellidos;

    @FXML
    private TableColumn<ClienteDto, String> colDireccion;

    @FXML
    private TableColumn<ClienteDto, String> colNombres;

    @FXML
    private TableColumn<ClienteDto, String> colNumeroIdentificacion;

    @FXML
    private TableView<ClienteDto> tableClientes;

    @FXML
    private TextField txfApellidos;

    @FXML
    private TextField txfDireccion;

    @FXML
    private TextField txfNombres;

    @FXML
    private TextField txfNumeroIdentificacion;

    @FXML
    void buscarCliente(ActionEvent event) {

    }

    @FXML
    void cancelarFiltro(ActionEvent event) {

    }

    @FXML
    void crearCliente(ActionEvent event) {
        crearCliente();
    }

    @FXML
    void editarCliente(ActionEvent event) {

    }

    @FXML
    void initialize() {
        tienda = new Tienda();
        clienteControllerService = new ClienteController();
        initView();

    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        listaClientes.clear();
        tableClientes.setItems(listaClientes);
        listenerSelection();
    }
    private void initDataBinding() {
        colNumeroIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numeroIdentificacion()));
        colNombres.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        colApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
    }

    private void listenerSelection() {
        tableClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteDtoSeleccionado = newSelection;
            mostrarInformacionCliente(clienteDtoSeleccionado);
        });
    }

    private void crearCliente() {

        ClienteDto clienteDto = construirClienteDto();

        if(datosValidos(clienteDto)){
            if(clienteControllerService.agregarCliente(clienteDto)){
                listaClientes.add(clienteDto);
                limpiarCamposClientes();

            }else{
                mostrarMensaje("Notificación cliente", "Cliente no creado", "El Cliente no se fue creado", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación cliente", "Cliente no creado", "La información es incompleta", Alert.AlertType.ERROR);
        }

    }

    private void obtenerClientes() {
        HashMap<String, ClienteDto> clientes = clienteControllerService.obtenerClientes();
        listaClientes.clear();
        listaClientes.addAll(clientes.values());
    }

    private void limpiarCamposClientes() {
        txfNumeroIdentificacion.setText("");
        txfNombres.setText("");
        txfApellidos.setText("");
        txfDireccion.setText("");
    }

    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txfNumeroIdentificacion.setText(clienteSeleccionado.numeroIdentificacion());
            txfNombres.setText(clienteSeleccionado.nombre());
            txfApellidos.setText(clienteSeleccionado.apellido());
            txfDireccion.setText(clienteSeleccionado.direccion());

        }
    }

    private ClienteDto construirClienteDto() {
        String numeroIdentificacion = txfNumeroIdentificacion.getText();
        String nombre = txfNombres.getText();
        String apellido = txfApellidos.getText();
        String direccion = txfDireccion.getText();
        return new ClienteDto(numeroIdentificacion, nombre, apellido, direccion);
    }

    private boolean datosValidos(ClienteDto clienteDto) {
        String mensaje = "";

        if(clienteDto.numeroIdentificacion() == null || clienteDto.numeroIdentificacion().equals(""))
            mensaje += "El documento del cliente es invalido \n" ;
        if(clienteDto.nombre() == null || clienteDto.nombre() .equals(""))
            mensaje += "Los nombres del cliente es invalido \n" ;
        if(clienteDto.apellido() == null || clienteDto.apellido() .equals(""))
            mensaje += "los apellidos del cliente es invalido \n" ;
        if(clienteDto.direccion() == null || clienteDto.direccion() .equals(""))
            mensaje += "La direccion del cliente es invalida \n" ;

        if(mensaje.equals("")){
            return true;
        }else{
            System.out.print("Comprador no creado");
            return false;
        }
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
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
