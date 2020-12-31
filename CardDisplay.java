package yugioh;

import yugioh.Card;
import yugioh.CardReader;
import yugioh.Card.*;
import yugioh.CardReader.*;
import yugioh.Date.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CardDisplay {
    
    public static ArrayList<Card> cards;

    public static void main(String[] args) {

        cards = CardReader.read();

        for (int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).name);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("A specific card?");
        String specific = scanner.next();
        if (specific.toLowerCase().equals("y") || specific.toLowerCase().equals("yes")) {
            System.out.println("Enter card name: ");
            String name = scanner.next();
            
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).name.equals(name)) {
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
        }   
        System.out.println("Monster, Spell, or Trap card?");

        String type = scanner.next();
        if (type.equals("Monster")) {
            System.out.println("What type of attribute?");
            String attribute = scanner.next();
            System.out.println("Minimum level?");
            int minLevel = scanner.nextInt();
            System.out.println("Maximum level?");
            int maxLevel = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What type?");
            String testType = scanner.nextLine();
            System.out.println("What type of effect?");
            String effect = scanner.next();
            System.out.println();
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).cardType == CardType.MONSTER) {
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
        } else if (type.equals("Spell") || type.equals("Trap")) {
            
            System.out.println("What type of effect?");
            String effect = scanner.next();
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).cardType == CardType.findMatch(type)) {
                    if (effect.toLowerCase().equals("none")) {
                        System.out.println(cards.get(i).name);
                    } else if (cards.get(i).effect.toString().equals(effect)) {
                        System.out.println(cards.get(i).name);
                    }
                }
            }

        } else {
            System.out.println("Sorry, something went wrong.");
            scanner.close();
            System.exit(0);
        }
        scanner.close();
    }
}