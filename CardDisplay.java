package yugioh;

import yugioh.Card;
import yugioh.CardReader;
import yugioh.Card.*;
import yugioh.CardReader.*;
import yugioh.Date.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program that displays all yugioh cards. It also allows the user to display cards
 * based upon specifications such as certain effects, attributes, etc.
 */
public class CardDisplay {
    
    // A list of all the cards available
    public static ArrayList<Card> cards;

    /**
     * Gathers all the cards into an arraylist and then prompts the user
     * what cards to read.
     * @param args User arguments, none used here.
     */
    public static void main(String[] args) {

        // Runs the CardReader program to read all the cards
        // from cards.tsv
        cards = CardReader.read();

        // Prints every single cards name, in case the user
        // is looking for a specific card.
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).name);
        }

        // Space things out.
        System.out.println();

        // Gathers user input
        Scanner scanner = new Scanner(System.in);

        // Endlessly loop until the user exits the program themself.
        while (true) {

            // Asks the user if they are looking for a specific card.
            // If they say no then it moves on to asking about what
            // types of cards to display.
            System.out.println("Find a specific card? [Type exit to exit]");
            String specific = scanner.nextLine();

            // Exit the program.
            if (specific.toLowerCase().equals("exit")) {
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
            }

            // Only works if the user types y or yes, not caps sensitive.
            if (specific.toLowerCase().equals("y") || specific.toLowerCase().equals("yes")) {
                // Get the user's card request.
                System.out.println("Enter card name: ");
                String name = scanner.nextLine();
                
                // Run through all the cards to find the right one.
                for (int i = 0; i < cards.size(); i++) {
                    //If we found the right card...
                    if (cards.get(i).name.equals(name)) {
                        // Unfortunately the way I have the toString methods set up I
                        // have to figure out what CardType the card is and then 
                        // type cast it.
                        if (cards.get(i).cardType == CardType.MONSTER) {
                            MonsterCard printCard = (MonsterCard) cards.get(i);
                            System.out.println("\n" + printCard.print());
                        } else if (cards.get(i).cardType == CardType.SPELL) {
                            SpellCard printCard = (SpellCard) cards.get(i);
                            System.out.println("\n" + printCard.print());
                        } else if (cards.get(i).cardType == CardType.TRAP) {
                            TrapCard printCard = (TrapCard) cards.get(i);
                            System.out.println("\n" + printCard.print());
                        }
                    }
                } 

            // If the user isn't looking for a specific card...
            } else if (specific.toLowerCase().equals("n") || specific.toLowerCase().equals("no")) {
                // Begin to whittle down what type of card they're looking for. The user
                // must chose a monster, spell, or trap.
                System.out.println("Monster, Spell, or Trap card?");
                String type = scanner.nextLine();

                // There's a lot of properties to display monster's by,
                // so bear with me.
                if (type.equals("Monster")) {

                    System.out.println("What type of attribute?");
                    String attribute = scanner.nextLine();

                    System.out.println("Minimum level?");
                    int minLevel = scanner.nextInt();

                    // Clear the line because it leaves an EOF symbol after
                    // the int.
                    System.out.println("Maximum level?");
                    int maxLevel = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("What type?");
                    String testType = scanner.nextLine();

                    System.out.println("What type of effect?");
                    String effect = scanner.nextLine();

                    // Blank line to space out the printed list.
                    System.out.println();

                    // Search through the cards and print the ones that match the specification.
                    for (int i = 0; i < cards.size(); i++) {
                        if (cards.get(i).cardType == CardType.MONSTER) {
                            // Easier to check the card's properties if we pull it out of the card list.
                            MonsterCard testCard = (MonsterCard) cards.get(i);
                            if (attribute.toLowerCase().equals("none") || testCard.attribute == Attribute.findMatch(attribute)) {
                                if (minLevel <= testCard.level && testCard.level <= maxLevel) {
                                    if (testType.toLowerCase().equals("none") || testCard.type == Type.findMatch(testType)) {
                                        if (effect.toLowerCase().equals("none") || testCard.effect == Effect.findMatch(effect)) {
                                            System.out.println(testCard.name);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    System.out.println();

                // Spells and traps have the same exact properties and can be dealt with
                // together.
                } else if (type.equals("Spell") || type.equals("Trap")) {
                    
                    // The only real property spells and traps have to organize is
                    // its effect.
                    System.out.println("What type of effect?");
                    String effect = scanner.next();

                    // Blank line to space things out.
                    System.out.println();

                    // Search through the cards and if it has the desired effect
                    // then display it. This also weeds out the desired cardType
                    // (spell or trap).
                    for (int i = 0; i < cards.size(); i++) {
                        if (cards.get(i).cardType == CardType.findMatch(type)) {
                            if (effect.toLowerCase().equals("none")) {
                                System.out.println(cards.get(i).name);
                            } else if (cards.get(i).effect.toString().equals(effect)) {
                                System.out.println(cards.get(i).name);
                            }
                        }
                    }

                    scanner.nextLine();
                    System.out.println();

                // Bad input
                } else {
                    System.out.println("Sorry, something went wrong.");
                    scanner.close();
                    System.exit(0);
                }
            // Bad input
            } else {
                System.out.println("Sorry, didn't understand that input.");
            }
        }
    }
}