// imports for enum maps, more efficient
import java.util.EnumMap;
import java.util.Map;

public class Card implements Comparable<Card> {
    // Suits saved as enum numbers
    public enum Suits {SPADES, CLUBS, HEARTS, DIAMONDS}
    private Suits suit; // creates a private instance of suit
    public enum Ranks {JOKER, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
    EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
    private Ranks rank;

    // enum map for suits and ranks
    private static final EnumMap<Ranks,Integer> warRankMap = new EnumMap<>(Map.ofEntries(
        Map.entry(Ranks.JOKER, 1),
        Map.entry(Ranks.TWO, 2),
        Map.entry(Ranks.THREE, 3),
        Map.entry(Ranks.FOUR, 4),
        Map.entry(Ranks.FIVE, 5),
        Map.entry(Ranks.SIX, 6),
        Map.entry(Ranks.SEVEN, 7),
        Map.entry(Ranks.EIGHT, 8),
        Map.entry(Ranks.NINE, 9),
        Map.entry(Ranks.TEN, 10),
        Map.entry(Ranks.JACK, 11),
        Map.entry(Ranks.QUEEN, 12),
        Map.entry(Ranks.KING, 13),
        Map.entry(Ranks.ACE, 14)
    ));

    // makes enums into strings
    private static final EnumMap<Ranks,String> rankToString = new EnumMap<>(Map.ofEntries(
        Map.entry(Ranks.JOKER, "Joker"),
        Map.entry(Ranks.TWO, "2"),
        Map.entry(Ranks.THREE, "3"),
        Map.entry(Ranks.FOUR, "4"),
        Map.entry(Ranks.FIVE, "5"),
        Map.entry(Ranks.SIX, "6"),
        Map.entry(Ranks.SEVEN, "7"),
        Map.entry(Ranks.EIGHT, "8"),
        Map.entry(Ranks.NINE, "9"),
        Map.entry(Ranks.TEN, "10"),
        Map.entry(Ranks.JACK, "Jack"),
        Map.entry(Ranks.QUEEN, "Queen"),
        Map.entry(Ranks.KING, "King"),
        Map.entry(Ranks.ACE, "Ace")
    ));

    private static final EnumMap<Suits,String> suitToString = new EnumMap<>(Map.ofEntries(
        Map.entry(Suits.SPADES, "Spades"),
        Map.entry(Suits.CLUBS, "Clubs"),
        Map.entry(Suits.HEARTS, "Hearts"),
        Map.entry(Suits.DIAMONDS, "Diamonds")
    ));
    
    // allows for implementation of Comparable
    @Override
    public int compareTo(Card other) {
        // compares card 1 (this) to card 2 (other)
        if (warRankMap.get(this.rank) > warRankMap.get(other.rank)) {
            return 1;
        }
        if (warRankMap.get(this.rank) == warRankMap.get(other.rank)) {
            return 0;
        }
        return -1;
    }

    // allows printing as atring
    @Override
    public String toString() {
        String cardString = "";
        cardString += rankToString.get(this.rank) + " of " + suitToString.get(this.suit) + "\n";
        return cardString;
    }

    // creates new card, constructor
    public Card(Suits in_suit, Ranks in_rank) {
        suit = in_suit;
        rank = in_rank;
    }

    // suit getter
    public Suits getSuit() {
        return suit;
    }

    // rank getter
    public Ranks getRank() {
        return rank;
    }
}
