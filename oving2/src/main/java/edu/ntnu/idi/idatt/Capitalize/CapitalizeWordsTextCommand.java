package src.main.java.edu.ntnu.idi.idatt.Capitalize;

public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {
  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    if (text.isEmpty()) {
      return text;
    }
    
    String[] words = text.split(" ");
    StringBuilder capitalizedText = new StringBuilder();

    for (String word : words) {
      if (!word.isEmpty()) {
        capitalizedText.append(super.execute(word))
            .append(" ");
      }
    }

    return capitalizedText.toString().trim();
  }
}
