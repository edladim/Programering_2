package src.test.java.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import src.main.java.edu.ntnu.idi.idatt.replace.ReplaceTextCommand;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ReplaceTextCommand Tests")
class ReplaceTextCommandTest {

  // Positive tester
  @Test
  @DisplayName("Should replace single occurrence")
  void testReplaceSingleOccurrence() {
    ReplaceTextCommand command = new ReplaceTextCommand("world", "universe");
    assertEquals("hello universe", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should replace all occurrences")
  void testReplaceAllOccurrences() {
    ReplaceTextCommand command = new ReplaceTextCommand("o", "0");
    assertEquals("hell0 w0rld", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should handle no match")
  void testNoMatch() {
    ReplaceTextCommand command = new ReplaceTextCommand("xyz", "abc");
    assertEquals("hello world", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should handle empty string")
  void testEmptyString() {
    ReplaceTextCommand command = new ReplaceTextCommand("test", "xyz");
    assertEquals("", command.execute(""));
  }

  @Test
  @DisplayName("Should replace with empty string")
  void testReplaceWithEmpty() {
    ReplaceTextCommand command = new ReplaceTextCommand("world", "");
    assertEquals("hello ", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should replace empty target (all chars)")
  void testReplaceEmptyTarget() {
    ReplaceTextCommand command = new ReplaceTextCommand("", "x");
    String result = command.execute("ab");
    assertTrue(result.contains("x"));
  }

  // Feilhåndtering tester
  @Test
  @DisplayName("Should throw exception when target is null")
  void testNullTarget() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new ReplaceTextCommand(null, "replacement");
    });
    assertEquals("Target cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception when replacement is null")
  void testNullReplacement() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new ReplaceTextCommand("target", null);
    });
    assertEquals("Replacement cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception when text is null")
  void testNullText() {
    ReplaceTextCommand command = new ReplaceTextCommand("target", "replacement");
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      command.execute(null);
    });
    assertEquals("Text cannot be null", exception.getMessage());
  }
}
