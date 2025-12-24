package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import java.util.List;

public class Rasterization {


    public static void drawLine(
            final PixelWriter pixelWriter,
            final int startX, final int startY,
            final int endX, final int endY,
            final Color startColor, final Color endColor) {

        List<int[]> points = Algoritm.computeLine(startX, startY, endX, endY);
        List<Color> colors = Algoritm.interpolateColors(startColor, endColor, points.size());

        for (int i = 0; i < points.size(); i++) {
            int[] point = points.get(i);
            pixelWriter.setColor(point[0], point[1], colors.get(i));
        }
    }

}
