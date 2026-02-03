package edu.ntnu.idi.idatt.Capitalize;

public class CapitalizeWordsTextCommand extends CapitalizeTextCommand{
  @Override
  public String execute(String text) {
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
