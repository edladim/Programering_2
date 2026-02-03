package src.main.java.edu.ntnu.idi.idatt.replace;

import src.main.java.edu.ntnu.idi.idatt.TextCommand;

public class ReplaceTextCommand implements TextCommand {

  protected String target;
  protected String replacement;

  public ReplaceTextCommand(String target, String replacement) {
    if (target == null) {
      throw new IllegalArgumentException("Target cannot be null");
    }
    if (replacement == null) {
      throw new IllegalArgumentException("Replacement cannot be null");
    }
    this.target = target;
    this.replacement = replacement;
  }

  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    return text.replace(target, replacement);
  }

  public String getTarget() {
    return target;
  }

  public String getReplacement() {
    return replacement;
  }
}
