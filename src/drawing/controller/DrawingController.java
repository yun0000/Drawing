package drawing.controller;
import drawing.view.MyPanel;
import drawing.model.Circle;
import drawing.view.DrawingView;
import drawing.model.Figure;
import drawing.model.Line;
import drawing.model.Pen;
import drawing.model.Rectangle;
import drawing.model.Rhombus;
import drawing.model.Triangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawingController {
    
    public ArrayList<Figure> myModel = new ArrayList<Figure>();
    public DrawingView myView;
    public MyPanel canvas;
    public double startX;
    public double startY;
    public double endX;
    public double endY;
    public double movedX;
    public double movedY;
    public double currentX;
    public double currentY;
    public static Color currentColor;
    public static Color gradientColor;
    public Figure currentShape;
    public int currentThickness;
    public State myState = State.Pen;
    public boolean square = false;
    
    int type;

    public DrawingController(ArrayList<Figure> drawingModel, DrawingView drawingView) {
        this.myModel = drawingModel;
        this.myView = drawingView;
        this.canvas = drawingView.getCanvas();
        this.currentColor = Color.BLACK;
        
        canvas.addMouseListener(new myMouseListener());
        canvas.addMouseMotionListener(new myMouseListener());
        
        myView.penButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Pen;
            }
        });
        myView.circleButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Circle;
            }
        });
        myView.rectangleButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Rectangle;
            }
        });
        myView.triangleButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Triangle;
            }
        });
        myView.lineButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Line;
            }
        });
        myView.rhombusButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Rhombus;
            }
        });
        myView.movingButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Move;
            }
        });
        myView.resizingButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Resize;
            }
        });
        myView.rotatingButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Rotate;
            }
        });
        
        myView.removingButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                myState = myState.Erase;
            }
        });
        myView.squareButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                if (square == true) {
                    square = false;
                    myView.squareButton.setText("Draw in Regular Shape");
                }
                else {
                    square = true;
                    myView.squareButton.setText("Stop Drawing in Regular Shape");
                }
            }
        });
        myView.redButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentColor = Color.red;
                currentShape.color = Color.red;
                myState = myState.Color;
            }
        });
        myView.orangeButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentColor = Color.orange;
                currentShape.color = Color.orange;
                myState = myState.Color;
            }
        });
        myView.yellowButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentColor = Color.yellow;
                currentShape.color = Color.yellow;
                myState = myState.Color;
            }
        });
        myView.greenButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                //currentShape.setFilled(!currentShape.isFill());
                currentColor = Color.green;
                currentShape.color = Color.green;
                myState = myState.Color;
            }
        });
        myView.blueButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentColor = Color.cyan;
                currentShape.color = Color.cyan;
                myState = myState.Color;
            }
        });
        myView.navyButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentColor = Color.blue;
                currentShape.color = Color.blue;
                myState = myState.Color;
            }
        });
        myView.magentaButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentColor = Color.magenta;
                currentShape.color = Color.magenta;
                myState = myState.Color;
            }
        });
        myView.gradientButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                currentShape.gradientColor = currentColor;
                currentShape.gradient = true;
            }
        });
        myView.thicknessButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ev) {
                String thickness = myView.lineThickness.getText();
                currentThickness = Integer.parseInt(thickness);
                        
            }
        });
    }
    
    public enum State {
            Pen {
                @Override
                public Figure getNewFigure() {
                    return new Pen(currentColor);
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
            }, Circle {
                @Override
                public Figure getNewFigure() {
                    return new Circle(currentColor);
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
            }, Rectangle{
                @Override
                public Figure getNewFigure() {
                    return new Rectangle(currentColor);
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
            }, Triangle{
                @Override
                public Figure getNewFigure() {
                    return new Triangle(currentColor);
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
            }, Rhombus{
                @Override
                public Figure getNewFigure() {
                    return new Rhombus(currentColor);
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
            }, Line{
                @Override
                public Figure getNewFigure() {
                    return new Line(currentColor);
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
            }, Move {
                @Override
                public Figure getNewFigure() {return null;}
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {
                    
                    currentShape.move(startX-endX, startY-endY);
                }
            }, Color {
                @Override
                public Figure getNewFigure() {
                    return null;
                }
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {
                    currentShape.setColor(currentColor);
                    currentShape.setFill(!currentShape.isFill());
                }
            }, Resize { 
                @Override
                public Figure getNewFigure() {return null;}

                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {
                    currentShape.resize(startX-endX, startY-endY);
                    }
            } , Erase {
                @Override
                public Figure getNewFigure() {return null;}
                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {}
                
            }, Rotate {
                 @Override
                public Figure getNewFigure() {return null;}

                @Override
                public void getAction(Figure currentShape, double startX, double startY, double endX, double endY) {
                    double centerX = (currentShape.getStartX() + currentShape.getEndX())/2;
                    double centerY = (currentShape.getStartY() + currentShape.getEndY())/2;
                    double angle1 = Math.atan2(startY - centerY, startX - centerX);
                    double angle2 = Math.atan2(endY - centerY, endX - centerX);
                    double angle = angle1-angle2;
                    currentShape.setAngle(angle);
                }
            };
            
            abstract public Figure getNewFigure();
            abstract public void getAction(Figure currentShape, double startX, double startY, double endX, double endY);

        }


    public class myMouseListener implements MouseListener, MouseMotionListener  {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
            for(Figure eachFigure:myModel) {
                if (eachFigure.isInside(e.getX(), e.getY())) {
                    currentShape = eachFigure;
                    System.out.println("selected by click");
                    if(myState == myState.Color) 
                        myState.getAction(currentShape, endX, endY,0,0);
                    else if (myState == myState.Erase) {
                        myModel.remove(currentShape);
                        if(!myModel.isEmpty())
                            currentShape = myModel.get(myModel.size()-1);
                        break;
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
                     
            startX = e.getX();
            startY = e.getY();
            
            for(Figure eachFigure:myModel) 
                    if (eachFigure.isInside(e.getX(), e.getY())) 
                        currentShape = eachFigure; 
                   
            if(myState.getNewFigure() != null) { // 그리기 모드일 때
                currentShape = myState.getNewFigure();
                if(currentThickness != 0)
                    currentShape.thickness = currentThickness;
                currentShape.setPoints(startX, startY, startX, startY);
                myModel.add(currentShape);
            }
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        
        @Override
        public void mouseMoved(MouseEvent e) {}
        
        @Override
        public void mouseDragged(MouseEvent e) {
            
            endX = e.getX();
            endY = e.getY();
            
            if(myState.getNewFigure() == null) { // 액션 모드일 때
                    myState.getAction(currentShape, endX, endY, startX, startY); 
                if (myState != myState.Rotate) {
                    startX = e.getX();
                    startY = e.getY();
                }
            } 
            else { // 그리기 모드일 때
                if (square == true)
                    currentShape.square = true;
                
                currentShape.setPoints(startX, startY, endX, endY);
                if(myState == myState.Pen) {
                    startX = endX;
                startY = endY;
                }
            }
        }
        
    }
}
