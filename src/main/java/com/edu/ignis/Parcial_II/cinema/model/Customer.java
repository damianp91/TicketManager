package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
  private String name;
  private String email;
  private String password;

  /** 
   * Constructs a new Customer object with the specified name, email, and password.
   * @param name the name of the customer
   * @param email the email of the customer
   * @param passsword the password of the customer
   */
  public Customer(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  } 

  /**
   * Retrieves the name of the customer.
   * @return the name of the customer
   */
  public String getName() {
    return name.toUpperCase();
  }

  /**
   * Retrieves the email of the customer.
   * @return the email of the customer
   */
  public String getEmail() {
    return email.toLowerCase();
  }

  /**
   * Retrieves the password of the customer.
   * @return the password of the customer
   */
  private String getPass() {
    return password;
  }

  /**
     * Checks if the provided password matches the customer's password.
     * @param pass the password to check
     * @return true if the password matches, false otherwise
     */
  public boolean passwordOk(String pass) {
    return getPass().equals(pass);
  }

  /**
   * Generates a hash code for the customer based on their email and password.
   * @return the hash code for the customer
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }

  /**
   * Determines whether this customer is equal to another object.
   * @param obj the object to compare
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Customer other = (Customer) obj;
    return Objects.equals(name, other.getName()) &&
    Objects.equals(email, other.getEmail()
    );
  }

  /**
   * Returns a string representation of the customer.
   * @return a string representation of the customer
   */
  @Override
  public String toString() {
    return "Customer: " + getName() + ", Email: " + getEmail();
  }
}
