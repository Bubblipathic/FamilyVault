/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package familyvault;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;

/**
 *
 * @author Jay
 */
public class File_List extends javax.swing.JFrame {
    PreparedStatement p;
    ResultSet r=null;
    Connection con;
    String f_path;
    String f_name;
    String f_cat = Categories.cat;
    int FILEID=1;
    static String previewPath;
    static String previewFNAME;


    /**
     * Creates new form NewJFrame
     */
    public File_List() {
        con=connect.Connect();
        initComponents();
        //Center the frame on the screen
        setLocationRelativeTo(null);
        
        
        jPanel6.setBackground(Categories.catColor);
        jPanel7.setBackground(Categories.catColor);
        jPanel5.setBackground(Categories.catColor);
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(Categories.iconPath)));
        jLabel5.setText(Categories.Title);
        jTITLE.setText(LogIn.inputFNAME.toUpperCase() +" FAMILY");
        
        // Initialize the JPanel objects and add them to the array
        JPanel[] panels = new JPanel[7];
        panels[0] = pFILE1;
        panels[1] = pFILE2;
        panels[2] = pFILE3;
        panels[3] = pFILE4;
        panels[4] = pFILE5;
        panels[5] = pFILE6;
        panels[6] = pFILE7;
        
        JLabel[] labels = new JLabel[7];
        // Initialize the JLabel objects and add them to the array
        labels[0] = lFNAME1;
        labels[1] = lFNAME2;
        labels[2] = lFNAME3;
        labels[3] = lFNAME4;
        labels[4] = lFNAME5;
        labels[5] = lFNAME6;
        labels[6] = lFNAME7;
        
        JLabel[] icons = new JLabel[7];
        // Initialize the JLabel objects and add them to the array
        icons[0] = lICON1;
        icons[1] = lICON2;
        icons[2] = lICON3;
        icons[3] = lICON1;
        icons[4] = lICON5;
        icons[5] = lICON6;
        icons[6] = lICON7;
        
        //Hide Panels
        for (int i =0; i>7; i++){
            panels[i].setVisible(false);
        }
        
        try{
            // Query to find the maximum FILE_IDs value
            p = con.prepareStatement("SELECT COUNT(*) AS FILE_COUNT FROM FAM_FILE WHERE FILE_CATEGORY = ? AND MEM_ID = ? AND CODE = ?");
            p.setString(1, f_cat);
            p.setInt(2, HomeScreen.MEMID);
            p.setInt(3, LogIn.inputCODE);
            r = p.executeQuery();

            int fileCount = 0;
            if (r.next()) {
                fileCount = r.getInt("FILE_COUNT");
            }


            if (fileCount >= 7) {
                // If there are already 7 FILE_IDs, return true
                Add2.setEnabled(false);
            } else{
                Add2.setEnabled(true);
            }
            
            // Initialize a counter to keep track of the current panel
            int panelCounter = 0;

            // Prepare the statement outside the loop
            p = con.prepareStatement("SELECT FILE_NAME FROM FAM_FILE WHERE MEM_ID = ? AND CODE = ? AND FILE_CATEGORY = ?");
            p.setInt(1, HomeScreen.MEMID);
            p.setInt(2, LogIn.inputCODE);
            p.setString(3, f_cat);
            r = p.executeQuery();

            // Iterate over the result set
            while (r.next() && panelCounter < 7) {
                labels[panelCounter].setText(r.getString("FILE_NAME"));
                if (r.getString("FILE_NAME").endsWith(".txt")) {
                    icons[panelCounter].setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/text.png")));
                } else if (r.getString("FILE_NAME").endsWith(".docx")||r.getString("FILE_NAME").endsWith(".pdf")){
                    icons[panelCounter].setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png")));
                } else if (r.getString("FILE_NAME").endsWith(".png")||r.getString("FILE_NAME").endsWith(".jpeg")||r.getString("FILE_NAME").endsWith(".jpg")){
                    icons[panelCounter].setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/image.png")));
                } else{
                    icons[panelCounter].setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png")));
                }
                panels[panelCounter].setVisible(true);
                panelCounter++;
            }

            // Hide any remaining panels if the result set contains fewer than 7 rows
            while (panelCounter < 7) {
                panels[panelCounter].setVisible(false);
                panelCounter++;
            }
            
            // Close the result set and statement
            r.close();
            p.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
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

        jPanel2 = new javax.swing.JPanel();
        jTITLE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        Add2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pFILE1 = new javax.swing.JPanel();
        lICON1 = new javax.swing.JLabel();
        lFNAME1 = new javax.swing.JLabel();
        lDEL1 = new javax.swing.JLabel();
        pFILE2 = new javax.swing.JPanel();
        lICON2 = new javax.swing.JLabel();
        lFNAME2 = new javax.swing.JLabel();
        lDEL2 = new javax.swing.JLabel();
        pFILE3 = new javax.swing.JPanel();
        lICON3 = new javax.swing.JLabel();
        lFNAME3 = new javax.swing.JLabel();
        lDEL3 = new javax.swing.JLabel();
        pFILE4 = new javax.swing.JPanel();
        lICON4 = new javax.swing.JLabel();
        lFNAME4 = new javax.swing.JLabel();
        lDEL4 = new javax.swing.JLabel();
        pFILE5 = new javax.swing.JPanel();
        lICON5 = new javax.swing.JLabel();
        lFNAME5 = new javax.swing.JLabel();
        lDEL5 = new javax.swing.JLabel();
        pFILE6 = new javax.swing.JPanel();
        lICON6 = new javax.swing.JLabel();
        lFNAME6 = new javax.swing.JLabel();
        lDEL6 = new javax.swing.JLabel();
        pFILE7 = new javax.swing.JPanel();
        lICON7 = new javax.swing.JLabel();
        lFNAME7 = new javax.swing.JLabel();
        lDEL7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 231, 222));
        setPreferredSize(new java.awt.Dimension(360, 640));
        setSize(new java.awt.Dimension(360, 640));

        jPanel2.setBackground(new java.awt.Color(219, 48, 82));

        jTITLE.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        jTITLE.setForeground(new java.awt.Color(241, 214, 171));
        jTITLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTITLE.setText("FAMILY VAULT");
        jTITLE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTITLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTITLE, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        Add.setBackground(new java.awt.Color(219, 48, 82));
        Add.setFont(new java.awt.Font("Eras Bold ITC", 1, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(241, 214, 171));
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-logout-32.png"))); // NOI18N
        Add.setPreferredSize(new java.awt.Dimension(50, 50));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel1.add(Add);

        Add2.setBackground(new java.awt.Color(219, 48, 82));
        Add2.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        Add2.setForeground(new java.awt.Color(241, 214, 171));
        Add2.setText("Add");
        Add2.setPreferredSize(new java.awt.Dimension(90, 50));
        Add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add2ActionPerformed(evt);
            }
        });
        jPanel1.add(Add2);

        jPanel3.setPreferredSize(new java.awt.Dimension(15, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(15, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-government-50.png"))); // NOI18N
        jPanel7.add(jLabel1);

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(241, 214, 171));
        jLabel5.setText("Legal");
        jPanel7.add(jLabel5);

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new java.awt.GridLayout(7, 0, 0, 10));

        pFILE1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE1MouseClicked(evt);
            }
        });

        lICON1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON1.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON1.setRequestFocusEnabled(false);

        lFNAME1.setText("jLabel2");

        lDEL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE1Layout = new javax.swing.GroupLayout(pFILE1);
        pFILE1.setLayout(pFILE1Layout);
        pFILE1Layout.setHorizontalGroup(
            pFILE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE1Layout.createSequentialGroup()
                .addComponent(lICON1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE1Layout.setVerticalGroup(
            pFILE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE1);

        pFILE2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE2MouseClicked(evt);
            }
        });

        lICON2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON2.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON2.setRequestFocusEnabled(false);

        lFNAME2.setText("jLabel2");

        lDEL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE2Layout = new javax.swing.GroupLayout(pFILE2);
        pFILE2.setLayout(pFILE2Layout);
        pFILE2Layout.setHorizontalGroup(
            pFILE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE2Layout.createSequentialGroup()
                .addComponent(lICON2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE2Layout.setVerticalGroup(
            pFILE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE2);

        pFILE3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE3MouseClicked(evt);
            }
        });

        lICON3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON3.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON3.setRequestFocusEnabled(false);

        lFNAME3.setText("jLabel2");

        lDEL3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE3Layout = new javax.swing.GroupLayout(pFILE3);
        pFILE3.setLayout(pFILE3Layout);
        pFILE3Layout.setHorizontalGroup(
            pFILE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE3Layout.createSequentialGroup()
                .addComponent(lICON3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE3Layout.setVerticalGroup(
            pFILE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE3);

        pFILE4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE4MouseClicked(evt);
            }
        });

        lICON4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON4.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON4.setRequestFocusEnabled(false);

        lFNAME4.setText("jLabel2");

        lDEL4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE4Layout = new javax.swing.GroupLayout(pFILE4);
        pFILE4.setLayout(pFILE4Layout);
        pFILE4Layout.setHorizontalGroup(
            pFILE4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE4Layout.createSequentialGroup()
                .addComponent(lICON4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE4Layout.setVerticalGroup(
            pFILE4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE4);

        pFILE5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE5MouseClicked(evt);
            }
        });

        lICON5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON5.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON5.setRequestFocusEnabled(false);

        lFNAME5.setText("jLabel2");

        lDEL5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE5Layout = new javax.swing.GroupLayout(pFILE5);
        pFILE5.setLayout(pFILE5Layout);
        pFILE5Layout.setHorizontalGroup(
            pFILE5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE5Layout.createSequentialGroup()
                .addComponent(lICON5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE5Layout.setVerticalGroup(
            pFILE5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE5);

        pFILE6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE6MouseClicked(evt);
            }
        });

        lICON6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON6.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON6.setRequestFocusEnabled(false);

        lFNAME6.setText("jLabel2");

        lDEL6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE6Layout = new javax.swing.GroupLayout(pFILE6);
        pFILE6.setLayout(pFILE6Layout);
        pFILE6Layout.setHorizontalGroup(
            pFILE6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE6Layout.createSequentialGroup()
                .addComponent(lICON6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE6Layout.setVerticalGroup(
            pFILE6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE6);

        pFILE7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pFILE7MouseClicked(evt);
            }
        });

        lICON7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lICON7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/document.png"))); // NOI18N
        lICON7.setPreferredSize(new java.awt.Dimension(15, 10));
        lICON7.setRequestFocusEnabled(false);

        lFNAME7.setText("jLabel2");

        lDEL7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDEL7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/familyvault/icons8-delete-20.png"))); // NOI18N
        lDEL7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lDEL7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFILE7Layout = new javax.swing.GroupLayout(pFILE7);
        pFILE7.setLayout(pFILE7Layout);
        pFILE7Layout.setHorizontalGroup(
            pFILE7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFILE7Layout.createSequentialGroup()
                .addComponent(lICON7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFNAME7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(lDEL7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pFILE7Layout.setVerticalGroup(
            pFILE7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lICON7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pFILE7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lDEL7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lFNAME7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(pFILE7);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        new Categories().setVisible(true); 
        dispose();
    }//GEN-LAST:event_AddActionPerformed

    private void Add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add2ActionPerformed
         // Create a new instance of JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Set the initial directory
        File initialDirectory = new File("C:\\BSCS 3-3\\Applications Development and Emerging Technologies\\Files");
        fileChooser.setCurrentDirectory(initialDirectory);

        // Show open dialog
        int returnValue = fileChooser.showOpenDialog(this);

        // Check if a file was selected
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Perform operations with the selected file
            f_path = selectedFile.getAbsolutePath();
            f_name = selectedFile.getName();

            try{
                p = con.prepareStatement("SELECT FILE_ID FROM FAM_FILE WHERE FILE_CATEGORY = ? AND MEM_ID = ? and CODE = ?");
                p.setString(1, f_cat);
                p.setInt(2, HomeScreen.MEMID); // Set MEM_ID parameter to 1
                p.setInt(3, LogIn.inputCODE);

                r = p.executeQuery();

                Set<Integer> existingIds = new HashSet<>();

                // Collect all existing FILE_ID values into a set
                while (r.next()) {
                    int existingId = r.getInt("FILE_ID");
                    existingIds.add(existingId);
                }

                // Generate a new FILE_ID
                while (existingIds.contains(FILEID)) {
                    // If the newId already exists, increment it until it's unique
                    FILEID++;
                }

                p = con.prepareStatement("INSERT INTO FAM_FILE (CODE,FILE_NAME,FILE_PATH,FILE_CATEGORY,MEM_ID,FILE_ID) VALUES (?,?,?,?,?,?)");
                p.setInt(1, LogIn.inputCODE);
                p.setString(2, f_name);
                p.setString(3, f_path);
                p.setString(4, f_cat);
                p.setInt(5, HomeScreen.MEMID);
                p.setInt(6, FILEID);


                p.executeUpdate();
                JOptionPane.showMessageDialog(null,"File Added");

                // Close the result set and statement
                r.close();
                p.close();
                r = null;

            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Invalid File");
        }

        new File_List().setVisible(true);
        dispose();
    }//GEN-LAST:event_Add2ActionPerformed

    private void lDEL1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL1MouseClicked
        FileDelete(lFNAME1);
    }//GEN-LAST:event_lDEL1MouseClicked

    private void lDEL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL2MouseClicked
        FileDelete(lFNAME2);
    }//GEN-LAST:event_lDEL2MouseClicked

    private void lDEL3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL3MouseClicked
        FileDelete(lFNAME3);
    }//GEN-LAST:event_lDEL3MouseClicked

    private void lDEL4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL4MouseClicked
        FileDelete(lFNAME4);
    }//GEN-LAST:event_lDEL4MouseClicked

    private void lDEL5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL5MouseClicked
        FileDelete(lFNAME5);
    }//GEN-LAST:event_lDEL5MouseClicked

    private void lDEL6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL6MouseClicked
        FileDelete(lFNAME6);
    }//GEN-LAST:event_lDEL6MouseClicked

    private void lDEL7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lDEL7MouseClicked
        FileDelete(lFNAME7);
    }//GEN-LAST:event_lDEL7MouseClicked

    private void pFILE1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE1MouseClicked
        getFilePath(lFNAME1);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE1MouseClicked

    private void pFILE2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE2MouseClicked
        getFilePath(lFNAME2);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE2MouseClicked

    private void pFILE3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE3MouseClicked
        getFilePath(lFNAME3);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE3MouseClicked

    private void pFILE4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE4MouseClicked
        getFilePath(lFNAME4);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE4MouseClicked

    private void pFILE5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE5MouseClicked
        getFilePath(lFNAME5);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE5MouseClicked

    private void pFILE6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE6MouseClicked
        getFilePath(lFNAME6);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE6MouseClicked

    private void pFILE7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pFILE7MouseClicked
        getFilePath(lFNAME7);
        if (previewPath.endsWith(".txt")||previewPath.endsWith(".docx")){
            new Text_Preview().setVisible(true);
        } else{
        new File_Nav().setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_pFILE7MouseClicked

    //Get File Path
    private void getFilePath(JLabel x){
         try{ 
                p = con.prepareStatement("SELECT FILE_PATH FROM FAM_FILE WHERE MEM_ID = ? and CODE = ? AND FILE_NAME = ? AND FILE_CATEGORY = ?");
                p.setInt(1, HomeScreen.MEMID);
                p.setInt(2, LogIn.inputCODE);
                p.setString(3, x.getText());
                p.setString(4, f_cat);
                r = p.executeQuery();
                
                if (r.next()) {
                    // Retrieve the value from the result set
                    previewPath = r.getString("FILE_PATH");
                    previewFNAME = x.getText();
                } else {
                    // Handle the case where no rows were returned (e.g., display a message)
                    previewPath = previewPath = "C:\\BSCS 3-3\\Applications Development and Emerging Technologies\\Codes\\FamilyVault\\src\\familyvault\\404.png";
                    previewFNAME = "404: File Not Fount";
                }
                
                // Close the result set and statement
                r.close();
                p.close();
                
                
                
            }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e);
            }

    }
    
    //Func to delete file
    private void FileDelete(JLabel x){
                                
        int result = JOptionPane.showConfirmDialog(null, "Do you want to Delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
        // Check the user's choice
        if (result == JOptionPane.YES_OPTION) {
            try{ 
                p = con.prepareStatement("DELETE FROM FAM_FILE WHERE MEM_ID = ? and CODE = ? AND FILE_NAME = ? AND FILE_CATEGORY = ?");
                p.setInt(1, HomeScreen.MEMID);
                p.setInt(2, LogIn.inputCODE);
                p.setString(3, x.getText());
                p.setString(4, f_cat);
                p.executeUpdate();
                JOptionPane.showMessageDialog(null,"File Deleted");
                
                // Close the result set and statement
                r.close();
                p.close();
                
                
                
            }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e);
            }
        } 
        
        new File_List().setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(File_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(File_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(File_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(File_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new File_List().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Add2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jTITLE;
    private javax.swing.JLabel lDEL1;
    private javax.swing.JLabel lDEL2;
    private javax.swing.JLabel lDEL3;
    private javax.swing.JLabel lDEL4;
    private javax.swing.JLabel lDEL5;
    private javax.swing.JLabel lDEL6;
    private javax.swing.JLabel lDEL7;
    private javax.swing.JLabel lFNAME1;
    private javax.swing.JLabel lFNAME2;
    private javax.swing.JLabel lFNAME3;
    private javax.swing.JLabel lFNAME4;
    private javax.swing.JLabel lFNAME5;
    private javax.swing.JLabel lFNAME6;
    private javax.swing.JLabel lFNAME7;
    private javax.swing.JLabel lICON1;
    private javax.swing.JLabel lICON2;
    private javax.swing.JLabel lICON3;
    private javax.swing.JLabel lICON4;
    private javax.swing.JLabel lICON5;
    private javax.swing.JLabel lICON6;
    private javax.swing.JLabel lICON7;
    private javax.swing.JPanel pFILE1;
    private javax.swing.JPanel pFILE2;
    private javax.swing.JPanel pFILE3;
    private javax.swing.JPanel pFILE4;
    private javax.swing.JPanel pFILE5;
    private javax.swing.JPanel pFILE6;
    private javax.swing.JPanel pFILE7;
    // End of variables declaration//GEN-END:variables
}
