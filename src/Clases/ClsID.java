/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Will Vasquez
 */
public class ClsID {
    String text;
    int id;
    
    public ClsID(String text, int id) {
        this.text = text;
        this.id = id;
    }
    
    @Override
    public String toString() {
        return text;
    }
    
    public String getText() {
        return text;
    }
    
    public int getID() {
        return id;
    }
}
