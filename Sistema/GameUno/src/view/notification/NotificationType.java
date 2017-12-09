/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.notification;

import java.awt.Color;



/**
 *
 * @author sergi
 */
public enum NotificationType {
//    SUCCESS((float)17.3,(float)63.9,(float)6.2),
//    
//    WARNING((float)93.2,(float)70.1,(float)1.4),
//    
//    DANGER((float)83.6,(float)0.7,(float)1.2);

    SUCCESS(Color.GREEN),
    
    WARNING(Color.ORANGE),
    
    DANGER(Color.RED);
    
    Color  value;
    
    NotificationType(Color myColor){
        this.value = myColor;
    }
    
    public Color getColor(){
        return value;
    }
  
}
