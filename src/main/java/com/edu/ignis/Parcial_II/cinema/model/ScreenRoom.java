package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

/**
 * Represents a screen room in the cinema.
 */
public class ScreenRoom implements Serializable {
  private int number;
  private String movie;
  private int file;
  private int seat;
  private Seat[][] seats;

  /**
   * Constructs a screen room with the specified number, movie, rows, and seats.
   * @param number the screen room number
   * @param movie the movie being shown
   * @param file the number of rows in the screen room
   * @param seat the number of seats per row
   */
  public ScreenRoom(int number, String movie, int file, int seat) {
    this.number = number;
    this.movie = movie;
    this.seats = new Seat[file][seat];
  }

  /**
   * Retrieves the screen room number.
   * @return the screen room number
   */
  public int getNumber() {
    return number;
  }

  /**
   * Retrieves the movie being shown in the screen room.
   * @return the movie title
   */
  public String getMovie() {
    return movie;
  }

  /**
   * Retrieves a specific seat in the screen room.
   * @return the seat object
   */
  public Seat getSeat() {
    return seats[file][seat];
  }

  public void setSeat(Seat seat, int file, int number) {
    if (file >= 0 && file < seats.length && 
        number >= 0 && number < seats[file].length) {
      seats[file][number] = seat;
    }
  }

  /**
   * Displays the layout of the screen room, including rows and seats.
   * @return a string representation of the screen room layout
   */
  public String showRoom() {
    StringBuilder sb = new StringBuilder();
    sb.append("Room: ").append(getNumber()).append("\n");
    sb.append("Movie: ").append(getMovie()).append("\n");

    for (int i = 0; i < seats.length; i++) {
      sb.append("\t\tfile ").append(i + 1).append(": ");
      for (int j = 0; j < seats[0].length; j++) {
        sb.append(seats[i][j] != null ? "[X]" : "[ ]");
      }
      sb.append("\n");
    }

    sb.append("\t====================\n");
    sb.append("\t\tScreen");

    return sb.toString();
  }
}
