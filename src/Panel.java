import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
 


public class Panel extends JPanel {
    private int cornerRadius = 15; // Radio de las esquinas redondeadas
    private Color backgroundColor = Color.WHITE; // Color de fondo del panel

    // Constructor sin parámetros
    public Panel() {
        setOpaque(false); // Hacer que el panel sea transparente para ver las esquinas redondeadas
    }

    // Constructor con parámetros
    public Panel(int cornerRadius, Color backgroundColor) {
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        setOpaque(false); // Hacer que el panel sea transparente para ver las esquinas redondeadas
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el fondo redondeado
        g2.setColor(backgroundColor);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        g2.dispose();
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  