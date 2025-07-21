package com.edu.ignis.Parcial_II.cinema.view;

import com.edu.ignis.Parcial_II.cinema.controller.LoginController;
import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.ErrorLoginException;
import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.ExistCustomerException;
import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends VBox {
  public LoginView(Stage stage, Cinema cinema) {
    setSpacing(10);
    setPadding(new javafx.geometry.Insets(20));

    // User
    Label lbName = new Label("Name: ");
    TextField fieldName = new TextField();
    Label lbEmail = new Label("Email: ");
    TextField fieldEmail = new TextField();
    Label lbPassword = new Label("Password: ");
    PasswordField fieldPassword = new PasswordField();

    // Buttoms
    Button btnLogin = new Button("Sign in");
    Button btnRegister = new Button("Register");

    Label message = new Label();

    btnLogin.setOnAction(e -> {
      String email = fieldEmail.getText();
      String pass = fieldPassword.getText();
      try {
        if (email.isEmpty() || pass.isEmpty()) {
          message.setText("Email and password required.");
          return;
        }
        Customer customer = LoginController.login(email, pass, cinema);
        message.setText("Welcome " + customer.getName());
        stage.setScene(new Scene(new MenuView(stage, cinema, customer)));
      } catch (ErrorLoginException elx) {
        message.setText(elx.getMessage());
      }
    });

    btnRegister.setOnAction(e -> {
      String name = fieldName.getText();
      String email = fieldEmail.getText();
      String pass = fieldPassword.getText();
      try {
        if (email.isEmpty() || pass.isEmpty()) {
          message.setText("Email and password required.");
          return;
        }
        LoginController.register(name, email, pass, cinema);
        message.setText("Succesful register.");
      } catch (ExistCustomerException ece) {
        message.setText(ece.getMessage());
      }
    });
    
    getChildren().addAll(lbName, fieldName, lbEmail, fieldEmail, lbPassword,
      fieldPassword, btnLogin, btnRegister, message
    );
  }
}
