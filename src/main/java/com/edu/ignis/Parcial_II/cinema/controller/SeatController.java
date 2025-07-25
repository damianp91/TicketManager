package com.edu.ignis.Parcial_II.cinema.controller;

import com.edu.ignis.Parcial_II.cinema.model.ScreenRoom;

public class SeatController {

  /**
     * Attempts to take a seat in the specified screen room at the given row and column.
     *
     * @param room the screen room where the seat is located
     * @param row the row of the seat to be occupied
     * @param col the column of the seat to be occupied
     * @return {@code true} if the seat was successfully taken, {@code false}
     * if the seat is already occupied
     */
  public static boolean takeSeat(ScreenRoom room, int row, int col) {
    boolean take = false;
    if(!room.isSeatOccupied(row, col)) {
      room.occupySeat(row, col);
      take = true;
    }
    return take;
  }
}
