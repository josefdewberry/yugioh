package yugioh;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.text.*;

import yugioh.Card.*;
import yugioh.CardDisplay.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import yugioh.WrapLayout.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class GUI {

    CardType cardType = CardType.ALL;
    Effect effect = Effect.ALL;
    Attribute attribute = Attribute.ALL;
    Type type = Type.ALL;
    int minLevel = 1;
    int maxLevel = 12;
    int minAtk = 0;
    int maxAtk = 9999;
    int minDef = 0;
    int maxDef = 9999;

    public GUI() {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(CardDisplay.allCardNames());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.setColumns(27);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JPanel cardTypePanel = new JPanel();
        cardTypePanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        JLabel cardTypeLabel = new JLabel("Card Type: ");

        JRadioButton cardTypeMonster = new JRadioButton("Monster");
        JRadioButton cardTypeSpell = new JRadioButton("Spell");
        JRadioButton cardTypeTrap = new JRadioButton("Trap");
        ButtonGroup cardTypeGroup = new ButtonGroup();
        cardTypeGroup.add(cardTypeMonster);
        cardTypeGroup.add(cardTypeSpell);
        cardTypeGroup.add(cardTypeTrap);
        cardTypeGroup.setSelected(cardTypeMonster.getModel(), true);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new BorderLayout());
        JPanel monsterEffectPanel = new JPanel();
        monsterEffectPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        monsterEffectPanel.setVisible(false);
        JLabel monsterEffectLabel = new JLabel("Monster Effect: ");

        JRadioButton monsterEffectAll = new JRadioButton("All");
        JRadioButton monsterEffectNormal = new JRadioButton("Normal");
        JRadioButton monsterEffectEffect = new JRadioButton("Effect");
        JRadioButton monsterEffectFlip = new JRadioButton("Flip");
        JRadioButton monsterEffectFusion = new JRadioButton("Fusion");
        ButtonGroup monsterEffectGroup = new ButtonGroup();
        monsterEffectGroup.add(monsterEffectAll);
        monsterEffectGroup.add(monsterEffectNormal);
        monsterEffectGroup.add(monsterEffectEffect);
        monsterEffectGroup.add(monsterEffectFlip);
        monsterEffectGroup.add(monsterEffectFusion);
        monsterEffectGroup.setSelected(monsterEffectAll.getModel(), true);

        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.setLayout(new BorderLayout());
        JPanel spellEffectPanel = new JPanel();
        spellEffectPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        spellEffectPanel.setVisible(false);
        JLabel spellEffectLabel = new JLabel("Spell Effect: ");

        JRadioButton spellEffectAll = new JRadioButton("All");
        JRadioButton spellEffectNormal = new JRadioButton("Normal");
        JRadioButton spellEffectContinuous = new JRadioButton("Continuous");
        JRadioButton spellEffectEquip = new JRadioButton("Equip");
        JRadioButton spellEffectField = new JRadioButton("Field");
        ButtonGroup spellEffectGroup = new ButtonGroup();
        spellEffectGroup.add(spellEffectAll);
        spellEffectGroup.add(spellEffectNormal);
        spellEffectGroup.add(spellEffectContinuous);
        spellEffectGroup.add(spellEffectEquip);
        spellEffectGroup.add(spellEffectField);
        spellEffectGroup.setSelected(spellEffectAll.getModel(), true);

        JPanel buttonPanel4 = new JPanel();
        buttonPanel4.setLayout(new BorderLayout());
        JPanel trapEffectPanel = new JPanel();
        trapEffectPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        trapEffectPanel.setVisible(false);
        JLabel trapEffectLabel = new JLabel("Trap Effect: ");

        JRadioButton trapEffectAll = new JRadioButton("All");
        JRadioButton trapEffectNormal = new JRadioButton("Normal");
        JRadioButton trapEffectContinuous = new JRadioButton("Continuous");
        JRadioButton trapEffectCounter = new JRadioButton("Counter");
        ButtonGroup trapEffectGroup = new ButtonGroup();
        trapEffectGroup.add(trapEffectAll);
        trapEffectGroup.add(trapEffectNormal);
        trapEffectGroup.add(trapEffectContinuous);
        trapEffectGroup.add(trapEffectCounter);
        trapEffectGroup.setSelected(trapEffectAll.getModel(), true);

        JPanel buttonPanel5 = new JPanel();
        buttonPanel5.setLayout(new BorderLayout());
        JPanel attributePanel = new JPanel();
        attributePanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        attributePanel.setVisible(false);
        JLabel attributeLabel = new JLabel("Monster Attribute: ");

        JRadioButton attributeAll = new JRadioButton("All");
        JRadioButton attributeDark = new JRadioButton("DARK");
        JRadioButton attributeLight = new JRadioButton("LIGHT");
        JRadioButton attributeEarth = new JRadioButton("EARTH");
        JRadioButton attributeFire = new JRadioButton("FIRE");
        JRadioButton attributeWater = new JRadioButton("WATER");
        JRadioButton attributeWind = new JRadioButton("WIND");
        ButtonGroup attributeGroup = new ButtonGroup();
        attributeGroup.add(attributeAll);
        attributeGroup.add(attributeDark);
        attributeGroup.add(attributeLight);
        attributeGroup.add(attributeEarth);
        attributeGroup.add(attributeFire);
        attributeGroup.add(attributeWater);
        attributeGroup.add(attributeWind);
        attributeGroup.setSelected(attributeAll.getModel(), true);

        JPanel buttonPanel6 = new JPanel();
        buttonPanel6.setLayout(new BorderLayout());
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        typePanel.setVisible(false);
        JLabel typeLabel = new JLabel("Monster Type: ");

        JRadioButton typeAll = new JRadioButton("All");
        JRadioButton typeAqua = new JRadioButton("Aqua");
        JRadioButton typeBeast = new JRadioButton("Beast");
        JRadioButton typeBeastwarrior = new JRadioButton("Beast-Warrior");
        JRadioButton typeDinosaur = new JRadioButton("Dinosaur");
        JRadioButton typeDragon = new JRadioButton("Dragon");
        JRadioButton typeFairy = new JRadioButton("Fairy");
        JRadioButton typeFiend = new JRadioButton("Fiend");
        JRadioButton typeFish = new JRadioButton("Fish");
        JRadioButton typeInsect = new JRadioButton("Insect");
        JRadioButton typeMachine = new JRadioButton("Machine");
        JRadioButton typePlant = new JRadioButton("Plant");
        JRadioButton typePyro = new JRadioButton("Pyro");
        JRadioButton typeReptile = new JRadioButton("Reptile");
        JRadioButton typeRock = new JRadioButton("Rock");
        JRadioButton typeSeaserpent = new JRadioButton("Sea Serpent");
        JRadioButton typeSpellcaster = new JRadioButton("Spellcaster");
        JRadioButton typeThunder = new JRadioButton("Thunder");
        JRadioButton typeWarrior = new JRadioButton("Warrior");
        JRadioButton typeWingedbeast = new JRadioButton("Winged Beast");
        JRadioButton typeZombie = new JRadioButton("Zombie");
        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(typeAll);
        typeGroup.add(typeAqua);
        typeGroup.add(typeBeast);
        typeGroup.add(typeBeast);
        typeGroup.add(typeBeastwarrior);
        typeGroup.add(typeDinosaur);
        typeGroup.add(typeDragon);
        typeGroup.add(typeFairy);
        typeGroup.add(typeFiend);
        typeGroup.add(typeFish);
        typeGroup.add(typeInsect);
        typeGroup.add(typeMachine);
        typeGroup.add(typePlant);
        typeGroup.add(typePyro);
        typeGroup.add(typeReptile);
        typeGroup.add(typeRock);
        typeGroup.add(typeSeaserpent);
        typeGroup.add(typeSpellcaster);
        typeGroup.add(typeThunder);
        typeGroup.add(typeWarrior);
        typeGroup.add(typeWingedbeast);
        typeGroup.add(typeZombie);
        typeGroup.setSelected(typeAll.getModel(), true);

        JPanel buttonPanel7 = new JPanel();
        buttonPanel7.setLayout(new BorderLayout());
        JPanel levelPanel = new JPanel();
        levelPanel.setVisible(false);
        levelPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        JLabel levelMinLabel = new JLabel("Minimum Level: ");
        String[] levels = {"1", "2", "3", "4", "5", "6",
                           "7", "8", "9", "10", "11", "12"};
        JComboBox levelMinBox = new JComboBox(levels);
        JLabel levelMaxLabel = new JLabel("Maximum Level: ");
        JComboBox levelMaxBox = new JComboBox(levels);
        levelMaxBox.setSelectedIndex(11);

        JPanel buttonPanel8 = new JPanel();
        buttonPanel8.setLayout(new BorderLayout());
        JPanel atkPanel = new JPanel();
        atkPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        atkPanel.setVisible(false);
        JLabel atkMinLabel = new JLabel("Minimum ATK: ");
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);
        JFormattedTextField atkMinField = new JFormattedTextField(format);
        atkMinField.setColumns(4);
        atkMinField.setValue(0);
        JLabel atkMaxLabel = new JLabel("Maximum ATK: ");
        JFormattedTextField atkMaxField = new JFormattedTextField(format);
        atkMaxField.setColumns(4);
        atkMaxField.setValue(9999);
        JButton atkButton = new JButton("Update");

        JPanel buttonPanel9 = new JPanel();
        buttonPanel9.setLayout(new BorderLayout());
        JPanel defPanel = new JPanel();
        defPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        defPanel.setVisible(false);
        JLabel defMinLabel = new JLabel("Minimum DEF: ");
        JFormattedTextField defMinField = new JFormattedTextField(format);
        defMinField.setColumns(4);
        defMinField.setValue(0);
        JLabel defMaxLabel = new JLabel("Maximum DEF: ");
        JFormattedTextField defMaxField = new JFormattedTextField(format);
        defMaxField.setColumns(4);
        defMaxField.setValue(9999);
        JButton defButton = new JButton("Update");


        cardTypeMonster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monsterEffectPanel.setVisible(true);
                spellEffectPanel.setVisible(false);
                trapEffectPanel.setVisible(false);
                attributePanel.setVisible(true);
                typePanel.setVisible(true);
                levelPanel.setVisible(true);
                atkPanel.setVisible(true);
                defPanel.setVisible(true);

                cardType = CardType.MONSTER;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        cardTypeSpell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monsterEffectPanel.setVisible(false);
                spellEffectPanel.setVisible(true);
                trapEffectPanel.setVisible(false);
                attributePanel.setVisible(false);
                typePanel.setVisible(false);
                levelPanel.setVisible(false);
                atkPanel.setVisible(false);
                defPanel.setVisible(false);

                cardType = CardType.SPELL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        cardTypeTrap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monsterEffectPanel.setVisible(false);
                spellEffectPanel.setVisible(false);
                trapEffectPanel.setVisible(true);
                attributePanel.setVisible(false);
                typePanel.setVisible(false);
                levelPanel.setVisible(false);
                atkPanel.setVisible(false);
                defPanel.setVisible(false);

                cardType = CardType.TRAP;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        monsterEffectAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.ALL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        monsterEffectNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.NORMAL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        monsterEffectEffect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.EFFECT;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        monsterEffectFlip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.FLIP;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        monsterEffectFusion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.FUSION;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        spellEffectAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.ALL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        spellEffectNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.NORMAL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        spellEffectContinuous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.CONTINUOUS;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        spellEffectEquip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.EQUIP;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        spellEffectField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.FIELD;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        trapEffectAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.ALL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        trapEffectNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.NORMAL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        trapEffectContinuous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.CONTINUOUS;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        trapEffectCounter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effect = Effect.COUNTER;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        attributeAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.ALL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        attributeDark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.DARK;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        attributeLight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.LIGHT;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        attributeEarth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.EARTH;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        attributeFire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.FIRE;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        attributeWater.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.WATER;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        attributeWind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attribute = Attribute.WIND;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        typeAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.ALL;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeAqua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.AQUA;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeBeast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.BEAST;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeBeastwarrior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.BEASTWARRIOR;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeDinosaur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.DINOSAUR;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeDragon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.DRAGON;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeFairy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.FAIRY;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeFiend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.FIEND;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeFish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.FISH;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeInsect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.INSECT;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeMachine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.MACHINE;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typePlant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.PLANT;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typePyro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.PYRO;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeReptile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.REPTILE;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeRock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.ROCK;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeSeaserpent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.SEASERPENT;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeSpellcaster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.SPELLCASTER;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeThunder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.THUNDER;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeWarrior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.WARRIOR;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeWingedbeast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.WINGEDBEAST;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        typeZombie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type = Type.ZOMBIE;
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        levelMinBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                minLevel = Integer.parseInt((String) levelMinBox.getSelectedItem());
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        levelMaxBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                maxLevel = Integer.parseInt((String) levelMaxBox.getSelectedItem());
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        atkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                minAtk = Integer.parseInt(atkMinField.getText());
                maxAtk = Integer.parseInt(atkMaxField.getText());
                minDef = Integer.parseInt(defMinField.getText());
                maxDef = Integer.parseInt(defMaxField.getText());
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });
        defButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                minAtk = Integer.parseInt(atkMinField.getText());
                maxAtk = Integer.parseInt(atkMaxField.getText());
                minDef = Integer.parseInt(defMinField.getText());
                maxDef = Integer.parseInt(defMaxField.getText());
                textArea.setText(CardDisplay.print(cardType, effect, attribute, type, minLevel, maxLevel, minAtk, maxAtk, minDef, maxDef));
            }
        });

        frame.add(buttonPanel, BorderLayout.CENTER);
        cardTypePanel.add(cardTypeLabel);
        cardTypePanel.add(cardTypeMonster);
        cardTypePanel.add(cardTypeSpell);
        cardTypePanel.add(cardTypeTrap);
        buttonPanel.add(cardTypePanel, BorderLayout.NORTH);
        buttonPanel.add(buttonPanel2, BorderLayout.CENTER);
        monsterEffectPanel.add(monsterEffectLabel);
        monsterEffectPanel.add(monsterEffectAll);
        monsterEffectPanel.add(monsterEffectNormal);
        monsterEffectPanel.add(monsterEffectEffect);
        monsterEffectPanel.add(monsterEffectFlip);
        monsterEffectPanel.add(monsterEffectFusion);
        buttonPanel2.add(monsterEffectPanel, BorderLayout.NORTH);
        buttonPanel2.add(buttonPanel3, BorderLayout.CENTER);
        spellEffectPanel.add(spellEffectLabel);
        spellEffectPanel.add(spellEffectAll);
        spellEffectPanel.add(spellEffectNormal);
        spellEffectPanel.add(spellEffectContinuous);
        spellEffectPanel.add(spellEffectEquip);
        spellEffectPanel.add(spellEffectField);
        buttonPanel3.add(spellEffectPanel, BorderLayout.NORTH);
        buttonPanel3.add(buttonPanel4, BorderLayout.CENTER);
        trapEffectPanel.add(trapEffectLabel);
        trapEffectPanel.add(trapEffectAll);
        trapEffectPanel.add(trapEffectNormal);
        trapEffectPanel.add(trapEffectContinuous);
        trapEffectPanel.add(trapEffectCounter);
        buttonPanel4.add(trapEffectPanel, BorderLayout.NORTH);
        buttonPanel4.add(buttonPanel5, BorderLayout.CENTER);
        attributePanel.add(attributeLabel);
        attributePanel.add(attributeAll);
        attributePanel.add(attributeDark);
        attributePanel.add(attributeLight);
        attributePanel.add(attributeEarth);
        attributePanel.add(attributeFire);
        attributePanel.add(attributeWater);
        attributePanel.add(attributeWind);
        buttonPanel5.add(attributePanel, BorderLayout.NORTH);
        buttonPanel5.add(buttonPanel6, BorderLayout.CENTER);
        typePanel.add(typeLabel);
        typePanel.add(typeAll);
        typePanel.add(typeAqua);
        typePanel.add(typeBeast);
        typePanel.add(typeBeast);
        typePanel.add(typeBeastwarrior);
        typePanel.add(typeDinosaur);
        typePanel.add(typeDragon);
        typePanel.add(typeFairy);
        typePanel.add(typeFiend);
        typePanel.add(typeFish);
        typePanel.add(typeInsect);
        typePanel.add(typeMachine);
        typePanel.add(typePlant);
        typePanel.add(typePyro);
        typePanel.add(typeReptile);
        typePanel.add(typeRock);
        typePanel.add(typeSeaserpent);
        typePanel.add(typeSpellcaster);
        typePanel.add(typeThunder);
        typePanel.add(typeWarrior);
        typePanel.add(typeWingedbeast);
        typePanel.add(typeZombie);
        buttonPanel6.add(typePanel, BorderLayout.NORTH);
        buttonPanel6.add(buttonPanel7, BorderLayout.CENTER);
        levelPanel.add(levelMinLabel);
        levelPanel.add(levelMinBox);
        levelPanel.add(levelMaxLabel);
        levelPanel.add(levelMaxBox);
        buttonPanel7.add(levelPanel, BorderLayout.NORTH);
        buttonPanel7.add(buttonPanel8, BorderLayout.CENTER);
        atkPanel.add(atkMinLabel);
        atkPanel.add(atkMinField);
        atkPanel.add(atkMaxLabel);
        atkPanel.add(atkMaxField);
        atkPanel.add(atkButton);
        buttonPanel8.add(atkPanel, BorderLayout.NORTH);
        buttonPanel8.add(buttonPanel9, BorderLayout.CENTER);
        defPanel.add(defMinLabel);
        defPanel.add(defMinField);
        defPanel.add(defMaxLabel);
        defPanel.add(defMaxField);
        defPanel.add(defButton);
        buttonPanel9.add(defPanel, BorderLayout.NORTH);

        frame.add(scrollPane, BorderLayout.EAST);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Yu-Gi-Oh! Cards");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();


    }
}