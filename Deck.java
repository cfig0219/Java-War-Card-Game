import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    // stores list of cards
    private List<Card> cards = new ArrayList<>();

    // constructor populates cards array list
    public Deck() {
        for (Card.Suits suit : Card.Suits.values()) {
            for (Card.Ranks rank : Card.Ranks.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // function resets cards array list
    public void shuffleCards() {
        List<Card> shuffledCards = new ArrayList<>();

        for (Card.Suits suit : Card.Suits.values()) {
            for (Card.Ranks rank : Card.Ranks.values()) {
                shuffledCards.add(new Card(suit, rank));
            }
        }
        cards = shuffledCards;
    }

    // function prints out the cards in the deck
    public void printDeck() {
        if (!cards.isEmpty()) {
            System.out.println(cards.toString());
        }
        else {
            System.out.println("No more cards.");
        }
    }

    // function draws cards from deck
    public List<Card> drawCards(int x) {
        // selected cards array list
        List<Card> drawnCards = new ArrayList<>();
        Random random = new Random();

        // Draw x number of cards randomly from the deck
        for (int i = 0; i < x; i++) {

            // if card list is Not empty
            if (!cards.isEmpty()) {
                int index = random.nextInt(cards.size());
                // removes selected card from main cards list
                Card selected = cards.remove(index);
                drawnCards.add(selected);
            }
            
            // if card list is empty
            else {
                System.out.println("No more cards.");
            }
        }
        return drawnCards;
    }
}
