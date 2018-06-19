/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.view;
import drawing.model.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
    
    ArrayList<Figure> model;
    public MyPanel(ArrayList<Figure> myModel) {
        this.model = myModel;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        for(Figure eachShape : model){
            eachShape.draw(g);
        }
        repaint();
    }
}
  
    