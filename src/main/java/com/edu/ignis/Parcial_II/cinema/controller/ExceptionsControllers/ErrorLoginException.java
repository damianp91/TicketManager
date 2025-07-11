package com.edu.ignis.Parcial_II.cinema.controller.ExceptionsControllers;

public class ErrorLoginException extends Exception {
  public ErrorLoginException (String message) {
    super(message);
  }
}
