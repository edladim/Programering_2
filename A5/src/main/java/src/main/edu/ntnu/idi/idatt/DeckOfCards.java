package src.main.edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

  public HandOfCards dealHand(int n) {
    if (n < 1 || n > 52) {
      throw new IllegalArgumentException("Number of Cards must be between 1 and 52.");
    }

    List<PlayingCard> copy = new ArrayList<>(cards);
    Collections.shuffle(copy, new Random());

    List<PlayingCard> hand = copy.subList(0, n);

    return new HandOfCards(new ArrayList<>(hand));
  }
}
