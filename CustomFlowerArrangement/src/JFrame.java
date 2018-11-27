
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class JFrame extends javax.swing.JFrame {

    private final String SQL_INSERT = "INSERT INTO CUSTOM VALUES (?,?,?,?,?,?,?)";
    private ButtonGroup BGCustomStyle = new ButtonGroup();
    private ButtonGroup BGCustomSize = new ButtonGroup();
    private ButtonGroup BGCustomFlower = new ButtonGroup();
    private ButtonGroup BGCustomAccer = new ButtonGroup();
    private ButtonGroup BGCustomPickup = new ButtonGroup();
    
    private String[] CustomStyle = {"Traditional", "Modern", "Bouquets"};
    private String[] CustomSize = {"Small", "Medium", "Big"};
    private String[] CustomFlower = {"Rose", "SunFlower", "Daisy"};
    private String[] CustomAccer = {"Ribbon", "Teddy", "Balloon"};
    private String[] CustomPickup = {"Express", "Standard", "Flexi"};
    
    private JButton btnConfirm = new JButton("Confirm");
    private JButton btnReset = new JButton("Reset");
    
    private Connection con;
    private PreparedStatement pStmt_Insert;  
    
    ResultSet rs;    
    
    public JFrame() {
        initComponents();
        try {
            initDbConnection();
            initPrepareStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        traditionalRad = new javax.swing.JRadioButton();
        modernRad = new javax.swing.JRadioButton();
        bouquetsRad = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        smallRad = new javax.swing.JRadioButton();
        mediumRad = new javax.swing.JRadioButton();
        bigRad = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        roseRad = new javax.swing.JRadioButton();
        sunflowerRad = new javax.swing.JRadioButton();
        daisyRad = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ribbonRad = new javax.swing.JRadioButton();
        teddyRad = new javax.swing.JRadioButton();
        balloonRad = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        expressChk = new javax.swing.JCheckBox();
        standardChk = new javax.swing.JCheckBox();
        flexiChk = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        jlabel8 = new javax.swing.JLabel();
        jlabel9 = new javax.swing.JLabel();
        totalflowerpriceTF = new javax.swing.JTextField();
        deliveryfeeTF = new javax.swing.JTextField();
        totalpriceTF = new javax.swing.JTextField();
        calculateBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        paymentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Fiore Flowershop");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        traditionalRad.setText("Traditional RM 10.00");
        traditionalRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traditionalRadActionPerformed(evt);
            }
        });

        modernRad.setText("Modern RM 15.00");
        modernRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modernRadActionPerformed(evt);
            }
        });

        bouquetsRad.setText("Bouquets RM20.00");
        bouquetsRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouquetsRadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel2.setText("Step 1 Select Flower Arrangement Style");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(traditionalRad)
                    .addComponent(modernRad)
                    .addComponent(bouquetsRad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(traditionalRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modernRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bouquetsRad)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        smallRad.setText("Small RM10.00");
        smallRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallRadActionPerformed(evt);
            }
        });

        mediumRad.setText("Medium RM15.00");
        mediumRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumRadActionPerformed(evt);
            }
        });

        bigRad.setText("Big RM20.00");
        bigRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bigRadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Step 2 Select Flower Arrangement Size");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(smallRad)
                    .addComponent(mediumRad)
                    .addComponent(bigRad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(smallRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mediumRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bigRad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        roseRad.setText("Rose RM30.00");
        roseRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roseRadActionPerformed(evt);
            }
        });

        sunflowerRad.setText("Sunflower RM25.00");
        sunflowerRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunflowerRadActionPerformed(evt);
            }
        });

        daisyRad.setText("Daisy RM20.00");
        daisyRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daisyRadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel4.setText("Step 3 Select Flowers");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roseRad)
                    .addComponent(sunflowerRad)
                    .addComponent(daisyRad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roseRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sunflowerRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(daisyRad)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ribbonRad.setText("Ribbon RM5.00");
        ribbonRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ribbonRadActionPerformed(evt);
            }
        });

        teddyRad.setText("Teddy RM15.00");
        teddyRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teddyRadActionPerformed(evt);
            }
        });

        balloonRad.setText("Balloon RM6.00");
        balloonRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balloonRadActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel5.setText("Step 4 Select Accessories");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ribbonRad)
                    .addComponent(teddyRad)
                    .addComponent(balloonRad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ribbonRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(teddyRad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(balloonRad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        expressChk.setText("Express delivery (within 60 minutes) RM10.50");
        expressChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expressChkActionPerformed(evt);
            }
        });

        standardChk.setText("Standard delivery (within 2-3days)   RM5.50");
        standardChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardChkActionPerformed(evt);
            }
        });

        flexiChk.setText("Flexi delivery (within 5 days)           RM2.50");
        flexiChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flexiChkActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setText("Select pick-up priority");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(flexiChk)
                            .addComponent(standardChk)
                            .addComponent(expressChk)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(16, 16, 16)
                .addComponent(expressChk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(standardChk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(flexiChk)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jlabel7.setText("Total Flower Price");

        jlabel8.setText("Delivery Fee");

        jlabel9.setText("Total Price");

        totalflowerpriceTF.setEditable(false);
        totalflowerpriceTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalflowerpriceTFActionPerformed(evt);
            }
        });

        deliveryfeeTF.setEditable(false);

        totalpriceTF.setEditable(false);
        totalpriceTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalpriceTFActionPerformed(evt);
            }
        });

        calculateBtn.setText("Calculate");
        calculateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateBtnActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        paymentBtn.setText("Payment");
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jlabel8)
                                                    .addComponent(jlabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(deliveryfeeTF, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                                    .addComponent(totalpriceTF)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalflowerpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(calculateBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(resetBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(paymentBtn))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel7)
                            .addComponent(totalflowerpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel8)
                            .addComponent(deliveryfeeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel9)
                            .addComponent(totalpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calculateBtn)
                            .addComponent(resetBtn)
                            .addComponent(paymentBtn))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void traditionalRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traditionalRadActionPerformed
        if (traditionalRad.isSelected())
        bouquetsRad.setSelected(false);
        modernRad.setSelected(false);
    }//GEN-LAST:event_traditionalRadActionPerformed

    private void modernRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modernRadActionPerformed
        if (modernRad.isSelected())
        bouquetsRad.setSelected(false);
        traditionalRad.setSelected(false);
    }//GEN-LAST:event_modernRadActionPerformed

    private void bouquetsRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouquetsRadActionPerformed
        if (bouquetsRad.isSelected())
        modernRad.setSelected(false);
        traditionalRad.setSelected(false);
    }//GEN-LAST:event_bouquetsRadActionPerformed

    private void smallRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallRadActionPerformed
        if (smallRad.isSelected())
        mediumRad.setSelected(false);
        bigRad.setSelected(false);
    }//GEN-LAST:event_smallRadActionPerformed

    private void mediumRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumRadActionPerformed
        if (mediumRad.isSelected())
        smallRad.setSelected(false);
        bigRad.setSelected(false);
    }//GEN-LAST:event_mediumRadActionPerformed

    private void bigRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bigRadActionPerformed
        if (bigRad.isSelected())
        smallRad.setSelected(false);
        mediumRad.setSelected(false);
    }//GEN-LAST:event_bigRadActionPerformed

    private void roseRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roseRadActionPerformed
        if (roseRad.isSelected())
        sunflowerRad.setSelected(false);
        daisyRad.setSelected(false);
    }//GEN-LAST:event_roseRadActionPerformed

    private void sunflowerRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunflowerRadActionPerformed
        if (sunflowerRad.isSelected())
        daisyRad.setSelected(false);
        roseRad.setSelected(false);
    }//GEN-LAST:event_sunflowerRadActionPerformed

    private void daisyRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daisyRadActionPerformed
        if (daisyRad.isSelected())
        roseRad.setSelected(false);
        sunflowerRad.setSelected(false);
    }//GEN-LAST:event_daisyRadActionPerformed

    private void ribbonRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ribbonRadActionPerformed
        if (ribbonRad.isSelected())
        teddyRad.setSelected(false);
        balloonRad.setSelected(false);
    }//GEN-LAST:event_ribbonRadActionPerformed

    private void teddyRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teddyRadActionPerformed
        if (teddyRad.isSelected())
        ribbonRad.setSelected(false);
        balloonRad.setSelected(false);
    }//GEN-LAST:event_teddyRadActionPerformed

    private void balloonRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balloonRadActionPerformed
        if (balloonRad.isSelected())
        ribbonRad.setSelected(false);
        teddyRad.setSelected(false);
    }//GEN-LAST:event_balloonRadActionPerformed

    private void standardChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardChkActionPerformed
        if (standardChk.isSelected())
        flexiChk.setSelected(false);
        expressChk.setSelected(false);
    }//GEN-LAST:event_standardChkActionPerformed

    private void flexiChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flexiChkActionPerformed
        if (flexiChk.isSelected())
        standardChk.setSelected(false);
        expressChk.setSelected(false);
    }//GEN-LAST:event_flexiChkActionPerformed

    private void expressChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expressChkActionPerformed
        if (expressChk.isSelected())
        standardChk.setSelected(false);
        flexiChk.setSelected(false);
    }//GEN-LAST:event_expressChkActionPerformed

    private void totalflowerpriceTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalflowerpriceTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalflowerpriceTFActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        traditionalRad.setSelected(false);
        modernRad.setSelected(false);
        bouquetsRad.setSelected(false);
     
        smallRad.setSelected(false);
        mediumRad.setSelected(false);
        bigRad.setSelected(false);

        roseRad.setSelected(false);
        sunflowerRad.setSelected(false);
        daisyRad.setSelected(false);
        
        teddyRad.setSelected(false);
        ribbonRad.setSelected(false);
        balloonRad.setSelected(false);
        
        standardChk.setSelected(false);
        expressChk.setSelected(false);
        flexiChk.setSelected(false);

        totalflowerpriceTF.setText("");
        deliveryfeeTF.setText("");
        totalpriceTF.setText("");
    }//GEN-LAST:event_resetBtnActionPerformed

    private void totalpriceTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalpriceTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalpriceTFActionPerformed

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void calculateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateBtnActionPerformed
        double total;
        double subtotal = 0;
        double express = 10.50;
        double standard = 5.50;
        double flexi = 2.50;
        double blank = 0.00;
        //double deliveryfee;

        
        if(traditionalRad.isSelected()){
            subtotal = subtotal + 10.00;
        }else if (modernRad.isSelected()){
            subtotal = subtotal + 15.00;
        }else if (bouquetsRad.isSelected()){
            subtotal = subtotal + 20.00;
        }

        if(smallRad.isSelected()){
            subtotal = subtotal + 10.00;
        }else if (mediumRad.isSelected()){
            subtotal = subtotal + 15.00;
        }else if (bigRad.isSelected()){
            subtotal = subtotal + 20.00;
        } 
        
        if(roseRad.isSelected()){
            subtotal = subtotal + 30.00;
        }else if (sunflowerRad.isSelected()){
            subtotal = subtotal + 25.00;
        }else if (daisyRad.isSelected()){
            subtotal = subtotal + 20.00;
        } 
        
        if(ribbonRad.isSelected()){
            subtotal = subtotal + 5.00;
        }else if (teddyRad.isSelected()){
            subtotal = subtotal + 15.00;
        }else if (balloonRad.isSelected()){
            subtotal = subtotal + 6.00;
        }
        
        
        if(expressChk.isSelected()){
            deliveryfeeTF.setText(Double.toString(express));
            totalflowerpriceTF.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(totalflowerpriceTF.getText());
            total = subtotal + 10.50;
            totalpriceTF.setText(Double.toString(total));
        }
        else if(standardChk.isSelected()){
            deliveryfeeTF.setText(Double.toString(standard));
            totalflowerpriceTF.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(totalflowerpriceTF.getText());
            total = subtotal + 5.50;
            totalpriceTF.setText(Double.toString(total));
            
        }
        else if(flexiChk.isSelected()){  
            deliveryfeeTF.setText(Double.toString(flexi));
            totalflowerpriceTF.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(totalflowerpriceTF.getText());
            total = subtotal + 2.50;
            totalpriceTF.setText(Double.toString(total));
        }
        else{
            deliveryfeeTF.setText(Double.toString(blank));
            totalflowerpriceTF.setText(Double.toString(subtotal));
            subtotal = Double.parseDouble(totalflowerpriceTF.getText());
            total = subtotal + 0.0;
            totalpriceTF.setText(Double.toString(total));            
        }
        
    }//GEN-LAST:event_calculateBtnActionPerformed
    
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton balloonRad;
    private javax.swing.JRadioButton bigRad;
    private javax.swing.JRadioButton bouquetsRad;
    private javax.swing.JButton calculateBtn;
    private javax.swing.JRadioButton daisyRad;
    private javax.swing.JTextField deliveryfeeTF;
    private javax.swing.JCheckBox expressChk;
    private javax.swing.JCheckBox flexiChk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel jlabel9;
    private javax.swing.JRadioButton mediumRad;
    private javax.swing.JRadioButton modernRad;
    private javax.swing.JButton paymentBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JRadioButton ribbonRad;
    private javax.swing.JRadioButton roseRad;
    private javax.swing.JRadioButton smallRad;
    private javax.swing.JCheckBox standardChk;
    private javax.swing.JRadioButton sunflowerRad;
    private javax.swing.JRadioButton teddyRad;
    private javax.swing.JTextField totalflowerpriceTF;
    private javax.swing.JTextField totalpriceTF;
    private javax.swing.JRadioButton traditionalRad;
    // End of variables declaration//GEN-END:variables

    private void initDbConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/FlowerShopDB", "nbuser", "nbuser");
    }

    private void initPrepareStatement() throws SQLException {
        pStmt_Insert = con.prepareStatement(SQL_INSERT);       
        
    }


}
