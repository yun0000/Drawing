/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Yun
 */
public class Line extends Figure {

    public Line(Color currentColor) {
        super(currentColor);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = g2d.getTransform();
        if(this.isRotated()) {
            g2d.rotate(angle, (startX+endX)/2, (startY+endY)/2);
        }
        g.drawLine((int)startX, (int)startY, (int)startX+width, (int)startY+height);
        g2d.setTransform(transform);
            
    }

    @Override
    public void move(double movedX, double movedY) {
        
        this.startX = startX + movedX;
        this.startY = startY + movedY;
        
    }
    @Override
    public void resize(double movedX, double movedY) {
        this.setEndX(endX + movedX);
        this.setEndY(endY + movedY);
    }
}
