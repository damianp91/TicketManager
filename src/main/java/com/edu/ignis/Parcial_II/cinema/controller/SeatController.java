package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;
import com.edu.ignis.Parcial_II.cinema.model.Seat;

public class SeatController {
  
  public static boolean takeSeat(ScreenRoom room, int row, int col) {
    boolean take = false;
    if(!room.isSeatOccupied(row, col)) {
      room.occupySeat(row, col);
      take = true;
    }
    return take;
  }
  
  public static String getStatusSeat(Seat seat) {
    return seat.toString();
  }
}
