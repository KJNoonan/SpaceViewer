/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonClass;


/**
 *
 * @author Kevin
 */
public class HealthImpl implements Health{
    private double strength;
    private double maxStrength;
    
    public HealthImpl(double mStrng){
        setMaxStrength(mStrng);        
    }

    @Override
    public double getStrength() {return strength;}

    @Override
    public double getMaxStrength() {return maxStrength;}

    @Override
    public void setStrength(double strng){
        strength = strng;
    }

    @Override
    public void setMaxStrength(double mStrng){
        maxStrength = mStrng;
    }

    
}
