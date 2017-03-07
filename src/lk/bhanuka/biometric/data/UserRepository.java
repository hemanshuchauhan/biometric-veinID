/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class UserRepository {
    
    private FileReader fileReader = new FileReader();
   
    private FileWriter fileWriter = new FileWriter();
    
    public List<String> getUserList() throws IOException{
        return this.fileReader.readFileLine("data/user-registry.data");
    }
    
    public List<User> getUsers() throws IOException{
        
        ArrayList<User> users = new ArrayList();
        
        for(String username: this.getUserList()){
            users.add(new User(username, this.fileReader.readFileCharacters("data/"+username+".data")));
        }
        
        return users;
    }
    
    public void AddUser(User user) throws IOException{
        this.fileWriter.writeLine("data/user-registry.data", user.getName());
        this.fileWriter.writeFileCharacters("data/"+user.getName()+".data", user.getVeinId());
    }
    
}
