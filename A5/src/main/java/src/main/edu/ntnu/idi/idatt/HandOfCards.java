package src.main.edu.ntnu.idi.idatt;

import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {

  private final List<PlayingCard> cards;

  public HandOfCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

  public boolean isFlush() {
    return cards.stream()
      .map(PlayingCard::getSuit)
      .distinct()
      .count() == 1;
  }

  public int sumOfCards() {
    return cards.stream()
        .mapToInt(PlayingCard::getValue)
        .sum();
  }

  public String getHeartsAsString() {
    return cards.stream()
        .filter(c -> c.getSuit() == 'H')
        .map(PlayingCard::toString)
        .reduce((a, b) -> a + ", " + b)
        .orElse("no hearts");
  }


  public boolean hasQueenOfSpades() {
    return cards.stream()
      .anyMatch(c -> c.getSuit() == 'S' && c.getValue() == 12);
  }

  @Override
  public String toString() {
    return cards.stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining(" "));
  }
}