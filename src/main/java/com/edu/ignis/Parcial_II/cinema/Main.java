package com.edu.ignis.Parcial_II.cinema;

import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
  // Customer c1 = new Customer("d", "d@g", "1234");
  // Customer c2 = new Customer("d", "d@g", "1254");

  ScreenRoom room = new ScreenRoom(1, "Matrix", 4, 5);

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    // Label label = new Label("¡Hello world from JavaFX! ");
    Label label = new Label(room.showRoom());
    Scene scene = new Scene(label, 400, 200);
    stage.setScene(scene);
    stage.setTitle("JavaFX Project:Parcial_II");
    stage.show();
  }
}
