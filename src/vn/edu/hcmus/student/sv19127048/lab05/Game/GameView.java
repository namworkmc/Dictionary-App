package vn.edu.hcmus.student.sv19127048.lab05.Game;

import static java.awt.Font.BOLD;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import vn.edu.hcmus.student.sv19127048.lab05.Dictionary.DictionaryController;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.Game<br> Created by 19127048 - Nguyen Duc Nam<br> Date
 * 12/13/2021 - 7:52 PM<br> Description: JDK16<br>
 */
public class GameView extends JFrame implements ActionListener {

  /**
   * Creates new form GameFrame
   */
  public GameView(DictionaryController dictionaryController) {
    this.dictionaryController = dictionaryController;
    initComponents();
  }

  private void initComponents() {

    questionLabel = new JLabel();
    answer1 = new JButton();
    answer1.addActionListener(this);

    answer2 = new JButton();
    answer2.addActionListener(this);

    answer3 = new JButton();
    answer3.addActionListener(this);

    answer4 = new JButton();
    answer4.addActionListener(this);

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Guess Game");

    questionLabel.setFont(new Font("Segoe UI", BOLD, 18)); // NOI18N
    questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(LEADING)
            .addGroup(TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(TRAILING)
                    .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer2, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer3, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer4, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(answer1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>

  private void initGamePlay1() {
    String randomSlang = dictionaryController.getRandomSlangWord();
    String[] randomDefinitions = dictionaryController.getRandomDefinitions(randomSlang);

    questionLabel.setText(randomSlang);
    answer1.setText(randomDefinitions[0]);
    answer2.setText(randomDefinitions[1]);
    answer3.setText(randomDefinitions[2]);
    answer4.setText(randomDefinitions[3]);
  }

  private void initGamePlay2() {
    String randomDefinition = dictionaryController.getRandomDefinition();
    String[] randomSlangs = dictionaryController.getRandomSlangWords(randomDefinition);

    questionLabel.setText(randomDefinition);
    answer1.setText(randomSlangs[0]);
    answer2.setText(randomSlangs[1]);
    answer3.setText(randomSlangs[2]);
    answer4.setText(randomSlangs[3]);
  }

  /**
   * Render game window
   */
  public void renderGameWindow() {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    EventQueue.invokeLater(() -> setVisible(true));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    boolean isCorrect;
    String theAnswer;

    if (e.getSource() == answer1) {
      System.out.println("Clicked answer 1");
      theAnswer = answer1.getText();

    } else if (e.getSource() == answer2) {
      System.out.println("Clicked answer 2");
      theAnswer = answer2.getText();

    } else if (e.getSource() == answer3) {
      System.out.println("Clicked answer 3");
      theAnswer = answer3.getText();

    } else {
      System.out.println("Clicked answer 4");
      theAnswer = answer4.getText();
    }

    if (mode == 2) {
      isCorrect = dictionaryController.isDefinitionOfSlangCorrect(theAnswer, questionLabel.getText());
    } else {
      isCorrect = dictionaryController.isDefinitionOfSlangCorrect(questionLabel.getText(), theAnswer);
    }

    if (isCorrect) {
      JOptionPane.showMessageDialog(
          null,
          "Correct",
          "CORRECT ANSWER",
          INFORMATION_MESSAGE
      );
    } else {
      JOptionPane.showMessageDialog(
          null,
          "Wrong, try again",
          "WRONG ANSWER",
          JOptionPane.WARNING_MESSAGE
      );
    }

    if (mode == 2) {
      initGamePlay2();
    } else {
      initGamePlay1();
    }
  }

  /**
   * Set game mode
   *
   * @param mode
   */
  public void setGameMode(Integer mode) {
    this.mode = mode;
    if (mode == 2) {
      initGamePlay2();
    } else {
      initGamePlay1();
    }
  }

  // Variables declaration - do not modify
  private JButton answer1;
  private JButton answer2;
  private JButton answer3;
  private JButton answer4;
  private JLabel questionLabel;

  private final DictionaryController dictionaryController;

  private Integer mode = 1;
  // End of variables declaration
}
