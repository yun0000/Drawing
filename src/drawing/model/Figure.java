package drawing.model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
    
    public Color color;
    public Color gradientColor;
    public double startX, startY;
    public double endX, endY;
    
    public int width, height;
    public int thickness = 1;
    public double angle;
    public Boolean fill = false;
    public Boolean square = false;
    public Boolean gradient = false;
    public Figure(Color currentColor) {
        color = currentColor;
    }
    
    public double getStartX () {
        return startX;
    }
    
    public double getStartY () {
        return startY;
    }
    
    public double getEndX () {
        return endX;
    }
    
    public double getEndY () {
        return endY;
    }
    
    public void setStartX (double startX) {
        this.startX = startX;
    }
    
    public void setStartY (double startY) {
        this.startY = startY;
    }
    
    public void setEndX (double endX) {
        this.endX = endX;
        this.width = (int)Math.abs(endX-startX);
    }
    
    public void setEndY (double endY) {
        this.endY = endY;
        this.height = (int)Math.abs(endY-startY);
    }
    
    public void setPoints (double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.width = (int)Math.abs(endX-startX);
        this.height = (int)Math.abs(endY-startY);
    }
    
    public void setAngle (double angle) {
        this.angle = angle;
    }
    
    public Boolean isFill() {
        return fill;
    }
    
    public boolean isRotated () {
        if (this.angle == 0)  
            return false;
        return true;
    }
    
    public void setFill (boolean filled){
        this.fill = filled;
    }
  
    public void setColor (Color color){
        this.color = color;
    }
    
    public boolean isSquared () {
        if (this.square == true)
            return true;
        return false;
    }
    
    public boolean isInside (int x, int y) {
        if (x>=this.startX && x<=this.endX || x<=this.startX && x>=this.endX)
            if(y>=this.startY && y<=this.endY || y<=this.startY && y>=this.endY)   
                return true;
        
        return false;
    }
    
    public boolean isGradient () {
        if (this.gradient)
            return true;
        return false;                 
        
    }
    
    public abstract void draw(Graphics g);
    public abstract void move(double movedX, double movedY);
    public abstract void resize(double movedX, double movedY);
    
}