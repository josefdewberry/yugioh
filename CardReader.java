package yugioh;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.net.URL;

import yugioh.Card.*;
import yugioh.Date.*;

/**
 * Reads through cards.tsv and creates an arraylist of yugioh cards.
 */
public class CardReader {

    /**
     * Builds a monster card with all its extra properties.
     * 
     * @param cardInfo All the card information as a tab separated line
     * @return The build card
     */
    public static MonsterCard buildMonster(String cardInfo) {
        // Base card properties
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;

        // Proprerties unique to monster cards.
        Attribute attribute;
        int level;
        Type type;
        int atk;
        int def;

        // Build a scanner and change the delimiter to a tab
        Scanner scanner = new Scanner(cardInfo);
        scanner.useDelimiter("\t");
        // The first token is that the card is a monster card, which we already know.
        scanner.next();

        // Gleam the needed info
        effect = Effect.findMatch(scanner.next());
        name = scanner.next();
        attribute = Attribute.findMatch(scanner.next());
        level = scanner.nextInt();
        type = Type.findMatch(scanner.next());
        atk = scanner.nextInt();
        def = scanner.nextInt();
        description = scanner.next();
        code = scanner.nextInt();
        date = new Date(scanner.next());
        releaseName = scanner.next();
        releaseType = ReleaseType.findMatch(scanner.next());

        // Close the scanner for good measure.
        scanner.close();

        // Make and return the monster card.
        MonsterCard monsterCard = new MonsterCard(name, description, effect, code, date, releaseName, releaseType, atk, def, level, type, attribute);
        return monsterCard;
    }

    /**
     * Builds the spell or trap card, which only requires the base
     * properties.
     * 
     * @param cardInfo The card information as a tab separated line.
     * @param cardType Whether the card is a spell or trap.
     * @return The built card
     */
    public static NonMonsterCard buildNonMonster(String cardInfo, CardType cardType) {
        // All the base properties of a card.
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;

        // Build the scanner and change the delimiter to a tab.
        Scanner scanner = new Scanner(cardInfo);
        scanner.useDelimiter("\t");
        scanner.next();

        effect = Effect.findMatch(scanner.next());
        name = scanner.next();

        // These are all properties that don't exist in the 
        // line, specific only to monster cards. Just skip
        // over them.
        scanner.next();
        scanner.next();
        scanner.next();
        scanner.next();
        scanner.next();

        // Continue filling the fields.
        description = scanner.next();
        code = scanner.nextInt();
        date = new Date(scanner.next());
        releaseName = scanner.next();
        releaseType = ReleaseType.findMatch(scanner.next());

        // Close the scanner for good measure!
        scanner.close();

        // Build and return the card.
        NonMonsterCard nonMonster = new NonMonsterCard(name, description, effect, code, date, releaseName, releaseType, cardType);
        return nonMonster;
    }

    /**
     * Scan through the cards.tsv file and build an arraylist of 
     * every detailed card.
     * @return An arraylist of yugioh cards.
     */
    public static ArrayList<Card> read() {
        // Cause we're working with files we need to throw everything
        // in a try/catch block.
        try {

            // I couldn't find the file without using this URL class.
            URL path = CardReader.class.getResource("cards.tsv");
            File f = new File(path.getFile());
            Scanner scanner = new Scanner(f);

            // The scanner should obviously have at least one line.
            // This line is the header and can be discarded.
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                System.out.println("Error: no first line!");
                System.exit(0);
            }

            // Make the empty arraylist for our cards.
            ArrayList<Card> cards = new ArrayList();

            // The main loop that reads all the cards.
            while (scanner.hasNextLine()) {

                // Get a line and build a scanner to read the 
                // card type.
                String cardInfo = scanner.nextLine();
                Scanner lineScanner = new Scanner(cardInfo);
                lineScanner.useDelimiter("\t");
                String cardType = "";

                // Read the first field.
                if (lineScanner.hasNext()) {
                    cardType = lineScanner.next();
                } else {
                    System.out.println("Error: bad line read, no token found!");
                }

                // Determine if the card is a monster or non-monster
                // and pass it off accordingly.
                switch(cardType) {
                    case "Monster":
                        cards.add(buildMonster(cardInfo));
                        break;
                    case "Spell":
                        cards.add(buildNonMonster(cardInfo, CardType.SPELL));
                        break;
                    case "Trap":
                        cards.add(buildNonMonster(cardInfo, CardType.TRAP));
                        break;
                    default:
                        System.out.println("Error: card type not found!");
                }
                lineScanner.close();
            }

            scanner.close();

            // Just some print statements to make sure nothing broke.
            // Can easily be done away with.
            System.out.println("We read the cards without breaking!");
            System.out.println("Size: " + cards.size());

            return cards;
        // Throw if something breaks.
        } catch(Exception e) {
            System.out.println("Try catch block broke.");
            System.exit(0);
        }
        // This shouldn't happen.
        return null;
    }
}