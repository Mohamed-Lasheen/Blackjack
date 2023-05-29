package blackjack;

public class Card {
    private final int suit, rank, value;
    
    public Card (int suit, int rank, int value)
    {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
     public Card (Card card)
    {
        this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value;
    }
    /* This card was only created to help with the initialization,
       to be used for the gui.update functions for the players */
     public Card()
     {
         this.suit = 0;
         this.rank = 0;
         this.value = 0;
     }
     
      public int getSuit()
     {
         return suit;
     }
     
      public int getRank()
     {
         return rank;
     }
      
      public int getValue()
     {
         return value;
     }
}