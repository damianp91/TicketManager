package com.edu.ignis.Parcial_II.cinema.view;

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
    Label data = new Label( customer.toString()
              + "\n" + room.toString()
              + "\n" + seat.toString()
    );
    Button btnConfirm = new Button("Confirm");
    Button btnCancel = new Button("Cancel");
    Label message = new Label();

    btnConfirm.setOnAction(e -> {
      try {
        PurchaseController.makePurchase(cinema, customer, room, seat);
        message.setText("Your purcahse was successfull!");
        stage.setScene(new Scene(new MenuView(stage, cinema, customer), 400, 400));
      } catch (AvalibleSeatException ase) {
        Alert error = new Alert(Alert.AlertType.ERROR, ase.getMessage(), ButtonType.OK);
        error.setTitle("Error");
        error.setHeaderText(null);
        error.showAndWait();
        stage.setScene(new Scene(new SeatView(stage, cinema, customer, room), 400, 400));
      }
    });

    btnCancel.setOnAction(e -> {
      message.setText("Your purchase was canceled!");
      MenuView back = new MenuView(stage, cinema, customer);
      stage.setScene(new Scene(back, 400, 400));
    });
    getChildren().addAll(title, data, btnConfirm, btnCancel);
  }
}
