package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
  private final List<PlayingCard> cards = new ArrayList<>();
  private final char[] suit = {'S', 'H', 'C', 'D'};

  public DeckOfCards() {
    for (char suit : suit) {
      for (int value = 1; value <= 13; value++) {
        cards.add(new PlayingCard(suit, value));
      }
    }
  }

  public List<PlayingCard> getCards() {
    return cards;
  }
}
