/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ship;

import Exceptions.InvalidParamException;
import Exceptions.NullParamException;
import Health.Health;
import Health.HealthImplFactory;
import Locatable.Locatable;
import Locatable.LocatableImplFactory;
import Movable.Movable;
import Movable.MovableImplFactory;
import display.ConsoleItemImpl;
import display.ViewManager;
import identification.Identifiable;
import identification.IdentifiableImplFactory;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Point3D;
import utils.PolygonPlus;

/**
 *
 * @author Kevin
 */
public abstract class ShipImpl implements Ship, Runnable{
    private Movable myMovable;
    private Locatable myLocatable;
    private Identifiable myIdentity;
    private Health myHealth;
    
    public ShipImpl(Point3D loc, Point3D dest, double spd,double mStrng,String id, String clrStr) throws NullParamException, InvalidParamException{
        myMovable = MovableImplFactory.createMovable(dest, spd);
        myLocatable = LocatableImplFactory.createLocatable(loc);
        myIdentity = IdentifiableImplFactory.createIdentifiable(id, clrStr);
        myHealth = HealthImplFactory.createHealth(mStrng);                
        ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColor(), getAngle(), getShape(), InfoText(), isDestroyed(), isDamaged()));
        Thread t1 = new Thread(this);
        t1.start();
    }
    
    public boolean isDamaged(){
        if(getStrength() < getMaxStrength()) return true;
        return false;
    }
    public boolean isDestroyed(){
        return getStrength() == 0.0;
    }
    public String getInfoText(){
        return "Color:\t\t\t"+getColor().toString()+"\n\n"
                +"Location:\t\t"+getLocation().toString()+"\n"
                +"Destination:\t\t"+getDestination().toString()+"\n"
                +"Speed:\t\t\t"+getSpeed()+"\n"
                +"Angle:\t\t\t"+getAngle()+"\n\n"
                +"Strength:\t\t"+getStrength()+"\n"
                +"Max Strength:\t\t"+getMaxStrength()+"\n"
                +"Damaged:\t\t"+isDamaged()+"\n";
    }
    
    


    @Override
    public double getStrength() {return myHealth.getStrength(); }

    @Override
    public double getMaxStrength() {return myHealth.getMaxStrength(); }

    @Override
    public void setStrength(double strng) throws InvalidParamException {
         myHealth.setStrength(strng);}

    @Override
    public void setMaxStrength(double mStrng) throws InvalidParamException {
        myHealth.setMaxStrength(mStrng);
    }

    @Override
    public double getAngle() {
        return myMovable.getAngle();
    }

    @Override
    public double getSpeed() {
        return myMovable.getSpeed();
    }

    @Override
    public Point3D getDestination() {
    return myMovable.getDestination();
            }

    @Override
    public Point3D getLocation() {
    return myLocatable.getLocation();
    }

    @Override
    public void setAngle(double angle) throws InvalidParamException {
    myMovable.setAngle(angle);
    }

    @Override
    public void setSpeed(double speed) throws InvalidParamException {
    myMovable.setSpeed(speed);
    }

    @Override
    public void setDestination(Point3D dest) throws NullParamException {
    myMovable.setDestination(dest);
    }

    @Override
    public void setLocation(Point3D loc) throws NullParamException {
        myLocatable.setLocation(loc);
    }

    @Override
    public String getIdentifier() {
    return myIdentity.getIdentifier();
    }

    @Override
    public Color getColor() {
        return myIdentity.getColor();
    }

    @Override
    public void setIdentifier(String id) throws NullParamException {
        myIdentity.setIdentifier(id);
    }

    @Override
    public void setColor(String clrStr) throws NullParamException {
    myIdentity.setColor(clrStr);
    }

    @Override
    public void run() {
        while(!this.isDestroyed()){
        try {
            move(1);
             ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColor(), getAngle(), getShape(), InfoText(), isDestroyed(), isDamaged()));
             Thread.sleep(50);
        } catch (NullParamException | InvalidParamException ex) {
            Logger.getLogger(ShipImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
    }
}
