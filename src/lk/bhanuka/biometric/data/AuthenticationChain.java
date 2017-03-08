/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class AuthenticationChain {
    
    private List<AuthUnit> authenticators;
    
    protected AuthenticationChain(){
        
        this.authenticators = new ArrayList<AuthUnit>();
        
        this.authenticators.add(new BasicAuth());
        this.authenticators.add(new ShiftAuth());
        
        for(int i=0; i < (this.authenticators.size() - 1); i++){
            this.authenticators.get(i).setNext(this.authenticators.get(i + 1));
        }
    }
    
    protected void start(User user, AuthenticationRequest request, AuthenticationScore score){
        this.authenticators.get(0).start(user, request, score);
    }
    
}
