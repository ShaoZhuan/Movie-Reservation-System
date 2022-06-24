package moviereservationsystem;

import GUI.ShowtimeButton;

public interface KnowledgeSource {

    // generate movie and return movie object
    public Movie MovieInformation(int id);

    //provides ticket reservation services to anonymous customers. 
    public void reserveTicket(ShowtimeButton button);

    //close reservation
    public void closeReserve(ShowtimeButton button);

    //close movie show 
    public void closeMovie();
}
