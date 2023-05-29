package blackjack;
import java.util.Scanner;
import java.util.Random;

public class Game {
  public static int highScore = 0;
  public Player player[] = new Player[4];
  private Card card[] = new Card[52];
  private int bjCounter = 0;
  private int tieCounter = 0;
  private int bustedCounter = 0;
  // the last three variables are to help with seeing who the winner will be, if any exist
  
  public void GenerateCardDeck(Card c[])
  {
      // this is to help with intializing the full deck using two for loops
      int loopController = 0;
      
      for (int i = 0; i<4; i++)
      {
          if (i != 0)
          {
              loopController+=13;
          }
         
          for (int j = 0; j<13; j++)
          {
              if (j < 10)
              {
                 c[j+loopController] = new Card(i, j, j+1);
              }
              else 
              {
                  c[j+loopController] = new Card(i, j, 10);
              }
              
          }
      }
  }
  
  public Card CardSelect(Card c[]){
      Random random = new Random();
        while(true)
        {
            int randomCard = random.nextInt(52);
            if (c[randomCard] != null)
            {
               Card temp = new Card(c[randomCard]);
               c[randomCard] = null;
               return temp;
            } 
        }
 }
 
  public void PlayerSetup(Player p[], Card c[])
  {
      String name;
      Scanner input = new Scanner(System.in);
      for (int i = 0; i < 4; i++)
      {
         System.out.println("Enter your name: "); 
         p[i] = player[i] = new Player();
         name = input.next();
         player[i].SetName(name); 
         player[i].DrawCard(CardSelect(c));
         player[i].DrawCard(CardSelect(c));
      }
  }
  
  public void UpdateHighScore(){
   for (int i = 0; i < 4; i++)
      {
              if ((player[i].GetScore() >= highScore) && (player[i].GetScore() <= 21))
              {
                  highScore = player[i].GetScore();
              }
      }
  }
  
  public int GetHighScore()
  {
      return highScore;
  }
  // This function is used to determine if a player won or not and if someone did then who
  
  public void Result()
  {
      // Condition to see Who has a blackjack or is busted and how many
      
      for (int i = 0; i < 4; i++)
      {
          if (player[i].GetScore() > 21)
          {
              bustedCounter++;
          }
          if (player[i].GetScore() == 21)
          {
              bjCounter++;
          } 
      }
      
      // Condition to see if all players have been busted
      
      if (bustedCounter == 4)
      {
          System.out.println("Push!!");
      }
      
      //Conditions to see how many players have a blackjack
  
      if (bjCounter == 1)
      {
          for (int i = 0; i < 4; i++)
          {
              if (player[i].GetScore() == 21)
              {
                  System.out.println(player[i].GetName());
              }
          }
      }
      
        else if (bjCounter == 3)
              {
                  for (int i = 0; i < 4; i++)
                  {
                      if (player[i].GetScore()!= 21)
                      {
                          System.out.println(player[i].GetName());
                      }
                  }
              }
      
        else if (bjCounter ==  4)
        {
            System.out.println("Push!!");
        }
        
      else
      {
          TieCounter();
      }
  }
  public void TieCounter()
  {
      /* Set HighScore to zero so that it wouldn't have 21 as the highest score 
         since more than one player has a blackjack */   
      highScore = 0;
      
      // To check who has the highest score
      
      for (int i = 0; i < 4; i++)
      {
              if ((player[i].GetScore() >= highScore) && (player[i].GetScore() < 21))
              {
                  highScore = player[i].GetScore();
              }
      }
          // To see if more than one person has the same highscore
        
          for (int i = 0; i < 4; i++)
          {
              if (player[i].GetScore() == highScore)
              {
                  tieCounter++;
              }
          }
          
        /* To check how many players have the same score 
           and to declare who the winner if no one has a blackjack */  
          
        if (tieCounter > 1)
          {
              System.out.println("Push!!");
          }
        else 
        {
            for (int i = 0; i  < 4; i++)
            {
                if (player[i].GetScore() == highScore)
                {
                    System.out.println(player[i].GetName());
                }
            }
        }
  }
}