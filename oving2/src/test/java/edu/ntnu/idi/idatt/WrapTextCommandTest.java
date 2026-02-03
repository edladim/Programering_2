
package src.test.java.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import src.main.java.edu.ntnu.idi.idatt.wrap.WrapTextCommand;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WrapTextCommand Tests")
class WrapTextCommandTest {

  @Test
  @DisplayName("Should wrap text with delimiters")
  void testWrapText() {
    WrapTextCommand command = new WrapTextCommand("<", ">");
    assertEquals("<hello>", command.execute("hello"));
  }

  @Test
  @DisplayName("Should wrap with different delimiters")
  void testDifferentDelimiters() {
    WrapTextCommand command = new WrapTextCommand("[[", "]]");
    assertEquals("[[test]]", command.execute("test"));
  }

  @Test
  @DisplayName("Should wrap empty string")
  void testWrapEmptyString() {
    WrapTextCommand command = new WrapTextCommand("{", "}");
    assertEquals("{}", command.execute(""));
  }

  @Test
  @DisplayName("Should wrap multi-line text")
  void testWrapMultiLine() {
    WrapTextCommand command = new WrapTextCommand("<", ">");
    assertEquals("<hello\nworld>", command.execute("hello\nworld"));
  }

  @Test
  @DisplayName("Should get opening delimiter")
  void testGetOpening() {
    WrapTextCommand command = new WrapTextCommand("(", ")");
    assertEquals("(", command.getOpening());
  }

  @Test
  @DisplayName("Should get end delimiter")
  void testGetEnd() {
    WrapTextCommand command = new WrapTextCommand("(", ")");
    assertEquals(")", command.getEnd());
  }

  // Feilhåndtering
  @Test
  @DisplayName("Should throw exception when opening is null")
  void testNullOpening() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new WrapTextCommand(null, ">");
    });
    assertEquals("Opening delimiter cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception when end is null")
  void testNullEnd() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new WrapTextCommand("<", null);
    });
    assertEquals("End delimiter cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception when text is null")
  void testNullText() {
    WrapTextCommand command = new WrapTextCommand("<", ">");
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      command.execute(null);
    });
    assertEquals("Text cannot be null", exception.getMessage());
  }
}
