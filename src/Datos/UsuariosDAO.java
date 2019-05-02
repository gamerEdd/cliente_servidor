/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import Entidad.Usuarios;
import Presentacion.mdiMenuPrincipal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.omg.CORBA_2_3.portable.InputStream;

/**
 *
 * @author eddgt
 */
public class UsuariosDAO extends Conexion {

    Connection con = null;
    private static UsuariosDAO instancia;

    public static UsuariosDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuariosDAO();
        }
        return instancia;
    }

    public int registrar(Usuarios usr, String ruta) throws SQLException, FileNotFoundException {
        con = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        FileInputStream fi = null;
        String sql = "INSERT INTO usuario (idusuario,cedula,nombre,apellido,imagenusu,nombreusuario,contraseña,email,rol_idrol)VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            File file = new File(ruta);
            fi = new FileInputStream(file);

            ps = con.prepareStatement(sql);
            ps.setInt(1, usr.getIdusuario());
            ps.setString(2, usr.getCedula());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getApellido());
            ps.setBinaryStream(5, fi);
            ps.setString(6, usr.getNombreusuario());
            ps.setString(7, usr.getContra());
            ps.setString(8, usr.getEmail());
            ps.setInt(9, usr.getIdrol());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
            ps.close();
        }

    }

    public int modificar(Usuarios usr) throws SQLException, FileNotFoundException {

        PreparedStatement ps = null;
        con = Conexion.getInstancia().miConexion();
        String sql = "update usuario set cedula=?,nombre=?,apellido=?,imagenusu=?,nombreusuario=?,contraseña=?,email=?,rol_idrol=? where idusuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getCedula());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setBinaryStream(4, usr.getImagen());
            ps.setString(5, usr.getNombreusuario());
            ps.setString(6, usr.getContra());
            ps.setString(7, usr.getEmail());
            ps.setInt(8, usr.getIdrol());
            ps.setInt(9, usr.getIdusuario());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
            ps.close();
        }

    }

    public void acceder(String usuario, String pass) {
        Conexion cc = new Conexion();
        Connection cn = cc.miConexion();
        String sql = "SELECT * FROM usuario WHERE idusuario='" + usuario + "' and contraseña=MD5('" + pass + "')";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()) {
                JOptionPane.showMessageDialog(null, "Bienvenido" + " " + usuario);

            } else {
                JOptionPane.showMessageDialog(null, "Datos Erroneos");

            }

        } catch (SQLException ex) {
            System.out.println("error");
        }

    }

    public boolean login(Usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = miConexion();

        String sql = "SELECT idusuario, nombreusuario, contraseña, rol_idrol FROM usuario WHERE nombreusuario = ? LIMIT 1";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombreusuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContra().equals(rs.getString(3))) {
                    usr.setIdusuario(rs.getInt(1));
                    usr.setIdrol(rs.getInt(4));
                    return true;
                } else {
                    return false;
                }
            }

            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = miConexion();

        String sql = "SELECT count(id) FROM usuario WHERE nusuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
        
    
    
}
