package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;



import java.awt.*;
import java.io.File;

public class Controller {

    @FXML
    private Button btnD;

    @FXML
    private Button btnC;

    @FXML
    private CheckBox checkSM;

    @FXML
    private CheckBox checkE;

    @FXML
    private CheckBox checkR;

    @FXML
    private CheckBox checkL;

    @FXML
    private ColorPicker ColorP;

    @FXML
    private Canvas can;



    private Figure F;



    public Controller(){
        super();
        F = new Figure();

    }

    @FXML
    public void initialize(){


        btnC.setOnAction( event -> {
            GraphicsContext gc = can.getGraphicsContext2D();
            F.drawLine(gc,100,100);

        });

        btnD.setOnAction( event -> {

            System.out.println("aaaaaa");

        });

        can.setOnMouseClicked(event ->{
            double x = event.getX();
            double y = event.getY();
            GraphicsContext gc = can.getGraphicsContext2D();
            F.clic(gc,x,y);

        });


        checkSM.setOnAction(event -> {
            checkE.setSelected(false);
            checkR.setSelected(false);
            checkL.setSelected(false);
            F.toSelectMove();
        });

        checkE.setOnAction(event -> {
            checkSM.setSelected(false);
            checkR.setSelected(false);
            checkL.setSelected(false);
            F.toEllipse();
        });

        checkL.setOnAction(event -> {
            checkE.setSelected(false);
            checkR.setSelected(false);
            checkSM.setSelected(false);
            F.toLine();
        });

        checkR.setOnAction(event -> {
            checkE.setSelected(false);
            checkL.setSelected(false);
            checkSM.setSelected(false);
            F.toRectangle();
        });

        ColorP.setOnAction(event -> {
            F.colorSelection(ColorP.getValue());
            System.out.println(ColorP.getValue());
        });

    }




}
