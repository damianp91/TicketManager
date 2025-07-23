package com.edu.ignis.Parcial_II.cinema.view;

import java.util.Optional;

import com.edu.ignis.Parcial_II.cinema.controller.PurchaseController;
import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.AvalibleSeatException;
import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.model.Seat;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmationView extends VBox {
  
  public ConfirmationView(Stage stage, Customer customer, ScreenRoom room,
      Seat seat, Cinema cinema) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Confirmation.");
    Label data = new Label("Customer: " + customer.getName()
              + "\nMovie: " + room.getMovie()
              + "\nSala: " + room.getNumber()
              + "\nSeat: row " + seat.getNumber() + " space " + seat.getLine()
    );
    Button btnConfirm = new Button("Confirm");
    
    btnConfirm.setOnAction(e -> {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
        "Are you sure you want to confirm the purchase?",
        ButtonType.YES, ButtonType.NO
      );
      alert.setTitle("Confirm Purchase");
      alert.setHeaderText(null);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.isPresent() && result.get() == ButtonType.YES) {
        try {
          PurchaseController.makePurchase(cinema, customer, room, seat);
          stage.setScene(new Scene(new MenuView(stage, cinema, customer), 400, 400));
        } catch (AvalibleSeatException ase) {
          Alert error = new Alert(Alert.AlertType.ERROR, ase.getMessage(), ButtonType.OK);
          error.setTitle("Error");
          error.setHeaderText(null);
          error.showAndWait();
          stage.setScene(new Scene(new SeatView(stage, cinema, customer, room), 400, 400));
        }
      } else {
        stage.setScene(new Scene(new MenuView(stage, cinema, customer), 400, 400));
      }
    });
    getChildren().addAll(title, data, btnConfirm);
  }
}
