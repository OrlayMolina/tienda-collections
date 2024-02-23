package collections.co.edu.uniquindio.estructura.datos.tienda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

    public static void main(String[] args) {
        launch();
    }
}