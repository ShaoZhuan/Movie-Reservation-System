/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import javax.swing.JFrame;
import moviereservationsystem.Controller;


public class GUI extends JFrame {

    
    

    

//    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
//        buttons.get(2).setDisabled();
//    }
//
//    private void generateTimetable() throws IOException, SQLException {
//        JButton jButton9 = new JButton("abc");
//        jButton9.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton9ActionPerformed(evt);
//            }
//        });
//        
//        mainPanel.add(jButton9);
//        ResultSet movies = db.retrieve("SELECT * FROM movie");
//
//        while (movies.next()) {
//            //Movie Poster
//            URL url = new URL(movies.getString(5));
//            Image image = ImageIO.read(url);
//            JLabel img = new JLabel();
//            JLabel title = new JLabel(movies.getString(2));
//            img.setPreferredSize(new Dimension(300, 300));
//            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
//            img.setIcon(imageIcon);
//
//            //Inner Panel
//            var panel = new JPanel();
//            panel.setLayout(new GridLayout(0, 2, 10, 10));
//            panel.setBackground(Color.GREEN);
//            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            var leftPanel = new JPanel();
//            var rightPanel = new JPanel();
//
//            leftPanel.setLayout(new GridLayout(0, 2, 10, 10));
//            rightPanel.setLayout(new GridLayout(0, 5, 10, 10));
//            leftPanel.add(img);
//            leftPanel.add(title);
//            addButton(rightPanel, movies.getInt("_id"));
//            panel.add(leftPanel);
//            panel.add(rightPanel);
//            mainPanel.add(panel);
//        }
//
//        var scroll = new JScrollPane(mainPanel);
//        f.getContentPane().add(scroll, BorderLayout.CENTER);
//        f.pack();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
//    }

//    private void addButton(JPanel panel, int _id) throws SQLException {
//        ResultSet showtimes = db.retrieve("SELECT * FROM showtime WHERE movie_id=" + _id);
//
//        while (showtimes.next()) {
//            ShowtimeButton button = new ShowtimeButton(showtimes.getInt(1), showtimes.getInt(2), showtimes.getString(3), showtimes.getInt(4));
//            buttons.add(button);
//            panel.add(button);
//        }
//        panel.revalidate();
//        panel.repaint();
//    }


    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Controller controller = new Controller();
                moviereservationsystem.Timer timer = new moviereservationsystem.Timer();
                Thread t1 = new Thread(controller);
                t1.start();
                Thread t2 = new Thread(timer);
                t2.start();
             
                    
                
            }
        });
    }
                 
}
