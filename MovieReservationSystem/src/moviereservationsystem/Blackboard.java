package moviereservationsystem;

import GUI.ShowtimeButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author hng
 */
public class Blackboard extends JFrame {

    private Action action;
    private static JFrame f;
    JPanel mainPanel;
    String time = "7.00";
    JLabel timeComponent;

    public Blackboard(Action action, List<Movie> movieList) throws SQLException {
        this.action = action;
        f = new JFrame("Movie Reservation System");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        action.loadData(movieList);
    }

    //special method for supporting the updating process carried out by knowledge sources
    public void update(List<Movie> list, List<ShowtimeButton> buttons) throws MalformedURLException, IOException, SQLException {
        // sort the list according to duration
        JPanel container = new JPanel();
        JPanel timecontainer = new JPanel();
        container.setLayout(new GridBagLayout());
        timecontainer.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(1, 0, 0, 0);
        c.gridx = 1;
        c.gridwidth = 3;
        c.gridy = 0;
        timeComponent = new JLabel("Time " + time, SwingConstants.CENTER);
        timeComponent.setFont(new Font("Serif", Font.BOLD, 20));
        timecontainer.add(timeComponent);
        container.add(timecontainer, c);

        for (Movie movie : list) {
            JLabel title = new JLabel(movie.getName());
            URL url = new URL(movie.getImageURL());
            Image image = ImageIO.read(url);
            JLabel img = new JLabel();
            img.setPreferredSize(new Dimension(300, 300));
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
            img.setIcon(imageIcon);

            //Inner Panel
            var panel = new JPanel();
            panel.setLayout(new GridLayout(0, 2, 10, 10));
            panel.setBackground(Color.GREEN);
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            var leftPanel = new JPanel();
            var rightPanel = new JPanel();

            leftPanel.setLayout(new GridLayout(0, 2, 10, 10));
            rightPanel.setLayout(new GridLayout(0, 5, 10, 10));
            leftPanel.add(img);
            leftPanel.add(title);
            action.addButton(rightPanel, movie.getId(), buttons);
            panel.add(leftPanel);
            panel.add(rightPanel);
            mainPanel.add(panel);

        }

        var scroll = new JScrollPane(mainPanel);
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 4.0;
        c.weighty = 1.0;
        container.add(scroll, c);
        f.getContentPane().add(container, BorderLayout.CENTER);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    public void setTime(double time) {
        timeComponent.setText("Time: " + String.format("%,.2f", time));

    }
}
