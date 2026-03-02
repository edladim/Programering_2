package edu.ntnu.idi.idatt;

public class PlayingCard {

  private final char suit;
  private final int value;

  public PlayingCard(char suit, int value) {
    if (!isValidSuit(suit)) {
      throw new IllegalArgumentException("Invalid suit");
    }

    if (value < 1 || value > 13) {
      throw new IllegalArgumentException("Invalid card value");
    }

    this.suit = suit;
    this.value = value;
  }

  public char getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  private boolean isValidSuit(char suit) {
    return suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C';
  }

  @Override
  public String toString() {
    return suit + String.valueOf(value);
  }
}