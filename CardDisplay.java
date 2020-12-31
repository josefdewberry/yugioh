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

        System.out.println("A specific card?");
        String specific = scanner.next();
        if (specific.toLowerCase().equals("y") || specific.toLowerCase().equals("yes")) {
            System.out.println("Enter card name: ");
            String name = scanner.next();
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).name.equals(name)) {
                    if (cards.get(i).cardType == CardType.MONSTER) {
                        System.out.println("\n" + (MonsterCard) cards.get(i).print());
                    } else if (cards.get(i).cardType == CardType.SPELL) {
                        System.out.println("\n" + (SpellCard) cards.get(i).print());
                    } else if (cards.get(i).cardType == CardType.TRAP) {
                        System.out.println("\n" + (TrapCard) cards.get(i).print());
                    }
                }
            } 
        }   
        System.out.println("Monster, Spell, or Trap card?");
        Scanner scanner = new Scanner(System.in);

        String type = scanner.next();
        if (type.equals("Monster")) {

        } else if (type.equals("Spell") || type.equals("Trap")) {
            
            System.out.println("What type of effect?");
            String effect = scanner.next();
            
        } else {
            System.out.println("Sorry, something went wrong.");
            scanner.close();
            System.exit(0);
        }
        scanner.close();
    }
}