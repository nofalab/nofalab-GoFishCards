/*
//SYST 17796 Project.- Go Fish
//Deliverable 3
//Date of submission: August 4, 2021
 */
package ca.sheridancollege.project;

/**
 * enum to assign sequence description    
 * @author Abdallah Nofal, Victor Vieira, Jacob Maltby, Imanuel Chatur
 */
public enum EnumSequence {
    FIRST("first player"), SECOND ("second player"), THIRD ("third player"), 
    FOURTH("fourth player"), FIFTH("fifth player"), SIXTH("sixth player"), 
    SEVENTH("seventh player");
    
    private final String description;
    
    private EnumSequence(String description){
        this.description = description;
    }
    
    public String getDescrisption(){
        return description;
    }
    
}
