package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

public class Ticket implements Serializable {
  private Customer customer;
  private ScreenRoom room;
  private Seat seat;

  /** 
   * Constructs a Ticket with the specified customer, room, and seat.
   * @param customer the customer who purchased the ticket
   * @param room the screen room associated with the ticket
   * @param seat the seat associated with the ticket
   */
  public Ticket(Customer customer, ScreenRoom room, Seat seat) {
    this.customer = customer;
    this.room = room;
    this.seat = seat;
  }

  /**
   * Retrieves the customer who purchased the ticket.
   * @return the customer object
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Retrieves the screen room associated with the ticket.
   * @return the screen room object
   */
  public ScreenRoom getRoom() {
    return room;
  }

  /**
   * Retrieves the seat associated with the ticket.
   * @return the seat object
   */
  public Seat getSeat() {
    return seat;
  }

  /**
   * Returns a string representation of the ticket's details.
   * @return a string indicating the customer, room, and seat details
   */
  @Override
  public String toString() {
    return "Ticket [customer: " + customer.getName().toUpperCase() + ", room: " +
      room.getNumber() + ", Movie: " + room.getMovie().toUpperCase()  + ", seat: " +
      seat.getNumber() + ", file: " + seat.getLine() + "]"
    ;
  }
}
