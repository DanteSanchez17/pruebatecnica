
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dante_Sanchez
 */
public class ProductoDAO extends Conexion{

    public boolean registrarProducto(Producto producto) {
        java.sql.PreparedStatement ps = null;
        Connection cn = conectar();
        
        String sql = "INSERT INTO productos (idproductos,nombre,cantidad,codigo) VALUES(?,?,?,?)";
        
        try {
            ps=cn.prepareStatement(sql);
            
            
            ps.setInt(1, producto.getIdproducto());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getCantidad());
            ps.setString(4, producto.getCodigo());
            
            ps.execute();
            
            System.out.println("se registro producto");
            return true;
        } catch (SQLException e) {
            System.err.println(e + "fallo en insertar producto");
            
            return false;
        }
        finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarProducto(Producto producto) {
        Connection cn = conectar();
        PreparedStatement ps = null;
        
        String sql = "UPDATE productos SET nombre=?,cantidad=?,codigo=? WHERE idproductos=?";
        
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setInt(1, producto.getIdproducto());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getCantidad());
            ps.setString(4, producto.getCodigo());
            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
         finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    
    public boolean eliminarProducto (Producto producto) {
        Connection cn = conectar();
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM productos WHERE idproductos=?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, producto.getIdproducto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e + "error a borrar producto");
            return false;
        }
        
         finally {
            try {
                cn.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
}
