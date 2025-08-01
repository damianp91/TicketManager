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
        this.seats[i][j] = new Seat(i, j);
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
    return movie.toUpperCase();
  }

  /**
   * Retrieves a specific seat in the screen room.
   * @return the seat object
   */
  public Seat[][] getSeats() {
    return seats;
  }

  /**
     * Checks if the given row and column indices are within the valid range of
     * the screen room layout.
     * @param row the row index to check
     * @param col the column index to check
     * @return true if the indices are valid, false otherwise
     */
  private boolean isPlaceCorrect(int row, int col) {
    return row >= 0 && row < seats.length &&
    col >= 0 && col < seats[row].length;
  }

  /**
     * Marks a specific seat as occupied in the screen room.
     * @param row the row index of the seat
     * @param col the column index of the seat
     */
  public void occupySeat(int row, int col) {
    if (isPlaceCorrect(row, col)) {
      seats[row][col].setOccupied(true);
    }
  }

  /**
     * Checks if a specific seat in the screen room is occupied.
     * @param row the row index of the seat
     * @param col the column index of the seat
     * @return true if the seat is occupied, false otherwise
     */
  public boolean isSeatOccupied(int row, int col) {
    return isPlaceCorrect(row, col) && seats[row][col].isOccupied();
  }

  @Override
  public String toString() {
    return "Screening Room: " + getNumber() + ", movie: " + getMovie();
  }
}
