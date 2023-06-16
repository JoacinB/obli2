   
package Interfaz;

import Dominio.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class VentanaVenta extends javax.swing.JFrame {

    /**
     * Creates new form VentanaVenta
     */
    public VentanaVenta(Sistema sistema) {
        initComponents();
        modelo = sistema;
        cargarCombo();
        botones();
        PanelBotones.setVisible(true);
    }
    
    public void cargarCombo(){
        for(Puesto obj : modelo.getListaPuesto()){
            ComboPuesto.addItem(obj.toString());
        }
    }
    
    
    public void botones(){
        JButton [][] matBotones = new JButton[12][3];
        PanelBotones.setLayout(new GridLayout(11,2));
        Puesto puesto = (Puesto)ComboPuesto.getSelectedItem();
        
        for(int i = 1;i<=11;i++){
            for(int j=1 ;j<=2;j++){
                JButton nuevo = new JButton("");
               
                for(Producto p: modelo.productoPuesto(puesto)){
                    //Si hay stock de este producto entonces agregalo al boton
                    Image imag = new ImageIcon(p.getImag()).getImage();
                    ImageIcon imagen;
                    imagen = new ImageIcon(imag.getScaledInstance(60,60,Image.SCALE_SMOOTH));
                    //Se agrega la imagen al boton
                    nuevo.setIcon(imagen);
                    JOptionPane.showMessageDialog(this,p);
//                    nuevo.setText(p.toString());
                    matBotones[i][j] = nuevo;
                }
                PanelBotones.setSize(453, 271);
                
                //nuevo.addActionListener(new ProcesoProducto());
                PanelBotones.add(new JScrollPane(nuevo));
            }
        }
        
    }
    
    private class ProcesoProducto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //este codigo se ejecuta al presionar el botón,obtengo cuál botón
            JButton cual = ((JButton)e.getSource());
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboPuesto = new javax.swing.JComboBox<>();
        lblPuesto = new javax.swing.JLabel();
        btnRegistra = new javax.swing.JButton();
        PanelBotones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ComboPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPuestoActionPerformed(evt);
            }
        });

        lblPuesto.setText("Puestos:");

        btnRegistra.setText("Elegir");
        btnRegistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraActionPerformed(evt);
            }
        });

        PanelBotones.setMinimumSize(new java.awt.Dimension(453, 271));

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addComponent(btnRegistra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblPuesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistra)
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        setBounds(0, 0, 731, 344);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPuestoActionPerformed

    private void btnRegistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraActionPerformed

    }//GEN-LAST:event_btnRegistraActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//     lblPuestotch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaVenta().setVisible(true);
//            }
//        });
//    }
    
    public Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPuesto;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JButton btnRegistra;
    private javax.swing.JLabel lblPuesto;
    // End of variables declaration//GEN-END:variables
}