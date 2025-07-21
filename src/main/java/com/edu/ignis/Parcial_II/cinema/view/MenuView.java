package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView extends VBox {

  public MenuView(Stage stage, Cinema cinema, Customer customer) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));
    // Customer customer = LoginController.login(email, pass, cinema);
    // message.setText("Welcome " + customer.getName());
    // stage.setScene(new Scene(new ScreenRoomView(stage, cinema, customer)));
    // Menu
    Label title = new Label("OPTIONS");
    Button btnBuy = new Button("Buy");
    Button btnTickets = new Button("Tickets");
    Button btnExit = new Button("Exit");

    btnBuy.setOnAction(e -> {
      // aca va logica de compra boleto
    });

    btnTickets.setOnAction(e -> {
      // aca va logica de tickets comprados
    });

    // Exit
    btnExit.setOnAction(e -> {
      LoginView back = new LoginView(stage, cinema);
      stage.setScene(new Scene(back));
    });
    getChildren().addAll(title, btnBuy, btnTickets, btnExit);
  }
}
