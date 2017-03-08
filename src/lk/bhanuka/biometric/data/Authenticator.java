/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bhanuka
 */
public class Authenticator {
    
    private AuthenticationChain authChain = new AuthenticationChain();
    
    private FileReader fileReader = new FileReader();
    
    private UserRepository userRepository = new UserRepository();
    
    public Map<User, AuthenticationScore> checkAuthentication(AuthenticationRequest request) throws IOException{
        
        request.veinId = this.fileReader.readFileCharacters(request.inputFile);
        
        HashMap<User, AuthenticationScore> results = new HashMap();
        
        for(User user: this.userRepository.getUsers()){
            AuthenticationScore score = new AuthenticationScore();
            this.authChain.start(user, request, score);
            results.put(user, score);
        }
        
        return results;
    
    }
    
}
