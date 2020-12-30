package yugioh;

import yugioh.Date.*;

public class Card {

    public enum Effect {
        
        NORMAL {
            public String toString() {
                return("Normal");
            }
        },
        EFFECT {
            public String toString() {
                return("Effect");
            }
        },
        FLIP {
            public String toString() {
                return("Flip");
            }
        },
        FIELD {
            public String toString() {
                return("Field");
            }
        },
        EQUIP {
            public String toString() {
                return("Equip");
            }
        },
        CONTINUOUS {
            public String toString() {
                return("Continuous");
            }
        };

        public static Effect findMatch(String s) {
            if (s.equals("Normal")) { return NORMAL; }
            if (s.equals("Flip")) { return FLIP; }
            if (s.equals("Field")) { return FIELD; }
            if (s.equals("Equip")) { return EQUIP; }
            if (s.equals("Effect")) { return EFFECT; }
            if (s.equals("Continuous")) { return CONTINUOUS; }

            return null;
        }
    }
    
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

            return null;
        }
    }
    
    public enum Attribute {
        DARK,
        LIGHT,
        EARTH,
        FIRE,
        WIND,
        WATER;

        public static Attribute findMatch(String s) {
            if (s.equals("DARK")) { return DARK; }
            if (s.equals("LIGHT")) { return LIGHT; }
            if (s.equals("EARTH")) { return EARTH; }
            if (s.equals("FIRE")) { return FIRE; }
            if (s.equals("WIND")) { return WIND; }
            if (s.equals("WATER")) { return WATER; }

            return null;
        }
    }
    
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
    
    public enum ReleaseType {
        SET {
            public String toString() {
                return("Set");
            }
        };

        public static ReleaseType findMatch(String s) {
            if (s.equals("Set")) { return SET; }

            return null;
        }
    }
    
    String name;
    String description;
    Effect effect;
    int code;
    Date date;
    String releaseName;
    ReleaseType releaseType;
    CardType cardType;


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


    public static class MonsterCard extends Card {
        int atk;
        int def;
        int level;
        Type type;
        Attribute attribute;

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

        public String detailedPrint() {
            
            String s = print();
            s = s.concat(code + "\n");
            s = s.concat("Released on: "+ date.print() + "\n");
            s = s.concat("Released in the " + releaseType + ": " + releaseName + "\n");
            return s;
        }
    }

    public static class SpellCard extends Card {
        
        public SpellCard(String name, String description, Effect effect, int code, Date date, 
                    String releaseName, ReleaseType releaseType) {
                        super(name, description, effect, code, date, releaseName, releaseType, CardType.SPELL);
        }

        public String print() {

            String s = "Spell\n";
            s = s.concat(name + "\n");
            s = s.concat(effect + "\n");
            s = s.concat(description + "\n");
            return s;
        }

        public String detailedPrint() {
            
            String s = print();
            s = s.concat(code + "\n");
            s = s.concat("Released on: "+ date.print() + "\n");
            s = s.concat("Released in the " + releaseType + ": " + releaseName + "\n");
            return s;
        }
    }

    public static class TrapCard extends Card {
    
        public TrapCard(String name, String description, Effect effect, int code, Date date, 
                    String releaseName, ReleaseType releaseType) {
                        super(name, description, effect, code, date, releaseName, releaseType, CardType.TRAP);
        }
    
        public String print() {
    
            String s = "Trap\n";
            s = s.concat(name + "\n");
            s = s.concat(effect + "\n");
            s = s.concat(description + "\n");
            return s;
        }
    
        public String detailedPrint() {
            
            String s = print();
            s = s.concat(code + "\n");
            s = s.concat("Released on: "+ date.print() + "\n");
            s = s.concat("Released in the " + releaseType + ": " + releaseName + "\n");
            return s;
        }
    }
}