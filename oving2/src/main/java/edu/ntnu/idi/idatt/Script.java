package src.main.java.edu.ntnu.idi.idatt;

import java.util.List;

public class Script {
  final List<TextCommand> textCommands;

  public Script(List<TextCommand> textCommands) {
    if (textCommands == null) {
      throw new IllegalArgumentException("Text commands list cannot be null");
    }
    this.textCommands = textCommands;
  }

  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    
    for (TextCommand command : textCommands) {
      if (command == null) {
        throw new IllegalStateException("Command in list cannot be null");
      }
      text = command.execute(text);
    }
    return text;
  }
}
