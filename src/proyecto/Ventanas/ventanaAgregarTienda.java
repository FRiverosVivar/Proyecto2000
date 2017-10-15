/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Ventanas;

import proyecto.Ventanas.ventanaMenuPrincipal;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto.Empresa;

/**
 *
 * @author Zekro
 */
public class ventanaAgregarTienda extends javax.swing.JFrame {

    /**
     * Creates new form ventanaAgregarTienda
     */
    Empresa best;
    public ventanaAgregarTienda(Empresa bestEmpresa) {
        initComponents();
        best = bestEmpresa;
        mnAdd_overlay.setBackground(new Color(0,0,0,100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnAdd_overlay = new javax.swing.JPanel();
        mnAdd_idTienda = new javax.swing.JTextField();
        mnAdd_nombreGerente = new javax.swing.JTextField();
        mnAdd_jB_agregarTienda = new javax.swing.JButton();
        mnAdd_dirTienda = new javax.swing.JTextField();
        mnAdd_rutGer = new javax.swing.JTextField();
        mnAdd_sueldoGerente = new javax.swing.JTextField();
        mnAdd_mnPrincipal = new javax.swing.JButton();
        pnl_msgID = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_msgDir = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl_nomGer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnl_sueldoGer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnl_rutGer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mnAdd_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 610));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mnAdd_overlay.setBackground(new java.awt.Color(0, 0, 0));
        mnAdd_overlay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mnAdd_overlay.add(mnAdd_idTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 220, -1));
        mnAdd_overlay.add(mnAdd_nombreGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 220, -1));

        mnAdd_jB_agregarTienda.setText("Agregar Tienda");
        mnAdd_jB_agregarTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAdd_jB_agregarTiendaActionPerformed(evt);
            }
        });
        mnAdd_overlay.add(mnAdd_jB_agregarTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, -1, -1));
        mnAdd_overlay.add(mnAdd_dirTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 220, -1));
        mnAdd_overlay.add(mnAdd_rutGer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 220, -1));

        mnAdd_sueldoGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAdd_sueldoGerenteActionPerformed(evt);
            }
        });
        mnAdd_overlay.add(mnAdd_sueldoGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 220, -1));

        mnAdd_mnPrincipal.setText("Volver Menu principal");
        mnAdd_mnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAdd_mnPrincipalActionPerformed(evt);
            }
        });
        mnAdd_overlay.add(mnAdd_mnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, -1, -1));

        pnl_msgID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingresa el ID de la tienda");
        pnl_msgID.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 20));

        mnAdd_overlay.add(pnl_msgID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 220, 40));

        pnl_msgDir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Ingrese la direccion de la tienda");
        pnl_msgDir.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 20));

        mnAdd_overlay.add(pnl_msgDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 40));

        pnl_nomGer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Ingresa el Nombre del Gerente");
        pnl_nomGer.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 20));

        mnAdd_overlay.add(pnl_nomGer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, 40));

        pnl_sueldoGer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Ingresa el Sueldo del Gerente");
        pnl_sueldoGer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 20));

        mnAdd_overlay.add(pnl_sueldoGer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 40));

        pnl_rutGer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Ingresa el Rut del Gerente");
        pnl_rutGer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 20));

        mnAdd_overlay.add(pnl_rutGer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 220, 40));

        getContentPane().add(mnAdd_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 610));

        mnAdd_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/City-Background-Night-Street-QD.jpg"))); // NOI18N
        mnAdd_bg.setMaximumSize(new java.awt.Dimension(880, 610));
        mnAdd_bg.setMinimumSize(new java.awt.Dimension(880, 610));
        mnAdd_bg.setPreferredSize(new java.awt.Dimension(880, 610));
        getContentPane().add(mnAdd_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnAdd_jB_agregarTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAdd_jB_agregarTiendaActionPerformed
        String id = mnAdd_idTienda.getText();
        String nomGer = mnAdd_nombreGerente.getText();
        String dir = mnAdd_dirTienda.getText();
        String sueldo = mnAdd_sueldoGerente.getText();
        String rut = mnAdd_rutGer.getText();
        
        if(id.isEmpty()||nomGer.isEmpty()||dir.isEmpty()||sueldo.isEmpty()||rut.isEmpty()){
            JOptionPane.showMessageDialog(null,"No es posible crear una tienda con algun campo vacio.");
            return;
        }
        if(best.agregarTienda(id,nomGer,dir,sueldo,rut) == -1){
            JOptionPane.showMessageDialog(null,"Ya existe una tienda con tal ID.");
            return;
        }
        
        JOptionPane.showMessageDialog(null,"Tienda Agregada Exitosamente.");
        try {
            best.guardarTiendas();
        } catch (IOException ex) {
            Logger.getLogger(ventanaAgregarTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnAdd_jB_agregarTiendaActionPerformed

    private void mnAdd_mnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAdd_mnPrincipalActionPerformed
        ventanaMenuPrincipal mnprn = new ventanaMenuPrincipal(best);
        mnprn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnAdd_mnPrincipalActionPerformed

    private void mnAdd_sueldoGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAdd_sueldoGerenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnAdd_sueldoGerenteActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel mnAdd_bg;
    private javax.swing.JTextField mnAdd_dirTienda;
    private javax.swing.JTextField mnAdd_idTienda;
    private javax.swing.JButton mnAdd_jB_agregarTienda;
    private javax.swing.JButton mnAdd_mnPrincipal;
    private javax.swing.JTextField mnAdd_nombreGerente;
    private javax.swing.JPanel mnAdd_overlay;
    private javax.swing.JTextField mnAdd_rutGer;
    private javax.swing.JTextField mnAdd_sueldoGerente;
    private javax.swing.JPanel pnl_msgDir;
    private javax.swing.JPanel pnl_msgID;
    private javax.swing.JPanel pnl_nomGer;
    private javax.swing.JPanel pnl_rutGer;
    private javax.swing.JPanel pnl_sueldoGer;
    // End of variables declaration//GEN-END:variables
}
