package com.edu.ignis.Parcial_II.cinema.model;

import java.io.Serializable;

public class ScreenRoom implements Serializable {
  private int number;
  private String movie;
  private String[][] room;
  public ScreenRoom(int number, String movie) {
    this.number = number;
    this.movie = movie;
  }

  public ScreenRoom(int number, String movie, String[][] room) {
    this.number = number;
    this.movie = movie;
    this.room = room;
  }

  public int getNumber() {
    return number;
  }

  public String getMovie() {
    return movie;
  }

  public String[][] getRoom() {
    return room;
  }
}
