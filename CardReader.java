package yugioh;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.net.URL;

import yugioh.Card.*;
import yugioh.Date.*;

public class CardReader {
    
    public static ArrayList cards = new ArrayList();

    public static MonsterCard buildMonster(String cardInfo) {
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;
        CardType cardType;

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
        cardType = CardType.MONSTER;

        scanner.close();

        MonsterCard monsterCard = new MonsterCard(name, description, effect, code, date, releaseName, releaseType, atk, def, level, type, attribute);
  
        return monsterCard;
    }

    public static SpellCard buildSpell(String cardInfo) {
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;
        CardType cardType;

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
        cardType = CardType.SPELL;

        scanner.close();

        SpellCard spellCard = new SpellCard(name, description, effect, code, date, releaseName, releaseType);

        return spellCard;
    }

    public static TrapCard buildTrap(String cardInfo) {
        String name;
        String description;
        Effect effect;
        int code;
        Date date;
        String releaseName;
        ReleaseType releaseType;
        CardType cardType;

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
        cardType = CardType.TRAP;

        scanner.close();

        TrapCard trapCard = new TrapCard(name, description, effect, code, date, releaseName, releaseType);

        return trapCard;
    }

    public static void main(String[] args) {
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
                        System.out.println("Monster added!");
                        break;
                    case "Spell":
                        cards.add(buildSpell(cardInfo));
                        System.out.println("Spell added!");
                        break;
                    case "Trap":
                        cards.add(buildTrap(cardInfo));
                        System.out.println("Trap added!");
                        break;
                    default:
                        System.out.println("Error: card type not found!");
                }
                lineScanner.close();
            }

            System.out.println("We read the cards without breaking!");
            System.out.println("Size: " + cards.size());
        } catch(Exception e) {
            System.out.println("Try catch block broke.");
        }
    }
}