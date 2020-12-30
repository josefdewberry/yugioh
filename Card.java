package yugioh;

import yugioh.Date.*;

/**
 * An object representing a single yugioh card.
 */
public class Card {

    /**
     * All cards have an effect (technically some cards don't, but we are considering
     * those to have a "normal" effect). I've also given each enum a toString() method
     * for ease of printing.
     */
    public enum Effect {
        
        // The normal effect (i.e. no effect), applicable to all cards.
        NORMAL {
            public String toString() {
                return("Normal");
            }
        },
        // The regular effect, applicable to all cards.
        EFFECT {
            public String toString() {
                return("Effect");
            }
        },
        // Applicable only to monster cards.
        FLIP {
            public String toString() {
                return("Flip");
            }
        },
        // Applicable only to spell cards.
        FIELD {
            public String toString() {
                return("Field");
            }
        },
        // Applicable only to spell cards.
        EQUIP {
            public String toString() {
                return("Equip");
            }
        },
        // Applicable only to spell and trap cards.
        CONTINUOUS {
            public String toString() {
                return("Continuous");
            }
        };

        // Effects are given as strings, so this is for ease of matching
        // a string to an enum.
        public static Effect findMatch(String s) {
            if (s.equals("Normal")) { return NORMAL; }
            if (s.equals("Flip")) { return FLIP; }
            if (s.equals("Field")) { return FIELD; }
            if (s.equals("Equip")) { return EQUIP; }
            if (s.equals("Effect")) { return EFFECT; }
            if (s.equals("Continuous")) { return CONTINUOUS; }

            // This shouldn't happen.
            return null;
        }
    }
    
    /**
     * Monster cards have a type. There's quite a few of them.
     */
    public enum Type {
        AQUA,
        BEAST,
        BEASTWARRIOR,
        DINOSAUR,
        DRAGON,
        FAIRY,
        FIEND,
        FISH,
        INSECT,
        MACHINE,
        PLANT,
        PYRO,
        REPTILE,
        ROCK,
        SEASERPENT,
        SPELLCASTER,
        THUNDER,
        WARRIOR,
        WINGEDBEAST,
        ZOMBIE;

        // Types are given as strings, so this is for ease of matching
        // the string to an enum. Notice certain types aren't actually
        // one word but rather two words or hyphanated.
        public static Type findMatch(String s) {
            if (s.equals("Aqua")) { return AQUA; }
            if (s.equals("Beast")) { return BEAST; }
            if (s.equals("Beast-Warrior")) { return BEASTWARRIOR; }
            if (s.equals("Dinosaur")) { return DINOSAUR; }
            if (s.equals("Dragon")) { return DRAGON; }
            if (s.equals("Fairy")) { return FAIRY; }
            if (s.equals("Fiend")) { return FIEND; }
            if (s.equals("Fish")) { return FISH; }
            if (s.equals("Insect")) { return INSECT; }
            if (s.equals("Machine")) { return MACHINE; }
            if (s.equals("Plant")) { return PLANT; }
            if (s.equals("Pyro")) { return PYRO; }
            if (s.equals("Reptile")) { return REPTILE; }
            if (s.equals("Rock")) { return ROCK; }
            if (s.equals("Sea Serpent")) { return SEASERPENT; }
            if (s.equals("Spellcaster")) { return SPELLCASTER; }
            if (s.equals("Thunder")) { return THUNDER; }
            if (s.equals("Warrior")) { return WARRIOR; }
            if (s.equals("Winged Beast")) { return WINGEDBEAST; }
            if (s.equals("Zombie")) { return ZOMBIE; }

            // This shouldn't happen, although it might if I add newer
            // cards and forget to add the appropriate type (i.e. alien type)
            return null;
        }
    }
    
    /**
     * All monsters have an attribute.
     */
    public enum Attribute {
        DARK,
        LIGHT,
        EARTH,
        FIRE,
        WIND,
        WATER;

        // Attributes are given as a string, so this is for ease of
        // matching a string to the appropriate enum. These are given
        // in all caps because that's how most yugioh databases do it.
        public static Attribute findMatch(String s) {
            if (s.equals("DARK")) { return DARK; }
            if (s.equals("LIGHT")) { return LIGHT; }
            if (s.equals("EARTH")) { return EARTH; }
            if (s.equals("FIRE")) { return FIRE; }
            if (s.equals("WIND")) { return WIND; }
            if (s.equals("WATER")) { return WATER; }

            // This shouldn't happen.
            return null;
        }
    }
    
    /**
     * All cards have a type, and there are only three. The card type determines the fields
     * and properties it has, although spell and trap cards are very similar. Monster cards
     * have a lot more property than spell and trap cards.
     */
    public enum CardType {
        MONSTER {
            public String toString() {
                return("Monster");
            }
        },
        SPELL {
            public String toString() {
                return("Spell");
            }
        },
        TRAP {
            public String toString() {
                return("Trap");
            }
        }
    }
    
    /**
     * This is how the card was originally released. There are more than just sets,
     * but I haven't gotten to those yet.
     */
    public enum ReleaseType {
        // One of those silver sleeves with like 10 cards.
        SET {
            public String toString() {
                return("Set");
            }
        };

        // Sets come as strings, so this is to easily match
        // the string to the proper enum.
        public static ReleaseType findMatch(String s) {
            if (s.equals("Set")) { return SET; }

            // This shouldn't happen.
            return null;
        }
    }
    
    // All cards have at least these properties.
    String name;
    String description;
    Effect effect;
    int code;
    Date date;
    String releaseName;
    ReleaseType releaseType;
    CardType cardType;


    /**
     * Constructor for a basic card type. Should never be called unless by an 
     * inherited class.
     * 
     * @param name The name of the card.
     * @param description The text of the card, can be the actual rules of the effect
     * or just a description.
     * @param effect The type of effect the card has.
     * @param code The code that is used in yugioh video games as a unique identifier.
     * @param date The date the card was released.
     * @param releaseName The name of the release item.
     * @param releaseType The type of item in which the card was released.
     * @param cardType The card type (i.e. monster, spell, trap).
     */
    public Card(String name, String description, Effect effect, int code, Date date, 
                String releaseName, ReleaseType releaseType, CardType cardType) {
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.code = code;
        this.date = date;
        this.releaseName = releaseName;
        this.releaseType = releaseType;
        this.cardType = cardType;
    }


    /**
     * Monster cards have other properties that spell/trap cards don't.
     */
    public static class MonsterCard extends Card {

        // The extra monster card properties.
        int atk;
        int def;
        int level;
        Type type;
        Attribute attribute;

        /**
         * Constructor for a monster card type.
         * 
         * @param name The name of the card.
         * @param description The text of the card, can be the actual rules of the effect
         * or just a description.
         * @param effect The type of effect the card has.
         * @param code The code that is used in yugioh video games as a unique identifier.
         * @param date The date the card was released.
         * @param releaseName The name of the release item.
         * @param releaseType The type of item in which the card was released.
         * @param cardType The card type (i.e. monster, spell, trap).
         * @param atk The monster's attack points value.
         * @param def The monster's defense points value.
         * @param level The monster's level (the stars below the name).
         * @param type The monster's type (above the description in the box).
         * @param attribute The monster's elemental attribute (in the top right corner).
         */
        public MonsterCard (String name, String description, Effect effect, int code, Date date, 
                            String releaseName, ReleaseType releaseType, int atk, int def, int level,
                            Type type, Attribute attribute) {
            super(name, description, effect, code, date, releaseName, releaseType, CardType.MONSTER);
            this.atk = atk;
            this.def = def;
            this.level = level;
            this.type = type;
            this.attribute = attribute;
        }

        /**
         * Currently I don't have the print method actually print. It should be 
         * renamed to toString(). I'll do that later.
         * 
         * @return The proper formatted string to be printed.
         */
        public String print() {

            String s = "Monster\n";
            s = s.concat(name + "\n");
            s = s.concat(attribute + "\n");
            s = s.concat("Level: " + level + "\n");
            s = s.concat(type + "\n");
            s = s.concat(effect + "\n");
            s = s.concat(atk + "/" + def + "\n");
            s = s.concat(description + "\n");
            return s;
        }

        /**
         * This should be toStringDetailed(). I'll do that later too. This adds
         * extra information that probably isn't normally needed when just looking at a card.
         * @return The properly formatted string to be printed.
         */
        public String detailedPrint() {
            
            String s = print();
            s = s.concat(code + "\n");
            s = s.concat("Released on: "+ date.print() + "\n");
            s = s.concat("Released in the " + releaseType + ": " + releaseName + "\n");
            return s;
        }
    }

    /**
     * Spell cards don't have extra properties. In reality this could be
     * combined with trap cards to form one class. I'll do that later.
     */
    public static class SpellCard extends Card {
        
        /**
         * Constructor for a spell card type.
         * 
         * @param name The name of the card.
         * @param description The text of the card, can be the actual rules of the effect
         * or just a description.
         * @param effect The type of effect the card has.
         * @param code The code that is used in yugioh video games as a unique identifier.
         * @param date The date the card was released.
         * @param releaseName The name of the release item.
         * @param releaseType The type of item in which the card was released.
         * @param cardType The card type (i.e. monster, spell, trap).
         */
        public SpellCard(String name, String description, Effect effect, int code, Date date, 
                    String releaseName, ReleaseType releaseType) {
                        super(name, description, effect, code, date, releaseName, releaseType, CardType.SPELL);
        }

        /**
         * Should be renamed to toString()
         * @return A properly formatted string to be printed.
         */
        public String print() {

            String s = "Spell\n";
            s = s.concat(name + "\n");
            s = s.concat(effect + "\n");
            s = s.concat(description + "\n");
            return s;
        }

        /**
         * Should be renamed to toStringDetailed()
         * @return The properly formatted string to be printed with extra details.
         */
        public String detailedPrint() {
            
            String s = print();
            s = s.concat(code + "\n");
            s = s.concat("Released on: "+ date.print() + "\n");
            s = s.concat("Released in the " + releaseType + ": " + releaseName + "\n");
            return s;
        }
    }

    /**
     * Spell cards don't have extra properties. In reality this could be
     * combined with trap cards to form one class. I'll do that later.
     */
    public static class TrapCard extends Card {
    
        /**
         * Constructor for a spell card type.
         * 
         * @param name The name of the card.
         * @param description The text of the card, can be the actual rules of the effect
         * or just a description.
         * @param effect The type of effect the card has.
         * @param code The code that is used in yugioh video games as a unique identifier.
         * @param date The date the card was released.
         * @param releaseName The name of the release item.
         * @param releaseType The type of item in which the card was released.
         * @param cardType The card type (i.e. monster, spell, trap).
         */
        public TrapCard(String name, String description, Effect effect, int code, Date date, 
                    String releaseName, ReleaseType releaseType) {
                        super(name, description, effect, code, date, releaseName, releaseType, CardType.TRAP);
        }
    
        /**
         * Should be renamed to toString()
         * @return A properly formatted string to be printed.
         */
        public String print() {
    
            String s = "Trap\n";
            s = s.concat(name + "\n");
            s = s.concat(effect + "\n");
            s = s.concat(description + "\n");
            return s;
        }
    
        /**
         * Should be renamed to toStringDetailed()
         * @return The properly formatted string to be printed with extra details.
         */
        public String detailedPrint() {
            
            String s = print();
            s = s.concat(code + "\n");
            s = s.concat("Released on: "+ date.print() + "\n");
            s = s.concat("Released in the " + releaseType + ": " + releaseName + "\n");
            return s;
        }
    }
}