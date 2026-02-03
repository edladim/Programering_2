package edu.ntnu.idi.idatt.Capitalize;

public class CapitalizeTextCommand {
  public String execute(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }
}
