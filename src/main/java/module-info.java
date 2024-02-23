module collections.co.edu.uniquindio.estructura.datos.tienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;
    requires java.logging;
    requires java.desktop;


    opens collections.co.edu.uniquindio.estructura.datos.tienda to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda;
    opens collections.co.edu.uniquindio.estructura.datos.tienda.models to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda.models;
    opens collections.co.edu.uniquindio.estructura.datos.tienda.viewController to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda.viewController;
    opens collections.co.edu.uniquindio.estructura.datos.tienda.controller to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda.controller;
    opens collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda.mapping.dto;
    opens collections.co.edu.uniquindio.estructura.datos.tienda.mapping.mappers to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda.mapping.mappers;
    opens collections.co.edu.uniquindio.estructura.datos.tienda.exceptions to javafx.fxml;
    exports collections.co.edu.uniquindio.estructura.datos.tienda.exceptions;
}