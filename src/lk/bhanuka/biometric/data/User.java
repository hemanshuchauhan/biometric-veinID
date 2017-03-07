/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

import java.util.List;

/**
 *
 * @author bhanuka
 */
public class User {
    
    private String username; 
    
    private List<String[]> veinId;
    
    public User(String username, List<String[]> veinId){
        this.username = username;
        this.veinId =veinId;
    }
    
    public String getName(){
        return this.username;
    }
    
    public List<String[]> getVeinId(){
        return this.veinId;
    }
}
