package com.cgvsu.rasterization;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import javafx.scene.paint.Color;
public class interpolateColorsTest {
    @Test
    public void testZeroSteps() {
        List<Color> result = Algoritm.interpolateColors(Color.RED, Color.BLUE, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOneStep() {
        List<Color> result = Algoritm.interpolateColors(Color.RED, Color.BLUE, 1);
        assertEquals(1, result.size());
        assertEquals(Color.RED, result.get(0));
    }

    @Test
    public void testTwoSteps() {
        List<Color> result = Algoritm.interpolateColors(Color.RED, Color.BLUE, 2);
        assertEquals(2, result.size());
        assertEquals(Color.RED, result.get(0));
        assertEquals(Color.BLUE, result.get(1));
    }
    @Test
    public void testMultipleStepsInterpolation() {
        List<Color> result = Algoritm.interpolateColors(Color.RED, Color.GREEN, 5);
        assertEquals(5, result.size());

        // Проверка первого и последнего цвета
        assertEquals(Color.RED, result.get(0));
        assertEquals(Color.GREEN, result.get(4));

        // Проверка промежуточного цвета (примерно)
        Color mid = result.get(2);
        assertTrue(mid.getRed() > 0 && mid.getRed() < 1);
        assertTrue(mid.getGreen() > 0 && mid.getGreen() < 1);
    }
}


