/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public interface Cloud extends Identifiable, Locatable{
    String getInfoText();
    void makeShape();
    void setIdentifier(String id);
    String getIdentifier();
    void setLocation(Point3D loc);
    void setColor(String clr);
    Color getColor();
    int getDuration();
    void setDuration(int d);
    boolean getVisible();
    void setVisible(boolean visibility);
    
}
