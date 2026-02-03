package src.test.java.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import src.main.java.edu.ntnu.idi.idatt.Capitalize.CapitalizeWordsTextCommand;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CapitalizeWordsTextCommand Tests")
class CapitalizeWordsTextCommandTest {

  @Test
  @DisplayName("Should capitalize all words")
  void testCapitalizeAllWords() {
    CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    assertEquals("Hello World", command.execute("hello world"));
  }

  @Test
  @DisplayName("Should handle single word")
  void testSingleWord() {
    CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    assertEquals("Hello", command.execute("hello"));
  }

  @Test
  @DisplayName("Should capitalize multiple words")
  void testMultipleWords() {
    CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    assertEquals("The Quick Brown Fox", command.execute("the quick brown fox"));
  }

  @Test
  @DisplayName("Should handle already capitalized words")
  void testAlreadyCapitalized() {
    CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    assertEquals("Hello World", command.execute("Hello World"));
  }

  @Test
  @DisplayName("Should return empty string for empty input")
  void testEmptyString() {
    CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    assertEquals("", command.execute(""));
  }

  @Test
  @DisplayName("Should throw exception when text is null")
  void testNullText() {
    CapitalizeWordsTextCommand command = new CapitalizeWordsTextCommand();
    assertThrows(IllegalArgumentException.class, () -> command.execute(null));
  }
}
