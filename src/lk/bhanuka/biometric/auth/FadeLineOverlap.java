/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.auth;

import lk.bhanuka.biometric.data.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class FadeLineOverlap extends AuthUnit{

    @Override
    protected void authenticate(User user, AuthenticationRequest request, AuthenticationScore score) {
        List<String[]> blackFade = this.fade(user.getVeinId(), true);
        
        int count = 0;
        int successCount = 0;
        
        for(int i =0; i < request.veinId.size(); i++){
            
            for(int j=0 ; j< request.veinId.get(i).length; j++){
                
                if(request.veinId.get(i)[j].equals("1")){ 
                    if(request.veinId.get(i)[j].equals(blackFade.get(i)[j])){
                        successCount ++;
                    }
                    count ++;
                }

//                else{
//                    if(request.veinId.get(i)[j].equals(user.getVeinId().get(i)[j])){
//                        successCount ++;
//                    }
//                }
               
            }
        }
        
        score.fadeLineOverlap = ((float)successCount)/((float)count);

    }
    
    
    private List<String[]> fade(List<String[]> inputData, boolean black){
        
        String fadeChar;
        if(black){
            fadeChar = "1";
        }
        else{
            fadeChar = "0";
        }
        
        List<String[]> data= new ArrayList<String[]>();

        int i= 0;
        
        
        while(i < inputData.size()){
           
            data.add(new String[10]);
           
            int j = 0;
            
            while(j < inputData.get(i).length){
                
                data.get(i)[j] = inputData.get(i)[j];
                
                if(fadeChar.equals(inputData.get(i)[j])){
                    
                    if(j != 0){
                        data.get(i)[j-1] = fadeChar;
                    }
                    if(j !=9){
                        data.get(i)[j+1] = fadeChar;
                        j++;
                    }
                }
                
                
                
                j++;
            }
            i++;

        }
        
        return data;
    }
    
   
}
