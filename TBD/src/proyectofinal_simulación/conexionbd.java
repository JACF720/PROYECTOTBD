/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_simulación;

import java.io.*;
import java.sql.*;
import javax.swing.*;
/* 3511 
Equipo 3 
Simulación
/**
 * @author Aguilar Castellanos Alexis
 * @author Alatorre Perez Irving Alan
 * @author Antonio Torres Juan
 * @author Casillas Flores Jaime Alberto
 * @author Sanchez Hernandez Brenda Alejandra
 */
public class conexionbd {

    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    final String Controlador = "com.mysql.jdbc.Driver";
    public String usersql, passsql;
    public String tablachi;
    public String bd1 = "IMC";
    public String bd2 = "Chicuadrado";
    final String url_bd = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String url_bd2 = "jdbc:mysql://localhost/" + bd1 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String url_bd3 = "jdbc:mysql://localhost/" + bd2 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public String rutaArchivo, linea;
    public int cantUs = 100, querycontador;
    String[] parts;
    String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
    Inicio ini = new Inicio();
    Formulario formu = new Formulario();
    

    public void ValidarUs(String us, String contraseña) {
        try {
            usersql = us;
            passsql = contraseña;
            Class.forName(Controlador);
            conexion = DriverManager.getConnection(url_bd, us, contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ConectarBasedeDatos() throws SQLException {
        try {
            Class.forName(Controlador);
            conexion = DriverManager.getConnection(url_bd2, usersql, passsql);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SHOW DATABASES like '" + bd1 + "'");
            JOptionPane.showMessageDialog(null, "No es nulo, La base de datos " + bd1 + " existe.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Si es nulo, La base de datos " + bd1 + " no existe.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
            conexion = DriverManager.getConnection(url_bd, usersql, passsql);
            sentencia = conexion.createStatement();
            String query = "DROP DATABASE IF EXISTS " + bd1;
            String query2 = "CREATE DATABASE " + bd1;
            sentencia.executeUpdate(query);
            sentencia.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Se ha creado con exito la base de datos " + bd1 + "!!.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ConectarBDChi() throws SQLException {
        try {
            Class.forName(Controlador);
            conexion = DriverManager.getConnection(url_bd3, usersql, passsql);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("SHOW DATABASES like '" + bd2 + "'");
            JOptionPane.showMessageDialog(null, "No es nulo, La base de datos " + bd2 + " existe.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Si es nulo, La base de datos " + bd2 + " no existe.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
            conexion = DriverManager.getConnection(url_bd, usersql, passsql);
            sentencia = conexion.createStatement();
            String query = "DROP DATABASE IF EXISTS " + bd2;
            String query2 = "CREATE DATABASE " + bd2;
            sentencia.executeUpdate(query);
            sentencia.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Se ha creado con exito la base de datos " + bd2 + "!!.", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Crear_tablas() throws SQLException, ClassNotFoundException {
        int valt;
        Class.forName(Controlador);
        conexion = DriverManager.getConnection(url_bd, usersql, passsql);
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery("SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = '" + bd1 + "' AND table_name = 'FORMULARIO'");
        if (resultado.next()) {
            valt = resultado.getInt("count");
            System.out.println("valor columna: " + valt);
            if (valt == 0) {
                conexion = DriverManager.getConnection(url_bd2, usersql, passsql);
                sentencia = conexion.createStatement();
                String query = "DROP TABLE IF EXISTS FORMULARIO";
                String query1 = "CREATE TABLE IF NOT EXISTS FORMULARIO (\n"
                        + "  ID mediumint NOT NULL AUTO_INCREMENT,\n"
                        + "  ALTURA varchar(5) NOT NULL,\n"
                        + "  RESULTADO varchar(22) NOT NULL,\n"
                        + "  EDAD VARCHAR(3) NOT NULL ,\n"
                        + "  PESO VARCHAR(5) not null,\n"
                        + "  DELGADOH varchar(1) NOT NULL,\n"
                        + "  NORMALH varchar(1) not NULL,\n"
                        + "  SOBREPESOH varchar(1) not NULL,\n"
                        + "  OBESIDADH varchar(1) not NULL,\n"
                        + "  DELGADOM varchar(1) NOT NULL,\n"
                        + "  NORMALM varchar(1) not NULL,\n"
                        + "  SOBREPESOM varchar(1) not NULL,\n"
                        + "  OBESIDADM varchar(1) not NULL,\n"
                        + "  IMC varchar(22) not NULL,\n"
                        + "  CONTADOR varchar(3) not NULL,\n"
                        + "  SEXO varchar(20) not NULL,\n"
                        + "  PRIMARY KEY (ID)\n"
                        + ") ;";
                sentencia.executeUpdate(query);
                sentencia.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Se ha creado con exito la tabla FORMULARIO!!", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        conexion = DriverManager.getConnection(url_bd, usersql, passsql);
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery("SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = '" + bd2 + "' AND table_name = 'chicuadradox2'");
        if (resultado.next()) {
            valt = resultado.getInt("count");
            System.out.println("" + valt);
            if (valt == 0) {
                conexion = DriverManager.getConnection(url_bd3, usersql, passsql);
                sentencia = conexion.createStatement();
                String query = "DROP TABLE IF EXISTS chicuadradox2";
                String query1 = "CREATE TABLE IF NOT EXISTS chicuadradox2 (\n"
                        + "    vp INT,\n"
                        + "    TOL0_001  VARCHAR(20),\n"
                        + "    TOL0_0025  VARCHAR(20),\n"
                        + "    TOL0_005  VARCHAR(20),\n"
                        + "    TOL0_01  VARCHAR(20),\n"
                        + "    TOL0_025  VARCHAR(20),\n"
                        + "    TOL0_05  VARCHAR(20),\n"
                        + "    TOL0_1  VARCHAR(20),\n"
                        + "    TOL0_15  VARCHAR(20),\n"
                        + "    TOL0_2  VARCHAR(20),\n"
                        + "    TOL0_25  VARCHAR(20),\n"
                        + "    TOL0_3  VARCHAR(20),\n"
                        + "    TOL0_35  VARCHAR(20),\n"
                        + "    TOL0_4  VARCHAR(20),\n"
                        + "    TOL0_45  VARCHAR(20),\n"
                        + "    TOL0_5  VARCHAR(20),\n"
                        + "    TOL0_55  VARCHAR(20),\n"
                        + "    TOL0_6  VARCHAR(20),\n"
                        + "    TOL0_65  VARCHAR(20),\n"
                        + "    TOL0_7  VARCHAR(20),\n"
                        + "    TOL0_75  VARCHAR(20),\n"
                        + "    TOL0_8  VARCHAR(20),\n"
                        + "    TOL0_85  VARCHAR(20),\n"
                        + "    TOL0_9  VARCHAR(20),\n"
                        + "    TOL0_95  VARCHAR(20),\n"
                        + "    TOL0_975  VARCHAR(20),\n"
                        + "    TOL0_99  VARCHAR(20),\n"
                        + "    TOL0_995  VARCHAR(20),\n"
                        + "    TOL0_9975  VARCHAR(20),\n"
                        + "    TOL0_999  VARCHAR(20),\n"
                        + "    PRIMARY KEY(vp)\n"
                        + ");";
                sentencia.executeUpdate(query);
                sentencia.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Se ha creado con exito la tabla chicuadradox2!!", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
                Insertarchix2();
            }
        }
    }

    public void leerArchivo() throws SQLException, ClassNotFoundException {
        Inicio in=new Inicio();
        Chi_Cuadrada chi=new Chi_Cuadrada(usersql,passsql);
        try {

            this.rutaArchivo = "formulario.txt";

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

    public void Insertarchix2() throws SQLException, ClassNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("chicuadradox2.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                Class.forName(Controlador);
                conexion = DriverManager.getConnection(url_bd3, usersql, passsql);
                sentencia = conexion.createStatement();
                sentencia.executeUpdate(linea);
            }
            JOptionPane.showMessageDialog(null, "Se han insertado de manera exitosa los datos de chicuadrada!!!", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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

    public void borrararchivo() {
        formu.archivo = new File("formulario.txt");
        if (!formu.archivo.exists()) {
            try {
                formu.archivo.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(formu.archivo));
                bw.write("");
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error con la creacion del archivo.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(formu.archivo));
                bw.write("");
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error con la escritura y lectura del archivo.", "Aviso!!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void DesconectarBasedeDatos() {
        try {
            if (conexion != null) {
                if (sentencia != null) {
                    sentencia.close();
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void obtenerdatochitabla(String parte1, String parte2, String us, String pass) throws ClassNotFoundException {
        int id;
        String datochi;
        ResultSet result = null;
        Connection con = null;
        Statement sen = null;
        try {
            Class.forName(Controlador);
            con = DriverManager.getConnection(url_bd3, us, pass);
            sen = con.createStatement();
            result = sen.executeQuery("SELECT vp,TOL0_" + parte2 + " FROM chicuadradox2 WHERE vp=" + parte1);
            while (result.next()) {
                id = result.getInt("vp");
                datochi = result.getString("TOL0_" + parte2);
                tablachi = datochi;
            }
        } catch (SQLException ex) {
            conexion = null;
            ex.printStackTrace();
            System.out.println(" SQLException : " + ex.getMessage());
            System.out.println(" SQLState : " + ex.getSQLState());
            System.out.println(" VendorError : " + ex.getErrorCode());
        }
    }

    public void mandardatos(String us, String pass) {
        int id;
        String TOL0_001, TOL0_0025, TOL0_005, TOL0_01, TOL0_025, TOL0_05, TOL0_1, TOL0_15, TOL0_2, TOL0_25, TOL0_3, TOL0_35,
                TOL0_4, TOL0_45, TOL0_5, TOL0_55, TOL0_6, TOL0_65, TOL0_7, TOL0_75, TOL0_8, TOL0_85, TOL0_9, TOL0_95, TOL0_975, TOL0_99,
                TOL0_995, TOL0_9975, TOL0_999;
        ResultSet result = null;
        Statement sen = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection(url_bd3, us, pass);
            sen = con.createStatement();
            result = sen.executeQuery("SELECT * FROM chicuadradox2");
            while (result.next()) {
                id = result.getInt("vp");
                TOL0_001 = result.getString("TOL0_001");
                TOL0_0025 = result.getString("TOL0_0025");
                TOL0_005 = result.getString("TOL0_005");
                TOL0_01 = result.getString("TOL0_01");
                TOL0_025 = result.getString("TOL0_025");
                TOL0_05 = result.getString("TOL0_05");
                TOL0_1 = result.getString("TOL0_1");
                TOL0_15 = result.getString("TOL0_15");
                TOL0_2 = result.getString("TOL0_2");
                TOL0_25 = result.getString("TOL0_25");
                TOL0_3 = result.getString("TOL0_3");
                TOL0_35 = result.getString("TOL0_35");
                TOL0_4 = result.getString("TOL0_4");
                TOL0_45 = result.getString("TOL0_45");
                TOL0_5 = result.getString("TOL0_5");
                TOL0_55 = result.getString("TOL0_55");
                TOL0_6 = result.getString("TOL0_6");
                TOL0_65 = result.getString("TOL0_65");
                TOL0_7 = result.getString("TOL0_7");
                TOL0_75 = result.getString("TOL0_75");
                TOL0_8 = result.getString("TOL0_8");
                TOL0_85 = result.getString("TOL0_85");
                TOL0_9 = result.getString("TOL0_9");
                TOL0_95 = result.getString("TOL0_95");
                TOL0_975 = result.getString("TOL0_975");
                TOL0_99 = result.getString("TOL0_99");
                TOL0_995 = result.getString("TOL0_995");
                TOL0_9975 = result.getString("TOL0_9975");
                TOL0_999 = result.getString("TOL0_999");
                System.out.println(id + " " + TOL0_001 + " " + TOL0_0025 + " " + TOL0_005
                        + " " + TOL0_01 + " " + TOL0_025 + " " + TOL0_05 + " " + TOL0_1
                        + " " + TOL0_15 + " " + TOL0_2 + " " + TOL0_25 + " " + TOL0_3
                        + " " + TOL0_35 + " " + TOL0_4 + " " + TOL0_45 + " " + TOL0_5
                        + " " + TOL0_55 + " " + TOL0_6 + " " + TOL0_65 + " " + TOL0_7
                        + " " + TOL0_75 + " " + TOL0_8 + " " + TOL0_85 + " " + TOL0_9
                        + " " + TOL0_95 + " " + TOL0_975 + " " + TOL0_99 + " " + TOL0_995
                        + " " + TOL0_9975 + " " + TOL0_999);
            }
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
}
