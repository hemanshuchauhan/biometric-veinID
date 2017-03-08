/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

/**
 *
 * @author bhanuka
 */
public class BasicAuth extends AuthUnit{

    @Override
    protected void authenticate(User user, AuthenticationRequest request, AuthenticationScore score) {
        
        System.out.println("performing basic authentication");
        int count = 0;
        int successCount = 0;
        
        for(int i =0; i < request.veinId.size(); i++){
            
            for(int j=0 ; j< request.veinId.get(i).length; j++){
                count ++;
                if(request.veinId.get(i)[j].equals(user.getVeinId().get(i)[j])){
                    successCount ++;
                }
            }
        }
        
        score.basicMatch = ((float)successCount)/((float)count);
    }
    
}
