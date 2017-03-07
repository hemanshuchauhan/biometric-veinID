/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class FileReader {
    
    private BufferedReader getBufferredReader(File file) throws FileNotFoundException{
        
        java.io.FileReader fr = new java.io.FileReader(file);
        
        return new BufferedReader(fr);
    }
    
    public List<String[]> readFileCharacters(File file) throws FileNotFoundException, IOException{
        
        BufferedReader br = this.getBufferredReader(file);
        
        ArrayList<String[]> returnList = new ArrayList();
        
        String currentLine; 
        while((currentLine = br.readLine()) != null){
            returnList.add(currentLine.split(""));
        }
        
        return returnList;
    }
    
    public List<String> readFileLines(File file) throws FileNotFoundException, IOException{
        
        BufferedReader br = this.getBufferredReader(file);
        
        ArrayList<String> returnList = new ArrayList();
        
        String currentLine;
        
        while((currentLine= br.readLine()) != null){
            returnList.add(currentLine);
        }
        
        return returnList;
    }
    
    public List<String> readFileLine(String fileName) throws IOException{
        return this.readFileLines(new File(fileName));
    }
    
    public List<String[]> readFileCharacters(String fileName) throws IOException{
        return this.readFileCharacters(new File(fileName));
    }
}
