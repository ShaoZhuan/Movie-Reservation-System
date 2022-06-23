/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereservationsystem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author hng
 */
public class PopupWindow extends JFrame{
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel successMsg;
    
    private String text;
    public boolean end = false;
    public PopupWindow(String text){
        this.text = text;
        this.setVisible(true);

        popUp();
    }
    
    public void popUp(){
        
        successMsg = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        successMsg.setText(text);

        closeButton.setText("Close");
        closeButton.addActionListener(this::closeButtonActionPerformed);        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(successMsg)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(closeButton)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(successMsg)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(end){
            System.exit(0);
        }
        else{
            this.setVisible(false);
        }
    }    
}
