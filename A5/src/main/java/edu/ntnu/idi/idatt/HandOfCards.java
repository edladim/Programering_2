package edu.ntnu.idi.idatt;

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

  @Override
  public String toString() {
    return cards.stream()
      .map(PlayingCard::toString)
      .collect(Collectors.joining(" "));
  }
}