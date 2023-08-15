/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Deepanshu Arora, 991701780
 * 
 */
public class Player 
{ 

    private String name;
    private List<Card> hand;
    private boolean staying;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) 
    {
    this.name = name;
    hand = new ArrayList<>();
    staying = false;
  }

  public String getName() 
  {
    return name;
  }

  public List<Card> getHand() 
  {
    return hand;
  }

  public void addCard(Card card) 
  {
    hand.add(card);
  }

  public boolean isStaying() 
  {
    return staying;
  }

  public boolean isBust() 
  {
    return calculateScore() > 21;
  }

  public int calculateScore() 
  {
    int score = 0;
    int numAces = 0;

    for (Card card : hand) 
    {
      score += card.getValue();
      if (card.getValue() == 11) 
      {
        numAces++;
      }
    }

    while (score > 21 && numAces > 0) 
    {
      score -= 10;
      numAces--;
    }

    return score;
  }

  public void playTurn(GroupOfCards deck, Scanner scanner) 
  {
    System.out.println("Your Hand: " + hand);
    System.out.println("Your Score: " + calculateScore());
    System.out.print("Do you want to Hit (H) or Stay (S)? ");

    String choice = scanner.nextLine().toUpperCase();
    if (choice.equals("H")) {
      addCard(deck.dealCard());
      if (isBust()) {
        staying = true;
        System.out.println("You went bust!");
      }
    } else if (choice.equals("S")) {
      staying = true;
    } else {
      System.out.println("Invalid choice! Please enter H or S.");
      playTurn(deck, scanner);
    }
  }

  public void playTurn(GroupOfCards deck) 
  {
    System.out.println("Dealer's Hand: " + hand);
    System.out.println("Dealer's Score: " + calculateScore());

    if (calculateScore() < 17) 
    {
      addCard(deck.dealCard());
      if (isBust()) 
      {
        staying = true;
        System.out.println("Dealer went bust!");
      }
    } else 
    {
      staying = true;
    }
  }
}