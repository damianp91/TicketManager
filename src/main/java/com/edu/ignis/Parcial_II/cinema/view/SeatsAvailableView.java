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

public class SeatsAvailableView extends VBox {

  public SeatsAvailableView(Stage stage, Cinema cinema, Customer customer) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    Label title = new Label("Seats rooms");
    ListView<ScreenRoom> rooms = new ListView<>();
    Label message = new Label();

    Label roomDetails = new Label();
    roomDetails.setStyle("-fx-font-family: monospace;");

    for (ScreenRoom s : cinema.getRooms()) {
      rooms.getItems().add(s);
    }

    Button btnSelect = new Button("Select room");
    Button btnBack = new Button("Back");

    btnSelect.setOnAction(e -> {
      ScreenRoom selected = rooms.getSelectionModel().getSelectedItem();
      if(selected != null) {
        roomDetails.setText(selected.showRoom());
        message.setText("Room selected");
      }
      else {
        message.setText("Error: you didn't select room");
        roomDetails.setText("");
      }
    });

    btnBack.setOnAction(e -> {
      stage.setScene(new Scene(new MenuView(stage, cinema, customer)));
    });

    getChildren().addAll(title, rooms, btnSelect, roomDetails, message, btnBack);
  }
}
