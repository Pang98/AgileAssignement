/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderpickup.delivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ViewOrder extends javax.swing.JFrame {

    /**
     * Creates new form ViewOrder
     */
    private final String SQL_SELECT = "select orderid, customer, ordertime,orderType,pickuptime,status from Orders WHERE MONTH (ordertime)=? AND YEAR (ordertime)=?";

    private Connection con;
    private PreparedStatement pStmt_Update, pStmt_Select;
    Object[] columns = new Object[]{"order id", "customer", "Order time", "order type", "pickup time", "status"};

    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    private String sname, otype, odate, pdate, status;
    private int orderid, month, year;

    public ViewOrder() {
        initComponents();
        jComboBox1.addActionListener(new comboListenerClass());
        jComboBox2.addActionListener(new combo2ListenerClass());

        if (jComboBox1.getSelectedIndex() == 1) {
            month = 1;
        } else if (jComboBox1.getSelectedIndex() == 2) {
            month = 2;
        } else if (jComboBox1.getSelectedIndex() == 3) {
            month = 3;
        } else if (jComboBox1.getSelectedIndex() == 4) {
            month = 4;
        } else if (jComboBox1.getSelectedIndex() == 5) {
            month = 5;
        } else if (jComboBox1.getSelectedIndex() == 6) {
            month = 6;
        } else if (jComboBox1.getSelectedIndex() == 7) {
            month = 7;
        } else if (jComboBox1.getSelectedIndex() == 8) {
            month = 8;
        } else if (jComboBox1.getSelectedIndex() == 9) {
            month = 9;
        } else if (jComboBox1.getSelectedIndex() == 10) {
            month = 10;
        } else if (jComboBox1.getSelectedIndex() == 11) {
            month = 11;
        } else if (jComboBox1.getSelectedIndex() == 12) {
            month = 12;
        }

        if (jComboBox2.getSelectedIndex() == 0) {
            year = 2017;
        } else if (jComboBox2.getSelectedIndex() == 1) {
            year = 2018;
        } else if (jComboBox2.getSelectedIndex() == 2) {
            year = 2019;
        } else if (jComboBox2.getSelectedIndex() == 3) {
            year = 2020;
        } else if (jComboBox2.getSelectedIndex() == 4) {
            year = 2021;
        } else if (jComboBox2.getSelectedIndex() == 5) {
            year = 2022;
        } else if (jComboBox2.getSelectedIndex() == 6) {
            year = 2023;
        }

        ResultSet rs = null;

        try {

            initDbConnection();
            initPrepareStatement();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        Object[] columns = new Object[]{orderid, sname, otype, odate, pdate, status};
        try {
            pStmt_Select.setInt(1, month);
            pStmt_Select.setInt(2,year);
            rs = pStmt_Select.executeQuery();

            while (rs.next()) {

                Object[] objects = new Object[6];
                for (int i = 0; i < 6; i++) {
                    objects[i] = rs.getObject(i + 1);
                }
                tableModel.addRow(objects);

//                tableModel.addRow(columns);
            }
            jTable1.removeAll();
            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.setTitle("Orders for the month");
        this.setLocationRelativeTo(null);

    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

    private void initDbConnection() throws SQLException {

        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FlowerShopDB", "nbuser", "nbuser");
    }

    private void initPrepareStatement() throws SQLException {
        pStmt_Select = con.prepareStatement(SQL_SELECT);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Name", "Order Date", "Order Type", "Pickup Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021", "2022" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:

    }                                          

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {                                          
        // TODO add your handling code here:


    }                                         

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
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrder().setVisible(true);
            }
        });
    }
    
    private class combo2ListenerClass implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (jComboBox1.getSelectedIndex() == 0) {
                month = 1;
            } else if (jComboBox1.getSelectedIndex() == 1) {
                month = 2;
            } else if (jComboBox1.getSelectedIndex() == 2) {
                month = 3;
            } else if (jComboBox1.getSelectedIndex() == 3) {
                month = 4;
            } else if (jComboBox1.getSelectedIndex() == 4) {
                month = 5;
            } else if (jComboBox1.getSelectedIndex() == 5) {
                month = 6;
            } else if (jComboBox1.getSelectedIndex() == 6) {
                month = 7;
            } else if (jComboBox1.getSelectedIndex() == 7) {
                month = 8;
            } else if (jComboBox1.getSelectedIndex() == 8) {
                month = 9;
            } else if (jComboBox1.getSelectedIndex() == 9) {
                month = 10;
            } else if (jComboBox1.getSelectedIndex() == 10) {
                month = 11;
            } else if (jComboBox1.getSelectedIndex() == 11) {
                month = 12;
            }
            
            if (jComboBox2.getSelectedIndex() == 0) {
            year = 2017;
        } else if (jComboBox2.getSelectedIndex() == 1) {
            year = 2018;
        } else if (jComboBox2.getSelectedIndex() == 2) {
            year = 2019;
        } else if (jComboBox2.getSelectedIndex() == 3) {
            year = 2020;
        } else if (jComboBox2.getSelectedIndex() == 4) {
            year = 2021;
        } else if (jComboBox2.getSelectedIndex() == 5) {
            year = 2022;
        } else if (jComboBox2.getSelectedIndex() == 6) {
            year = 2023;
        }

            ResultSet rs = null;

            try {

                initDbConnection();
                initPrepareStatement();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            Object[] columns = new Object[]{orderid, sname, otype, odate, pdate, status};
            tableModel.setRowCount(0);
            try {
                pStmt_Select.setInt(1, month);
                pStmt_Select.setInt(2, year);
                rs = pStmt_Select.executeQuery();

                while (rs.next()) {

                    Object[] objects = new Object[6];
                    for (int i = 0; i < 6; i++) {
                        objects[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(objects);

                }

                jTable1.setModel(tableModel);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }

    private class comboListenerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jComboBox1.getSelectedIndex() == 0) {
                month = 1;
            } else if (jComboBox1.getSelectedIndex() == 1) {
                month = 2;
            } else if (jComboBox1.getSelectedIndex() == 2) {
                month = 3;
            } else if (jComboBox1.getSelectedIndex() == 3) {
                month = 4;
            } else if (jComboBox1.getSelectedIndex() == 4) {
                month = 5;
            } else if (jComboBox1.getSelectedIndex() == 5) {
                month = 6;
            } else if (jComboBox1.getSelectedIndex() == 6) {
                month = 7;
            } else if (jComboBox1.getSelectedIndex() == 7) {
                month = 8;
            } else if (jComboBox1.getSelectedIndex() == 8) {
                month = 9;
            } else if (jComboBox1.getSelectedIndex() == 9) {
                month = 10;
            } else if (jComboBox1.getSelectedIndex() == 10) {
                month = 11;
            } else if (jComboBox1.getSelectedIndex() == 11) {
                month = 12;
            }
            
            if (jComboBox2.getSelectedIndex() == 0) {
            year = 2017;
        } else if (jComboBox2.getSelectedIndex() == 1) {
            year = 2018;
        } else if (jComboBox2.getSelectedIndex() == 2) {
            year = 2019;
        } else if (jComboBox2.getSelectedIndex() == 3) {
            year = 2020;
        } else if (jComboBox2.getSelectedIndex() == 4) {
            year = 2021;
        } else if (jComboBox2.getSelectedIndex() == 5) {
            year = 2022;
        } else if (jComboBox2.getSelectedIndex() == 6) {
            year = 2023;
        }

            ResultSet rs = null;

            try {

                initDbConnection();
                initPrepareStatement();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            Object[] columns = new Object[]{orderid, sname, otype, odate, pdate, status};
            tableModel.setRowCount(0);
            try {
                pStmt_Select.setInt(1, month);
                pStmt_Select.setInt(2, year);
                rs = pStmt_Select.executeQuery();

                while (rs.next()) {

                    Object[] objects = new Object[6];
                    for (int i = 0; i < 6; i++) {
                        objects[i] = rs.getObject(i + 1);
                    }
                    tableModel.addRow(objects);

                }

                jTable1.setModel(tableModel);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

    }
    
    
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
