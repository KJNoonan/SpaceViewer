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
public interface Health {
    double getStrength();
    double getMaxStrength();
    
    void setStrength(double strng)throws InvalidParamException;
    void setMaxStrength(double mStrng)throws InvalidParamException;
}
