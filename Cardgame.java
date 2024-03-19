// imports for string list
import java.util.ArrayList;
import java.util.List;
// import for random value selection
import java.util.Random;

/**
 The Cardgame.java program represents a simple one-file implementation of 
 the War card game. The "main" program function tests the implementation of 
 this program and the other more module-based multi-file Card game program. 
 **/

public class Cardgame
{
    // card list variables
    private static List<String> suits = 
        new ArrayList<>(List.of("Spades", "Clubs", "Hearts", "Diamonds"));
    private static List<String> ranks = 
        new ArrayList<>(List.of("2", "3", "4", "5", "6", "7", "8", 
        						"9", "10", "Jack", "Queen", "King", "Ace"));
    
    // function to select cards
    public static String[] selectCard() {
        Random random = new Random();
        String randomRank = ranks.get(random.nextInt(ranks.size()));
        String randomSuit = suits.get(random.nextInt(suits.size()));
        return new String[] { randomRank, randomSuit };
    }
    
    // function to select player 1 and 2 cards
    public static String[] playerCards() {
        // player 1 card selection
        String[] selectedCard1 = selectCard();
        String rank1 = selectedCard1[0];
        String suit1 = selectedCard1[1];
        String player1Card = rank1 + " of " + suit1;
        
        // player 2 card selection
        String[] selectedCard2 = selectCard();
        String rank2 = selectedCard2[0];
        String suit2 = selectedCard2[1];
        String player2Card = rank2 + " of " + suit2;
        
        // returns player 1 and 2 cards as a string
        return new String[] { player1Card, player2Card };
    }
    
    // function determines winner
    public static String determineWinner(String player1, String player2) {
        // obtains player card rank from player string
        String[] player1CardParts = player1.split(" ");
        String[] player2CardParts = player2.split(" ");
        String rank1 = player1CardParts[0];
        String rank2 = player2CardParts[0];
    
        // searches for the index of the rank in the ranks list
        int rankIndex1 = ranks.indexOf(rank1);
        int rankIndex2 = ranks.indexOf(rank2);
        
        // determines winner from rank index
        if (rankIndex1 > rankIndex2) {
            return "Player 1 wins!";
        } else if (rankIndex1 < rankIndex2) {
            return "Player 2 wins!";
        } else {
            return "It's a tie!";
        }
    }
    
    // main program function
    public static void main(String []args)
    {
        // player cards selection
        String[] playerCards = playerCards();
        String player1 = playerCards[0];
        String player2 = playerCards[1];
        
        // Determines the winner, prints output of simple card game
        String winner = determineWinner(player1, player2);
        System.out.println("Simple Card Game Output: ");
        System.out.println("Player 1 Card: " + player1);
        System.out.println("Player 2 Card: " + player2);
        System.out.println("Winner: " + winner + '\n');

        /**
         Prints out the output of the complex module-based card
         program. This other implementation is meant to be 
         adaptable into other card game configurations. 
         **/
        System.out.println("Complex Card Game Output: ");
        Deck testDeck = new Deck();

        List<Card> drawnCards = testDeck.drawCards(17); // Draw 5 cards
        // Print the drawn cards
        System.out.println(drawnCards.toString());
        testDeck.printDeck();
        // resets cards
        testDeck.shuffleCards();
        testDeck.printDeck();
    }
};