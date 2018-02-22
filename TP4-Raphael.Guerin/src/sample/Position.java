package sample;


import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

import static java.lang.Math.abs;

public class Position {
    private double x;
    private double y;
    private Color c;
    public int forme;

    public Position(double x,double y, Color c, int f){
        this.x=x;
        this.y=y;
        this.c=c;
        this.forme=f;
    }

    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }

    public Color getColor(){
        return c;
    }

    public boolean closerto(Position p, double x, double y){
        double dx1=abs(x-p.getx());
        double dx2=abs(x-this.x);
        double dy1=abs(y-p.gety());
        double dy2=abs(y-this.y);
        double d1=(dx1+dy1)/2;
        double d2=(dx2+dy2)/2;
        if(d2<d1){
            return true;
        }
        else return false;
    }

}
