/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import display.ConsoleItemImpl;
import display.ViewManager;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
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
public class CargoShip extends ShipDelegateImpl implements Runnable{
    private int dclouds;
    private PolygonPlus shape;
    private double angle;
    private Thread t1;
    
    public CargoShip(String id, String clrStr, Point3D loc, Point3D dest, double mStrng, double spd, int dclds){
        super(id,clrStr,loc,dest,mStrng,spd);
        setDebrisClouds(dclds);
        setShape();
        
        SpaceController.addShip(this);
        ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColor(), getAngle(), getShape(), getInfoText(), destroyed(), damaged()));
        t1 = new Thread(this);
        t1.start();
    }
    
    @Override
    public void run() {
        while (!destroyed()) {
            move(1);
            ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColor(), getAngle(), getShape(), getInfoText(), destroyed(), damaged()));
            try {
                t1.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShipDelegateImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setDebrisClouds(int dclds) {dclouds = dclds;}
    
    private int getDebrisClouds(){return dclouds;}

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
    public PolygonPlus getShape() {return shape;}
    
    
    public void move(int cycle) {
        Point3D locOld = getLocation();
        double distTraveled = getSpeed() * cycle;
        Point3D dest = getDestination();
        double destTo = locOld.distance(dest);

        if (distTraveled >= destTo) {
            setLocation(dest);
            setDestination(SpaceController.makePoint());
        } else {
            double delta = distTraveled/destTo;
            double XCoord = locOld.getX()+(dest.getX()-locOld.getX())*delta;
            double YCoord = locOld.getY()+(dest.getY()-locOld.getY())*delta;
            double ZCoord = locOld.getZ()+(dest.getZ()-locOld.getZ())*delta;
            
            Point3D newpt = new Point3D(XCoord, YCoord, ZCoord);
            setLocation(newpt);
            double nx = XCoord - locOld.getX();
            double ny = YCoord - locOld.getY();
            setAngle(Math.atan2(ny, nx) + (Math.PI / 2.0));
        }
    }

    
    
    public void setAngle(double d) {
        angle = d;
    }
    
    public String getInfoText(){
        return "Color:\t\t\t"+ColorMaker.getColorName(getColor())
                +"\nLocation:\t\t"+getLocation()
                +"\nDestination:\t\t"+getDestination()
                +"\nSpeed:\t\t\t"+getSpeed()
                +"\nAngle:\t\t\t"+getAngle()
                +"\n\nStrength:\t\t"+getStrength()
                +"\nMax Strength:\t\t"+getMaxStrength()
                +"\nDamaged:\t\t"+damaged();
    }
    
    public double getAngle(){
        return angle;
    }
    public void reactToRadarLock(Point3D location) {
        if (dclouds < 0){
            return;
        }else{
            setDestination(SpaceController.makePoint());
            SoundUtility.getInstance().playSound("sounds"+File.separator+"Cloud.wav");
            for (int i = 0; i < 2; i++){
                Point3D newP = SpaceController.makePointNear(getLocation(), 0.05);
                new DebrisCloud("Debris Cloud " + getDebrisClouds() + " from " + getIdentifier(), newP, "GRAY", 3000, true, 1.0);
                dclouds --;
            }
        }
    }

    }
    

