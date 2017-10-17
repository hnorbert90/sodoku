/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sodoku;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Sodoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Generator.generateTable();  
            Generator.writeTables();
        } catch (IOException ex) {
            Logger.getLogger(Sodoku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
