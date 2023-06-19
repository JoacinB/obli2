   
package Interfaz;

import Dominio.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaVenta extends javax.swing.JFrame {
 
    JButton [][] Botones = new JButton[11][2];
    public int fila = 0;
    public int col = 0;
    public Producto prod;
    public Puesto puestoSelec;
    DefaultComboBoxModel mod = new DefaultComboBoxModel();

    public VentanaVenta(Sistema sistema) {
        initComponents();
        modelo = sistema;
        cargarCombo();
        panelBotones.setVisible(true);
        panelBotones.setPreferredSize(new Dimension(453, 671));
        botones();
    }
    
    public void cargarCombo(){
        for(Puesto obj : modelo.getListaPuesto()){
            ComboPuesto.addItem(obj);
            mod.addElement(obj);
        }
        ComboPuesto.setModel(mod);
    }
    
    
    public void botones(){
        panelBotones.setLayout(new GridLayout(11,2));
        puestoSelec = (Puesto) ComboPuesto.getSelectedItem();
         
        int pos = 0;
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
                    Botones[i][j].setSize(90, 60);
                    Botones[i][j].addActionListener(new ProcesoProducto());
                    panelBotones.add(nuevo);
                    Botones[i][j].addMouseListener(new ProcesoProducto());

                    pos++;
                }
                else{
                    Botones[i][j] = nuevo;
                    Botones[i][j].setSize(90, 60);
                    panelBotones.add(nuevo);
                }
                
                Botones[i][j] = nuevo;
                Botones[i][j].setSize(90, 60);
                panelBotones.add(nuevo);
            }
                                
        }
        
        panelBotones.setVisible(true);
    }
    
    
    private class ProcesoProducto implements ActionListener,MouseListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //obtengo boton seleccionado
            JButton cual = ((JButton)e.getSource());
            Icon im = cual.getIcon();
            for(int i = 0; i<11;i++){
                for(int j = 0;j<2;j++){
                    if(cual == Botones[i][j]){
                        fila = i;
                        col = j;
                    }
                }
            }
            //imagen de la posicion del producto
            Icon imagen = Botones[fila][col].getIcon();
            JOptionPane.showMessageDialog(null, imagen);
             
            int cantidad = pedirNum("Ingrese cantidad a comprar: ");
            int precio = pedirNum("Ingrese precio unitario: ");

            if(modelo.hayStock(imagen, cantidad)){
                VentaProducto vp = new VentaProducto(puestoSelec,prod,cantidad,precio);
                JOptionPane.showMessageDialog(null, vp);
            }
            else{
                JOptionPane.showMessageDialog(null,"No hay venta parcial","Error",JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }
        
        
        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }
        
        
        //Mostrar nombre del producto
        @Override
        public void mouseEntered(MouseEvent e) {
            int pos = 0;
            for(int i = 0; i<11;i++){
                for(int j = 0;j<2;j++){
                     if(pos != modelo.productoPuesto(puestoSelec).size()){
                        prod = modelo.productoPuesto(puestoSelec).get(pos);
                        Botones[i][j].setToolTipText(prod.getNombre());
                        pos++;
                     }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    }
    
    public int pedirNum(String mensaje){
        int dato = 0;
        boolean seguir = false;
        while(!seguir){
            try{
                dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                if(Character.isLetter(dato)) {
                    JOptionPane.showMessageDialog(this,"Ingrese solo números","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    seguir = true;
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this,"Ingrese solo números","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        return dato;
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
        btnElegir = new javax.swing.JButton();

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

        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

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
                        .addContainerGap(182, Short.MAX_VALUE)
                        .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnElegir)
                        .addGap(105, 105, 105))))
        );

        setBounds(0, 0, 893, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPuestoActionPerformed
        
    }//GEN-LAST:event_ComboPuestoActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        puestoSelec = (Puesto) ComboPuesto.getSelectedItem();
        if(mod.getSelectedItem().equals(puestoSelec)){
            puestoSelec = (Puesto) mod.getSelectedItem();
        }
    }//GEN-LAST:event_btnElegirActionPerformed

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
    private javax.swing.JButton btnElegir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JPanel panelBotones;
    // End of variables declaration//GEN-END:variables
}
