package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.model.Seat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeatsAvailableView extends VBox {

  public SeatsAvailableView(Stage stage, Cinema cinema, Customer customer) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Seats rooms");
    ListView<ScreenRoom> rooms = new ListView<>();
    Label message = new Label();
    message.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

    GridPane seatGrid = new GridPane();
    seatGrid.setHgap(5);
    seatGrid.setVgap(5);
    seatGrid.setPadding(new Insets(10));

    for (ScreenRoom s : cinema.getRooms()) {
      rooms.getItems().add(s);
    }

    Label screenText = new Label("SCREEN");
    screenText.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

    HBox screenBox = new HBox(screenText);
    screenBox.setAlignment(Pos.CENTER);
    screenBox.setPadding(new Insets(5));
    screenBox.setStyle("-fx-background-color: lightblue; -fx-border-color: gray;");

    Button btnSelect = new Button("Select room");
    Button btnBack = new Button("Back");

    btnSelect.setOnAction(e -> {
      ScreenRoom selected = rooms.getSelectionModel().getSelectedItem();
      seatGrid.getChildren().clear();

      if(selected != null) {
        Seat[][] seats = selected.getSeats();

        for (int i = 0; i < seats.length; i ++) {
          for (int j = 0; j < seats[i].length; j ++) {
            Seat seat = seats[i][j];
            Button btnSeat = new Button((i + 1) + "." + (j + 1));
            btnSeat.setDisable(true);
            btnSeat.setPrefSize(40, 40);
            btnSeat.setStyle(seat.isOccupied() ?
              "-fx-background-color: red" : "-fx-background-color: green"
            );
            seatGrid.add(btnSeat, j, seats.length - 1 - i);
          }
        }
        message.setText("Room selected");
      }
      else {
        message.setStyle("-fx-text-fill: red;");
        message.setText("Error: you didn't select room");
        seatGrid.getChildren().clear();
      }
    });

    btnBack.setOnAction(e -> {
      MenuView back = new MenuView(stage, cinema, customer);
      stage.setScene(new Scene(back, 400, 400));
    });

    getChildren().addAll(title, rooms, btnSelect, seatGrid, screenBox, message, btnBack);
  }
}
