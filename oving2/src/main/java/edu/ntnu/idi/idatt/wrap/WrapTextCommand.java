package src.main.java.edu.ntnu.idi.idatt.wrap;

import src.main.java.edu.ntnu.idi.idatt.TextCommand;

public class WrapTextCommand implements TextCommand {
  protected String opening;
  protected String end;

  public WrapTextCommand(String opening, String end) {
    if (opening == null) {
      throw new IllegalArgumentException("Opening delimiter cannot be null");
    }
    if (end == null) {
      throw new IllegalArgumentException("End delimiter cannot be null");
    }
    this.opening = opening;
    this.end = end;
  }

  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    return String.format("%s%s%s", opening, text, end);
  }

  public String getOpening() {
    return opening;
  }

  public String getEnd() {
    return end;
  }
}
