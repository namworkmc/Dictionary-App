package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.Dictionary<br> Created by 19127048 - Nguyen Duc Nam<br>
 * Date 12/12/2021 - 11:49 PM<br> Description: JDK16<br>
 */
public class EditView extends JFrame {

  EditView() {
    initEditTextField();
  }

  /**
   * Init edit text field
   */
  private void initEditTextField() {
    JPanel editPanel = new JPanel();
    editSlangField = new JTextField();
    confirmEditButton = new JButton();
    editDefinitionField = new JTextField();
    JLabel slangLabel = new JLabel();
    JLabel definitionLabel = new JLabel();

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    editSlangField.setHorizontalAlignment(JTextField.CENTER);

    confirmEditButton.setText("Confirm");

    editDefinitionField.setHorizontalAlignment(JTextField.CENTER);

    slangLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    slangLabel.setHorizontalAlignment(SwingConstants.CENTER);
    slangLabel.setText("Slang");

    definitionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    definitionLabel.setText("Definition");

    GroupLayout editPanelLayout = new GroupLayout(editPanel);
    editPanel.setLayout(editPanelLayout);
    editPanelLayout.setHorizontalGroup(
        editPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(definitionLabel)
                    .addComponent(slangLabel))
                .addGap(23, 23, 23)
                .addGroup(editPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(editSlangField, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(editDefinitionField))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmEditButton, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
    );
    editPanelLayout.setVerticalGroup(
        editPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editSlangField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(slangLabel))
                .addGap(18, 18, 18)
                .addGroup(editPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editDefinitionField, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(definitionLabel))
                .addContainerGap())
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(confirmEditButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(editPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
    );

    pack();
  }// </editor-fold>

  public void renderEditTextField() {
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
      java.util.logging.Logger.getLogger(EditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    EventQueue.invokeLater(() -> setVisible(true));
  }

  public JButton getConfirmEditButton() {
    return confirmEditButton;
  }

  public JTextField getEditSlangField() {
    return editSlangField;
  }

  public JTextField getEditDefinitionField() {
    return editDefinitionField;
  }

  // Variables declaration - do not modify
  private JButton confirmEditButton;
  private JTextField editDefinitionField;
  private JTextField editSlangField;
  // End of variables declaration
}
