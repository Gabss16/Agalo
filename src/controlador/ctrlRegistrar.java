
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.UsuarioEscritorio;
import vista.frmRegistro;

/**
 *
 * @author lagal
 */
public class ctrlRegistrar implements MouseListener {
   UsuarioEscritorio modelo;
   frmRegistro vista;
   
   
    //2-Constructor 
    public ctrlRegistrar(UsuarioEscritorio modelo, frmRegistro vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnRegistrar.addMouseListener(this);

    }
    
  
    
    @Override
    public void mouseClicked(MouseEvent e) {
           System.out.println("Mouse clicked detected");
          if(e.getSource() == vista.btnRegistrar){
       
            System.out.println("Botón registrar clicado");
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setUsuario(vista.txtNombre.getText());
            modelo.setCorreo(vista.txtCorreoElectronico.getText());
            modelo.setContrasena(vista.txtContra.getText());
            
            modelo.GuardarUsuario();
            
            //Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
        }
          
          
          
          
          
          
   
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}
