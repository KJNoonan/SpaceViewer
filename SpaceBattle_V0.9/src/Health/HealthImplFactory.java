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
public class HealthImplFactory {
    public static HealthImpl createHealth(double mStrng)throws InvalidParamException{
        return new HealthImpl(mStrng);
    }
}
