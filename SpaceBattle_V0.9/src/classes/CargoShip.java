/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import CommonClass.ShipDelegate;
import CommonClass.ShipDelegateImplFactory;
import java.awt.Color;
import utils.Point3D;

/**
 *
 * @author Kevin
 */
public class CargoShip implements ShipDelegate{
    private ShipDelegate myShip;
    private int dclouds;
    
    public CargoShip(String id, String clrStr, Point3D loc, Point3D dest, double mStrng, double spd, int dclds){
        myShip = ShipDelegateImplFactory.createship(id, clrStr, loc, dest, mStrng, spd);
        setDebrisClouds(dclds);
    }

    @Override
    public void resetStrength() { myShip.resetStrength();}

    @Override
    public boolean damaged() { return myShip.damaged();}

    @Override
    public boolean destroyed() {return myShip.damaged();}

    @Override
    public String getInfoText() {return myShip.getInfoText();}

    @Override
    public void applyDamage(double dmg) {myShip.applyDamage(dmg);}

    @Override
    public double getStrength() {return myShip.getStrength();}

    @Override
    public double getMaxStrength() {return myShip.getMaxStrength();}

    @Override
    public void setStrength(double strng) {myShip.setStrength(strng);}

    @Override
    public void setMaxStrength(double mStrng) {myShip.setStrength(mStrng);}

    @Override
    public double getSpeed() {return myShip.getSpeed();}

    @Override
    public Point3D getDestination() {return myShip.getDestination();}

    @Override
    public void setSpeed(double speed) {myShip.setSpeed(speed);}

    @Override
    public void setDestination(Point3D dest) {myShip.setDestination(dest);}

    @Override
    public String getIdentifier() {myShip.set;}

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdentifier(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(String clrStr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point3D getLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocation(Point3D loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//

    private void setDebrisClouds(int dclds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
