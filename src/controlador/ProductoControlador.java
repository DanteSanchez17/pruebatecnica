
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.dao.Producto;
import modelo.dao.ProductoDAO;
import vista.ProductoVista;
import javax.swing.JOptionPane;

/**
 *
 * @author Dante_Sanchez
 */
public class ProductoControlador implements ActionListener{

    private Producto modelo;
    private ProductoDAO modeloDAO;
    private ProductoVista vistaProducto;

    public ProductoControlador(Producto modelo, ProductoDAO modeloDAO, ProductoVista vistaProducto) {
        
        this.modelo = modelo;
        this.modeloDAO = modeloDAO;
        this.vistaProducto = vistaProducto;
        
        this.vistaProducto.btnactualizar.addActionListener(this);
        this.vistaProducto.btneliminar.addActionListener(this);
        this.vistaProducto.btnguardar.addActionListener(this);
        
 
    }
        

    @Override
    public void actionPerformed (ActionEvent e) {
        
        if(e.getSource()== vistaProducto.btnguardar) {
            modelo.setIdproducto(Integer.parseInt(vistaProducto.txtidproducto.getText()));
            modelo.setNombre(vistaProducto.txtnombre.getText());
            modelo.setCantidad(Double.parseDouble(vistaProducto.txtcantidad.getText()));
            modelo.setCodigo(vistaProducto.txtcodigo.getText());
            
            
            if(modeloDAO.registrarProducto(modelo)){
                System.out.println("registro exitoso");
            }else {
                System.out.println("fallo registro");
            }
            
            
        }
        
        
          if(e.getSource()== vistaProducto.btnactualizar) {
            modelo.setIdproducto(Integer.parseInt(vistaProducto.txtidproducto.getText()));

            modelo.setNombre(vistaProducto.txtnombre.getText());
            modelo.setCantidad(Double.parseDouble(vistaProducto.txtcantidad.getText()));
            modelo.setCodigo(vistaProducto.txtcodigo.getText());
            
            
            if(modeloDAO.modificarProducto(modelo)){
                System.out.println("actualizacion exitosa");
            }else {
                System.out.println("fallo en actualizar");
            }
            
            
        }
          
          
          if(e.getSource()== vistaProducto.btneliminar) {
            modelo.setIdproducto(Integer.parseInt(vistaProducto.txtidproducto.getText()));
           
            
            
            if(modeloDAO.eliminarProducto(modelo)){
                System.out.println("eliminado");
            }else {
                System.out.println("no eliminado");
            }
            
            
        }
    }
    
}
