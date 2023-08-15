/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modifier Sauravkumar, 991705077
 * 
 * 
 */
public class Card {
  private String suit;
  private String rank;
  private int value;

  public Card(String suit, String rank, int value) {
    this.suit = suit;
    this.rank = rank;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }
}