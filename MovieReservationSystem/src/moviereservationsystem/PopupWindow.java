package moviereservationsystem;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PopupWindow extends JFrame {

    private javax.swing.JButton closeButton;
    private javax.swing.JLabel successMsg;

    private String text;
    public boolean end = false;
    
    //contstructor for initialise and assignment of variable
    public PopupWindow(String text) {
        this.text = text;
        this.setVisible(true);

        popUp();
    }
    
    // display the pop up window with given text
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

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridwidth = 10;
        c.gridy = 0;
        container.add(successMsg, c);

        d.weightx = 1;
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
