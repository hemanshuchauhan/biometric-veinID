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
public class FadeAuth extends AuthUnit{

    @Override
    protected void authenticate(User user, AuthenticationRequest request, AuthenticationScore score) {
        List<String[]> userId = this.fade(user.getVeinId());
        List<String[]> requestId = this.fade(request.veinId);
        
        int count = 0;
        int successCount = 0;
        
        for(int i =0; i < requestId.size(); i++){
            
            for(int j=0 ; j< requestId.get(i).length; j++){
                count ++;
                if(requestId.get(i)[j].equals(userId.get(i)[j])){
                    successCount ++;
                }
            }
        }

        score.fadeAuth = ((float)successCount)/((float)count);
        
    }
    
    private List<String[]> fade(List<String[]> inputData){
        
        List<String[]> data= new ArrayList<String[]>();

        int i= 0;
        
        
        while(i < inputData.size()){
           
            data.add(new String[10]);
           
            int j = 0;
            
            while(j < inputData.get(i).length){
                
                data.get(i)[j] = inputData.get(i)[j];
                
                if("1".equals(inputData.get(i)[j])){
                    
                    if(j != 0){
                        data.get(i)[j-1] = "1";
                    }
                    if(j !=9){
                        data.get(i)[j+1] = "1";
                        j++;
                    }
                }
                
                
                
                j++;
            }
            i++;

        }
        
        return data;
    }
    
    private void print(List<String[]> characters){
        
        for(int i =0; i < characters.size(); i++){
            String out = "";
            for(String character : characters.get(i)){
                out = out + character;
            }
            System.out.println(out);
        }
    }
}
