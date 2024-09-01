/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.UsuarioEscritorio;
import vista.frmLogin;
import vista.frmRegistro;

/**
 *
 * @author lagal
 */
public class ctrlLogin implements MouseListener {

    UsuarioEscritorio modelo;
    frmLogin vista;
    
    
    public ctrlLogin(UsuarioEscritorio modelo, frmLogin vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.btnIngresar.addMouseListener(this);
        vista.btnIrAregistro.addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            modelo.setCorreo(vista.txtEmail.getText());
            modelo.setContrasena(vista.txtContrasena.getText());

            // Creo una variable llamada "comprobar" 
            // que guardará el resultado de ejecutar el método iniciarSesion()            
            boolean comprobar = modelo.iniciarSesion();

            // Si la variable es "true" significa que sí existe el usuario ingresado    
            if (comprobar) {
                JOptionPane.showMessageDialog(vista,"Usuario existe, ¡Bienvenido!");
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario no encontrado");
            }
        } 
        
        // Clic al botón de Ir Al Registro
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Implementar lógica si es necesario
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Implementar lógica si es necesario
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Implementar lógica si es necesario
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Implementar lógica si es necesario
    }
}
