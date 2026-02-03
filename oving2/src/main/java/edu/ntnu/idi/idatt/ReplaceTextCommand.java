package øving2.oving2.src.main.java.edu.ntnu.idi.idatt;

import øving2.TextCommand;

public class ReplaceTextCommand implements TextCommand {

  String target;
  String replacement;

  public ReplaceTextCommand(String target, String replacement) {
    this.target = target;
    this.replacement = replacement;
  }

  @Override
  public String execute(String text) {
    return text.replace(target, replacement);
  }

  public String getTarget() {
    return target;
  }

  public String getReplacement() {
    return replacement;
  }
}
