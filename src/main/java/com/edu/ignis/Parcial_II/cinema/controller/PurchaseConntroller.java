package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers.AvalibleSeatException;
import com.edu.ignis.Parcial_II.cinema.model.*;

public class PurchaseConntroller {

  public static void makePurchase(Cinema cinema, Customer customer, ScreenRoom room,
      Seat seat) throws AvalibleSeatException {
    if(seat.isOccupied()) {
      throw new AvalibleSeatException("Seat isn't avalible.");
    }
    seat.setOccupied(false);
    Ticket ticket = new Ticket(customer, room, seat);
    cinema.addTicket(ticket);
  }
}
