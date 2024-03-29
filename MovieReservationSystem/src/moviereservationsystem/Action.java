package moviereservationsystem;

import GUI.ShowtimeButton;
import database.DBConnection;
import java.io.IOException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Action implements KnowledgeSource {
    
    private List<Movie> movieList;    
    DBConnection db;
    MovieBox mb;
    public Action(List<Movie> movieList){
        
        try {
            this.db = new DBConnection();            
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.movieList = movieList;
    }
    
    // load the movie data from the database
    public void loadData(List<Movie> movieList) throws SQLException{
        try (ResultSet movies = db.retrieve("SELECT * FROM movie")) {
            while (movies.next()) {
                //assign the data into list
                int id  = movies.getInt("_id");
                String title = movies.getString(2);
                String info = movies.getString(3);
                int duration  = movies.getInt("duration");
                String url= movies.getString(5);
                movieList.add(new Movie(id,title,info,duration,url));
            }
        }
        
        
        
    }
    
    // add a showtime button into a button list
    public void addButton(JPanel panel, int _id, List<ShowtimeButton> buttons) throws SQLException {
        ResultSet showtimes = db.retrieve("SELECT * FROM showtime WHERE movie_id=" + _id);            
        while (showtimes.next()) {
            ShowtimeButton button = new ShowtimeButton(showtimes.getInt(1), showtimes.getInt(2), showtimes.getString(3), showtimes.getInt(4));
            button.addActionListener(e-> {
                // display the movie information
                mb = new MovieBox(MovieInformation(button.getMovieId()),button,this);
                try {
                    mb.display();
                } catch (IOException ex) {
                    Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            buttons.add(button);            
            panel.add(button);
        }
        panel.revalidate();
        panel.repaint();
    }


    // override the movieinformation from the knowledge source
    @Override
    public Movie MovieInformation(int id) {
        // return movie information
        for (Movie movie:movieList) {
            if(movie.getId()==id){
                return movie;
            }
        }
        return null;

    }
    
    // override the reserveTicket from the knowledge source
    @Override
    public void reserveTicket(ShowtimeButton button) {
        if(button.isEnabled()){
            if(button.isFull()){
               //popout error message 
               PopupWindow error = new PopupWindow("Sorry the capacity is full. Please choose for another slot");           
            }
            else{
                button.reserve();
                // popout reserve successfully
                PopupWindow success = new PopupWindow("Reserve Successfully!");                 
            }            
        }
        else{
            PopupWindow expired = new PopupWindow("The time for reservation is passed. Please try next slot.");
            mb.setVisible(false);
        }
    }

  
    // override the closeReserve from the knowledge source
    @Override
    public void closeReserve(ShowtimeButton button) {
        button.setDisabled();    
    }

    // override the closeMovie from the knowledge source
    @Override
    public void closeMovie() {
        PopupWindow endWindow = new PopupWindow("Cinema is closed now. Please come again tomorrow!");
        endWindow.end = true;
    }
}
