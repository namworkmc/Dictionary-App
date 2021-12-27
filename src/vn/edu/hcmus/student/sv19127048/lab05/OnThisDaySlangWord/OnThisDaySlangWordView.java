/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import vn.edu.hcmus.student.sv19127048.lab05.Dictionary.DictionaryController;

public class OnThisDaySlangWordView extends JFrame {

  public OnThisDaySlangWordView(DictionaryController dictionaryController) {
    this.dictionaryController = dictionaryController;
    OnThisDaySlangWordController onThisDaySlangWordController = new OnThisDaySlangWordController();
    log = onThisDaySlangWordController.readLog();

    initComponents();
    renderOnThisDaySlangWindow();
  }

  private void initComponents() {
    // Variables declaration - do not modify
    JPanel panel = new JPanel();
    JLabel todaysLabel = new JLabel("Today's Slang Word");
    todayDate = new JLabel(log.get(0).toString());
    randomSlangWithDefinition = new JLabel(log.get(1).toString());

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    todaysLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    todaysLabel.setHorizontalAlignment(SwingConstants.CENTER);

    todayDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    todayDate.setHorizontalAlignment(SwingConstants.CENTER);
    todayDate.setToolTipText("");

    randomSlangWithDefinition.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    randomSlangWithDefinition.setHorizontalAlignment(SwingConstants.CENTER);

    GroupLayout panelLayout = new GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
        panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(todayDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(todaysLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(randomSlangWithDefinition, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
    );
    panelLayout.setVerticalGroup(
        panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(todaysLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(todayDate, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(randomSlangWithDefinition, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
    );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
    );

    pack();
  }// </editor-fold>

  private void renderOnThisDaySlangWindow() {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(OnThisDaySlangWordView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> setVisible(true));
  }

  private JLabel randomSlangWithDefinition;
  private JLabel todayDate;

  final private DictionaryController dictionaryController;
  final private ArrayList<Serializable> log;

  // End of variables declaration
}
