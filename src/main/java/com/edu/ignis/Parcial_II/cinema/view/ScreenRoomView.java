package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScreenRoomView extends VBox {

  public ScreenRoomView(Stage stage, Cinema cinema, Customer customer) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Avalible rooms");
    ListView<ScreenRoom> rooms = new ListView<>();
    Label message = new Label();
    for (ScreenRoom s : cinema.getRooms()) {
      rooms.getItems().add(s);
    }

    Button btnSelect = new Button("Select room");

    btnSelect.setOnAction(e -> {
      ScreenRoom select = rooms.getSelectionModel().getSelectedItem();
      if(select != null) {
        message.setText("Select a place.");
        stage.setScene(new Scene(new SeatView(stage, cinema, customer, select), 800, 600));
      }
      else {
        message.setText("Error: you don't selected sala");
      }
    });

    getChildren().addAll(title, rooms, btnSelect);
  }
}
