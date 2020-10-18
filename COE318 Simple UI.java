package coe318.lab5;

import java.util.Scanner;

/**
 * The detailed user interface for the blackjack game
 */
public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    private Boolean gameEnd = false;

    /**
     *
     * @param game sets the class game to the running blackjack game
     */
    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    /**
     * Displays the house and user cards.
     */
    @Override
    public void display() {
        System.out.println("House:" + System.lineSeparator() + game.getHouseCards().toString());
        System.out.println("You:" + System.lineSeparator() + game.getYourCards().toString());
    }

    /**
     * Determines if the user wants to be hit.
     * @return if the player wants to be hit
     */
    @Override
    public boolean hitMe() {
        System.out.println("Would you like a card? (y/n)");
        String in = user.nextLine().toLowerCase();
        if (in.equals("n"))
            return false;
        else if (in.equals("y"))
            return true;
        else
            return hitMe();
    }

    /**
     * Determines who has one the game, and displays that
     * to the user. Also asks the user if they would like
     * to play again.
     */
    @Override
    public void gameOver() {
        for (Card c : game.getHouseCards().getCards())
            c.setFaceUp(true);

        display();
        int houseScore = game.getHouseScore();
        int userScore = game.getUserScore();
        boolean winner = false;

        if(houseScore >= userScore) {
            if (houseScore > 21 && userScore > 21)
                winner = false;
            else if (houseScore > 21 && userScore <= 21)
                winner = true;
            else
                winner = false;
        }
        else {
            if (houseScore >= 21 && userScore > 21)
                winner = false;
            else if(houseScore <= 21 && userScore > 21)
                winner = false;
            else
                winner =  true;
        }


        if (!winner) {
            System.out.println("The House is the winner with a score: " + Integer.toString(houseScore) + ".");
            System.out.println("Your score is: " + Integer.toString(userScore) + ".");
        }
        else {
            System.out.println("The You are the the winner with a score: " + Integer.toString(userScore) + ".");
            System.out.println("The House score is: " + Integer.toString(houseScore) + ".");
        }
        System.out.println("Would you like to play again? (y/n)");
        while(!gameEnd) {
            String in = user.nextLine().toLowerCase();
            if (in.equals("y"))
                game.main(null);
            else if (in.equals("n")) ;
                gameEnd = true;
        }

    }
}
