
package Interfaz;

import Dominio.*;
import java.awt.Image;
import java.io.File;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaProducto extends javax.swing.JFrame {
    
    String archivo = "";
    public static final int CANCEL_OPTION = 1;
    public static final int  APPROVE_OPTION = 0; 

    public VentanaProducto(Sistema sistema) {
         cambiarEsp();
        initComponents();
        modelo = sistema;
        
        //Archivo imagenes por defecto
        String currentDir = System.getProperty("user.dir");
        String defaultFolder = currentDir + "/ImagenesOblig";
        FileChooser.setCurrentDirectory(new File(defaultFolder));
        
//        File defaultFolder = new File("C:\\OBLI2\\ImagenesOblig");
//        FileChooser.setCurrentDirectory(defaultFolder);
        
        //Archivos solo de tipo jpg y png
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("jpg, png","jpg","png");
        FileChooser.setFileFilter(filtrado);

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombre = new javax.swing.JLabel();
        jLabelDescri = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelVentapor = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        TextDescripcion = new javax.swing.JTextField();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        ComboBoxVenta = new javax.swing.JComboBox<>();
        FileChooser = new javax.swing.JFileChooser();
        jLabelimagen = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre);
        jLabelNombre.setBounds(20, 40, 60, 20);

        jLabelDescri.setText("Descripción:");
        getContentPane().add(jLabelDescri);
        jLabelDescri.setBounds(20, 80, 80, 16);

        jLabelTipo.setText("Tipo:");
        getContentPane().add(jLabelTipo);
        jLabelTipo.setBounds(20, 120, 60, 16);

        jLabelVentapor.setText("Venta por:");
        getContentPane().add(jLabelVentapor);
        jLabelVentapor.setBounds(20, 160, 70, 16);

        TextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNombreActionPerformed(evt);
            }
        });
        getContentPane().add(TextNombre);
        TextNombre.setBounds(120, 40, 120, 22);
        getContentPane().add(TextDescripcion);
        TextDescripcion.setBounds(120, 80, 220, 22);

        ComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "fruta", "verdura" }));
        getContentPane().add(ComboBoxTipo);
        ComboBoxTipo.setBounds(120, 120, 120, 22);

        ComboBoxVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "unidad", "kilogramo" }));
        getContentPane().add(ComboBoxVenta);
        ComboBoxVenta.setBounds(120, 160, 120, 22);

        FileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooserActionPerformed(evt);
            }
        });
        getContentPane().add(FileChooser);
        FileChooser.setBounds(400, 30, 580, 230);

        jLabelimagen.setText("Imagen:");
        getContentPane().add(jLabelimagen);
        jLabelimagen.setBounds(410, 10, 70, 16);
        getContentPane().add(lblImagen);
        lblImagen.setBounds(20, 220, 130, 120);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);
        btnReset.setBounds(180, 220, 72, 22);

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlta);
        btnAlta.setBounds(180, 270, 72, 22);

        setBounds(0, 0, 1017, 406);
    }// </editor-fold>//GEN-END:initComponents

    private void TextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNombreActionPerformed

    
    //Cambiar JFileChooser a español 
    public void cambiarEsp(){
        UIManager.put("FileChooser.openButtonText","Abrir");
        UIManager.put("FileChooser.openDialogTitleText","Abrir");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        UIManager.put("FileChooser.fileNameLabelText","Archivo");
        UIManager.put("FileChooser.filesOfTypeLabelText","Tipo");
        UIManager.put("FileChooser.lookInLabelText","Mirar en");
        UIManager.put("FileChooser.openButtonToolTipText","Abrir selección");
        UIManager.put("FileChooser.cancelButtonToolTipText","Cancelar selección");
    }
    
    
    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        
        if(JFileChooser.APPROVE_OPTION == 0){
            //Se selecciona un archivo
            archivo = FileChooser.getSelectedFile().getPath();
            Image imag = new ImageIcon(archivo).getImage();
            ImageIcon imagen;
            imagen = new ImageIcon(imag.getScaledInstance(lblImagen.getWidth(),lblImagen.getHeight(),Image.SCALE_SMOOTH));
            //Se muestra la imagen
            lblImagen.setIcon(imagen);
        }
        
        else{
            if(JFileChooser.CANCEL_OPTION == 1){
                //Se cancela un archivo
                lblImagen.setIcon(null);
                lblImagen.setText("Sin imagen");
            }
        }
        
    }//GEN-LAST:event_FileChooserActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        lblImagen.setIcon(null);
        lblImagen.setText("");
        TextNombre.setText("");
        TextDescripcion.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        if(modelo.campoVacio(TextNombre.getText()) || modelo.campoVacio(TextDescripcion.getText())){
            JOptionPane.showMessageDialog(this,"Campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(modelo.existeNombre(TextNombre.getText())){
                JOptionPane.showMessageDialog(this,"Nombre repetido", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Producto p = new Producto(TextNombre.getText(),TextDescripcion.getText(),ComboBoxTipo.getSelectedItem().toString(),ComboBoxVenta.getSelectedItem().toString(),archivo);
                modelo.agregarProducto(p);
            }
        }
    }//GEN-LAST:event_btnAltaActionPerformed

    
    
//    /**
//     * @param args the command line arguments
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
//            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaProducto().setVisible(true);
//            }
//        });
//    }
    
    private Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JComboBox<String> ComboBoxVenta;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JTextField TextDescripcion;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabelDescri;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelVentapor;
    private javax.swing.JLabel jLabelimagen;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}
