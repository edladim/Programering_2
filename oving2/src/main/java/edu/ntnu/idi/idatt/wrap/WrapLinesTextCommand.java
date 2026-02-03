package edu.ntnu.idi.idatt.wrap;

public class WrapLinesTextCommand extends WrapTextCommand{
  public WrapLinesTextCommand(String opening, String end) {
    super(opening, end);
  }
  @Override
  public String execute(String text) {
    String[] lines = text.split("\n");
    StringBuilder sb = new StringBuilder();

    for (String line : lines) {
      sb.append(opening).append(line).append("\n").append(end);
    }
    return sb.toString();
  }
}
