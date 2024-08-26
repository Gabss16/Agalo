/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.Dashboard;
import vista.menu;



/**
 *
 * @author lagal
 */
public class ctrlMenu implements MouseListener{
    
    menu vista;
    
    public ctrlMenu(menu Vista){
    this.vista = Vista;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource()== vista.btnHome) {
            
            Dashboard objD = new Dashboard();
        
        vista.jPCpntenedor.removeAll();
        vista.jPCpntenedor.add(objD);
            
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
