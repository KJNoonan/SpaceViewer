/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import CommonClass.Identifiable;
import CommonClass.Locatable;
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
    
    private Identifiable myIdentity;
    private Locatable myLocation;
    private int duration;
    private boolean visible;
    private PolygonPlus shape;
    
    
    public DebrisCloud(String ID, Point3D location, String cName, int duration, boolean visibility, double size_factor) {
        myIdentity.setColor(cName);
        myIdentity.setIdentifier(ID);
        myLocation.setLocation(location);
        setDuration(duration);
        setVisible(visibility);
        makeShape();
        shape.scale(size_factor);
        ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(),getLocation(),getColor(),Math.toRadians(Math.random() * 360.0), shape, getInfoText(), false, false));
        SpaceController.addDebrisCloud(this);
        new Thread(this).start();
    }
   
    public String getInfoText(){
        return "Location:\t\t"+getLocation()+
                "\nDuration:\t\t"+duration+
                "\nRadar Visable:\t"+visible;
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
    
    @Override
    public void run(){
        if(duration <= 0){
            ViewManager.getInstance().removeItem(getIdentifier());
            if(!visible)
                SpaceController.removeCloud(getIdentifier());          
        }
        else{
            
            try {
                ViewManager.getInstance().updateItem(new ConsoleItemImpl(getIdentifier(), getLocation(), getColor(), Math.toRadians(Math.random()*360.0), shape, getInfoText(), false, false));
                Thread.sleep(50);
                duration -= 50;
                run();
            } catch (InterruptedException ex) {
                ex.printStackTrace();//
            }
            
        }
    }
    public void setIdentifier(String id){
        myIdentity.setIdentifier(id);
    }
    
    public String getIdentifier(){return myIdentity.getIdentifier();}
    
    public void setLocation(Point3D loc){myLocation.setLocation(loc);}
    
    public Point3D getLocation(){return myLocation.getLocation();}
    
    public void setColor(String clr){myIdentity.setColor(clr);}
    
    public Color getColor(){return myIdentity.getColor();}
    
    public int getDuration(){return duration;}

    private void setDuration(int d) {
        duration = d;
    }

    public boolean getVisible(){return visible;}
    
    private void setVisible(boolean visibility) {
    visible = visibility;
    }
    
}
