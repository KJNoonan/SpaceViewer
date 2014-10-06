/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;

import utils.PolygonPlus;

/**
 *
 * @author Kevin
 */
public interface ShipDelegate extends Health, Movable, Identifiable, Locatable{
    
    void resetStrength();
    boolean damaged();
    boolean destroyed();
    String getInfoText();
    void applyDamage(double dmg);
    void setShape();
    PolygonPlus getShape();
    void setAngle(double d);
    double getAngle();
    
}
