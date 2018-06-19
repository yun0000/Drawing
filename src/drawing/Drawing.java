package drawing;
import drawing.controller.DrawingController;
import drawing.model.Figure;
import drawing.view.DrawingView;
import java.io.IOException;
import java.util.*;

public class Drawing {

    public static void main(String[] args) throws IOException {
        ArrayList<Figure> drawingModel = new ArrayList<>();
        DrawingView view = new DrawingView(drawingModel);
        DrawingController controller = new DrawingController(drawingModel, view);
        
        
    } 
}
