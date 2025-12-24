package com.cgvsu.rasterization;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;

public class Algoritm {

    public static List<int[]> computeLine(int x0, int y0, int x1, int y1) {
        List<int[]> points = new ArrayList<>();

        int deltax = abs(x1 - x0);
        int deltay = abs(y1 - y0);

        int dirx = x1 > x0 ? 1 : -1;
        int diry = y1 > y0 ? 1 : -1;

        // Если линия пологая (dx >= dy)
        if (deltax >= deltay) {
            int error = 2 * deltay - deltax;
            int y = y0;
            int x = x0;
            for (int i = 0; i <= deltax; i++) {
                points.add(new int[]{x, y});
                if (error > 0) {
                    y += diry;
                    error -= 2 * deltax;
                }
                x += dirx;
                error += 2 * deltay;
            }
        }
        // Если линия крутая (dy > dx)
        else {
            int error = 2 * deltax - deltay;
            int x = x0;
            int y = y0;
            for (int i = 0; i <= deltay; i++) {
                points.add(new int[]{x, y});
                if (error > 0) {
                    x += dirx;
                    error -= 2 * deltay;
                }
                y += diry;
                error += 2 * deltax;
            }
        }

        return points;
    }

    public static List<Color> interpolateColors(Color startColor, Color endColor, int steps) {
        if (steps <= 0) {
            return new ArrayList<>();
        }
        if (steps == 1) {
            List<Color> colors = new ArrayList<>();
            colors.add(startColor);
            return colors;
        }

        List<Color> colors = new ArrayList<>();

        double r1 = startColor.getRed();
        double g1 = startColor.getGreen();
        double b1 = startColor.getBlue();
        double r2 = endColor.getRed();
        double g2 = endColor.getGreen();
        double b2 = endColor.getBlue();

        for (int i = 0; i < steps; i++) {
            double t = (double) i / (steps - 1);
            double r = r1 + t * (r2 - r1);
            double g = g1 + t * (g2 - g1);
            double b = b1 + t * (b2 - b1);
            colors.add(Color.color(r, g, b));
        }

        return colors;
    }
}