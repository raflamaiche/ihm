package sample;

import javafx.geometry.Pos;
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


import java.util.ArrayList;

public class Figure {
    private int mode; // 0 mode select/move; 1 mode Ellipse; 2 mode Rectangle; 3 mode Line
    private Color couleur;
    private ArrayList<Position> Liste;
    private boolean select;
    private Position selected;

    public Figure(){
        mode = 0;
        Liste = new ArrayList<Position>();
    }

    public void toSelectMove(){
        this.mode = 0;
    }

    public void toEllipse(){
        this.mode = 1;

    }

    public void toRectangle(){
        this.mode = 2;

    }

    public void toLine(){
        this.mode = 3;

    }

    public  void colorSelection(Color nc){
        this.couleur = nc;
    }

    public void clic(GraphicsContext gc, double x, double y){
        if (mode==3 ){
            drawLine(gc,x,y);
        }
        if(mode==1){
            drawEllipse(gc,x,y);
        }
        if(mode==2){
            drawRectangle(gc,x,y);
        }
        if(mode==0){
            if(select){
                if(selected.forme==1){
                    couleur=selected.getColor();
                    drawEllipse(gc,x,y);
                    deleteEllipse(gc,selected.getx(),selected.gety(),selected
                    );
                }
                if(selected.forme==2){
                    couleur=selected.getColor();
                    drawRectangle(gc,x,y);
                    deleteRectangle(gc,selected.getx(),selected.gety(),selected);
                }
                if(selected.forme==3){
                    couleur=selected.getColor();
                    drawLine(gc,x,y);
                    deleteLine(gc,selected.getx(),selected.gety(),selected);
                }
                this.select=false;

            } else {
                Position p = new Position(10000,10000,couleur,0);
                for(int i=0; i<Liste.size();i++){
                    if(Liste.get(i).closerto(p,x,y)){
                        p=Liste.get(i);
                    }
                }
                selected=p;

                this.select=true;

            }
        }

    }

    public void deleteLine(GraphicsContext gc,double x, double y,Position p){
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(7);
        gc.strokeLine(x, y, x+100, y);
        Liste.remove(p);
    }

    public void deleteEllipse(GraphicsContext gc,double x, double y,Position p){
        gc.setFill(Color.WHITE);
        gc.fillOval(x, y, 50, 50);
        Liste.remove(p);
    }

    public void deleteRectangle(GraphicsContext gc,double x, double y,Position p){
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, 50, 50);
        Liste.remove(p);
    }

    public void drawLine(GraphicsContext gc,double x, double y){ ;
        gc.setStroke(couleur);
        gc.setLineWidth(7);
        gc.strokeLine(x, y, x+100, y);
        Liste.add(new Position(x,y,couleur,3));
    }

    public void drawRectangle(GraphicsContext gc,double x, double y){
        gc.setFill(couleur);
        gc.fillRect(x, y, 50, 50);
        Liste.add(new Position(x,y,couleur,2));
    }

    public void drawEllipse(GraphicsContext gc,double x, double y){
        gc.setFill(couleur);
        gc.fillOval(x, y, 50, 50);
        Liste.add(new Position(x,y,couleur,1));
    }

}
