package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

public class Seat implements Serializable {
  private int row;
  private int col;
  private boolean occupied;

  /**
   * Constructs a Seat with the specified number, line, and occupation status.
   * @param number the seat number
   * @param line the line where the seat is located
   * @param occupied the occupation status of the seat
   */
  public Seat(int row, int col) {
    this.row = row;
    this.col = col;
    this.occupied = false;
  }

  /**
   * Retrieves the seat number.
   * @return the number of the seat
   */
  public int getRow() {
    return row;
  }

  /**
   * Retrieves the line where the seat is located.
   * @return the line of the seat
   */
  public int getCol() {
    return col;
  }

  /**
   * Checks if the seat is occupied.
   * @return true if the seat is occupied, false otherwise
   */
  public boolean isOccupied() {
    return occupied;
  }

  /**
   * Sets the occupation status of the seat.
   * @param occupied the new occupation status
   */
  public void setOccupied(boolean occupied) {
    this.occupied = occupied;
  }

  /**
   * Returns a string representation of the seat's details.
   * @return a string indicating the number, line, and occupation status of the seat
   */
  @Override
  public String toString() {
    return "Row: " + (row + 1) + ", Number: " + (col + 1) + ", status: " +
      (occupied ? "Occupied" : "Available")
    ;
  }
}
