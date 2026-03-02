package src.main.edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  @Test
  void deckShouldContain52Cards() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getCards().size());
  }

  @Test
  void dealHandShouldReturnCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    HandOfCards hand = deck.dealHand(5);
    assertEquals(5, hand.getCards().size());
  }

  @Test
  void dealHandShouldThrowExceptionIfInvalidNumber() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
  }
}