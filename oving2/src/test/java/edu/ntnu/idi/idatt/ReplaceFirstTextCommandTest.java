package src.test.java.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import src.main.java.edu.ntnu.idi.idatt.replace.ReplaceFirstTextCommand;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ReplaceFirstTextCommand Tests")
class ReplaceFirstTextCommandTest {

  @Test
  @DisplayName("Should replace only first occurrence")
  void testReplaceOnlyFirst() {
    ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("o", "0");
    assertEquals("hell0 world", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should leave other occurrences unchanged")
  void testLeaveOthersUnchanged() {
    ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("test", "xyz");
    assertEquals("xyz test test", command.execute("test test test"));
  }

  @Test
  @DisplayName("Should handle single occurrence")
  void testSingleOccurrence() {
    ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("world", "universe");
    assertEquals("hello universe", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should throw exception when text is null")
  void testNullText() {
    ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("test", "xyz");
    assertThrows(IllegalArgumentException.class, () -> command.execute(null));
  }
}
