package src.main.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

  @Test
  void toStringShouldReturnCorrectFormat() {
    PlayingCard card = new PlayingCard('H', 10);
    assertEquals("H10", card.toString());
  }

  @Test
  void shouldThrowExceptionForInvalidSuit() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('X', 5));
  }

  @Test
  void shouldThrowExceptionForInvalidValue() {
    assertThrows(IllegalArgumentException.class,
        () -> new PlayingCard('H', 20));
  }
}