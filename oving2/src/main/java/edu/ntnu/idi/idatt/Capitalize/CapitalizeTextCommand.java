package src.main.java.edu.ntnu.idi.idatt.Capitalize;

import src.main.java.edu.ntnu.idi.idatt.TextCommand;

public class CapitalizeTextCommand implements TextCommand {
  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    if (text.isEmpty()) {
      return text;
    }
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }
}
