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

  /**
   * Constructs a Cinema object with empty lists for screen rooms and tickets.
   */
  public Cinema() {
    this.rooms = new ArrayList<>();
    this.tickets = new ArrayList<>();
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

  /**
   * Finds a customer's ticket in the cinema by their email.
   * @param email the email of the customer to search for
   * @return the Ticket object associated with the customer, or null if not found
   */
  public Ticket findCustomer(String email) {
    Ticket ticket = null;
    for (Ticket t : tickets) {
      if(t.getCustomer().getEmail().equals(email)) {
        ticket = t;
      }
    }
    return ticket;
  }
}
