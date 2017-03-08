/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.controller;

import java.io.IOException;
import lk.bhanuka.biometric.data.AuthenticationRequest;
import lk.bhanuka.biometric.data.Authenticator;

/**
 *
 * @author bhanuka
 */
public class AuthenticationController {
    
    private static final Authenticator authenticator = new Authenticator();
    
    public static void checkAuthentication(AuthenticationRequest request) throws IOException{
        NavigationController.openAuthMatchPage(AuthenticationController.authenticator.checkAuthentication(request));
    }
    
}
