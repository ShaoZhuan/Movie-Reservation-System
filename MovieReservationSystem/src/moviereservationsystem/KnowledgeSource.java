/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package moviereservationsystem;

import java.util.List;

/**
 *
 * @author hng
 */
public interface KnowledgeSource {
    
    // generate movie and return movie object
    public Movie MovieInformation();
    
    //provides ticket reservation services to anonymous customers. 
    public void reserveTicketAnonymous();
    
    //provide member reservation
    public void reserveTicketMember();
    
    
    //close reservation
    public void closeReserve();
    
    //close movie show 
    public void closeMovie();
}
