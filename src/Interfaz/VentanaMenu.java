// Autores: Julieta Lopez (295568) y Joaquin Borges (284675)
package Interfaz;
import Dominio.*;

public class VentanaMenu extends javax.swing.JFrame {

    public VentanaMenu(Sistema sistema) {
        initComponents();
        modelo = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        menRegistrar = new javax.swing.JMenu();
        itemProducto = new javax.swing.JMenuItem();
        itemDueñoPuesto = new javax.swing.JMenuItem();
        itemPuesto = new javax.swing.JMenuItem();
        itemMayorista = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        ItemCompra = new javax.swing.JMenuItem();
        ItemVenta = new javax.swing.JMenuItem();
        menConsultar = new javax.swing.JMenu();
        itemConProductos = new javax.swing.JMenuItem();
        itemConDuenos = new javax.swing.JMenuItem();
        itemConPuestos = new javax.swing.JMenuItem();
        itemConMayoristas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menRegistrar.setMnemonic('f');
        menRegistrar.setText("Registro");

        itemProducto.setMnemonic('o');
        itemProducto.setText("Producto");
        itemProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductoActionPerformed(evt);
            }
        });
        menRegistrar.add(itemProducto);

        itemDueñoPuesto.setMnemonic('s');
        itemDueñoPuesto.setText("Dueño de puesto");
        itemDueñoPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDueñoPuestoActionPerformed(evt);
            }
        });
        menRegistrar.add(itemDueñoPuesto);

        itemPuesto.setMnemonic('a');
        itemPuesto.setText("Puesto");
        itemPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPuestoActionPerformed(evt);
            }
        });
        menRegistrar.add(itemPuesto);

        itemMayorista.setMnemonic('x');
        itemMayorista.setText("Mayorista");
        itemMayorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMayoristaActionPerformed(evt);
            }
        });
        menRegistrar.add(itemMayorista);

        menuBar.add(menRegistrar);

        editMenu.setMnemonic('e');
        editMenu.setText("Movimiento");

        ItemCompra.setMnemonic('t');
        ItemCompra.setText("Registrar compra");
        ItemCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCompraActionPerformed(evt);
            }
        });
        editMenu.add(ItemCompra);

        ItemVenta.setMnemonic('y');
        ItemVenta.setText("Registrar Venta");
        ItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemVentaActionPerformed(evt);
            }
        });
        editMenu.add(ItemVenta);

        menuBar.add(editMenu);

        menConsultar.setMnemonic('h');
        menConsultar.setText("Consultas");

        itemConProductos.setMnemonic('c');
        itemConProductos.setLabel("Producto");
        itemConProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConProductosActionPerformed(evt);
            }
        });
        menConsultar.add(itemConProductos);

        itemConDuenos.setMnemonic('a');
        itemConDuenos.setLabel("Dueños");
        itemConDuenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConDuenosActionPerformed(evt);
            }
        });
        menConsultar.add(itemConDuenos);

        itemConPuestos.setText("Puestos");
        itemConPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConPuestosActionPerformed(evt);
            }
        });
        menConsultar.add(itemConPuestos);

        itemConMayoristas.setText("Mayoristas");
        itemConMayoristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConMayoristasActionPerformed(evt);
            }
        });
        menConsultar.add(itemConMayoristas);

        menuBar.add(menConsultar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMayoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMayoristaActionPerformed
        VentanaMayorista ventMayorista = new VentanaMayorista(modelo);
        ventMayorista.setVisible(true);
    }//GEN-LAST:event_itemMayoristaActionPerformed

    private void itemProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductoActionPerformed
        VentanaProducto ventProducto = new VentanaProducto(modelo);
        ventProducto.setVisible(true);
    }//GEN-LAST:event_itemProductoActionPerformed

    private void itemDueñoPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDueñoPuestoActionPerformed
        VentanaDueñoP ventanaD = new VentanaDueñoP(modelo);
        ventanaD.setVisible(true);
    }//GEN-LAST:event_itemDueñoPuestoActionPerformed

    private void itemPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPuestoActionPerformed
        VentanaPuestos ventanaP = new VentanaPuestos(modelo);
        ventanaP.setVisible(true);
    }//GEN-LAST:event_itemPuestoActionPerformed

    private void ItemCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCompraActionPerformed
        VentanaCompra ventanaC = new VentanaCompra(modelo);
        ventanaC.setVisible(true);
    }//GEN-LAST:event_ItemCompraActionPerformed

    private void ItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemVentaActionPerformed
        VentanaVenta ventanaV = new VentanaVenta(modelo);
        ventanaV.setVisible(true);
    }//GEN-LAST:event_ItemVentaActionPerformed

    private void itemConProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConProductosActionPerformed
        VentanaConsultaProducto ventanaConProd = new VentanaConsultaProducto(modelo);
        ventanaConProd.setVisible(true);
    }//GEN-LAST:event_itemConProductosActionPerformed

    private void itemConDuenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConDuenosActionPerformed
        VentanaConsultaDueño ventanaConDuenos = new VentanaConsultaDueño(modelo);
        ventanaConDuenos.setVisible(true);
    }//GEN-LAST:event_itemConDuenosActionPerformed

    private void itemConMayoristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConMayoristasActionPerformed
        VentanaConsultaMayoristas ventanaConMayoristas = new VentanaConsultaMayoristas(modelo);
        ventanaConMayoristas.setVisible(true);
    }//GEN-LAST:event_itemConMayoristasActionPerformed

    private void itemConPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConPuestosActionPerformed
        VentanaConsultaPuestos ventanaConPuestos = new VentanaConsultaPuestos(modelo);
        ventanaConPuestos.setVisible(true);
    }//GEN-LAST:event_itemConPuestosActionPerformed
    
    

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
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaMenu().setVisible(true);
//            }
//        });
    }
    
    private Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemCompra;
    private javax.swing.JMenuItem ItemVenta;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem itemConDuenos;
    private javax.swing.JMenuItem itemConMayoristas;
    private javax.swing.JMenuItem itemConProductos;
    private javax.swing.JMenuItem itemConPuestos;
    private javax.swing.JMenuItem itemDueñoPuesto;
    private javax.swing.JMenuItem itemMayorista;
    private javax.swing.JMenuItem itemProducto;
    private javax.swing.JMenuItem itemPuesto;
    private javax.swing.JMenu menConsultar;
    private javax.swing.JMenu menRegistrar;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
