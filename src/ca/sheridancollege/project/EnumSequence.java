/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author abdal
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
