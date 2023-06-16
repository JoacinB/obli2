
package Interfaz;

import Dominio.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class VentanaCompra extends javax.swing.JFrame implements Observer {
    
    public static Producto producto;
    public static Mayorista mayorista;
    public static Puesto puesto;

    public VentanaCompra(Sistema sistema) {
        initComponents();
        modelo = sistema;
        modelo.addObserver(this);
        cargarPuesto();
        cargarMayorista();
        update(null,null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaPuesto = new javax.swing.JList();
        lblPuesto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMayorista = new javax.swing.JList();
        lblMayorista = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaProd = new javax.swing.JList();
        lblProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaPuesto.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPuestoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPuesto);

        lblPuesto.setText("Puesto:");

        listaMayorista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaMayoristaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaMayorista);

        lblMayorista.setText("Mayorista:");

        listaProd.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProdValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaProd);

        lblProducto.setText("Producto:");

        lblPrecio.setText("Precio: ");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel1.setText("Cantidad:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(lblMayorista, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuesto)
                    .addComponent(lblMayorista)
                    .addComponent(lblProducto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(60, 60, 60))
        );

        setBounds(0, 0, 584, 288);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(modelo.campoVacio(txtPrecio.getText()) || modelo.campoVacio(txtCantidad.getText())){
            JOptionPane.showMessageDialog(this,"Campos obligatorios","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(listaPuesto.isSelectionEmpty() || listaMayorista.isSelectionEmpty() || listaProd.isSelectionEmpty()){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un puesto, un mayorista y un producto", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            else{
            CompraProducto c = new CompraProducto(puesto,mayorista,producto,Integer.parseInt(txtPrecio.getText()),Integer.parseInt(txtCantidad.getText()));
            modelo.agregarCompra(c);
            }
        }
        txtPrecio.setText("");
        txtCantidad.setText("");
        limpiarListaProd();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char key = evt.getKeyChar();
        
        if(Character.isLetter(key)){
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char key = evt.getKeyChar();
        
        if(Character.isLetter(key)){
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void listaMayoristaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaMayoristaValueChanged
        mayorista = (Mayorista)listaMayorista.getSelectedValue();
        cargarProducto();
    }//GEN-LAST:event_listaMayoristaValueChanged

    private void listaProdValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProdValueChanged
        producto = (Producto)listaProd.getSelectedValue();
    }//GEN-LAST:event_listaProdValueChanged

    private void listaPuestoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPuestoValueChanged
        puesto = (Puesto)listaPuesto.getSelectedValue();
    }//GEN-LAST:event_listaPuestoValueChanged
    
    private void cargarPuesto(){
        listaPuesto.setListData(modelo.getListaPuesto().toArray());
    }
    
    private void cargarMayorista(){
        listaMayorista.setListData(modelo.getListaMayorista().toArray());
    }
    
    private void cargarProducto(){
        Mayorista m = (Mayorista)listaMayorista.getSelectedValue();
        
        listaProd.setListData(modelo.productoDe(m).toArray());
    }
    
    public DefaultListModel limpiarListaProd(){
        DefaultListModel nuevo = new DefaultListModel();
        
        listaProd.setModel(nuevo);
        
        return nuevo;
    }
    
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
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaCompra().setVisible(true);
//            }
//        });
//  }
    
    public Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMayorista;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JList listaMayorista;
    private javax.swing.JList listaProd;
    private javax.swing.JList listaPuesto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

//    private void update(Object object, Object object0) {
//        listaPuesto.setListData(modelo.getListaPuesto().toArray());
//        listaMayorista.setListData(modelo.getListaMayorista().toArray());
//    }

    @Override
    public void update(Observable o, Object arg) {
        listaPuesto.setListData(modelo.getListaPuesto().toArray());
        listaMayorista.setListData(modelo.getListaMayorista().toArray());
        listaProd.setListData(modelo.getListaProducto().toArray());
    }
}