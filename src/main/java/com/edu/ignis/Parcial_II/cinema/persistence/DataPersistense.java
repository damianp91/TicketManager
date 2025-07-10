package com.edu.ignis.Parcial_II.cinema.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;

public class DataPersistense {
  private static final String ARCHIVO = "cine.ser";

  /**
   * Saves the Cinema object to a file using serialization.
   * @param cinema the Cinema object to be saved
   */
  public static void save(Cinema cinema) {
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
      oos.writeObject(cinema);
    } catch (IOException e) {
      System.out.println("Error guardando estado: " + e.getMessage());
    }
  }

  /**
   * Loads the Cinema object from a file using serialization.
   * @return the Cinema object loaded from the file or a new Cinema object if an error occurs
   */
  public static Cinema load() {
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
      return (Cinema) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      return new Cinema();
    }
  }
}
