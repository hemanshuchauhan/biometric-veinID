/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.auth;

/**
 *
 * @author bhanuka
 */
public class AuthenticationScore {
    
    
    public Float basicMatch;
    
    public Float shiftAuth;
    public int shiftFactor;
    
    public Float fadeAuth;
    
    public Float fadeLineOverlap;
    
    public Float getConfidenceLevel(){
        if(this.basicMatch == 1.0f){
            return 1.0f;
        }
        else{
            return (Float)((basicMatch + 0.5f*(10 - shiftFactor) * shiftAuth/10f + 0.3f* fadeAuth + 0.2f * fadeLineOverlap)/2.0f);
        }
    }
    
}
