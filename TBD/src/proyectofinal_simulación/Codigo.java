package proyectofinal_simulación;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Codigo extends javax.swing.JFrame {

    String usr;
    String pass;
    //Variables
    
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    public String bd1 = "LIBRERIA";
    final String url_bd = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String url_bd2 = "jdbc:mysql://localhost/" + bd1 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String Controlador = "com.mysql.jdbc.Driver";
    public String rutaArchivo, linea;
    String[] parts;
    String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
    Inicio ini = new Inicio();
    Formulario formu = new Formulario();
    /**
     * Creates new form Chi_Cuadrada
     */
    public Codigo(String us,String pas) {
        initComponents();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(ancho-350,alto-450));
        setTitle("Cuadrados Medios:");
        setLocationRelativeTo(null);
        RestrictedTextField restricted = new RestrictedTextField(borrartx);
        restricted.setLimit(7);
        //restricted.setOnlyNums(true);
        setLocationRelativeTo(null);
        usr=us;
        pass=pas;
    }

    private Codigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public void mandardatoslibros(String us, String pass) {
        ResultSet result = null;
        Statement sen = null;
        Connection con = null;
        DefaultTableModel m1 = new DefaultTableModel();
        m1.setColumnIdentifiers(new Object[]{"idlibro","libronombre","editorial","autor","genero","pais","paginas","edicion","precio"});
        try {
            con = DriverManager.getConnection(url_bd2, us, pass);
            sen = con.createStatement();
            result = sen.executeQuery("SELECT * FROM LIBROS");
            while (result.next()) {
                m1.addRow(new Object[]{result.getString("idlibro"),result.getString("libronombre"),result.getString("editorial"),result.getString("autor"),result.getString("genero"),result.getString("pais"),result.getString("paginas"),result.getString("edicion"),result.getString("precio")});
            }
            tabla_1.setModel(m1);
            result.close();
            conexion.close();
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
}
public void mandardatosusr(String us, String pass) {
        ResultSet result = null;
        Statement sen = null;
        Connection con = null;
        DefaultTableModel m2 = new DefaultTableModel();
        m2.setColumnIdentifiers(new Object[]{"idprestamo","idusuario","editorial","idlibro","nombre","apellidos","telefono","libronombre"});
        try {
            con = DriverManager.getConnection(url_bd2, us, pass);
            sen = con.createStatement();
            result = sen.executeQuery("SELECT * FROM PRESTAMO");
            while (result.next()) {
                m2.addRow(new Object[]{result.getString("idprestamo"),result.getString("idusuario"),result.getString("idlibro"),result.getString("nombre"),result.getString("apellidos"),result.getString("telefono"),result.getString("libronombre")});
            }
            tabla_2.setModel(m2);
            result.close();
            conexion.close();
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
}
public void borrarFormulario(int idb) throws SQLException, ClassNotFoundException {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Class.forName(Controlador);
            conexion = DriverManager.getConnection(url_bd2, usr, pass);
            sentencia = conexion.createStatement();
            String query = "DELETE FROM PRESTAMO WHERE id="+idb;
            try {
                ps = conexion.prepareStatement(query, ps.RETURN_GENERATED_KEYS);
                ps.executeUpdate(query, ps.RETURN_GENERATED_KEYS);
                rs = ps.getGeneratedKeys();
                JOptionPane.showMessageDialog(null, "Se han completado los registros del formulario.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "AVISO!!", JOptionPane.ERROR_MESSAGE);
            }
}
    public void leerArchivo() throws SQLException, ClassNotFoundException {
        Inicio in=new Inicio();
        Codigo chi=new Codigo(usr,pass);
        try {

            this.rutaArchivo = "flibro.txt";

            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader entradaArchivo = new BufferedReader(fr);
            linea = entradaArchivo.readLine();
            while (linea != null) {
                parts = linea.split("\\" + "|");
                p1 = parts[0];
                p2 = parts[1];
                p3 = parts[2];
                p4 = parts[3];
                p5 = parts[4];
                p6 = parts[5];
                p7 = parts[6];
                p8 = parts[7];
                p9 = parts[8];
                p10 = parts[9];
                p11 = parts[10];
                p12 = parts[11];
                p13 = parts[12];
                p14 = parts[13];
                p15 = parts[14];
                System.out.println("-" + p1 + "-" + p2 + "-" + p3 + "-" + p4 + "-" + p5 + "-" + p6 + "-" + p7 + "-" + p8 + "-" + p9 + "-" + p10 + "-" + p11 + "-" + p12 + "-" + p13 + "-" + p14 + "-" + p15);
                insertarFormulario();
                linea = entradaArchivo.readLine();
            }
            borrararchivo();
            chi.setVisible(true);
            in.dispose();
        } catch (IOException ex) {
            System.out.println("Error en la apertura del archivo " + ex.toString());
        }

    }
public void insertarFormulario() throws SQLException, ClassNotFoundException {
        if (querycontador <= cantUs) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Class.forName(Controlador);
            conexion = DriverManager.getConnection(url_bd2, usersql, passsql);
            sentencia = conexion.createStatement();
            String query = "INSERT INTO FORMULARIO(ALTURA,RESULTADO,EDAD,PESO,DELGADOH,NORMALH,SOBREPESOH,OBESIDADH,DELGADOM,NORMALM,SOBREPESOM,OBESIDADM,IMC,CONTADOR,SEXO) values ('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + p7 + "','" + p8 + "','" + p9 + "','" + p10 + "','" + p11 + "','" + p12 + "','" + p13 + "','" + p14 + "','" + p15 + "')";
            try {
                ps = conexion.prepareStatement(query, ps.RETURN_GENERATED_KEYS);
                ps.executeUpdate(query, ps.RETURN_GENERATED_KEYS);
//                ps.setString(1, p1);
//                ps.setString(2, p2);
//                ps.setString(3, p4);
//                ps.setString(5, p5);
//                ps.setString(6, p6);
//                ps.setString(7, p7);
//                ps.setString(8, p8);
//                ps.setString(9, p9);
//                ps.setString(10, p10);
//                ps.setString(11, p11);
//                ps.setString(12, p12);
//                ps.setString(13, p13);
//                ps.setString(14, p14);
//                ps.setString(15, p15);
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    querycontador = rs.getInt(1);
                    System.out.println("" + querycontador);
                }
                JOptionPane.showMessageDialog(null, "Se han completado los registros del formulario.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "AVISO!!", JOptionPane.ERROR_MESSAGE);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BORRAR = new javax.swing.JButton();
        ACEPTAR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        borrartx = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idlibro", "libronombre", "editorial", "autor", "genero", "pais", "paginas", "edicion", "precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 710, 70));

        jLabel1.setFont(new java.awt.Font("Unica One", 0, 36)); // NOI18N
        jLabel1.setText("REGISTROS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        regresar.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, 40));

        tabla_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idprestamo", "idusuario", "idlibro", "nombre", "apellidos", "telefono", "libronombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 710, 80));

        jLabel4.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        jLabel4.setText("ID de usuario que desea eliminar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        jLabel5.setText("Libros");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        BORRAR.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        BORRAR.setText("Borrar");
        BORRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BORRARActionPerformed(evt);
            }
        });
        getContentPane().add(BORRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, -1, 40));

        ACEPTAR.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        ACEPTAR.setText("Aceptar");
        ACEPTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACEPTARActionPerformed(evt);
            }
        });
        getContentPane().add(ACEPTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, -1, 40));

        jLabel6.setFont(new java.awt.Font("Unica One", 0, 18)); // NOI18N
        jLabel6.setText("Usuarios");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));
        getContentPane().add(borrartx, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        // TODO add your handling code here:
        Principal obj = new Principal();
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

    private void BORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BORRARActionPerformed
        // TODO add your handling code here:
        int idb=Integer.parseInt(borrartx.getText());
        try {
            borrarFormulario(idb);
        } catch (SQLException ex) {
            Logger.getLogger(Codigo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Codigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BORRARActionPerformed

    private void ACEPTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACEPTARActionPerformed
        // TODO add your handling code here:
        Inicio obj=new Inicio();
        mandardatoslibros(usr, pass);
        mandardatosusr(usr, pass);
    }//GEN-LAST:event_ACEPTARActionPerformed

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
            java.util.logging.Logger.getLogger(Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Codigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Codigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACEPTAR;
    private javax.swing.JButton BORRAR;
    private javax.swing.JTextField borrartx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tabla_1;
    private javax.swing.JTable tabla_2;
    // End of variables declaration//GEN-END:variables
}
