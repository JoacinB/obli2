   
package Interfaz;

import Dominio.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaVenta extends javax.swing.JFrame implements Observer{
 
    JButton [][] Botones = new JButton[11][2];
    public int fila = 0;
    public int col = 0;
    private Producto prod;
    public Puesto puestoSelec;
   

    public VentanaVenta(Sistema sistema) {
        initComponents();
        modelo = sistema;
        cargarCombo();
        panelBotones.setVisible(true);
        panelBotones.setPreferredSize(new Dimension(453, 671));
        botones();
        update(null,null);
    }
    
    public void cargarCombo(){
        for(Puesto obj : modelo.getListaPuesto()){
            ComboPuesto.addItem(obj);
        }
        ComboPuesto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                botones();
            }
        });
    }
    
    
    public void botones(){
        panelBotones.setLayout(new GridLayout(11,2));
        //puesto seleccionado
        puestoSelec = (Puesto) ComboPuesto.getSelectedItem();
        int pos = 0;
        
        //limpiar grilla
        panelBotones.removeAll();
        
        for(int i = 0;i<11;i++){
            for(int j=0 ;j<2;j++){
                JButton nuevo = new JButton("");
                
                if(pos != modelo.productoPuesto(puestoSelec).size()){
                    //Si hay stock de este producto entonces agregalo al boton
                    prod = modelo.productoPuesto(puestoSelec).get(pos);

                    Image imagenProducto = prod.getImage();
                    Image scaledImage = imagenProducto.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(scaledImage);
                    //Se agrega la imagen al boton
                    nuevo.setIcon(imageIcon);
                    Botones[i][j] = nuevo;
                    Botones[i][j].setName(prod.getNombre());
                    Botones[i][j].setSize(90, 60);
                    
                    //evento al seleccionar un boton
                    Botones[i][j].addActionListener(new ProcesoProducto());
                    panelBotones.add(nuevo);
                    final String nom = prod.getNombre();
                    nuevo.addMouseListener(new MouseAdapter(){
                        
                        @Override
                        public void mouseEntered(MouseEvent e){
                            //Mostrar nombre del producto
                            nuevo.setToolTipText(nom);
                        }
                    });
                    pos++;
                }
                else{
                    //si no hay ningun producto en el puesto seleccionado
                    Botones[i][j] = nuevo;
                    Botones[i][j].setSize(90, 60);
                    panelBotones.add(nuevo);
                }
                //Si no se selecciono ningun puesto 
                Botones[i][j] = nuevo;
                Botones[i][j].setSize(90, 60);
                panelBotones.add(nuevo);
            }
        }
        revalidate();
        repaint();
        //panelBotones.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
         
    }

    
    private class ProcesoProducto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //obtengo boton seleccionado
            JButton cual = ((JButton)e.getSource());
            //Obtengo que producto fue seleccionado
            String s = cual.getName();
            
            Producto nombreProd = modelo.obtenerNombreProd(s);
            
            
            //Mensaje de cantidad y precio a ingresar 
            String cantidadIng = JOptionPane.showInputDialog(VentanaVenta.this,"Ingrese cantidad a comprar:  ",JOptionPane.PLAIN_MESSAGE);
            String precioIng = JOptionPane.showInputDialog(VentanaVenta.this,"Ingrese precio unitario:  ",JOptionPane.PLAIN_MESSAGE);
            
            int cantidad = 0;
            int precio = 0;
            
            //validar ingreso de datos
            try{
                //Validar ingresar solo número
                cantidad = Integer.parseInt(cantidadIng);
                precio = Integer.parseInt(precioIng);
                if(Character.isLetter(cantidad) && Character.isLetter(precio)) {
                    JOptionPane.showMessageDialog(VentanaVenta.this,"Ingrese solo números","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(s != null){
                    //Validar stock del producto
                         if(modelo.hayStock(s, cantidad)){
                             modelo.decrementar(s, cantidad);

                            VentaProducto vp = new VentaProducto(puestoSelec,nombreProd,cantidad,precio);
                            modelo.agregarVenta(vp);
                            JOptionPane.showMessageDialog(null, vp);
                            int mov = modelo.incrementarVenta();
                            JOptionPane.showMessageDialog(VentanaVenta.this,"Cantidad de movimientos: " + mov,"Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No hay venta parcial","Error",JOptionPane.ERROR_MESSAGE);
                         }
                    }
                }
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(VentanaVenta.this,"Ingrese solo números","Error",JOptionPane.ERROR_MESSAGE);
            }
            
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

        jPanel1 = new javax.swing.JPanel();
        ComboPuesto = new javax.swing.JComboBox<>();
        lblPuesto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelBotones = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ComboPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPuestoActionPerformed(evt);
            }
        });

        lblPuesto.setText("Puestos:");

        panelBotones.setLayout(null);
        jScrollPane1.setViewportView(panelBotones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPuesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setBounds(0, 0, 893, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPuestoActionPerformed
        
    }//GEN-LAST:event_ComboPuestoActionPerformed

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
    private javax.swing.JComboBox<Puesto> ComboPuesto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JPanel panelBotones;
    // End of variables declaration//GEN-END:variables
}
