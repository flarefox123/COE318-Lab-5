package coe318.lab5;

/**
 * A general user interface for the blackjack game
 */
public interface UserInterface {//DO NOT MODIFY
    /** Set the Blackjack game
     * this UserInterface belongs to.
     * @param game the game to be played
     */
    public void setGame(BlackjackGame game);
    /**
     * Display the cards held by the House
     * and the player (you).
     */
    public void display();
    /**
     * Prompt the user if they want another
     * card.
     * @return Return true if another card
     * desired.
     */
    public boolean hitMe();
    /**
     * Display the final cards, scores
     * and winner.
     */
    public void gameOver();
}
