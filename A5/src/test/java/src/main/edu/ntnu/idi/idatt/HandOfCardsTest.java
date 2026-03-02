package src.main.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

  @Test
  void sumOfCardsShouldBeCorrect() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 4),
        new PlayingCard('S', 6),
        new PlayingCard('D', 10)
    ));

    assertEquals(20, hand.sumOfCards());
  }

  @Test
  void shouldDetectFlush() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('H', 5),
        new PlayingCard('H', 7),
        new PlayingCard('H', 9),
        new PlayingCard('H', 12)
    ));

    assertTrue(hand.isFlush());
  }

  @Test
  void shouldNotDetectFlush() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('S', 5),
        new PlayingCard('H', 7),
        new PlayingCard('D', 9),
        new PlayingCard('H', 12)
    ));

    assertFalse(hand.isFlush());
  }

  @Test
  void shouldDetectQueenOfSpades() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('S', 12)
    ));

    assertTrue(hand.hasQueenOfSpades());
  }

  @Test
  void shouldReturnNoHeartsIfNonePresent() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('S', 5),
        new PlayingCard('D', 7)
    ));

    assertEquals("no hearts", hand.getHeartsAsString());
  }
}