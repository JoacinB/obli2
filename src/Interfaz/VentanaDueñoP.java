
package Interfaz;

import Dominio.*;
import javax.swing.JOptionPane;


public class VentanaDueñoP extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDueñoP
     */
    public VentanaDueñoP(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jLabelExperiencia = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        TextEdad = new javax.swing.JTextField();
        TextExperiencia = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelNombre.setText("Nombre: ");
        getContentPane().add(jLabelNombre);
        jLabelNombre.setBounds(30, 50, 65, 16);

        jLabelEdad.setText("Edad: ");
        getContentPane().add(jLabelEdad);
        jLabelEdad.setBounds(30, 90, 66, 16);

        jLabelExperiencia.setText("Experiencia: ");
        getContentPane().add(jLabelExperiencia);
        jLabelExperiencia.setBounds(30, 140, 80, 20);
        getContentPane().add(TextNombre);
        TextNombre.setBounds(131, 46, 104, 22);

        TextEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextEdadKeyTyped(evt);
            }
        });
        getContentPane().add(TextEdad);
        TextEdad.setBounds(131, 92, 104, 22);

        TextExperiencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextExperienciaKeyTyped(evt);
            }
        });
        getContentPane().add(TextExperiencia);
        TextExperiencia.setBounds(131, 138, 104, 22);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(228, 199, 100, 22);

        setBounds(0, 0, 416, 308);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(modelo.campoVacio(TextNombre.getText()) || modelo.campoVacio(TextEdad.getText()) || modelo.campoVacio(TextExperiencia.getText()) ) {
            JOptionPane.showMessageDialog(this,"Campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(modelo.existeNombre(TextNombre.getText())){
              JOptionPane.showMessageDialog(this,"Nombre repetido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                DueñoPuesto d = new DueñoPuesto(TextNombre.getText(),Integer.parseInt(TextEdad.getText()),Integer.parseInt(TextExperiencia.getText()));
                modelo.agregarDueño(d);
            }
        }
        TextNombre.setText("");
        TextEdad.setText("");
        TextExperiencia.setText("");
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void TextEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextEdadKeyTyped
        //validar ingreso solo números
        
        char key = evt.getKeyChar();
        
        if(Character.isLetter(key)){
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
        }
    }//GEN-LAST:event_TextEdadKeyTyped

    private void TextExperienciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextExperienciaKeyTyped
        //validar ingreso solo números
        
        char key = evt.getKeyChar();
        
        if(Character.isLetter(key)){
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
        }
    }//GEN-LAST:event_TextExperienciaKeyTyped

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
//            java.util.logging.Logger.getLogger(VentanaDueñoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaDueñoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaDueñoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaDueñoP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaDueñoP().setVisible(true);
//            }
//        });
//    }
    
    private Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextEdad;
    private javax.swing.JTextField TextExperiencia;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelExperiencia;
    private javax.swing.JLabel jLabelNombre;
    // End of variables declaration//GEN-END:variables
}
