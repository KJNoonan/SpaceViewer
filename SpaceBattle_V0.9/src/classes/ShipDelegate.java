/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import utils.PolygonPlus;

/**
 *
 * @author Kevin
 */
public interface ShipDelegate extends Health, Movable, Identifiable, Locatable{
    
    void resetStrength();
    boolean damaged();
    boolean destroyed();
    void applyDamage(double dmg);
    void setShape();
    PolygonPlus getShape();    
}
