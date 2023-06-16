
package Interfaz;

import Dominio.Puesto;
import Dominio.Sistema;
import javax.swing.JOptionPane;

public class VentanaPuestos extends javax.swing.JFrame {

 
    public VentanaPuestos(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        lblDueño = new javax.swing.JLabel();
        lblUbi = new javax.swing.JLabel();
        lblCantEm = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtDueño = new javax.swing.JTextField();
        txtUbi = new javax.swing.JTextField();
        txtCantE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblID.setText("Identificación:");
        getContentPane().add(lblID);
        lblID.setBounds(30, 40, 81, 16);

        lblDueño.setText("Dueño:");
        getContentPane().add(lblDueño);
        lblDueño.setBounds(30, 80, 81, 16);

        lblUbi.setText("Ubicación:");
        getContentPane().add(lblUbi);
        lblUbi.setBounds(30, 120, 73, 16);

        lblCantEm.setText("Cantidad de empleados: ");
        getContentPane().add(lblCantEm);
        lblCantEm.setBounds(30, 160, 140, 16);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(280, 240, 90, 22);
        getContentPane().add(txtID);
        txtID.setBounds(210, 40, 110, 22);
        getContentPane().add(txtDueño);
        txtDueño.setBounds(210, 80, 110, 22);
        getContentPane().add(txtUbi);
        txtUbi.setBounds(210, 120, 110, 22);

        txtCantE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantEKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantE);
        txtCantE.setBounds(210, 160, 110, 22);

        setBounds(0, 0, 416, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(modelo.campoVacio(txtID.getText()) || modelo.campoVacio(txtDueño.getText()) || modelo.campoVacio(txtUbi.getText()) || modelo.campoVacio(txtCantE.getText())){
            JOptionPane.showMessageDialog(this, "Campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(modelo.existeNombre(txtID.getText())){
                JOptionPane.showMessageDialog(this,"Identificaión repetida","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                Puesto p = new Puesto(txtID.getText(),txtDueño.getText(),txtUbi.getText(),Integer.parseInt(txtCantE.getText()));
                modelo.agregarPuestos(p);
            }
        }
        txtID.setText("");
        txtDueño.setText("");
        txtUbi.setText("");
        txtCantE.setText("");
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCantEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantEKeyTyped
        char key = evt.getKeyChar();
        
        if(Character.isLetter(key)){
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
        }
    }//GEN-LAST:event_txtCantEKeyTyped

    /**
     * @param args the command line arguments
//     */
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
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaPuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPuestos().setVisible(true);
//            }
//        });
//    }
    
    private Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblCantEm;
    private javax.swing.JLabel lblDueño;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblUbi;
    private javax.swing.JTextField txtCantE;
    private javax.swing.JTextField txtDueño;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtUbi;
    // End of variables declaration//GEN-END:variables
}
