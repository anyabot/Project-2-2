/**
 * @name        Simple Java Calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;


import java.io.*;

public class UI implements ActionListener {
   /**
    * frame.
    */
   private final JFrame frame;
   /**
    * panel that contains all subpanels.
    */
   private final JPanel panel;
   /**
    * subpanel that contains text area.
    */
   private final JPanel panelSub1;
   /**
    * subpanel that contains 1, 2, 3, add, minus buttons.
    */
   private final JPanel panelSub2;
   /**
    * subpanel that contains 4, 5, 6, multiply, divide buttons.
    */
   private final JPanel panelSub3;
   /**
    * subpanel that contains 7, 8, 9, equal, cancel buttons.
    */
   private final JPanel panelSub4;
   /**
    * subpanel that contains 0 buttons.
    */
   private final JPanel panelSub5;
   /**
    * subpanel that contains square, square root, one divided by,
    * and x to the power of y buttons.
    */
   private final JPanel panelSub6;
   /**
    * subpanel that contains cos, sin, tan buttons.
    */
   private final JPanel panelSub7;
   /**
    * subpanel that contains log, rate, abs, binary buttons.
    */
   private final JPanel panelSub8;
   /**
    * text area for input / output.
    */
   private final JTextArea text;
   /**
    * lists of buttons.
    */
   private final JButton[] but;
   /**
    * button for add.
    */
   private final JButton butAdd;
   /**
    * button for minus.
    */
   private final JButton butMinus;
   /**
    * button for multiply.
    */
   private final JButton butMultiply;
   /**
    * button for divide.
    */
   private final JButton butDivide;
   /**
    * button for equal.
    */
   private final JButton butEqual;
   /**
    * button for cancel.
    */
   private final JButton butCancel;
   /**
    * button for square root.
    */
   private final JButton butSquareRoot;
   /**
    * button for square.
    */
   private final JButton butSquare;
   /**
    * button for one divided by.
    */
   private final JButton butOneDevidedBy;
   /**
    * button for cos.
    */
   private final JButton butCos;
   /**
    * button for sin.
    */
   private final JButton butSin;
   /**
    * button for tan.
    */
   private final JButton butTan;
   /**
    * button for x to the power of y.
    */
   private final JButton butxpowerofy;
   /**
    * button for log.
    */
   private final JButton butlog;
   /**
    * button for rate.
    */
   private final JButton butrate;
   /**
    * button for absolute.
    */
   private final JButton butabs;
   /**
    * button for binary.
    */
   private final JButton butBinary;
   /**
    * create calculator from Calculator.java.
    */
   private final Calculator calc;
   /**
    * list of number buttons.
    */
   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};
   /**
    * normal font.
    */
   private final Font font;
   /**
    * text font.
    */
   private final Font textFont;

   /**
    * create user interface.
    * @throws IOException
    */
   public UI() throws IOException {
      frame = new JFrame("Calculator PH");
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());
      final int plainfontsize = 18;
      final int boldfontsize = 24;
      final int rowsize = 1;
      final int colsize = 30;
      final int numberlength = 10;
      font = new Font("Consolas", Font.PLAIN, plainfontsize);
      text = new JTextArea(rowsize, colsize);
      textFont = new Font("Consolas", Font.BOLD, boldfontsize);
      but = new JButton[numberlength];
      for (int i = 0; i < numberlength; i++) {
         but[i] = new JButton(String.valueOf(i));
      }
      butAdd = new JButton("+");
      butMinus = new JButton("-");
      butMultiply = new JButton("*");
      butDivide = new JButton("/");
      butEqual = new JButton("=");
      butSquareRoot = new JButton("sqrt");
      butSquare = new JButton("x*x");
      butOneDevidedBy = new JButton("1/x");
      butCos = new JButton("Cos");
      butSin = new JButton("Sin");
      butTan = new JButton("Tan");
      butxpowerofy = new JButton("x^y");
      butlog = new JButton("log10(x)");
      butrate = new JButton("x%");
      butabs = new JButton("abs(x)");
      butCancel = new JButton("C");
      butBinary = new JButton("Bin");
      calc = new Calculator();
   }
   /***
    * initialize user interface.
    */
   public void init() {
      final int uisize = 450;
      final int numberlength = 10;
      frame.setSize(uisize, uisize);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      text.setFont(textFont);
      text.setEditable(false);
      for (int i = 0; i < numberlength; i++) {
         but[i].setFont(font);
      }
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDevidedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font);
      final int panelwidth = 100;
      final int zerowidth = 210;
      final int buttonwidth = 15;
      final int butt1 = 1;
      final int butt2 = 2;
      final int butt3 = 3;
      final int butt4 = 4;
      final int butt5 = 5;
      final int butt6 = 6;
      final int butt7 = 7;
      final int butt8 = 8;
      final int butt9 = 9;
      final int butt0 = 0;
      panel.add(Box.createHorizontalStrut(panelwidth));
      panelSub1.add(text);
      panel.add(panelSub1);
      panelSub2.add(but[butt1]);
      panelSub2.add(but[butt2]);
      panelSub2.add(but[butt3]);
      panelSub2.add(Box.createHorizontalStrut(buttonwidth));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);
      panelSub3.add(but[butt4]);
      panelSub3.add(but[butt5]);
      panelSub3.add(but[butt6]);
      panelSub3.add(Box.createHorizontalStrut(buttonwidth));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);
      panel.add(panelSub3);
      panelSub4.add(but[butt7]);
      panelSub4.add(but[butt8]);
      panelSub4.add(but[butt9]);
      panelSub4.add(Box.createHorizontalStrut(buttonwidth));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);
      panelSub5.add(but[butt0]);
      panelSub5.add(Box.createHorizontalStrut(zerowidth));
      panel.add(panelSub5);
      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDevidedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);
      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);
      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);
      for (int i = 0; i < numberlength; i++) {
         but[i].addActionListener(this);
      }
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDevidedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);
      butEqual.addActionListener(this);
      butCancel.addActionListener(this);
      frame.add(panel);
   }
   /***
    * actionPerformed affect the text zone when a button is pressed.
    */
   @Override
   public void actionPerformed(final ActionEvent e) {
      final Object source = e.getSource();
      final int numberlength = 10;
      for (int i = 0; i < numberlength; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }
      if (source == butAdd) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
      }
      if (source == butMinus) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
      }
      if (source == butMultiply) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.multiply,
                                 reader()));
      }
      if (source == butDivide) {
         writer(calc
                   .calculateBi(Calculator.BiOperatorModes.divide, reader()));
      }
      if (source == butxpowerofy) {
         writer(calc
                   .calculateBi(Calculator.BiOperatorModes.xpowerofy,
                           reader()));
      }
      if (source == butSquare) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.square,
                 reader()));
      }
      if (source == butSquareRoot) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,
                                   reader()));
      }
      if (source == butOneDevidedBy) {
         writer(calc.calculateMono(
                                   Calculator.MonoOperatorModes.oneDevidedBy,
                 reader()));
      }
      if (source == butCos) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.cos,
                                   reader()));
      }
      if (source == butSin) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.sin,
                                   reader()));
      }
      if (source == butTan) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.tan,
                                   reader()));
      }
      if (source == butlog) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.log,
                                   reader()));
      }
      if (source == butrate) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.rate,
                                   reader()));
      }
      if (source == butabs) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));
      }
      if (source == butEqual) {
         writer(calc.calculateEqual(reader()));
      }
      if (source == butCancel) {
         writer(calc.reset());
      }
      if (source == butBinary) {
         parsetoBinary();
      }
      text.selectAll();
   }
   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }
   /***
    * @return the number in text zone
    */
   public Double reader() {
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);
      return num;
   }
   /***
    * @param num the number to write in text zone
    */
   public void writer(final Double num) {
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
