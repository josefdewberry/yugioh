package yugioh;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import yugioh.CardDisplay.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GUI {
    
    public GUI() {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        JTextArea textArea = new JTextArea(CardDisplay.allCardNames(), 5, 26);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        JRadioButton cardTypeAll = new JRadioButton("All");
        JRadioButton cardTypeMonster = new JRadioButton("Monster");
        JRadioButton cardTypeSpell = new JRadioButton("Spell");
        JRadioButton cardTypeTrap = new JRadioButton("Trap");
 
        ButtonGroup cardTypeGroup = new ButtonGroup();
        cardTypeGroup.add(cardTypeAll);
        cardTypeGroup.add(cardTypeMonster);
        cardTypeGroup.add(cardTypeSpell);
        cardTypeGroup.add(cardTypeTrap);
 
        JRadioButton mEffectAll = new JRadioButton("All");
        JRadioButton mEffectNormal = new JRadioButton("Normal");
        JRadioButton mEffectEffect = new JRadioButton("Effect");
        JRadioButton mEffectFlip = new JRadioButton("Flip");
        JRadioButton mEffectFusion = new JRadioButton("Fusion");

        ButtonGroup mEffectGroup = new ButtonGroup();
        mEffectGroup.add(mEffectAll);
        mEffectGroup.add(mEffectNormal);
        mEffectGroup.add(mEffectEffect);
        mEffectGroup.add(mEffectFlip);
        mEffectGroup.add(mEffectFusion);

        JRadioButton attributeAll = new JRadioButton("All");
        JRadioButton attributeDark = new JRadioButton("DARK");
        JRadioButton attributeLight = new JRadioButton("LIGHT");
        JRadioButton attributeWater = new JRadioButton("WATER");
        JRadioButton attributeWind = new JRadioButton("WIND");
        JRadioButton attributeFire = new JRadioButton("FIRE");
        JRadioButton attributeEarth = new JRadioButton("EARTH");

        ButtonGroup attributeGroup = new ButtonGroup();
        attributeGroup.add(attributeAll);
        attributeGroup.add(attributeDark);
        attributeGroup.add(attributeLight);
        attributeGroup.add(attributeWater);
        attributeGroup.add(attributeWind);
        attributeGroup.add(attributeEarth);
        attributeGroup.add(attributeFire);

        JRadioButton stEffectAll = new JRadioButton("All");
        JRadioButton stEffectNormal = new JRadioButton("Normal");
        JRadioButton stEffectField = new JRadioButton("Field");
        JRadioButton stEffectEquip = new JRadioButton("Equip");
        JRadioButton stEffectContinuous = new JRadioButton("Continuous");
        JRadioButton stEffectCounter = new JRadioButton("Counter");

        ButtonGroup stEffectGroup = new ButtonGroup();
        stEffectGroup.add(stEffectAll);
        stEffectGroup.add(stEffectNormal);
        stEffectGroup.add(stEffectField);
        stEffectGroup.add(stEffectEquip);
        stEffectGroup.add(stEffectContinuous);
        stEffectGroup.add(stEffectCounter);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 0));
        JPanel cardTypePanel = new JPanel();
        cardTypePanel.add(new JLabel("Card Type: "));
        cardTypePanel.add(cardTypeAll);
        cardTypePanel.add(cardTypeMonster);
        cardTypePanel.add(cardTypeSpell);
        cardTypePanel.add(cardTypeTrap);

        buttonPanel.add(cardTypePanel);
    
        JPanel mEffectPanel = new JPanel();
        mEffectPanel.add(new JLabel("Monster Effect: "));
        mEffectPanel.add(mEffectNormal);
        mEffectPanel.add(mEffectEffect);
        mEffectPanel.add(mEffectFlip);
        mEffectPanel.add(mEffectFusion);

        buttonPanel.add(mEffectPanel);

        JPanel attributePanel = new JPanel();
        attributePanel.add(new JLabel("Attribute: "));
        attributePanel.setLayout(new GridLayout(0, 4));
        attributePanel.add(attributeDark);
        attributePanel.add(attributeLight);
        attributePanel.add(attributeEarth);
        attributePanel.add(attributeFire);
        attributePanel.add(attributeWater);
        attributePanel.add(attributeWind);

        buttonPanel.add(attributePanel);

        JPanel stEffectPanel = new JPanel();
        stEffectPanel.add(new JLabel("Spell & Trap Effect: "));
        stEffectPanel.setLayout(new GridLayout(0, 4));
        stEffectPanel.add(stEffectNormal);
        stEffectPanel.add(stEffectEquip);
        stEffectPanel.add(stEffectField);
        stEffectPanel.add(stEffectContinuous);
        stEffectPanel.add(stEffectCounter);

        buttonPanel.add(stEffectPanel);

        // frame.add(panel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.WEST);
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