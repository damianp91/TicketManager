package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Cinema with screen rooms and tickets.
 */
public class Cinema implements Serializable {
  private List<ScreenRoom> rooms;
  private List<Ticket> tickets;
  private List<Customer> customers;

  /**
   * Constructs a Cinema object with empty lists for screen rooms and tickets.
   */
  public Cinema() {
    this.rooms = new ArrayList<>();
    this.tickets = new ArrayList<>();
    this.customers = new ArrayList<>();
  }

  /** 
   * Retrieves the list of screen rooms in the cinema.
   * @return a List of ScreenRoom objects
   */
  public List<ScreenRoom> getRooms() {
    return rooms;
  }

  /** 
   * Retrieves the list of tickets issued by the cinema.
   * @return a List of Ticket objects
   */
  public List<Ticket> getTickets() {
    return tickets;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  /**
   * Adds a new screen room to the cinema.
   * @param room the ScreenRoom object to add
   */
  public void addRoom(ScreenRoom room) {
    rooms.add(room);
  }

  /**
   * Adds a new ticket to the cinema.
   * @param ticket the Ticket object to add
   */
  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  /**
   * Finds a customer's ticket in the cinema by their email.
   * @param email the email of the customer to search for
   * @return the Ticket object associated with the customer, or null if not found
   */
  public Customer findCustomer(String email) {
    Customer customer = null;
    for (Customer c : customers) {
      if(c.getEmail().equals(email)) {
        customer = c;
      }
    }
    return customer;
  }
}
