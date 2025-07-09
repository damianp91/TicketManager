package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

public class Seat implements Serializable {
  private int number;
  private String line;
  private boolean occupied;

  public Seat(int number, String line, boolean occupied) {
    this.number = number;
    this.line = line;
    this.occupied = occupied;
  }

  public int getNumber() {
    return number;
  }

  public String getLine() {
    return line;
  }

  public boolean isOccupied() {
    return occupied;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public void setOccupied(boolean occupied) {
    this.occupied = occupied;
  }

  @Override
  public String toString() {
    return "Seat [number: " + number + ", line: " + line + ", occupied: " +
      (occupied ? "avalible" : "not avalible") + "]"
    ;
  }
}
