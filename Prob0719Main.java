package prob0719;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Chapter 7, Problem 19 from <i>Computer Systems</i>.
 *
 * <p>
 * File: <code>Prob0719Main.java</code>
 *
 * <p>
 * Name: Ira Porchia
 *
 * <p>
 * Date: 3/10/20
 *
 * <p>
 * Assignment: 14
 */
public class Prob0719Main implements ActionListener {

   final JFrame mainWindowFrame;
   final JPanel inputPanel;
   final JTextArea textArea;
   final JPanel buttonPanel;
   final JButton button;

   public Prob0719Main() {
      // Set up the main window.
      mainWindowFrame = new JFrame("Problem 7.19");
      mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainWindowFrame.setSize(new Dimension(240, 120));

      // Lay out the text area input panel from top to bottom.
      inputPanel = new JPanel();
      inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
      textArea = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setPreferredSize(new Dimension(250, 250));
      inputPanel.add(scrollPane);
      inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      // Lay out the button from left to right.
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
      buttonPanel.add(Box.createHorizontalGlue());
      button = new JButton("Translate");
      buttonPanel.add(button);
      buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));

      // Combine the input panel and the button panel in the main window.
      mainWindowFrame.add(inputPanel, BorderLayout.CENTER);
      mainWindowFrame.add(buttonPanel, BorderLayout.PAGE_END);

      button.addActionListener(this);

      mainWindowFrame.pack();
      mainWindowFrame.setVisible(true);
   }

   private static void createAndShowGUI() {
      JFrame.setDefaultLookAndFeelDecorated(true);
      new Prob0719Main();
   }

   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(Prob0719Main::createAndShowGUI);
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      InBuffer inBuffer = new InBuffer(textArea.getText());
      Translator tr = new Translator(inBuffer);
      tr.translate();
   }
}
