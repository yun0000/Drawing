package drawing.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Circle extends Figure {
    

    public Circle(Color currentColor) {
        super(currentColor);
    }
    
    GradientPaint gradient;
      
    @Override
    public void draw(Graphics g) {
        
        g.setColor(color);        
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = g2d.getTransform();
        if(this.isRotated()) 
            g2d.rotate(angle, (startX+endX)/2, (startY+endY)/2);
        if(this.isSquared())
            height = width;
        g2d.setStroke(new BasicStroke(this.thickness));
        g.drawOval((int)Math.min(startX, endX), (int)Math.min(startY, endY), width, height);  
        if (this.isFill()) {
            if(this.isGradient()) {
                gradient = new GradientPaint((int)Math.min(startX, endX), (int)Math.min(startY, endY), gradientColor, 
                        (int)Math.min(startX, endX)+width, (int)Math.min(startY, endY)+height, color);
                g2d.setPaint(gradient);
            }
            g2d.fillOval((int)Math.min(startX, endX), (int)Math.min(startY, endY), width, height); 
        }
        g2d.setTransform(transform);
    }
    
    @Override
    public void move(double movedX, double movedY) {
        
        
        this.startX = startX + movedX;
        this.startY = startY + movedY;
        this.endX = endX + movedX;
        this.endY = endY + movedY;
        
    }

    @Override
    public void resize(double movedX, double movedY) {
        this.setEndX(endX + movedX);
        this.setEndY(endY + movedY);
    }

   
}
