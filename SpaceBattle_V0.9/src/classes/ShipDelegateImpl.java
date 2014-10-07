/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import classes.DebrisCloud;
import classes.SpaceController;
import display.ConsoleItemImpl;
import display.ViewManager;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ColorMaker;
import utils.Point3D;
import utils.PolygonPlus;
import utils.SoundUtility;

/**
 *
 * @author Kevin
 */
public class ShipDelegateImpl implements ShipDelegate{

    private Health myHealth;
    private Identifiable myIdentity;
    private Locatable myLocation;
    private Movable myMovable;
    private double angle;
    private PolygonPlus shape;
    private String colorName;
    

    public ShipDelegateImpl(String id, String clrStr, Point3D loc, Point3D dest, double mStrng, double spd) {
        myHealth = HealthImplFactory.createHealth(mStrng);
        myIdentity = IdentifiableImplFactory.createIdentifiable(id, clrStr);
        colorName = clrStr;
        myLocation = LocatableImplFactory.createLocatable(loc);
        myMovable = MovableImplFactory.createMovable(dest, spd);
        resetStrength();
    }
    
    
    @Override
    public void resetStrength(){ myHealth.setStrength(myHealth.getMaxStrength());}
    
    @Override
    public boolean damaged(){return getStrength() == getMaxStrength();}
    
    @Override
    public boolean destroyed(){return getStrength() <= 0;}
    
    @Override
    public void applyDamage(double dmg) {
        double strng = getStrength()-dmg;
        setStrength(strng);
        
        if(strng <= 0){
            
            String id = getIdentifier();
            SpaceController.removeShip(id);
            ViewManager.getInstance().removeItem(id);
            SpaceController.processDetonation(id, getLocation(), strng, dmg);
            SpaceController.addDebrisCloud(new DebrisCloud("Ship Debris from "+id,getLocation(), colorName ,4000,false,1.5));
            SoundUtility.getInstance().playSound("sounds" + File.separator + "Blast.wav");
        }
    }
    //Accessors
    @Override
    public double getStrength(){return myHealth.getStrength();}
    
    @Override
    public double getMaxStrength(){return myHealth.getMaxStrength();}

    
    @Override
    public String getIdentifier(){return myIdentity.getIdentifier();}
    
    @Override
    public Color getColor(){return myIdentity.getColor();}
    
    @Override
    public Point3D getLocation(){return myLocation.getLocation();}
    
    @Override
    public Point3D getDestination(){return myMovable.getDestination();}
    
    @Override
    public double getSpeed(){return myMovable.getSpeed();}
    
    //Modifiers
    @Override
    public void setStrength(double strng){myHealth.setStrength(strng);}
    
    @Override
    public void setMaxStrength(double mStrng){myHealth.setMaxStrength(mStrng);}
    
    @Override
    public void setIdentifier(String id){myIdentity.setIdentifier(id);}
    
    @Override
    public void setColor(String s){myIdentity.setColor(s);}
    
    @Override
    public void setLocation(Point3D loc){myLocation.setLocation(loc);}
    
    @Override
    public void setDestination(Point3D dest){myMovable.setDestination(dest);}
    
    @Override
    public void setSpeed(double spd){myMovable.setSpeed(spd);}
    
    

    @Override
    public void setColor(Color color) { myIdentity.setColor(color);}

    @Override
    public void setShape() {shape = new PolygonPlus();}

    @Override
    public PolygonPlus getShape() {return shape;}

 

    
    


    
    
}

    
    
    

