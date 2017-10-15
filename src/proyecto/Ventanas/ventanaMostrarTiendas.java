/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.Ventanas;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import proyecto.Empresa;
import proyecto.Tienda;
import proyecto.Trabajador;

/**
 *
 * @author Zekro
 */
public class ventanaMostrarTiendas extends javax.swing.JFrame {

    /**
     * Creates new form ventanaMostrarTiendas
     */
    Empresa best;
    public ventanaMostrarTiendas(Empresa bestEmpresa) {
        initComponents();
        best = bestEmpresa;
        mnPrintOpt_overlay.setBackground(new Color(0,0,0,100));
        DefaultListModel<String> mdl = best.crearMdl();
        mnPrintOpt_jList.setModel(mdl);
        /*String element = null;
        Tienda aux;
    	Trabajador worker;
        ArrayList<Tienda> shopList = best.getShopArrayList();
        if(shopList.size()>0){
            ListIterator<Tienda> itr=shopList.listIterator();
            while (itr.hasNext()) {
                    aux = itr.next();
                    worker = aux.getGerente();
                    element = ("[ID: "+aux.getID()+"] - [Gerente: "+worker.getName()+
                    "] - [Trabajadores Registrados: "+aux.getStaff()+"] - [Inventario de la Tienda: "+aux.getInventory()+"]");
            }
        }else{
            element = "No hay ninguna tienda registrada actualmente.";
        }
        mdl.addElement(element);*/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnPrintOpt_overlay = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mnPrintOpt_jList = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        mnPrintOpt_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mnPrintOpt_overlay.setBackground(new java.awt.Color(0, 0, 0));
        mnPrintOpt_overlay.setToolTipText("");
        mnPrintOpt_overlay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        mnPrintOpt_overlay.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Guardar en Archivo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 20));

        mnPrintOpt_overlay.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 40));

        jScrollPane1.setViewportView(mnPrintOpt_jList);

        mnPrintOpt_overlay.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 590, 320));

        jButton3.setText("Volver al menu principal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        mnPrintOpt_overlay.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        getContentPane().add(mnPrintOpt_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 610));

        mnPrintOpt_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sin título-1.jpg"))); // NOI18N
        getContentPane().add(mnPrintOpt_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ventanaMenuPrincipal mnPrin = new ventanaMenuPrincipal(best);
        mnPrin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            best.mostrarTiendasEnArchivo();
            JOptionPane.showMessageDialog(null,"Archivo creado exitosamente (guardado en carpeta del proyecto).");
            /*try {
            try (FileWriter writer = new FileWriter("TiendasRegistradas.txt")) {
            ArrayList<Tienda> shopu = new ArrayList<>();
            shopu = best.getShopArrayList();
            String element = null;
            Tienda aux;
            Trabajador worker;
            if(shopu.size()<1){
            writer.close();
            JOptionPane.showMessageDialog(null,"No hay tiendas para guardar en un archivo txt.");
            return;
            }
            
            ListIterator<Tienda> itr=shopu.listIterator();
            while (itr.hasNext()) {
            aux = itr.next();
            worker = aux.getGerente();
            element = ("[ID: "+aux.getID()+"] - [Gerente: "+worker.getName()+
            "] - [Trabajadores Registrados: "+aux.getStaff()+"] - [Inventario de la Tienda: "+aux.getInventory()+"]");
            writer.write(element);
            }
            }
            JOptionPane.showMessageDialog(null,"Archivo creado exitosamente.");
            } catch (IOException ex){};*/
        } catch (IOException ex) {
            Logger.getLogger(ventanaMostrarTiendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mnPrintOpt_bg;
    private javax.swing.JList<String> mnPrintOpt_jList;
    private javax.swing.JPanel mnPrintOpt_overlay;
    // End of variables declaration//GEN-END:variables
}
