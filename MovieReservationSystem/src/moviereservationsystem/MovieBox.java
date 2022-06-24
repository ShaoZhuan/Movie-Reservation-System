package moviereservationsystem;

import GUI.ShowtimeButton;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovieBox extends JFrame{
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel movieDescription;
    private javax.swing.JLabel movieTitle;
    private javax.swing.JButton reserveButton;
    private javax.swing.JLabel seat;
    private javax.swing.JLabel seatNum;
    private javax.swing.JLabel title;
    
    private ShowtimeButton button;
    private Movie movie;    
    private Action action;
    // End of variables declaration  
    
    //contstructor for initialise and assignment of variable 
    public MovieBox(Movie movie ,ShowtimeButton button,Action action){
        title = new javax.swing.JLabel();
        description = new javax.swing.JTextArea();
        
        this.action = action;
        this.movie = movie;     
        this.button = button;
        this.setVisible(true);
        setDetails();
    }
    
    // set the information from movie object
    public void setDetails(){
        title.setText(movie.getName());
        description.setText(movie.getDescription());
        
        this.setTitle("Movie: "+movie.getName());
    }
    
    // display the movie information window
    public void display() throws MalformedURLException, IOException{
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        imagePanel = new javax.swing.JLabel();
        movieTitle = new javax.swing.JLabel();
        movieDescription = new javax.swing.JLabel();
        reserveButton = new javax.swing.JButton();
        
        closeButton = new javax.swing.JButton();
        seatNum = new javax.swing.JLabel();
        seat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        URL url = new URL(movie.getImageURL());
        Image image = ImageIO.read(url);
        imagePanel.setPreferredSize(new Dimension(300, 300));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
        imagePanel.setIcon(imageIcon);
        
        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        movieTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        movieTitle.setText("Movie Title: ");

        movieDescription.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        movieDescription.setText("Movie Description: ");

        reserveButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        reserveButton.setText("Reserve Now");
        reserveButton.addActionListener(this::reserveButtonActionPerformed);

        title.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        closeButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(this::closeButtonActionPerformed);

        seatNum.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        seatNum.setText("Seat Available: ");

        seat.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        seat.setText(Integer.toString(button.getAvailable()));

        description.setColumns(20);
        description.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        description.setRows(5);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        jScrollPane2.setViewportView(description);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(movieDescription)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(movieTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reserveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seatNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seat)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(movieTitle)
                            .addComponent(title))
                        .addGap(18, 18, 18)
                        .addComponent(movieDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seatNum)
                            .addComponent(seat))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reserveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        
    }
    
    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        reserveButton.setEnabled(false);
        action.reserveTicket(button);        
        seat.setText(Integer.toString(button.getAvailable()));
        
        
    }  

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.dispose();
    }  
}
