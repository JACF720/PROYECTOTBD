/* 3511 
Equipo 3 
Simulación 
Chi Cuadrada*/
package proyectofinal_simulación;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Aguilar Castellanos Alexis
 * @author Alatorre Perez Irving Alan
 * @author Antonio Torres Juan
 * @author Casillas Flores Jaime Alberto
 * @author Sanchez Hernandez Brenda Alejandra
 */
public class Chi_Cuadrada extends javax.swing.JFrame {

    String usr;
    String pass;
    //Variables
    int mD, mN, mS, mO, hD, hN, hS, hO, numeroColumnas = 4, numerofilas = 2;
    String cf = "", m = "", comps = "";
    double totaltotal, totalD, totalN, totalS, totalO, totalMujeres, totalHombres, sumatoria, MFED, MFEN, MFES, MFEO, HFED, HFEN, HFES, HFEO;
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    public int delH, norH, soH, oH, delM, norM, soM, oM;
    public String bd1 = "IMC";
    public String bd2 = "Chicuadrado";
    final String url_bd = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String url_bd2 = "jdbc:mysql://localhost/" + bd1 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String url_bd3 = "jdbc:mysql://localhost/" + bd2 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * Creates new form Chi_Cuadrada
     */
    public Chi_Cuadrada(String us,String pas) {
        initComponents();
        setLocationRelativeTo(null);
        usr=us;
        pass=pas;
    }

    private Chi_Cuadrada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void CosultapesosH(String usr, String pass) {
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(DELGADOH) AS 'N' from FORMULARIO where DELGADOH='1'");
            if (resultado.next()) {
                delH = resultado.getInt("N");
                System.out.println("" + delH);
                hD = delH;
//                conb.hD = delH;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(NORMALH) AS 'N' from FORMULARIO where NORMALH='1'");
            if (resultado.next()) {
                norH = resultado.getInt("N");
                System.out.println("" + norH);
                hN = norH;
//                conb.hN = norH;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(SOBREPESOH) AS 'N' from FORMULARIO where SOBREPESOH='1'");
            if (resultado.next()) {
                soH = resultado.getInt("N");
                System.out.println("" + soH);
//                conb.hS = soH;
                hS = soH;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(OBESIDADH) AS 'N' from FORMULARIO where OBESIDADH='1'");
            if (resultado.next()) {
                oH = resultado.getInt("N");
                System.out.println("" + oH);
//                conb.hO = oH;
                hO = oH;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
    }

    public void CosultapesosM(String usr, String pass) {
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(DELGADOM) AS 'N' from FORMULARIO where DELGADOM='1'");
            if (resultado.next()) {
                delM = resultado.getInt("N");
                System.out.println("" + delM);
                mD = delM;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(NORMALM) AS 'N' from FORMULARIO where NORMALM='1'");
            if (resultado.next()) {
                norM = resultado.getInt("N");
                System.out.println("" + norM);
//                conb.mN = norM;
                mN = norM;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(SOBREPESOM) AS 'N' from FORMULARIO where SOBREPESOM='1'");
            if (resultado.next()) {
                soM = resultado.getInt("N");
                System.out.println("" + soM);
//                conb.mS = soM;
                mS = soM;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
        try {
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select count(OBESIDADM) AS 'N' from FORMULARIO where OBESIDADM='1'");
            if (resultado.next()) {
                oM = resultado.getInt("N");
                System.out.println("" + oM);
//                conb.mO = oM;
                mO = soM;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
    }

    public void llenadoTablas() throws ClassNotFoundException {
        conexionbd obj = new conexionbd();
        //Tabla 1
        //Mujeres
//        System.out.println("" + obj.delM + obj.delH + obj.norM + obj.norH + obj.soH + obj.soM + obj.oH + obj.oM);

//        mD = obj.delM;
//        hD = obj.delH;
//        mN = obj.norM;
//        hN = obj.norH;
//        mS = obj.soM;
//        hS = obj.soH;
//        mO = obj.oM;
//        hO = obj.oH;
        System.out.println("" + mD + mN + mS + mO + hD + hN + hS + hO);
        tabla_1.setValueAt("Mujer", 0, 0);
        tabla_1.setValueAt(mD, 0, 1);
        tabla_1.setValueAt(mN, 0, 2);
        tabla_1.setValueAt(mS, 0, 3);
        tabla_1.setValueAt(mO, 0, 4);
        tabla_1.setValueAt((int) (mD + mN + mS + mO), 0, 5);
        //Hombres
        tabla_1.setValueAt("Hombre", 1, 0);
        tabla_1.setValueAt(hD, 1, 1);
        tabla_1.setValueAt(hN, 1, 2);
        tabla_1.setValueAt(hS, 1, 3);
        tabla_1.setValueAt(hO, 1, 4);
        tabla_1.setValueAt((int) (hD + hN + hS + hO), 1, 5);
        //Totales
        tabla_1.setValueAt("Total", 2, 0);
        tabla_1.setValueAt((int) (mD + hD), 2, 1);
        tabla_1.setValueAt((int) (mN + hN), 2, 2);
        tabla_1.setValueAt((int) (mS + hS), 2, 3);
        tabla_1.setValueAt((int) (mO + hO), 2, 4);
        tabla_1.setValueAt((int) ((mD + mN + mS + mO) + (hD + hN + hS + hO)), 2, 5);

        totaltotal = ((mD + mN + mS + mO) + (hD + hN + hS + hO));
        totalMujeres = (mD + mN + mS + mO);
        totalHombres = (hD + hN + hS + hO);
        totalD = mD + hD;
        totalN = mN + hN;
        totalS = mS + hS;
        totalO = mO + hO;
        //Tabla 2
        //Mujeres
        tabla_2.setValueAt("Mujer", 0, 0);
        tabla_2.setValueAt((totalD * totalMujeres) / totaltotal, 0, 1);
        tabla_2.setValueAt((totalN * totalMujeres) / totaltotal, 0, 2);
        tabla_2.setValueAt((totalS * totalMujeres) / totaltotal, 0, 3);
        tabla_2.setValueAt((totalO * totalMujeres) / totaltotal, 0, 4);
        MFED = (totalD * totalMujeres) / totaltotal;
        MFEN = (totalN * totalMujeres) / totaltotal;
        MFES = (totalS * totalMujeres) / totaltotal;
        MFEO = (totalO * totalMujeres) / totaltotal;
        //Hombres
        tabla_2.setValueAt("Hombre", 1, 0);
        tabla_2.setValueAt((totalD * totalHombres) / totaltotal, 1, 1);
        tabla_2.setValueAt((totalN * totalHombres) / totaltotal, 1, 2);
        tabla_2.setValueAt((totalS * totalHombres) / totaltotal, 1, 3);
        tabla_2.setValueAt((totalO * totalHombres) / totaltotal, 1, 4);
        HFED = (totalD * totalHombres) / totaltotal;
        HFEN = (totalN * totalHombres) / totaltotal;
        HFES = (totalS * totalHombres) / totaltotal;
        HFEO = (totalO * totalHombres) / totaltotal;
        comps = (String) margen.getSelectedItem();
        if (comps.equals("TOL0_001")) {
            m = "001";
        } else if (comps.equals("TOL0_0025")) {
            m = "0025";
        } else if (comps.equals("TOL0_005")) {
            m = "005";
        } else if (comps.equals("TOL0_01")) {
            m = "01";
        } else if (comps.equals("TOL0_025")) {
            m = "025";
        } else if (comps.equals("TOL0_05")) {
            m = "05";
        } else if (comps.equals("TOL0_1")) {
            m = "1";
        } else if (comps.equals("TOL0_15")) {
            m = "15";
        } else if (comps.equals("TOL0_2")) {
            m = "2";
        } else if (comps.equals("TOL0_25")) {
            m = "25";
        } else if (comps.equals("TOL0_3")) {
            m = "3";
        } else if (comps.equals("TOL0_35")) {
            m = "35";
        } else if (comps.equals("TOL0_4")) {
            m = "4";
        } else if (comps.equals("TOL0_45")) {
            m = "45";
        } else if (comps.equals("TOL0_5")) {
            m = "5";
        } else if (comps.equals("TOL0_55")) {
            m = "55";
        } else if (comps.equals("TOL0_6")) {
            m = "6";
        } else if (comps.equals("TOL0_65")) {
            m = "65";
        } else if (comps.equals("TOL0_7")) {
            m = "7";
        } else if (comps.equals("TOL0_75")) {
            m = "75";
        } else if (comps.equals("TOL0_8")) {
            m = "8";
        } else if (comps.equals("TOL0_85")) {
            m = "85";
        } else if (comps.equals("TOL0_9")) {
            m = "9";
        } else if (comps.equals("TOL0_95")) {
            m = "95";
        } else if (comps.equals("TOL0_975")) {
            m = "975";
        } else if (comps.equals("TOL0_99")) {
            m = "99";
        } else if (comps.equals("TOL0_995")) {
            m = "995";
        } else if (comps.equals("TOL0_9975")) {
            m = "9975";
        } else if (comps.equals("TOL0_999")) {
            m = "999";
        }
        sumatoria = (double) ((Math.pow(mD - MFED, 2) / (double) MFED) + (Math.pow(hD - HFED, 2) / (double) HFED) + (Math.pow(mN - MFEN, 2) / (double) MFEN) + (Math.pow(hN - HFEN, 2) / (double) HFEN) + (Math.pow(mS - MFES, 2) / (double) MFES) + (Math.pow(hS - HFES, 2) / (double) HFES) + (Math.pow(mO - MFEO, 2) / (double) MFEO) + (Math.pow(hO - HFEO, 2) / (double) HFEO));
        cf = Integer.toString(((numerofilas - 1) * (numeroColumnas - 1)));
        glibertad.setText(cf);
        X2.setText("" + sumatoria);
        System.out.println(cf + " " + m + "  " + (String) margen.getSelectedItem());
        obj.obtenerdatochitabla(cf, m, usr, pass);
        String tc = obj.tablachi;
        TCi.setText(tc);
        if (tc == null) {
            seacepta.setText("El valor en tabla chi no se encuentra.");
        }
        if (tc != null) {
            double comparacion = (double) Double.parseDouble(tc);
            if (comparacion < sumatoria) {
                acpn.setText("Se rechaza H0!!.");
                seacepta.setText(tc + "<" + sumatoria);
            } else if (tc == null || comparacion > sumatoria) {
                acpn.setText("Se rechaza H1!!. Por lo tanto no influye...");
                seacepta.setText(tc + ">" + sumatoria);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        margen = new javax.swing.JComboBox<>();
        seacepta = new javax.swing.JLabel();
        acpn = new javax.swing.JLabel();
        aceptar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        glibertad = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        X2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TCi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Delgado", "Normal", "Sobrepeso", "Obesidad", "Total"
            }
        ));
        tabla_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 70));

        jLabel1.setFont(new java.awt.Font("Unica One", 0, 36)); // NOI18N
        jLabel1.setText("Chi Cuadrada");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        regresar.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 40));

        tabla_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Delgado", "Normal", "Sobrepeso", "Obesidad"
            }
        ));
        tabla_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 60));

        jLabel3.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        jLabel3.setText("Margen de Error");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        jLabel4.setText("Frecuencia Esperada");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        jLabel5.setText("Frecuencia Observada");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        margen.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        margen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TOL0_001", "TOL0_0025", "TOL0_005", "TOL0_01", "TOL0_025", "TOL0_05", "TOL0_1", "TOL0_15", "TOL0_2", "TOL0_25", "TOL0_3", "TOL0_35", "TOL0_4", "TOL0_45", "TOL0_5", "TOL0_55", "TOL0_6", "TOL0_65", "TOL0_7", "TOL0_75", "TOL0_8", "TOL0_85", "TOL0_9", "TOL0_95", "TOL0_975", "TOL0_99", "TOL0_995", "TOL0_9975", "TOL0_999" }));
        getContentPane().add(margen, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 160, -1));
        getContentPane().add(seacepta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 220, 30));
        getContentPane().add(acpn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 250, 30));

        aceptar1.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        aceptar1.setText("Aceptar");
        aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar1ActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, 40));

        jLabel2.setFont(new java.awt.Font("Lexend Deca", 1, 14)); // NOI18N
        jLabel2.setText("Grados de Libertad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        glibertad.setFont(new java.awt.Font("Lexend Deca", 2, 12)); // NOI18N
        getContentPane().add(glibertad, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 60, 20));

        jLabel6.setFont(new java.awt.Font("Lexend Deca", 1, 14)); // NOI18N
        jLabel6.setText("X^2=");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        X2.setFont(new java.awt.Font("Lexend Deca", 2, 11)); // NOI18N
        getContentPane().add(X2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 110, 20));

        jLabel7.setFont(new java.awt.Font("Lexend Deca", 1, 14)); // NOI18N
        jLabel7.setText("Tabla Chi=");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, -1));

        TCi.setFont(new java.awt.Font("Lexend Deca", 2, 12)); // NOI18N
        getContentPane().add(TCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 110, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        Inicio obj = new Inicio();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void tabla_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_1KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_tabla_1KeyTyped

    private void tabla_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_2KeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_tabla_2KeyTyped

    private void aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar1ActionPerformed
        // TODO add your handling code here:
        sumatoria = 0;
        Inicio obj=new Inicio();
        try {
            CosultapesosH(usr, pass);
            CosultapesosM(usr, pass);
            llenadoTablas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Chi_Cuadrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Chi_Cuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chi_Cuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chi_Cuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chi_Cuadrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chi_Cuadrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TCi;
    private javax.swing.JLabel X2;
    private javax.swing.JButton aceptar1;
    private javax.swing.JLabel acpn;
    private javax.swing.JLabel glibertad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> margen;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel seacepta;
    private javax.swing.JTable tabla_1;
    private javax.swing.JTable tabla_2;
    // End of variables declaration//GEN-END:variables
}
