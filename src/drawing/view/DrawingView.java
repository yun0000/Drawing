package drawing.view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import drawing.model.Figure;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class DrawingView {
    
    public JFrame frame;
    public JPanel toolbar;
    public JPanel colorbar;
    public MyPanel canvas;
    public ArrayList<Figure> myModel;
    Color currentColor;
    public JButton circleButton;
    public JButton rectangleButton;
    public JButton triangleButton;
    public JButton lineButton;
    public JButton rhombusButton;
    public JButton penButton;
    public JButton movingButton;
    public JButton resizingButton;
    public JButton rotatingButton;
    public JButton removingButton;
    public JButton squareButton;
    public JButton redButton;
    public JButton orangeButton;
    public JButton yellowButton;
    public JButton greenButton;
    public JButton blueButton;
    public JButton navyButton;
    public JButton magentaButton;
    public JButton gradientButton;
    public JTextField lineThickness;
    public JButton thicknessButton;
  
    
    public DrawingView(ArrayList<Figure> drawingModel) throws FileNotFoundException, IOException {
        myModel = drawingModel;
        
        frame = new JFrame();
        toolbar = new JPanel();
        canvas = new MyPanel(myModel);
        
        penButton = new JButton("Free Curve");
        circleButton = new JButton("Circle");
        rectangleButton = new JButton("Rectangle");
        triangleButton = new JButton("Triangle");
        lineButton = new JButton("Line");
        rhombusButton = new JButton("Rhombus");
        movingButton = new JButton("Move");
        resizingButton = new JButton("Scale");
        rotatingButton = new JButton("Rotate");
        removingButton = new JButton("Erase");
        squareButton = new JButton("Draw in Regular Shape");
        redButton = new JButton("    ");
        redButton.setBackground(Color.red);
        orangeButton = new JButton("    ");
        orangeButton.setBackground(Color.orange);
        yellowButton = new JButton("    ");
        yellowButton.setBackground(Color.yellow);
        greenButton = new JButton("    ");
        greenButton.setBackground(Color.green);
        blueButton = new JButton("    ");
        blueButton.setBackground(Color.CYAN);
        navyButton = new JButton("    ");
        navyButton.setBackground(Color.blue);
        magentaButton = new JButton("    ");
        magentaButton.setBackground(Color.magenta);
        gradientButton = new JButton("Gradation");
        lineThickness = new JTextField(2);
        thicknessButton = new JButton("Line Thickness");
        
        toolbar.add(circleButton);
        toolbar.add(rectangleButton);
        toolbar.add(triangleButton);
        toolbar.add(lineButton);
        toolbar.add(rhombusButton);
        toolbar.add(penButton);
        toolbar.add(movingButton);
        toolbar.add(resizingButton);
        toolbar.add(rotatingButton);
        toolbar.add(removingButton);
        toolbar.add(squareButton);
        toolbar.add(redButton);
        toolbar.add(orangeButton);
        toolbar.add(yellowButton);
        toolbar.add(greenButton);
        toolbar.add(blueButton);
        toolbar.add(navyButton);
        toolbar.add(magentaButton);
        toolbar.add(gradientButton);
        toolbar.add(lineThickness);
        toolbar.add(thicknessButton);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.NORTH, toolbar);
        frame.getContentPane().add(BorderLayout.CENTER, canvas);
       
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(2200,1600);
        
    }
    
    public MyPanel getCanvas() {
        return canvas;
    }
}
