package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Cinema with screen rooms and tickets.
 */
public class Cinema implements Serializable {
  private List<ScreenRoom> rooms;
  private List<Ticket> tickets;
  private List<Customer> customers;

  private transient Map<String, Customer> customerMap = new HashMap<>();

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

  /**
     * Retrieves the list of customers registered in the cinema.
     * @return a List of Customer objects
     */
  public List<Customer> getCustomers() {
    return customers;
  }

  /**
   * Adds a new screen room to the cinema.
   * @param room the ScreenRoom object to add
   */
  public void addRoom(ScreenRoom room) {
    if(!rooms.contains(room)) {
      rooms.add(room);
    }
  }

  /**
   * Adds a new ticket to the cinema.
   * @param ticket the Ticket object to add
   */
  public void addTicket(Ticket ticket) {
    if(!tickets.contains(ticket)) {
      tickets.add(ticket);
    }
  }

  public void addCustomer(Customer customer) {
    if(!customers.contains(customer)) {
      customers.add(customer);
      customerMap.put(customer.getEmail(), customer);
    }
  }

  /**
     * Finds a customer in the cinema by their email.
     * @param email the email of the customer to search for
     * @return the Customer object associated with the email, or null if not found
     */
  public Customer findCustomerByEmail(String email) {
    return customerMap.get(email);
  }

  /**
     * Rebuilds the customer map by populating it with entries from the customers list.
     * This ensures the map is synchronized with the current list of customers.
     */
  public void rebuildCustomerMap() {
    customerMap = new HashMap<>();
    for (Customer c: customers) {
      customerMap.put(c.getEmail(), c);
    }
  }

  @Override
  public String toString() {
    return "Cinema\nRooms: " + rooms.toString() + "\nTickets: " + tickets.toString();
  }
}
