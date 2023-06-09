// Autores: Julieta Lopez (295568) y Joaquin Borges (284675)
package Interfaz;

import Dominio.*;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaConsultaProducto extends javax.swing.JFrame {

    List<String> nombresProductos;
    private Sistema sistema;
    int IndexActual = 0;
    
    public VentanaConsultaProducto(Sistema sistema) {
        this.sistema = sistema;
        this.nombresProductos = new ArrayList<>();
        
        if (sistema.getListaProducto().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se han cargado productos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            for (Producto producto : sistema.getListaProducto()) {
                this.nombresProductos.add(producto.getNombre());
            }
        }
            
        initComponents();
    }
    
    
    private void actualizarInfoProducto(String nombreProducto) {
        Producto producto = null;

        // Buscar el producto en la listaProducto usando el nombreProducto
        for (Producto p : sistema.getListaProducto()) {
            if (p.getNombre().equals(nombreProducto)) {
                producto = p;
                break;
            }
        }

        // Si se encuentra el producto, actualizar interfaz.
        if (producto != null) {
            
            //nombre, descripcion, tipo, venta por e imagen.
            jTextFieldNombre.setText(producto.getNombre());
            jTextFieldDescripcion.setText(producto.getDescripcion());
            jComboBoxTipo.setSelectedItem(producto.getTipo());
            jComboBoxVentaPor.setSelectedItem(producto.getFormaVenta());
            Image imagenProducto = producto.getImage();
            Image scaledImage = imagenProducto.getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            jLabelImagen.setIcon(imageIcon);
            
            //total $ v/c entre todos los puestos
            int totalVendido = sistema.calcularTotalVendidoPorProducto(producto);
            jLabelTotalVendido.setText("Total $ vendido entre todos los puestos: " + totalVendido);
            int totalComprado = sistema.calcularTotalCompradoPorProducto(producto);
            jLabelTotalComprado.setText("Total $ comprado entre todos los puestos: " + totalComprado);
            
            //precios maximos y minimos
            double minPrecio = sistema.obtenerPrecioMinimoVendido(producto);
            jLabelPrecioMinVendido.setText("Precio mínimo vendido: " + String.format("%.2f", minPrecio));
            double maxPrecio = sistema.obtenerPrecioMaximoVendido(producto);
            jLabelPrecioMaxVendido.setText("Precio máximo vendido: " + String.format("%.2f", maxPrecio));
            
            //Cantidad total v/c entre todos los puestos
            int cantidadTotalV = sistema.calcularCantidadTotalVendidaPorProducto(producto);
            jLabelCantTotalV.setText("Cantidad total vendida entre todos los puestos (unidad/kilo): " + cantidadTotalV + " - " + producto.getFormaVenta());
            int cantidadTotal = sistema.calcularCantidadTotalCompradaPorProducto(producto);
            jLabelCantTotalC.setText("Cantidad total comprada entre todos los puestos (unidad/kilo): " + cantidadTotal + " - " + producto.getFormaVenta());
            
            //Puestos con el precio de venta min/max
            actualizarPuestosConMax_MinPrice(producto);
        } else {
            System.out.println("Producto no encontrado");
        }
    }
    
    public void actualizarPuestosConMax_MinPrice(Producto producto) {
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;

        List<Puesto> puestosMaxPrice = new ArrayList<>();
        List<Puesto> puestosMinPrice = new ArrayList<>();

        // Go through all the sales to find max and min price.
        for (VentaProducto venta : sistema.getListaVenta()) {
            if (venta.getProd().equals(producto)) {
                double precio = venta.getPrecio();
                Puesto puesto = venta.getPuesto(); // Assuming VentaProducto has a method getPuesto to get the Puesto.

                if (precio > maxPrice) {
                    maxPrice = precio;
                    puestosMaxPrice.clear();
                    puestosMaxPrice.add(puesto);
                } else if (precio == maxPrice) {
                    puestosMaxPrice.add(puesto);
                }

                if (precio < minPrice) {
                    minPrice = precio;
                    puestosMinPrice.clear();
                    puestosMinPrice.add(puesto);
                } else if (precio == minPrice) {
                    puestosMinPrice.add(puesto);
                }
            }
        }

        // Update jListMaximo
        javax.swing.DefaultListModel<String> maxModel = new javax.swing.DefaultListModel<>();
        for (Puesto p : puestosMaxPrice) {
            maxModel.addElement(p.toString()); // or p.getName(), depends on how you want to represent Puesto as a String
        }
        jListMaximo.setModel(maxModel);

        // Update jListMinimo
        javax.swing.DefaultListModel<String> minModel = new javax.swing.DefaultListModel<>();
        for (Puesto p : puestosMinPrice) {
            minModel.addElement(p.toString()); // or p.getName(), depends on how you want to represent Puesto as a String
        }
        jListMinimo.setModel(minModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDescripcion = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelVentaPor = new javax.swing.JLabel();
        jButtonP_Mayor = new javax.swing.JButton();
        jButtonP_Menor = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jComboBoxVentaPor = new javax.swing.JComboBox<>();
        jLabelInfoProducto = new javax.swing.JLabel();
        jLabelTotalVendido = new javax.swing.JLabel();
        jLabelTotalComprado = new javax.swing.JLabel();
        jLabelCantTotalV = new javax.swing.JLabel();
        jLabelCantTotalC = new javax.swing.JLabel();
        jLabelPrecioMinVendido = new javax.swing.JLabel();
        jLabelPuestosPrecioVenMin = new javax.swing.JLabel();
        jLabelPuestosPrecioVenMax = new javax.swing.JLabel();
        jLabelPrecioMaxVendido = new javax.swing.JLabel();
        jScrollPaneMinimo = new javax.swing.JScrollPane();
        jListMinimo = new javax.swing.JList<>();
        jScrollPaneMaximo = new javax.swing.JScrollPane();
        jListMaximo = new javax.swing.JList<>();
        jLabelImagen = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jLabelDescripcion.setText("Descripción:");
        getContentPane().add(jLabelDescripcion);
        jLabelDescripcion.setBounds(120, 140, 90, 16);

        jLabelTipo.setText("Tipo:");
        getContentPane().add(jLabelTipo);
        jLabelTipo.setBounds(120, 190, 50, 16);

        jLabelVentaPor.setText("Venta por:");
        getContentPane().add(jLabelVentaPor);
        jLabelVentaPor.setBounds(120, 240, 80, 16);

        jButtonP_Mayor.setText(">");
        jButtonP_Mayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP_MayorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonP_Mayor);
        jButtonP_Mayor.setBounds(130, 330, 70, 50);

        jButtonP_Menor.setText("<");
        jButtonP_Menor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonP_MenorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonP_Menor);
        jButtonP_Menor.setBounds(40, 330, 70, 50);

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombre);
        jTextFieldNombre.setBounds(240, 90, 150, 22);
        getContentPane().add(jTextFieldDescripcion);
        jTextFieldDescripcion.setBounds(240, 140, 260, 22);

        jComboBoxTipo.setModel(new DefaultComboBoxModel<>(sistema.getListaProducto().stream().map(Producto::getTipo).distinct().toArray(String[]::new)));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipo);
        jComboBoxTipo.setBounds(240, 190, 170, 22);

        jComboBoxVentaPor.setModel(new DefaultComboBoxModel<>(sistema.getListaProducto().stream().map(Producto::getFormaVenta).distinct().toArray(String[]::new)));
        jComboBoxVentaPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVentaPorActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxVentaPor);
        jComboBoxVentaPor.setBounds(240, 240, 170, 22);

        jLabelInfoProducto.setText("Información del producto:");
        getContentPane().add(jLabelInfoProducto);
        jLabelInfoProducto.setBounds(650, 70, 150, 16);

        jLabelTotalVendido.setText("Total $ vendido entre todos los puestos:");
        getContentPane().add(jLabelTotalVendido);
        jLabelTotalVendido.setBounds(650, 100, 320, 16);

        jLabelTotalComprado.setText("Total $ comprado por todos los puestos:");
        getContentPane().add(jLabelTotalComprado);
        jLabelTotalComprado.setBounds(650, 130, 320, 16);

        jLabelCantTotalV.setText("Cantidad total vendida entre todos los puestos (unidad/kilo):");
        getContentPane().add(jLabelCantTotalV);
        jLabelCantTotalV.setBounds(650, 160, 530, 16);

        jLabelCantTotalC.setText("Cantidad total comprada entre todos los puestos (unidad/kilo):");
        getContentPane().add(jLabelCantTotalC);
        jLabelCantTotalC.setBounds(650, 190, 530, 16);

        jLabelPrecioMinVendido.setText("Precio mínimo vendido:");
        getContentPane().add(jLabelPrecioMinVendido);
        jLabelPrecioMinVendido.setBounds(650, 220, 260, 16);

        jLabelPuestosPrecioVenMin.setText("Puestos con el precio de venta mínimo:");
        jLabelPuestosPrecioVenMin.setPreferredSize(new java.awt.Dimension(230, 16));
        getContentPane().add(jLabelPuestosPrecioVenMin);
        jLabelPuestosPrecioVenMin.setBounds(650, 250, 260, 16);

        jLabelPuestosPrecioVenMax.setText("Puestos con el precio de venta máximo:");
        getContentPane().add(jLabelPuestosPrecioVenMax);
        jLabelPuestosPrecioVenMax.setBounds(910, 250, 300, 16);

        jLabelPrecioMaxVendido.setText("Precio máximo vendido:");
        getContentPane().add(jLabelPrecioMaxVendido);
        jLabelPrecioMaxVendido.setBounds(910, 220, 290, 16);

        jScrollPaneMinimo.setViewportView(jListMinimo);

        getContentPane().add(jScrollPaneMinimo);
        jScrollPaneMinimo.setBounds(650, 280, 190, 130);

        jScrollPaneMaximo.setViewportView(jListMaximo);

        getContentPane().add(jScrollPaneMaximo);
        jScrollPaneMaximo.setBounds(910, 280, 210, 130);
        getContentPane().add(jLabelImagen);
        jLabelImagen.setBounds(10, 10, 100, 90);

        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre);
        jLabelNombre.setBounds(120, 90, 70, 16);

        setBounds(0, 0, 1231, 448);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonP_MayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP_MayorActionPerformed
        IndexActual++;
        if (IndexActual >= nombresProductos.size()) {
            IndexActual = 0;
        }
        actualizarInfoProducto(nombresProductos.get(IndexActual));
    }//GEN-LAST:event_jButtonP_MayorActionPerformed

    private void jButtonP_MenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonP_MenorActionPerformed
        IndexActual--;
        if (IndexActual < 0) {
            IndexActual = nombresProductos.size() - 1;
        }
        actualizarInfoProducto(nombresProductos.get(IndexActual));
    }//GEN-LAST:event_jButtonP_MenorActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed

    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jComboBoxVentaPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVentaPorActionPerformed

    }//GEN-LAST:event_jComboBoxVentaPorActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Sistema sistema = new Sistema();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConsultaProducto(sistema).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonP_Mayor;
    private javax.swing.JButton jButtonP_Menor;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JComboBox<String> jComboBoxVentaPor;
    private javax.swing.JLabel jLabelCantTotalC;
    private javax.swing.JLabel jLabelCantTotalV;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelInfoProducto;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecioMaxVendido;
    private javax.swing.JLabel jLabelPrecioMinVendido;
    private javax.swing.JLabel jLabelPuestosPrecioVenMax;
    private javax.swing.JLabel jLabelPuestosPrecioVenMin;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelTotalComprado;
    private javax.swing.JLabel jLabelTotalVendido;
    private javax.swing.JLabel jLabelVentaPor;
    private javax.swing.JList<String> jListMaximo;
    private javax.swing.JList<String> jListMinimo;
    private javax.swing.JScrollPane jScrollPaneMaximo;
    private javax.swing.JScrollPane jScrollPaneMinimo;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
