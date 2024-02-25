package collections.co.edu.uniquindio.estructura.datos.tienda;

import collections.co.edu.uniquindio.estructura.datos.tienda.models.Cliente;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Producto;
import collections.co.edu.uniquindio.estructura.datos.tienda.models.Tienda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tabulador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Tienda la U");
        String rutaRelativa = "/collections/co/edu/uniquindio/estructura/datos/tienda/img/logo.png";
        Image iconImage = new Image(Objects.requireNonNull(getClass().getResource(rutaRelativa)).toExternalForm());
        stage.getIcons().add(iconImage);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void cargarVentanaDetalleVenta() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("detalle-venta-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            String rutaRelativa = "/collections/co/edu/uniquindio/estructura/datos/tienda/img/logo.png";
            Image iconImage = new Image(Objects.requireNonNull(getClass().getResource(rutaRelativa)).toExternalForm());
            newStage.getIcons().add(iconImage);
            newStage.setTitle("Subastas Quindío | Inicio");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch();
    }
}