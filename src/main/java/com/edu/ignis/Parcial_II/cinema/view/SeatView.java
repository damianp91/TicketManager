package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.model.Seat;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeatView extends VBox {

  public SeatView(Stage stage, Cinema cinema, Customer customer, ScreenRoom room) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Seats - Sala" + room.getNumber() + " - " + room.getMovie());
    GridPane g = new GridPane();
    g.setHgap(5);
    g.setVgap(5);

    // Panel inferior con información
    Label screenLabel = new Label("SCREEN");
    screenLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

    // getChildren().addAll(title, seatsGrid, screenLabel);
  }

}
