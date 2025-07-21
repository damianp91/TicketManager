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

    Label title = new Label("Seats - Sala" + room.getNumber() + " - " + room.getMovie());
    GridPane g = new GridPane();
    g.setHgap(5);
    g.setVgap(5);

    Seat[][] seats = room.getSeats();
    for(int i = 0; i < seats.length; i ++) {
      for(int j = 0; j < seats[i].length; j++) {
        Seat seat = seats[i][j];
        Button btnSeat = new Button(seat.getNumber() + "");
        btnSeat.setDisable(seat.isOccupied());
        btnSeat.setStyle(seat.isOccupied() ? "-fx-background-color: red;" : "-fx-background-color: green;");

        btnSeat.setOnAction(e -> {
          stage.setScene(new Scene(new ConfirmationView(stage, customer, room, seat, cinema)));
        });
        g.add(btnSeat, j, i);
      }
    }
    
    Button btnback = new Button("Back");

    btnback.setOnAction(e -> {
      LoginView back = new LoginView(stage, cinema);
      stage.setScene(new Scene(back));
    });
    getChildren().addAll(title, g);
  }
}
