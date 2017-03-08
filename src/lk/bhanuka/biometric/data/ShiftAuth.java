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
public class ShiftAuth extends AuthUnit{

    @Override
    protected void authenticate(User user, AuthenticationRequest request, AuthenticationScore score) {
        
        float maxScore = 0;
        int shiftFactor = 0;
        
        for(int shift = 0; shift < 10; shift ++){
          
            int count = 0;
            int successCount = 0;

            for(int i =0; i < request.veinId.size(); i++){

                for(int j=0 ; j< request.veinId.get(i).length; j++){
                    count ++;
                    if(request.veinId.get(i)[j].equals(user.getVeinId().get(i)[(j + shift)%10])){
                        successCount ++;
                    }
                }
            }

            if(((float)successCount)/((float)count) > maxScore){
                maxScore = ((float)successCount)/((float)count);
                shiftFactor = shift;
            }
    
        }
        
        score.shiftAuth = maxScore;
        score.shiftFactor = shiftFactor;
    }
    
}
