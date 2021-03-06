/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.userinterface;

import at.ac.tuwien.dsg.serviceregistrymodel.AnalyticServiceUnit;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dsg
 */
public class UserInterface extends javax.swing.JFrame {

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        serviceUnitName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        taskName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        processType = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        serviceCost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        analyticTime = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Information about SERVICE REGISTRY");

        jLabel2.setText("URI:");

        uri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uriMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uriMouseEntered(evt);
            }
        });
        uri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uriActionPerformed(evt);
            }
        });

        jLabel3.setText("Service Unit Name:");

        jLabel4.setText("Task Name:");

        jLabel5.setText("Process Type:");

        jLabel6.setText("Service Cost (euro/MB):");

        serviceCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                serviceCostKeyTyped(evt);
            }
        });

        jLabel7.setText("Analytic Time (sec/MB):");

        analyticTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                analyticTimeKeyTyped(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 255, 204));
        jLabel8.setFont(new java.awt.Font("Monospaced", 2, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 51, 0));
        jLabel8.setText("e.g., www.DataAnalyticServiceUnit.com");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(uri, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(analyticTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(serviceCost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(processType, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taskName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serviceUnitName))))
                .addGap(49, 49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(uri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(serviceUnitName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(taskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(processType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(serviceCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(analyticTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFrame frame=new JFrame("test");
       HashMap information=new HashMap();
       information.put("taskName", new String(taskName.getText()));
       information.put("processType", new String(processType.getText()));
       information.put("serviceCost", new String(serviceCost.getText()+"euro/MB"));
       information.put("analyticTime", new String(analyticTime.getText()+"sec/MB"));
       if(uri.getText().isEmpty()) 
       {
           JOptionPane.showMessageDialog(frame, "You should enter the value of URI","Warning Message", JOptionPane.WARNING_MESSAGE);
       }
       else{ 
        
           AnalyticServiceUnit.uri="http://"+uri.getText()+"#";
           AnalyticServiceUnit.objectName=serviceUnitName.getText();
           AnalyticServiceUnit.getInstance().serviceModel(information); 
       
           JOptionPane.showMessageDialog(frame, "The generated "+serviceUnitName.getText()+".rdf file is stored in ./example2 folder ");
       }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void analyticTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_analyticTimeKeyTyped
       char c=evt.getKeyChar();
      if(! (Character.isDigit(c) || (c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_BACK_SPACE)))
         {
         getToolkit().beep();
          evt.consume();
      
         } // TODO add your handling code here:
    }//GEN-LAST:event_analyticTimeKeyTyped

    private void serviceCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serviceCostKeyTyped
     char c=evt.getKeyChar();
      if(! (Character.isDigit(c) || (c==KeyEvent.VK_PERIOD || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_BACK_SPACE)))
        {
         getToolkit().beep();
          evt.consume();
      
      }   // TODO add your handling code here:
    }//GEN-LAST:event_serviceCostKeyTyped

    private void uriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uriMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_uriMouseEntered

    private void uriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uriMouseClicked
      uri.setText("DataAnalyticServiceUnit.com");  // TODO add your handling code here:
    }//GEN-LAST:event_uriMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField analyticTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField processType;
    private javax.swing.JTextField serviceCost;
    private javax.swing.JTextField serviceUnitName;
    private javax.swing.JTextField taskName;
    private javax.swing.JTextField uri;
    // End of variables declaration//GEN-END:variables
}
