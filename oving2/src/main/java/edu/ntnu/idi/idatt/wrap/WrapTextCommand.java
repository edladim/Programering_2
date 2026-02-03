package edu.ntnu.idi.idatt.wrap;

import edu.ntnu.idi.idatt.TextCommand;

public class WrapTextCommand implements TextCommand {
  protected String opening;
  protected String end;

  public WrapTextCommand(String opening, String end) {
    this.opening = opening;
    this.end = end;
  }

  @Override
  public String execute(String text) {
    return String.format("%s%s%s", opening, text, end);
  }

  public String getOpening() {
    return opening;
  }

  public String getEnd() {
    return end;
  }
}
