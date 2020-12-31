package yugioh;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.net.URL;

import yugioh.Card.*;
import yugioh.Date.*;

public class CardReader {

    public static MonsterCard buildMonster(String cardInfo) {
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;

        Attribute attribute;
        int level;
        Type type;
        int atk;
        int def;

        Scanner scanner = new Scanner(cardInfo);
        scanner.useDelimiter("\t");
        scanner.next();
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

        scanner.close();

        MonsterCard monsterCard = new MonsterCard(name, description, effect, code, date, releaseName, releaseType, atk, def, level, type, attribute);
  
        return monsterCard;
    }

    public static NonMonsterCard buildNonMonster(String cardInfo, CardType cardType) {
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;

        Scanner scanner = new Scanner(cardInfo);
        
        scanner.useDelimiter("\t");
        scanner.next();
        effect = Effect.findMatch(scanner.next());
        name = scanner.next();

        scanner.next();
        scanner.next();
        scanner.next();
        scanner.next();
        scanner.next();

        description = scanner.next();
        code = scanner.nextInt();
        date = new Date(scanner.next());
        releaseName = scanner.next();
        releaseType = ReleaseType.findMatch(scanner.next());

        scanner.close();

        NonMonsterCard nonMonster = new NonMonsterCard(name, description, effect, code, date, releaseName, releaseType, cardType);

        return nonMonster;
    }

    public static ArrayList<Card> read() {
        try {

            URL path = CardReader.class.getResource("cards.tsv");
            File f = new File(path.getFile());

            Scanner scanner = new Scanner(f);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                System.out.println("Error: no first line!");
                System.exit(0);
            }

            ArrayList<Card> cards = new ArrayList();

            while (scanner.hasNextLine()) {

                String cardInfo = scanner.nextLine();

                Scanner lineScanner = new Scanner(cardInfo);

                String cardType = "";

                lineScanner.useDelimiter("\t");
                if (lineScanner.hasNext()) {
                    cardType = lineScanner.next();
                } else {
                    System.out.println("Error: bad line read, no token found!");
                }

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

            System.out.println("We read the cards without breaking!");
            System.out.println("Size: " + cards.size());

            return cards;
        } catch(Exception e) {
            System.out.println("Try catch block broke.");
            System.exit(0);
        }
        return null;
    }
}