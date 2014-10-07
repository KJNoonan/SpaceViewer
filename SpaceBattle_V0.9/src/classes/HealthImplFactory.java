/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



/**
 *
 * @author Kevin
 */
public class HealthImplFactory {
    static HealthImpl createHealth(double mStrng){
        return new HealthImpl(mStrng);
    }
}
