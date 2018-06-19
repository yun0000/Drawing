/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.model;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
public class Pen extends Figure {
    
    ArrayList<Line> lines = new ArrayList<>();
    Line eachLine;
    double formerLineX;
    double formerLineY;
    double smallestX;
    double smallestY;
    double biggestX;
    double biggestY;
    double movedX;
    double movedY;

    public Pen(Color currentColor) {
        super(currentColor);
    }
    
    public void setPoints (double startX, double startY, double endX, double endY) {
        eachLine = new Line(this.color);
        eachLine.setStartX(startX);
        eachLine.setStartY(startY);
        eachLine.setEndX(endX);
        eachLine.setEndY(endY);
        lines.add(eachLine);
    }
    
    public boolean isInside (int x, int y) {
        if (x>=this.getSmallestX() && x<=this.getBiggestX())
            if(y>=this.getSmallestY() && y<=this.getBiggestY())   
                return true;
        
        return false;
    }
    
    public void draw(Graphics g) {
        
        g.setColor(color);
        
        for(Line eachLine:lines) {

            Graphics2D g2d = (Graphics2D)g;

            g2d.setStroke(new BasicStroke(this.thickness));
            AffineTransform transform = g2d.getTransform();

            if(this.isRotated()) 
                g2d.rotate(angle*2, this.getCenterX() ,this.getCenterY());
            
            g.drawLine((int)(eachLine.startX), (int)(eachLine.startY), (int)(eachLine.endX), (int)(eachLine.endY));
            
            g2d.setTransform(transform);
        }  
    }
    
    public double getCenterX() {
    
        return (this.getSmallestX()+this.getBiggestX())/2;
    }
    
    public double getSmallestX() {
    
        biggestX = 0;
        smallestX = 20000;
        for(Line eachLine:lines) 
            if(eachLine.startX < smallestX)
                smallestX = eachLine.startX;
         
        return smallestX;
    }
    public double getBiggestX() {
    
        biggestX = 0;
        for(Line eachLine:lines) 
            if (eachLine.startX > biggestX)
                biggestX = eachLine.startX;

        return biggestX;
    }
    
    public double getCenterY() {
    
        return (this.getSmallestY()+this.getBiggestY())/2;
    }
    
    public double getSmallestY() {
    
        smallestY = 20000;
        for(Line eachLine:lines) 
            if(eachLine.startY < smallestY)
                smallestY = eachLine.startY;

        return smallestY;
    }
    public double getBiggestY() {
    
        biggestY = 0;
        for(Line eachLine:lines) 
            if (eachLine.startY > biggestY)
                biggestY = eachLine.startY;

        return biggestY;
    }
        
    @Override
    public void move(double movedX, double movedY) {
           
        for(Line eachLine:lines) {
            eachLine.startX += movedX;
            eachLine.endX += movedX;
            eachLine.startY += movedY;
            eachLine.endY += movedY;
        }
    }
    @Override
    public void resize(double movedX, double movedY) {
        
        Line firstLine = lines.get(0);
        firstLine.startX -= movedX/10;
        firstLine.startY -= movedX/10;
        firstLine.endX += movedX/10;
        firstLine.endY += movedX/10;
        
        for(int i=1;i<lines.size();i++) {
            Line eachLine = lines.get(i);
            eachLine.startX = firstLine.endX;
            eachLine.startY = firstLine.endY;
            
            eachLine.endX += movedX*i/10;
            eachLine.endY += movedX*i/10;
            firstLine = eachLine;
        }
    }
    
}
