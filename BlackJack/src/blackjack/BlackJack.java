package blackjack;
import java.util.Scanner;

public class BlackJack {
   
    public static void main(String[] args) {
        // Creating variables and initializing the start of the game
        
       GUI gui = new GUI();
       Game game = new Game();
       Player player[] = new Player[4];
       Card cards[] = new Card[52];
       Scanner input = new Scanner(System.in);
       game.GenerateCardDeck(cards);
       game.PlayerSetup(player, cards);
       gui.runGUI(cards, player[0].GetCard(), player[1].GetCard(), player[2].GetCard(), player[3].GetCard());
       
       // The game loop
       
       for (int i = 0; i < 4; i++)
       {
           // Getting the names of the players
           
           System.out.printf("%s's turn...%n", player[i].GetName());
           
           // Condition so that it's for the 3 players
           
           if (i < 3) {
            while(true)
            {
                // the player makes a choice
           
                System.out.printf("Please enter your choice:%n1. Hit %n2.Stand %n %n");
                int choice = input.nextInt();
                
                // if player chose to select a card
                
                if(choice == 1)
                {
                    System.out.println("Hit! Dealer is giving the player a card...");
                    Card c = new Card(player[i].DrawCard(game.CardSelect(cards)));
                    gui.updatePlayerHand(c, i);
                    game.UpdateHighScore();
                }
                
                // if the player chose to end their turn
                
                else if (choice == 2) {
                    System.out.printf("Stand! %s's turn is now over. Player's hand sums to %d %n %n", player[i].GetName(), player[i].GetScore());
                    break;
                }
                
                // to check if the player is busted or has a blackjack
                
                if (player[i].GetScore() >= 21)
                {
                    if (player[i].GetScore() > 21)
                    {
                      System.out.printf("%s is busted. Player's hand sums to %d %n", player[i].GetName(), player[i].GetScore());
                    }
                    else
                        {
                           System.out.printf("%s's turn is now over. Player has a blackjack!(21) %n", player[i].GetName());     
                        }
                    break;
                }
            }
           }
           
           // This is the dealer's turn
            else
            {
               System.out.println("The dealer is drawing cards...");
               while(true)
               {
                   // condition to make the dealer draw cards till he wins or busts
               
                   if ((player[3].GetScore() < game.GetHighScore()) && (player[3].GetScore() < 21))
                   {
                        Card c = new Card(player[3].DrawCard(game.CardSelect(cards)));
                        gui.updateDealerHand(c, cards);
                        game.UpdateHighScore();
                   }
                   
                    else if (player[i].GetScore() > 21)
                        {
                         System.out.printf("The dealer is busted. Player's hand sums to %d %n", player[3].GetScore());
                         break;
                        }
                    else {
                        System.out.printf("The dealer's turn is over. Dealer's hand sums to %d %n", player[3].GetScore());
                        break;
                    }
                    
                    
               }
           }
       }
      // To see if anyone won or not 
      game.Result();
   }
}