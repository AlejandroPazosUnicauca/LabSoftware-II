package co.edu.unicauca.layersmvc.presentation;

import co.edu.unicauca.layersmvc.domain.Product;
import co.edu.unicauca.layersmvc.infra.Observer;
import co.edu.unicauca.layersmvc.domain.service.ServiceModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Es un observador
 *
 * @author ahurtado
 */
public class GUIListProductViewController extends javax.swing.JFrame implements Observer {

    ServiceModel service;
    JTable table;
    DefaultTableModel model;

    /**
     * Creates new form GUIListadoProductos
     *
     * @param service servicio
     */
    public GUIListProductViewController(ServiceModel service) {
        initComponents();
        this.service = service;
        this.model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        table = new JTable(model);
        jPanel2.add(new JScrollPane(table));
        setSize(500, 200);
        setLocation(10,50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Listado de Productos");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int index = table.getSelectedRow();
        service.listProducts().get(index);
        new GUIEditProductViewController(service, service.listProducts().get(index)).setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = table.getSelectedRow();
        service.deleteProduct(service.listProducts().get(index).getProductId());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object o) {
        this.setVisible(true);
        model.setRowCount(0);
        for (Product p : service.listProducts()) {
            model.addRow(new Object[]{"" + p.getProductId(), p.getName(), p.getPrice()});
        }
        table.paintImmediately(table.getBounds());
    }
}
