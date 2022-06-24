/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hng
 */
public class PopupWindow extends JFrame {

    private javax.swing.JButton closeButton;
    private javax.swing.JLabel successMsg;

    private String text;
    public boolean end = false;

    public PopupWindow(String text) {
        this.text = text;
        this.setVisible(true);

        popUp();
    }

    public void popUp() {
        JPanel container = new JPanel(new GridBagLayout());
        successMsg = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints d = new GridBagConstraints();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        successMsg.setText(text);

        closeButton.setText("Close");
        closeButton.addActionListener(this::closeButtonActionPerformed);

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(128, 128, 128)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(successMsg)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(23, 23, 23)
//                        .addComponent(closeButton)))
//                .addContainerGap(142, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(41, 41, 41)
//                .addComponent(successMsg)
//                .addGap(18, 18, 18)
//                .addComponent(closeButton)
//                .addContainerGap(27, Short.MAX_VALUE))
//        );
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridwidth = 10;
        c.gridy = 0;
        container.add(successMsg, c);

//        d.fill = GridBagConstraints.HORIZONTAL;
        d.weightx = 0.5;
        d.gridx = 0;
        d.gridy = 1;
        container.add(closeButton,d);
        add(container);
        pack();
        setLocationRelativeTo(null);
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (end) {
            System.exit(0);
        } else {
            this.setVisible(false);
        }
    }
}
