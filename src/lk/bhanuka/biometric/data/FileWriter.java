/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.biometric.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class FileWriter {

    private  BufferedWriter getBufferedWriter(File file) throws IOException{
        
        if(!file.exists()){
            file.createNewFile();
        }
        
        java.io.FileWriter fw = new java.io.FileWriter(file.getAbsoluteFile(), true);
        
        return new BufferedWriter(fw);
    }
    
    public void writeFileCharacters(File file, List<String[]> characters) throws IOException{
        
        for(int i =0; i < characters.size(); i++){
            String out = "";
            for(String character : characters.get(i)){
                out = out + character;
            }
            this.writeLine(file, out+"\n");
        }
    }
    
    public void writeFileCharacters(String fileName, List<String[]> characters) throws IOException{
        this.writeFileCharacters(new File(fileName), characters);
    }
    
    public void writeLine(File file, String line) throws IOException{
        
        BufferedWriter bw = getBufferedWriter(file);
        bw.write(line);
        bw.close();
    }
    
    public void writeLine(String fileName, String line) throws IOException{
        
        this.writeLine(new File(fileName), line);
    }
    
    
}
