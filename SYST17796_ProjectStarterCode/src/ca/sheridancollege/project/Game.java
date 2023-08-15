/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.Scanner;

public class Game 
{ 
/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Arshdeep Kaur, 991711763
 * 
 */
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please Enter your name: ");
    String playerName = scanner.nextLine();
    Player player = new Player(playerName);
    Player dealer = new Player("Dealer");

    GroupOfCards GroupOfCards = new GroupOfCards();
    GroupOfCards.shuffle();

    player.addCard(GroupOfCards.dealCard());
    dealer.addCard(GroupOfCards.dealCard());
    player.addCard(GroupOfCards.dealCard());
    dealer.addCard(GroupOfCards.dealCard());

    System.out.println("Blackjack");
    System.out.println("Welcome, " + player.getName() + "!");
    System.out.println("Let's play!");

    boolean gameOver = false;
    while (!gameOver) {
      System.out.println("\n Now, It's Player's Turn ");
      player.playTurn(GroupOfCards, scanner);

      if (player.isBust()) {
        gameOver = true;
        break;
      }

      System.out.println("\nNow, It's Dealer's Turn");
      dealer.playTurn(GroupOfCards);

      if (dealer.isBust()) {
        gameOver = true;
        break;
      }

      if (player.isStaying() && dealer.isStaying()) {
        gameOver = true;
      }
    }

    System.out.println("\n  The Game is Over");
    System.out.println("Player's Hand: " + player.getHand());
    System.out.println("Dealer's Hand: " + dealer.getHand());

    if (player.isBust()) {
      System.out.println("Sadly, you failed! Dealer triumphs.");
    } else if (dealer.isBust()) {
      System.out.println("The dealer failed! You triumph.");
    } else {
      int playerScore = player.calculateScore();
      int dealerScore = dealer.calculateScore();

      System.out.println("Player's Score: " + playerScore);
      System.out.println("Dealer's Score: " + dealerScore);

      if (playerScore > dealerScore) {
        System.out.println("Congratulations! You win!");
      } else if (playerScore < dealerScore) {
        System.out.println("Oops! you loose, Dealer wins!");
      } else {
        System.out.println("And...It's a tie!");
      }
    }
  }
}
