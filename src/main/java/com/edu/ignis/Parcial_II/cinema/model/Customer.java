package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
  private String name;
  private String email;
  private String passsword;

  public Customer(String name, String email, String passsword) {
    this.name = name;
    this.email = email;
    this.passsword = passsword;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  private String getPass() {
    return passsword;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, passsword);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Customer other = (Customer) obj;
    return Objects.equals(email, other.getEmail()) &&
      Objects.equals(passsword, other.getPass()
    );
  }

  @Override
  public String toString() {
    return "Customer [name: " + name + ", email: " + email + "]";
  }
}
