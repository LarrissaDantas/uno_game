/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.notification;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import view.util.Notification;

/**
 *
 * @author sergi
 */
public class NotificationPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form NotificationPanel
     */
    public NotificationPanel() {
        initComponents();
        
        //Config notification
        BoxLayout lay = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(lay);
        this.setOpaque(false);
    }
    public void showNotification(Notification notification,NotificationEventsInterface notificationInterface,NotificationTime time){
        notification.setInterface(notificationInterface);
        
        notification.setAlignmentX(Component.LEFT_ALIGNMENT);
        if(this.getComponentCount()>0){
            this.removeAll();
        }
        this.add(notification);
        this.revalidate();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((long) (time.getValue()*1000));
                    clearPanel();
                } catch (InterruptedException ex) {
                    Logger.getLogger(NotificationPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
    public void clearPanel(){
        if(this.getComponentCount()>0){
            this.removeAll();
        }
        this.updateUI();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
