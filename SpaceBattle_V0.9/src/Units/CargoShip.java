/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;

import Exceptions.InvalidParamException;
import Exceptions.NullParamException;
import Ship.ShipImpl;
import Units.DebrisCloud;
import Units.SpaceController;
import display.ConsoleItemImpl;
import display.ViewManager;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import utils.Point3D;
import utils.PolygonPlus;
import utils.SoundUtility;

/**
 *
 * @author Kevin
 */
public class CargoShip extends ShipImpl{
    
    private int debrisClouds;
    private PolygonPlus shape;
    
    public CargoShip(String id, String clrStr, Point3D loc, Point3D dest, double mStrng, double spd, int dbrsclds)throws NullParamException, InvalidParamException{
        super(loc, dest, spd, mStrng, id, clrStr);
        debrisClouds = dbrsclds;
        setShape();
        SpaceController.addShip(this);
         
    }
    
    @Override
    public void move(int cycles)throws NullParamException, InvalidParamException{
        Point3D locOld = getLocation();
        Point3D dest = getDestination();
        double distTraveled = getSpeed()*cycles;
        double distToDest = locOld.distance(dest);
        if(distToDest != 0.0){
            if(distToDest < distTraveled){
                setLocation(dest);
                setDestination(SpaceController.getInstance().makePoint());
            }else{
                double delta = distTraveled/distToDest;
                double newXCoord = locOld.getX()+((dest.getX()-locOld.getX())*delta);
                double newYCoord = locOld.getY()+((dest.getY()-locOld.getY())*delta);
                double newZCoord = locOld.getZ()+((dest.getZ()-locOld.getZ())*delta);
                
                Point3D newPt = new Point3D(newXCoord, newYCoord, newZCoord);
                setLocation(newPt);
                double nx = newPt.getX()-locOld.getX();
                double ny = newPt.getY()-locOld.getY();
                setAngle(Math.atan2(ny, nx)+(Math.PI/2));
                
            }
        }
    }
    
    public void resetStrength() throws InvalidParamException{
        setStrength(getMaxStrength());
    }
    
    public void reactToRadarLock(Point3D closePT) throws NullParamException, InvalidParamException{
    if(debrisClouds == 0)return;
    setDestination(SpaceController.makePoint());
    SoundUtility.getInstance().playSound("sounds"+File.separator+"Cloud.wav");
    for(int i=2;i>0;i++){
        Point3D newP;
        newP = SpaceController.makePointNear(getLocation(), 0.05);
        new DebrisCloud("Debris Cloud " + debrisClouds + " from " + getIdentifier(), newP, "GRAY", 3000, true, 1.0);
        debrisClouds--;
    }
}
    
    
    public void applyDamage(double hit)throws InvalidParamException, NullParamException{
        if (hit <= 0){
            throw new InvalidParamException("applyDamage must recieve a number greater than 0.");
        }
        double cStrength = getStrength() - hit;
        if(cStrength <= 0){
            String id = getIdentifier();
            SpaceController.removeShip(id);
            ViewManager.getInstance().removeItem(id);
            Point3D crashSite = getLocation();
            SpaceController.processDetonation(id, crashSite, 50, 200);
            new DebrisCloud("Ship Debris Cloud from"+id, crashSite, getColor().toString(), 4000, false, 1.5);
            SoundUtility.getInstance().playSound("sounds"+File.separator+"Blast.wav");
        }else{
            setStrength(cStrength);
        }
    }

    @Override
    public void setShape() {
        ArrayList<Point> sp = new ArrayList<>(); 
        sp.add(new Point(+0, -20)); // The Point here is java.awt.Point 
        sp.add(new Point(+12, +16)); // The Point here is java.awt.Point 
        sp.add(new Point(+0, +30)); // The Point here is java.awt.Point 
        sp.add(new Point(-12, +16)); // The Point here is java.awt.Point 
        // Now create the PolygonPlus – data member is “shape” in this example 
        shape = new PolygonPlus(); 
        for (Point sp1 : sp) { 
            shape.addPoint(sp1.x, sp1.y); 
        } 
    }

    @Override
    public PolygonPlus getShape() {
        return shape;    
    }

    
    
}
