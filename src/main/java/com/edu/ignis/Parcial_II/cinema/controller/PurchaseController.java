package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.AvalibleSeatException;
import com.edu.ignis.Parcial_II.cinema.model.*;

public class PurchaseController {

  /**
     * Handles the purchase process for a cinema ticket.
     *
     * @param cinema   The cinema where the purchase is being made.
     * @param customer The customer making the purchase.
     * @param room     The screen room where the seat is located.
     * @param seat     The seat being purchased.
     * @throws AvalibleSeatException If the seat is not available for purchase.
     */
  public static void makePurchase(Cinema cinema, Customer customer, ScreenRoom room,
      Seat seat) throws AvalibleSeatException {
    if(!SeatController.takeSeat(room, seat.getRow(), seat.getCol())) {
      throw new AvalibleSeatException("Seat isn't available.");
    }
    else {
      Ticket ticket = new Ticket(customer, room, seat);
      cinema.addTicket(ticket);
      cinema.addCustomer(customer);
    }
  }
}
