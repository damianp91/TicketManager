package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.model.Seat;

public class SeatController {

  public static boolean isOccupied(Seat seat) {
    return seat.isOccupied();
  }
  
  public static boolean takeSeat(Seat seat) {
    boolean avalibleSeat = false;
    if(!seat.isOccupied()) {
      seat.setOccupied(false);
      avalibleSeat = true;
    }
    return avalibleSeat;
  }
  
  public static String getStatusSeat(Seat seat) {
    return seat.isOccupied() ? "Avalible" : "Not avalible";
  }
}
