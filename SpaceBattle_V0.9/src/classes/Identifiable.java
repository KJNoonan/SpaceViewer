/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.awt.Color;

/**
 *
 * @author Kevin
 */
public interface Identifiable {
    String getIdentifier();
    Color getColor();
    
    void setColor(Color color);    
    void setIdentifier(String id);
    void setColor(String clrStr);
}
