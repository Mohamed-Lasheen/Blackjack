package blackjack;

public class Player {
    private String name;
    private int score = 0;
    private Card playerCards[] = new Card[11];
    private int cardIndex = 0;
    
    public void SetName(String name)
    {
        this.name = name;
    }
    
    public String GetName()
    {
        return name;
    }
    
    /* Function to draw a card from the deck and
       to add up the cards the player has */
    
    public Card DrawCard(Card c)
    {
        if (cardIndex < 11)
        {
           
            playerCards[cardIndex] = c;
            this.score += c.getValue();
            cardIndex++;
            return c;
        }
        else {
            return null;
        }
    }
    public Card[] GetCard()
    {
      return playerCards;
    }
    
    public int GetScore()
    {
        return this.score;
    }
}