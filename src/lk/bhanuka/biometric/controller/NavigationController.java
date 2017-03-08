/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.controller;

import java.util.Map;
import lk.bhanuka.biometric.auth.AuthenticationScore;
import lk.bhanuka.biometric.data.User;
import lk.bhanuka.biometric.view.AuthMatching;
import lk.bhanuka.biometric.view.Main;

/**
 *
 * @author bhanuka
 */
public class NavigationController {

    public static void Launch(){
        Main mainFrame = new Main();
        mainFrame.setVisible(true);
    }
    
    public static void openAuthMatchPage(Map<User, AuthenticationScore> data){
        AuthMatching authPage = new AuthMatching(data);
        authPage.setVisible(true);
    }
    
    public static void exit(){
        System.exit(0);
    }
}
