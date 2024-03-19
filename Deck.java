import java.util.ArrayList;
import java.util.List;

public class Deck {
    // stores list of cards
    private List<Card> cards = new ArrayList<>();

    // constructor populates cards array list
    public Deck() {
        cards.add(new Card(Card.Suits.DIAMONDS, Card.Ranks.ACE));
        cards.add(new Card(Card.Suits.SPADES, Card.Ranks.JOKER));
    }

    // prints out the cards in the deck
    public void printCards() {
        System.out.println(cards.toString());
    }
}
