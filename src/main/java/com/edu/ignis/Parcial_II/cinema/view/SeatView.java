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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeatView extends VBox {

  public SeatView(Stage stage, Cinema cinema, Customer customer, ScreenRoom room) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label(room.toString());
    title.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

    GridPane g = new GridPane();
    g.setHgap(5);
    g.setVgap(5);

    Label screenText = new Label("SCREEN");
    screenText.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
    
    // Setting image of screen
    HBox screenBox = new HBox(screenText);
    screenBox.setAlignment(Pos.CENTER);
    screenBox.setPadding(new Insets(5));
    screenBox.setStyle("-fx-background-color: lightblue; -fx-border-color: gray;");

    Seat[][] seats = room.getSeats();
    for(int i = 0; i < seats.length; i ++) {
      for(int j = 0; j < seats[i].length; j++) {
        Seat seat = seats[i][j];
        Button btnSeat = new Button((seat.getRow() + 1) + "." + (seat.getCol() + 1));
        btnSeat.setStyle(seat.isOccupied() ? "-fx-background-color: red;" :
          "-fx-background-color: green;")
        ;
        btnSeat.setPrefWidth(40);
        btnSeat.setPrefHeight(40);

        btnSeat.setOnAction(e -> {
          stage.setScene(new Scene(new ConfirmationView(stage, customer, room,
            seat, cinema))
          );
        });
        g.add(btnSeat, j, seats.length - 1 - i);
      }
    }

    Button btnback = new Button("Back");

    btnback.setOnAction(e -> {
      MenuView back = new MenuView(stage, cinema, customer);
      stage.setScene(new Scene(back, 400, 400));
    });
    getChildren().addAll(title, g, screenBox, btnback);
  }
}
