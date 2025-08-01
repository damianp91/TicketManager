package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.controller.PurchaseController;
import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.AvalibleSeatException;
import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.model.Seat;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ConfirmationView extends VBox {

  public ConfirmationView(Stage stage, Customer customer, ScreenRoom room,
      Seat seat, Cinema cinema) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Confirmation.");
    title.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
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
        message.setStyle("-fx-text-fill: green;");
        message.setText("Your purcahse was successfull!");
        PauseTransition pause = new PauseTransition(Duration.seconds(1.9));
        pause.setOnFinished(ev -> {
          stage.setScene(new Scene(new MenuView(stage, cinema, customer), 400, 400));
        });
        pause.play();
      } catch (AvalibleSeatException ase) {
        Alert error = new Alert(Alert.AlertType.ERROR, ase.getMessage(), ButtonType.OK);
        error.setTitle("Error");
        error.setHeaderText(null);
        error.showAndWait();
        stage.setScene(new Scene(new SeatView(stage, cinema, customer, room), 400, 400));
      }
    });

    btnCancel.setOnAction(e -> {
      message.setStyle("-fx-text-fill: red;");
      message.setText("Your purchase was canceled!");
      PauseTransition pause = new PauseTransition(Duration.seconds(1.9));
      pause.setOnFinished(ev -> {
        MenuView back = new MenuView(stage, cinema, customer);
        stage.setScene(new Scene(back, 400, 400));
      });
      pause.play();
    });

    HBox btnBox = new HBox(10, btnConfirm, btnCancel);
    btnBox.setAlignment(Pos.CENTER);

    getChildren().addAll(title, data, btnBox, message);
  }
}
