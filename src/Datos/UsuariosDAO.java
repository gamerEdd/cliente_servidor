/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author eddgt
 */
public class UsuariosDAO extends Conexion {   
      public boolean registrar(Usuarios usr) throws SQLException {
        PreparedStatement ps = null;
        Connection con = miConexion();

        String sql = "INSERT INTO usuarios (idusuario, nusuario, contraseña, rol_idrol) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usr.getIdusuario());
            ps.setString(2, usr.getNombreusuario());
            ps.setString(3, usr.getPass());    
            ps.setInt(4, usr.getIdrol());
            ps.execute();
            return true;
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
    
        public boolean login(Usuarios usr) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = miConexion();

        String sql = "SELECT u.idusuario, u.nusuario, u.contraseña, u.rol_idrol, r.descripcion FROM usuario AS u INNER JOIN usuario AS ON u.rol_idrol=r.idrol  WHERE usuario=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, usr.getNombreusuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getPass().equals(rs.getString(3))) {
                    usr.setIdusuario(rs.getInt(1));
                    usr.setNombreusuario(rs.getString(2));
                    usr.setIdrol(rs.getInt(4));
                    usr.setTipo(rs.getString(5));
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
                JOptionPane.showMessageDialog(null, "aqui error"+e.toString());
            }
        }
    }
         public int existeUsuario(String usuario) throws SQLException {
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
