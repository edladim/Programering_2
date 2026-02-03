package src.main.java.edu.ntnu.idi.idatt.wrap;

public class WrapLinesTextCommand extends WrapTextCommand{
  public WrapLinesTextCommand(String opening, String end) {
    super(opening, end);
  }
  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    if (text.isEmpty()) {
      return text;
    }
    
    String[] lines = text.split("\n");
    StringBuilder sb = new StringBuilder();

    for (String line : lines) {
      sb.append(opening).append(line).append(end).append("\n");
    }
    
    // Fjern siste newline
    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
      sb.setLength(sb.length() - 1);
    }
    
    return sb.toString();
  }
}
