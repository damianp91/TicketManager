package com.edu.ignis.Parcial_II.cinema;


import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.persistence.DataPersistense;
import com.edu.ignis.Parcial_II.cinema.view.LoginView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  private Cinema cinema;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    try {
      cinema = DataPersistense.load();
    } catch (Exception e) {
      cinema = new Cinema();
    }

    if(cinema.getRooms().isEmpty()) {
      cinema.addRoom(new ScreenRoom(1, "Matix", 4, 5));
      cinema.addRoom(new ScreenRoom(2, "StarWars", 4, 5));
    }

    LoginView login = new LoginView(primaryStage, cinema);
    Scene scene = new Scene(login, 400, 400);
    primaryStage.setTitle("Cine App");
    primaryStage.setScene(scene);
    primaryStage.setOnCloseRequest(e -> DataPersistense.save(cinema));
    primaryStage.show();
  }
}
