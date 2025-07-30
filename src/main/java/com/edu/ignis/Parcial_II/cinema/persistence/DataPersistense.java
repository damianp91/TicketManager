package com.edu.ignis.Parcial_II.cinema.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.edu.ignis.Parcial_II.cinema.model.Cinema;

public class DataPersistense {
  private static final String FILE = "cine.ser";

  /**
   * Saves the Cinema object to a file using serialization.
   * @param cinema the Cinema object to be saved
   */
  public static void save(Cinema cinema) {
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
      oos.writeObject(cinema);
    } catch (IOException e) {
      System.out.println("Failed to save state: " + e.getMessage());
    }
  }

  /**
   * Loads the Cinema object from a file using serialization.
   * @return the Cinema object loaded from the file or a new Cinema object if an error occurs
   */
  public static Cinema load() throws IOException, ClassNotFoundException{
    File f = new File(FILE);
    if (!f.exists()) {
      return new Cinema();
    }

    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
      Cinema cinema = (Cinema) ois.readObject();
      cinema.rebuildCustomerMap();
      return cinema;
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Error: Failed to load the file. Make sure 'cine.ser'" +
        "exists and is valid: " + e.getMessage()
      );
      return new Cinema();
    }
  }
}
