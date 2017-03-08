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
public class AuthenticationScore {
    
    
    public Float basicMatch;
    
    public Float shiftAuth;
    public int shiftFactor;
    
    public Float fadeAuth;
    
    public Float fadeLineOverlap;
    
    public Float getConfidenceLevel(){
        return 1.0f;
    }
    
}
