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

        System.out.println("What card would you like to look at?");
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();

        for (int i = 0; i < cards.size(); i++) {
            if (name.equals(cards.get(i).name)) {
                if (cards.get(i).cardType == CardType.MONSTER) {
                    MonsterCard mCard = (MonsterCard) cards.get(i);
                    System.out.println("\n" + mCard.print());
                } else if (cards.get(i).cardType == CardType.SPELL) {
                    SpellCard sCard = (SpellCard) cards.get(i);
                    System.out.println("\n" + sCard.print());
                } else if (cards.get(i).cardType == CardType.TRAP) {
                    TrapCard tCard = (TrapCard) cards.get(i);
                    System.out.println("\n" + tCard.print());
                }
            }
        }
    }
}
