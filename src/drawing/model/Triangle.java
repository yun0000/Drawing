package drawing.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
public class Triangle extends Figure {

    GradientPaint gradient;
    
    public Triangle(Color currentColor) {
        super(currentColor);
    }

    @Override
    public void draw(Graphics g) {
        
        g.setColor(color);
        if (this.isSquared())
            endY = endX - startX +startY;
        int[] xPoints = {(int)(startX+endX)/2, (int)startX, (int)endX};
        int[] yPoints = {(int)startY, (int)endY, (int)endY};
              
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = g2d.getTransform();
        
        if(this.isRotated()) 
            g2d.rotate(angle, (startX+endX)/2, (startY+endY)/2);
        g2d.setStroke(new BasicStroke(this.thickness));
        g.drawPolygon(xPoints, yPoints, 3);  
         
        if(this.isFill()) {
            if(this.isGradient()) {
                gradient = new GradientPaint((int)Math.min(startX, endX), (int)Math.min(startY, endY), gradientColor, 
                        (int)Math.min(startX, endX)+width, (int)Math.min(startY, endY)+height, color);
                g2d.setPaint(gradient);
            }
            g.fillPolygon(xPoints, yPoints, 3);  
        }
        g2d.setTransform(transform);
    }
    
    @Override
    public void move(double movedX, double movedY) {
        this.startX += movedX;
        this.endX += movedX;
        this.startY += movedY;
        this.endY += movedY;
    }
    @Override
    public void resize(double movedX, double movedY) {
        this.setEndX(endX + movedX);
        this.setEndY(endY + movedY);
    }
}
