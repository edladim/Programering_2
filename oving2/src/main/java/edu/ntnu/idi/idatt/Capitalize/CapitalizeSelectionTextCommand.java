package edu.ntnu.idi.idatt.Capitalize;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand{
  private String selection;

  public CapitalizeSelectionTextCommand(String selection) {
    this.selection = selection;
  }

  public String execute(String text) {
    return text.replace(selection, super.execute(selection));
  }

  public String getSelection() {
    return selection;
  }
}
