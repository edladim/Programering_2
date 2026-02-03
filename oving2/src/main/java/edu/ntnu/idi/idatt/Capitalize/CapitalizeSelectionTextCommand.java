package src.main.java.edu.ntnu.idi.idatt.Capitalize;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {
  private String selection;

  public CapitalizeSelectionTextCommand(String selection) {
    if (selection == null) {
      throw new IllegalArgumentException("Selection cannot be null");
    }
    if (selection.isEmpty()) {
      throw new IllegalArgumentException("Selection cannot be empty");
    }
    this.selection = selection;
  }

  @Override
  public String execute(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null");
    }
    if (text.isEmpty()) {
      return text;
    }
    return text.replace(selection, super.execute(selection));
  }

  public String getSelection() {
    return selection;
  }
}
