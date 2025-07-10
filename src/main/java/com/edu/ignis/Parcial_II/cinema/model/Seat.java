package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

public class Seat implements Serializable {
  private int number;
  private String line;
  private boolean occupied;

  /**
   * Constructs a Seat with the specified number, line, and occupation status.
   * @param number the seat number
   * @param line the line where the seat is located
   * @param occupied the occupation status of the seat
   */
  public Seat(int number, String line, boolean occupied) {
    this.number = number;
    this.line = line;
    this.occupied = occupied;
  }

  /**
   * Retrieves the seat number.
   * @return the number of the seat
   */
  public int getNumber() {
    return number;
  }

  /**
   * Retrieves the line where the seat is located.
   * @return the line of the seat
   */
  public String getLine() {
    return line;
  }

  /**
   * Checks if the seat is occupied.
   * @return true if the seat is occupied, false otherwise
   */
  public boolean isOccupied() {
    return occupied;
  }

  /**
   * Sets the seat number.
   * @param number the new seat number
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Sets the line for the seat.
   * @param line the new line for the seat
   */
  public void setLine(String line) {
    this.line = line;
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
    return "Seat [number: " + number + ", line: " + line + ", occupied: " +
      (occupied ? "avalible" : "not avalible") + "]"
    ;
  }
}
