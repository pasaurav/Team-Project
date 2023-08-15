/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Ramneek kaur, (991710454)
 * 
 */
public class GroupOfCards 
{
    private List<Card> cards;
    
    public GroupOfCards() 
    {
    cards = new ArrayList<>();
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    for (String suit : suits) 
    {
      for (int i = 0; i < ranks.length; i++) {
        Card card = new Card(suit, ranks[i], values[i]);
        cards.add(card);
      }
    }
  }

  public void shuffle() 
  {
    Random random = new Random();
    for (int i = cards.size() - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      Card temp = cards.get(i);
      cards.set(i, cards.get(j));
      cards.set(j, temp);
    }
  }
  
  public Card dealCard() 
  {
    if (cards.isEmpty()) 
    {
      throw new RuntimeException("Deck is empty!");
    }
    return cards.remove(cards.size() - 1);
  }
}
