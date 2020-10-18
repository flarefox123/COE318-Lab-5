package coe318.lab5;
import java.util.ArrayList;
import java.util.Random;
/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        cards = new ArrayList<>();

    }
    /**
     * Add a card to the pile.
     * @param card the card to be added to the cardpile
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return The card that has been removed
     */
    public Card removeRandom() {
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        Card toBeRemoved = cards.get(index);
        cards.remove(index);
        return toBeRemoved;
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return The string representation
     */
    @Override
    public String toString() {
        String list = "";
        for(Card c: cards)
            list += c.toString() + System.lineSeparator();
        return list;
    }

    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        deck.toString();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}
