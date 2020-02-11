
import controlador.ProductoControlador;
import modelo.dao.Conexion;
import modelo.dao.Producto;
import modelo.dao.ProductoDAO;
import vista.ProductoVista;


/**
 *
 * @author Dante_Sanchez
 */
public class principal {
    public static void main (String[] args) {
    
        Conexion cn = new Conexion();
        
        if(cn.conectar()!=null) {
            System.out.println("Se conecto a bd");
        }else {
            System.out.println("fallo la conexion");
        }
        
        
            Producto modeloProducto = new Producto();
            ProductoDAO modeloProductoDAO = new ProductoDAO();
            ProductoVista vistaProducto = new ProductoVista();
            
            ProductoControlador controladorProducto = new ProductoControlador(modeloProducto, modeloProductoDAO, vistaProducto);
            
            vistaProducto.setVisible(true);
        
}
}
