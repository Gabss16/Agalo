package custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRedondeado extends JPanel {

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public PanelRedondeado() {
        setOpaque(false);
    }

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape roundRect = createRoundRectangle();
        g2.setColor(getBackground());
        g2.fill(roundRect);

        g2.dispose();
    }

    private Shape createRoundRectangle() {
        int width = getWidth();
        int height = getHeight();

        int arcWidthTopLeft = Math.min(roundTopLeft, height);
        int arcHeightTopLeft = Math.min(roundTopLeft, width);
        int arcWidthTopRight = Math.min(roundTopRight, height);
        int arcHeightTopRight = Math.min(roundTopRight, width);
        int arcWidthBottomLeft = Math.min(roundBottomLeft, height);
        int arcHeightBottomLeft = Math.min(roundBottomLeft, width);
        int arcWidthBottomRight = Math.min(roundBottomRight, height);
        int arcHeightBottomRight = Math.min(roundBottomRight, width);

        return new RoundRectangle2D.Double(
                0, 0, width, height,
                arcWidthTopLeft, arcHeightTopLeft
        );
    }
}
