package com.edu.ignis.Parcial_II.cinema.view;

import java.util.ArrayList;
import java.util.List;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;
import com.edu.ignis.Parcial_II.cinema.model.Ticket;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PurchasedTicketsView extends VBox {

  public PurchasedTicketsView(Stage stage, Cinema cinema, Customer customer) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));
    
    Label title = new Label("Your tickets:");
    title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    
    Label name = new Label(customer.toString());
    List<Ticket> tickets = new ArrayList<>();
    for (Ticket t : cinema.getTickets() ) {
      String email = t.getCustomer().getEmail(); 
      if(email.equals(customer.getEmail())) {
        tickets.add(t);
      } 
    }
    
    Node ticketsList;

    if (tickets.isEmpty()) {
      ticketsList = new Label("There aren't any tickets purchased");
    }
    else {
      ListView<Ticket> list = new ListView<>();
      list.getItems().addAll(tickets);
      ticketsList = list;
    }

    Button btnBack = new Button("Back");

    btnBack.setOnAction(e -> {
      MenuView back = new MenuView(stage, cinema, customer);
      stage.setScene(new Scene(back, 400, 400));
    });
    getChildren().addAll(title, name, ticketsList, btnBack);
  }
}
