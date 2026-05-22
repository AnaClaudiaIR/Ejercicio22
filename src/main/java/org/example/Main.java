package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Botón para mostrar texto");

        //Cuadrícula
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Opción 1", "Opción 2", "Opción 3", "Opción 4");
        grid.add(comboBox,0,1);

        Label texto = new Label("Escoger opción");
        grid.add(texto, 0, 0);

        Button boton = new Button("Aceptar");
        grid.add(boton, 1, 1);

        boton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //Mensaje de confirmación
            alert.setTitle("Confirmar operación");
            alert.setHeaderText("¿Desea mostrar este texto?");
            alert.setContentText("Confirmar acción");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    System.out.println("Opción elegida --> "+comboBox.getValue());
                } else {
                    System.out.println("Operación cancelada.");
                }
            });

        });

        Scene scene = new Scene(grid, 270, 100);
        stage.setScene(scene);
        stage.show();

    }
}
