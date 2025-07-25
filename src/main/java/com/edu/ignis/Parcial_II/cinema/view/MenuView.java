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

    // Menu
    Label message = new Label();
    message.setText("Welcome " + customer.getName());
    Label title = new Label("OPTIONS");
    Button btnBuy = new Button("Buy");
    Button btnSeatsAvailable = new Button("Seats Available");
    Button btnTickets = new Button("Tickets");
    Button btnExit = new Button("Exit");

    btnBuy.setOnAction(e -> {
      ScreenRoomView buy = new ScreenRoomView(stage, cinema, customer);
      stage.setScene(new Scene(buy));
    });

    btnSeatsAvailable.setOnAction(e -> {
      SeatsAvailableView available = new SeatsAvailableView(stage, cinema, customer);
      stage.setScene(new Scene(available));
    });  

    btnTickets.setOnAction(e -> {
      PurchasedTicketsView tickets = new PurchasedTicketsView(stage, cinema, customer);
      stage.setScene(new Scene(tickets));
    });

    // Exit
    btnExit.setOnAction(e -> {
      LoginView back = new LoginView(stage, cinema);
      stage.setScene(new Scene(back));
    });
    getChildren().addAll(message, title, btnBuy, btnSeatsAvailable, btnTickets, btnExit);
  }
}
