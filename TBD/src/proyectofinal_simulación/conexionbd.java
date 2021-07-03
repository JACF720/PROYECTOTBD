/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_simulación;

import java.io.*;
import java.sql.*;
import javax.swing.*;

public class conexionbd {

    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    final String Controlador = "com.mysql.jdbc.Driver";
    public String usersql, passsql;
    public String tablachi;
    public String bd1 = "LIBRERIA";
    final String url_bd = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String url_bd2 = "jdbc:mysql://localhost/" + bd1 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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

    public void Crear_tablas() throws SQLException, ClassNotFoundException {
        int valt;
        Class.forName(Controlador);
        conexion = DriverManager.getConnection(url_bd, usersql, passsql);
        sentencia = conexion.createStatement();
        resultado = sentencia.executeQuery("SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = '" + bd1 + "' AND table_name = 'LIBROS'");
        if (resultado.next()) {
            valt = resultado.getInt("count");
            System.out.println("valor columna: " + valt);
            if (valt == 0) {
                conexion = DriverManager.getConnection(url_bd2, usersql, passsql);
                sentencia = conexion.createStatement();
                String query = "DROP TABLE IF EXISTS LIBROS";
                String query1 = "CREATE TABLE IF NOT EXISTS LIBROS (\n" +
                                "    id idlibro NOT NULL AUTO_INCREMENT,\n" +
                                "    libronombre varchar(20) NOT NULL,\n" +
                                "    editorial varchar(20) NOT NULL,\n" +
                                "    autor varchar(20) NOT NULL,\n" +
                                "    genero varchar(20) NOT NULL,\n" +
                                "    pais varchar(20) NOT NULL,\n" +
                                "    paginas varchar(20) NOT NULL,\n" +
                                "    edicion varchar(20) NOT NULL,\n" +
                                "    precio varchar(10) NOT NULL,\n" +
                                "    PRIMARY KEY (id)\n" +
                                ");";
                sentencia.executeUpdate(query);
                sentencia.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Se ha creado con exito la tabla LIBROS!!", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        resultado = sentencia.executeQuery("SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = '" + bd1 + "' AND table_name = 'PRESTAMO'");
        if (resultado.next()) {
            valt = resultado.getInt("count");
            System.out.println("valor columna: " + valt);
            if (valt == 0) {
                conexion = DriverManager.getConnection(url_bd2, usersql, passsql);
                sentencia = conexion.createStatement();
                String query = "DROP TABLE IF EXISTS PRESTAMO";
                String query1 = "CREATE TABLE IF NOT EXISTS PRESTAMO (\n" +
                                "    id idprestamo NOT NULL AUTO_INCREMENT,\n" +
                                "    idusuario NOT NULL AUTO_INCREMENT ,\n" +
                                "    idlibro int(11) NOT NULL,\n" +
                                "    nombre varchar(40) NOT NULL,\n" +
                                "    apellidos varchar(40) NOT NULL,\n" +
                                "    telefono varchar(12) NOT NULL,\n" +
                                "    libronombre varchar(50) NOT NULL \n" +
                                "    PRIMARY KEY (id)\n" +
                                ");";
                sentencia.executeUpdate(query);
                sentencia.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Se ha creado con exito la tabla PRESTAMO!!", "Aviso!!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void leerArchivo() throws SQLException, ClassNotFoundException {
        Inicio in=new Inicio();
        Codigo chi=new Codigo(usersql,passsql);
        try {
            this.rutaArchivo = "registrolibros.txt";
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
                System.out.println("-" + p1 + "-" + p2 + "-" + p3 + "-" + p4 + "-" + p5 + "-" + p6 + "-" + p7 + "-" + p8);
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
    public void leerArchivousr() throws SQLException, ClassNotFoundException {
        Inicio in=new Inicio();
        Codigo chi=new Codigo(usersql,passsql);
        try {
            this.rutaArchivo = "registrousr.txt";
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
                System.out.println("-" + p1 + "-" + p2 + "-" + p3 + "-" + p4 + "-" + p5 + "-" + p6 + "-" + p7 + "-" + p8);
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
            String query = "INSERT INTO LIBROS(libronombre,editorial,autor,genero,pais,paginas,edicion,precio) values ('" + p1 + "','" + p2 + "','" + p3 + "','" + p4 + "','" + p5 + "','" + p6 + "','" + p7 + "','" + p8 + "')";
            try {
                ps = conexion.prepareStatement(query, ps.RETURN_GENERATED_KEYS);
                ps.executeUpdate(query, ps.RETURN_GENERATED_KEYS);
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
        formu.archivo = new File("registrolibros.txt");
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
    
}
