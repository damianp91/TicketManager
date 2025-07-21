package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

/**
 * Represents a screen room in the cinema.
 */
public class ScreenRoom implements Serializable {
  private int number;
  private String movie;
  private Seat[][] seats;

  /**
   * Constructs a screen room with the specified number, movie, rows, and seats.
   * @param number the screen room number
   * @param movie the movie being shown
   * @param row the number of rows in the screen room
   * @param seatPerRow the number of seats per row
   */
  public ScreenRoom(int number, String movie, int row, int seatPerRow) {
    this.number = number;
    this.movie = movie;
    this.seats = new Seat[row][seatPerRow];

    for(int i = 0; i < row; i ++) {
      for(int j = 0; j < seatPerRow; j ++) {
        this.seats[i][j] = new Seat(j + 1, i + 1);
      }
    }
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
  public Seat[][] getSeats() {
    return seats;
  }

  private boolean isPlaceCorrect(int row, int col) {
    return row >= 0 && row < seats.length &&
            col >= 0 && col < seats[row].length;
  }

  public void occupySeat(int row, int col) {
    if (isPlaceCorrect(row, col)) {
      seats[row][col].setOccupied(true);
    }
  }

  public boolean isSeatOccupied(int row, int col) {
    return isPlaceCorrect(row, col) && seats[row][col].isOccupied();
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
      for (int j = 0; j < seats[i].length; j++) {
        sb.append(seats[i][j].isOccupied() ? "[X]" : "[ ]");
      }
      sb.append("\n");
    }

    sb.append("\t====================\n");
    sb.append("\t\tScreen");

    return sb.toString();
  }

  @Override
  public String toString() {
    return "ScreenRoom [Sala: " + number + ", movie: " + movie + "]";
  }
}
