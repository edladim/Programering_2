package src.test.java.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import src.main.java.edu.ntnu.idi.idatt.Capitalize.CapitalizeTextCommand;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CapitalizeTextCommand Tests")
class CapitalizeTextCommandTest {

  @Test
  @DisplayName("Should capitalize first letter")
  void testCapitalizeFirstLetter() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    assertEquals("Hello", command.execute("hello"));
  }

  @Test
  @DisplayName("Should preserve already capitalized text")
  void testAlreadyCapitalized() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    assertEquals("Hello", command.execute("Hello"));
  }

  @Test
  @DisplayName("Should handle single character")
  void testSingleCharacter() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    assertEquals("A", command.execute("a"));
  }

  @Test
  @DisplayName("Should preserve rest of text")
  void testPreserveRest() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    assertEquals("Hello world", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should return empty string for empty input")
  void testEmptyString() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    assertEquals("", command.execute(""));
  }

  @Test
  @DisplayName("Should throw exception when text is null")
  void testNullText() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      command.execute(null);
    });
    assertEquals("Text cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should capitalize text with numbers")
  void testWithNumbers() {
    CapitalizeTextCommand command = new CapitalizeTextCommand();
    assertEquals("Hello123", command.execute("hello123"));
  }
}
