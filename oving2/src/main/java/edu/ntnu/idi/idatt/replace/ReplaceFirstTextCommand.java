package src.main.java.edu.ntnu.idi.idatt.replace;

public class ReplaceFirstTextCommand extends ReplaceTextCommand{
  public ReplaceFirstTextCommand(String target, String replacement) {
    super(target, replacement);
  }

  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    return text.replaceFirst(target, replacement);
  }
}
