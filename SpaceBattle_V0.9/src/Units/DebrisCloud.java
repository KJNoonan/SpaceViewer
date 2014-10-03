/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;

import Exceptions.NullParamException;
import display.ConsoleItemImpl;
import display.ViewManager;
import java.awt.Color;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Point3D;
import utils.PolygonPlus;

/**
 *
 * @author Kevin
 */
public class DebrisCloud implements Runnable{
    private String identifier;
    private Point3D location;
    private PolygonPlus shape;
    private int duration;
    private Color colour;
    private boolean radarVisable;
    
    public DebrisCloud(String ID, Point3D location, String cName, int duration, boolean visibility, double size_factor)throws NullParamException{
        setIdentifier(ID);
        setLocation(location);
        setColour(cName);
        setDuration(duration);
        setRadarVisable(visibility);
        makeShape();
        shape.scale(size_factor);
        ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColour(), Math.toRadians(Math.random()*360.0), shape, getInfoText(), false, false));
        if(radarVisable) SpaceController.addCloud(this);
        new Thread(this).start();
    }
    
    public String getInfoText(){
        return "Location:\t\t"+location+
                "\nDuration:\t\t"+duration+
                "\nRadar Visable:\t"+radarVisable;
    }
    
    public void makeShape(){
        ArrayList<Point> sp = new ArrayList<>(); 
        sp.add(new Point(0, -13)); 
        sp.add(new Point(4, -15)); 
        sp.add(new Point(7, -14)); 
        sp.add(new Point(9, -9)); 
        sp.add(new Point(14, -7)); 
        sp.add(new Point(15, -4)); 
        sp.add(new Point(13, 0)); 
        sp.add(new Point(15, 4)); 
        sp.add(new Point(14, 7)); 
        sp.add(new Point(9, 9)); 
        sp.add(new Point(7, 14)); 
        sp.add(new Point(4, 15)); 
        sp.add(new Point(0, 13)); 
        sp.add(new Point(-4, 15)); 
        sp.add(new Point(-7, 14)); 
        sp.add(new Point(-9, 9)); 
        sp.add(new Point(-14, 7)); 
        sp.add(new Point(-15, 4)); 
        sp.add(new Point(-13, 0)); 
        sp.add(new Point(-15, -4)); 
        sp.add(new Point(-14, -7)); 
        sp.add(new Point(-9, -9)); 
        sp.add(new Point(-7, -14)); 
        sp.add(new Point(-4, -15)); 
        // Now create the PolygonPlus – data member is “shape” in this example 
        shape = new PolygonPlus(); 
        for (Point sp1 : sp) { 
        shape.addPoint(sp1.x, sp1.y); 
 }
    }
    
    
    //Modifiers
    private void setIdentifier(String ID){
        identifier = ID;
    }
    
    private void setLocation(Point3D pt){
        location = pt;
    }
    private void setDuration(int dur){
        duration = dur;
    }
    private void setColour(String clr)throws NullParamException{
       if (clr == null) {
            throw new NullParamException("Color is pointing "
                    + "to a null Color Object");
        }
        colour = Color.getColor(clr);
    }
    private void setRadarVisable(boolean visable){
        radarVisable = visable;
    }
    
    
    //Accessor Methods
     public String getIdentifier(){
        return identifier;
    }
    
    public Point3D getLocation(){
        return location;
    }
    public int getDuration(){
        return duration;
    }
    public Color getColour(){
        return colour;
    }
    public boolean getRadarVisable(){
        return radarVisable;
    }

    @Override
    public void run(){
        if(duration <= 0){
            ViewManager.getInstance().removeItem(identifier);
            if(!radarVisable)try {
                SpaceController.removeCloud(identifier);
            } catch (NullParamException ex) {
                Logger.getLogger(DebrisCloud.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
            ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColour(), Math.toRadians(Math.random()*360.0), shape, getInfoText(), false, false));
            //sleep for 50 ms
            duration -= 50;
            run();
        }
    }
    
}
