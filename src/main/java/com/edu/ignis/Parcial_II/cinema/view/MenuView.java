package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView extends VBox {

  public MenuView(Stage stage, Cinema cinema, Customer customer) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));
    setAlignment(Pos.CENTER);

    // Menu
    Label message = new Label();
    message.setText("Welcome " + customer.getName());
    Label title = new Label("TICKET MANAGER");
    Button btnBuy = new Button("Buy");
    btnBuy.setPrefWidth(120);
    Button btnSeatsAvailable = new Button("Seats Available");
    btnSeatsAvailable.setPrefWidth(120);
    Button btnTickets = new Button("Tickets");
    btnTickets.setPrefWidth(120);
    Button btnExit = new Button("Exit");
    btnExit.setPrefWidth(120);
  
    btnBuy.setOnAction(e -> {
      ScreenRoomView buy = new ScreenRoomView(stage, cinema, customer);
      stage.setScene(new Scene(buy, 400, 400));
    });

    btnSeatsAvailable.setOnAction(e -> {
      SeatsAvailableView available = new SeatsAvailableView(stage, cinema, customer);
      stage.setScene(new Scene(available, 400, 400));
    });

    btnTickets.setOnAction(e -> {
      PurchasedTicketsView tickets = new PurchasedTicketsView(stage, cinema, customer);
      stage.setScene(new Scene(tickets, 400, 400));
    });

    // Exit
    btnExit.setOnAction(e -> {
      LoginView back = new LoginView(stage, cinema);
      stage.setScene(new Scene(back, 400, 400));
    });
    getChildren().addAll(title, message, btnBuy, btnSeatsAvailable, btnTickets, btnExit);
  }
}
