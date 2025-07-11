package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.ErrorLoginException;
import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.ExistCustomerException;
import com.edu.ignis.Parcial_II.cinema.model.Cinema;
import com.edu.ignis.Parcial_II.cinema.model.Customer;

public class LoginController {
  
  public static Customer login(String email, String password,
      Cinema cinema) throws ErrorLoginException {
    Customer customer = cinema.findCustomer(email); 
    if(customer == null || !customer.passwordOk(password)) {
      throw new ErrorLoginException("Error in login, name or emal doesn't exist");
    }
    return customer;
  }

  public static void register(String name, String email, String password,
      Cinema cinema) throws ExistCustomerException {
    if(cinema.findCustomer(email) != null) {
      throw new ExistCustomerException("Customer already exists.");
    }
    Customer newCustomer = new Customer(name, email, password);
    cinema.addCustomer(newCustomer);
  }
}
