package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.ErrorLoginException;
import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.ExistCustomerException;
import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;

public class LoginController {

  /**
     * Authenticates a customer based on their email and password.
     *
     * @param email    the email address of the customer
     * @param password the password of the customer
     * @param cinema   the cinema system where the customer is registered
     * @return the authenticated Customer object
     * @throws ErrorLoginException if the email is not found or the password is incorrect
     */
  public static Customer login(String email, String password, Cinema cinema)
  throws ErrorLoginException {
    Customer customer = cinema.findCustomerByEmail(email); 
    if(customer == null) {
      throw new ErrorLoginException("User not found. Please register first.");
    }
    else if(!customer.passwordOk(password)) {
      throw new ErrorLoginException("Login failed: invalid email or password.");
    }
    return customer;
  }

  /**
     * Registers a new customer into the cinema system.
     *
     * @param name     the name of the new customer
     * @param email    the email address of the new customer
     * @param password the password for the new customer
     * @param cinema   the cinema system where the customer will be registered
     * @throws ExistCustomerException if a customer with the same email already exists
     */
  public static void register(String name, String email, String password,
    Cinema cinema) throws ExistCustomerException {
    if(cinema.findCustomerByEmail(email) != null) {
      throw new ExistCustomerException("Customer already exists.");
    }
    Customer newCustomer = new Customer(name, email, password);
    cinema.addCustomer(newCustomer);
  }
}
