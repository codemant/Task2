package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));



        Rasterization.drawLine(
                canvas.getGraphicsContext2D().getPixelWriter(),
                50, 200, 500, 200,
                Color.CYAN, Color.PINK
        );


        // Пологая линия, зелёная - жёлтая

        Rasterization.drawLine(
                canvas.getGraphicsContext2D().getPixelWriter(),
                100, 300, 400, 350,
                Color.GREEN, Color.YELLOW
        );

        // Крутая линия, фиолетовая - оранжевая
        Rasterization.drawLine(
                canvas.getGraphicsContext2D().getPixelWriter(),
                200, 50, 250, 300,
                Color.MAGENTA, Color.ORANGE
        );


        Rasterization.drawLine(
                canvas.getGraphicsContext2D().getPixelWriter(),
                50, 50, 400, 300,
                Color.RED, Color.BLUE
        );


    }

}