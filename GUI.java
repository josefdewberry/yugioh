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

import yugioh.CardDisplay.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import yugioh.WrapLayout.*;
import java.awt.GridLayout;

public class GUI {
    
    public GUI() {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(CardDisplay.allCardNames());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JPanel cardTypePanel = new JPanel();
        cardTypePanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        JLabel cardTypeLabel = new JLabel("Card Type: ");

        JRadioButton cardTypeAll = new JRadioButton("All");
        JRadioButton cardTypeMonster = new JRadioButton("Monster");
        JRadioButton cardTypeSpell = new JRadioButton("Spell");
        JRadioButton cardTypeTrap = new JRadioButton("Trap");
        ButtonGroup cardTypeGroup = new ButtonGroup();
        cardTypeGroup.add(cardTypeAll);
        cardTypeGroup.add(cardTypeMonster);
        cardTypeGroup.add(cardTypeSpell);
        cardTypeGroup.add(cardTypeTrap);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLayout(new BorderLayout());
        JPanel monsterEffectPanel = new JPanel();
        monsterEffectPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
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

        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.setLayout(new BorderLayout());
        JPanel spellEffectPanel = new JPanel();
        spellEffectPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
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

        JPanel buttonPanel4 = new JPanel();
        buttonPanel4.setLayout(new BorderLayout());
        JPanel trapEffectPanel = new JPanel();
        trapEffectPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
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

        JPanel buttonPanel5 = new JPanel();
        buttonPanel5.setLayout(new BorderLayout());
        JPanel attributePanel = new JPanel();
        attributePanel.setLayout(new WrapLayout(FlowLayout.LEADING));
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

        JPanel buttonPanel6 = new JPanel();
        buttonPanel6.setLayout(new BorderLayout());
        JPanel typePanel = new JPanel();
        typePanel.setLayout(new WrapLayout(FlowLayout.LEADING));
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

        JPanel buttonPanel7 = new JPanel();
        buttonPanel7.setLayout(new BorderLayout());
        JPanel levelPanel = new JPanel();
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
        JLabel atkMinLabel = new JLabel("Minimum ATK: ");
        JFormattedTextField atkMinField = new JFormattedTextField();
        atkMinField.setColumns(4);
        JLabel atkMaxLabel = new JLabel("Maximum ATK: ");
        JFormattedTextField atkMaxField = new JFormattedTextField();
        atkMaxField.setColumns(4);

        JPanel buttonPanel9 = new JPanel();
        buttonPanel9.setLayout(new BorderLayout());
        JPanel defPanel = new JPanel();
        defPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        JLabel defMinLabel = new JLabel("Minimum DEF: ");
        JFormattedTextField defMinField = new JFormattedTextField();
        defMinField.setColumns(4);
        JLabel defMaxLabel = new JLabel("Maximum DEF: ");
        JFormattedTextField defMaxField = new JFormattedTextField();
        defMaxField.setColumns(4);


        frame.add(buttonPanel, BorderLayout.CENTER);
        cardTypePanel.add(cardTypeLabel);
        cardTypePanel.add(cardTypeAll);
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
        buttonPanel8.add(atkPanel, BorderLayout.NORTH);
        buttonPanel8.add(buttonPanel9, BorderLayout.CENTER);
        defPanel.add(defMinLabel);
        defPanel.add(defMinField);
        defPanel.add(defMaxLabel);
        defPanel.add(defMaxField);
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