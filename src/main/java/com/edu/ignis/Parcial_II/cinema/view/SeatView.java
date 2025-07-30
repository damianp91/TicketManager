package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.model.Seat;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeatView extends VBox {

  public SeatView(Stage stage, Cinema cinema, Customer customer, ScreenRoom room) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label(room.toString());
    GridPane g = new GridPane();
    g.setHgap(5);
    g.setVgap(5);

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
          System.out.println("fila: " + (seat.getRow() + 1) + "columna: " +
            (seat.getCol() + 1))
          ;
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
    getChildren().addAll(title, g, btnback);
  }
}
