/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Health;

import Exceptions.InvalidParamException;

/**
 *
 * @author Kevin
 */
public class HealthImpl implements Health{
    private double strength;
    private double maxStrength;
    
    public HealthImpl(double strng, double mStrng)throws InvalidParamException{
        setMaxStrength(mStrng);
        setStrength(strng);
        
    }

    @Override
    public double getStrength() {return strength;}

    @Override
    public double getMaxStrength() {return maxStrength;}

    @Override
    public void setStrength(double strng) throws InvalidParamException {
        if(strng < 0 || strng > maxStrength){
            throw new InvalidParamException("Strength must be greater than 0 or less than the max strength.");
        }
        strength = strng;
    }

    @Override
    public void setMaxStrength(double mStrng) throws InvalidParamException {
        if(mStrng <= 0){
            throw new InvalidParamException("Max strength must be greater than 0.");
        }
        maxStrength = mStrng;
    }

    
}
