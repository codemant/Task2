package com.cgvsu.rasterization;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputeLineTest {
    @Test
    public void testSamePoint() {
        List<int[]> pts = Algoritm.computeLine(10, 20, 10, 20);
        assertEquals(1, pts.size());
        assertArrayEquals(new int[]{10, 20}, pts.get(0));
    }

    @Test
    public void testHorizontalRight() {
        List<int[]> pts = Algoritm.computeLine(10, 5, 15, 5);
        assertEquals(6, pts.size());
        assertArrayEquals(new int[]{10, 5}, pts.get(0));
        assertArrayEquals(new int[]{15, 5}, pts.get(5));
    }

    @Test
    public void testHorizontalLeft() {
        List<int[]> pts = Algoritm.computeLine(15, 5, 10, 5);
        assertEquals(6, pts.size());
        assertArrayEquals(new int[]{15, 5}, pts.get(0));
        assertArrayEquals(new int[]{10, 5}, pts.get(5));
    }

    @Test
    public void testVerticalUp() {
        List<int[]> pts = Algoritm.computeLine(3, 2, 3, 7);
        assertEquals(6, pts.size());
        assertArrayEquals(new int[]{3, 2}, pts.get(0));
        assertArrayEquals(new int[]{3, 7}, pts.get(5));
    }

    @Test
    public void testVerticalDown() {
        List<int[]> pts = Algoritm.computeLine(3, 7, 3, 2);
        assertEquals(6, pts.size());
        assertArrayEquals(new int[]{3, 7}, pts.get(0));
        assertArrayEquals(new int[]{3, 2}, pts.get(5));
    }

    @Test
    public void testShallowSlopePositive() {
        List<int[]> pts = Algoritm.computeLine(10, 10, 20, 15);
        assertEquals(11, pts.size());
        assertArrayEquals(new int[]{10, 10}, pts.get(0));
        assertArrayEquals(new int[]{20, 15}, pts.get(10));
    }

    @Test
    public void testShallowSlopeNegative() {
        List<int[]> pts = Algoritm.computeLine(10, 10, 20, 5);
        assertEquals(11, pts.size());
        assertArrayEquals(new int[]{10, 10}, pts.get(0));
        assertArrayEquals(new int[]{20, 5}, pts.get(10));
    }

    @Test
    public void testSteepSlopePositive() {
        List<int[]> pts = Algoritm.computeLine(5, 5, 8, 15);
        assertEquals(11, pts.size());
        assertArrayEquals(new int[]{5, 5}, pts.get(0));
        assertArrayEquals(new int[]{8, 15}, pts.get(10));
    }

    @Test
    public void testSteepSlopeNegative() {
        List<int[]> pts = Algoritm.computeLine(5, 15, 8, 5);
        assertEquals(11, pts.size());
        assertArrayEquals(new int[]{5, 15}, pts.get(0));
        assertArrayEquals(new int[]{8, 5}, pts.get(10));
    }

    @Test
    public void testReverseOrder() {
        List<int[]> pts1 = Algoritm.computeLine(1, 1, 5, 4);
        List<int[]> pts2 = Algoritm.computeLine(5, 4, 1, 1);

        assertEquals(pts1.size(), pts2.size());
        assertArrayEquals(pts1.get(0), pts2.get(pts2.size() - 1));
    }

    @Test
    public void testNegativeToPositive() {
        List<int[]> pts = Algoritm.computeLine(-5, -3, 2, 4);
        assertEquals(8, pts.size());
        assertArrayEquals(new int[]{-5, -3}, pts.get(0));
        assertArrayEquals(new int[]{2, 4}, pts.get(7));
    }

    @Test
    public void testNegativeToNegative() {
        List<int[]> pts = Algoritm.computeLine(-8, -5, -3, -2);
        assertEquals(6, pts.size());
        assertArrayEquals(new int[]{-8, -5}, pts.get(0));
        assertArrayEquals(new int[]{-3, -2}, pts.get(5));
    }

    @Test
    public void testDiagonal() {
        List<int[]> pts = Algoritm.computeLine(0, 0, 4, 4);
        assertEquals(5, pts.size());
        for (int i = 0; i <= 4; i++) {
            assertArrayEquals(new int[]{i, i}, pts.get(i));
        }
    }

    @Test
    public void testBackwardDiagonal() {
        List<int[]> pts = Algoritm.computeLine(5, 5, 1, 1);
        assertEquals(5, pts.size());
        assertArrayEquals(new int[]{5, 5}, pts.get(0));
        assertArrayEquals(new int[]{1, 1}, pts.get(4));
    }

    @Test
    public void testAlmostHorizontal() {
        List<int[]> pts = Algoritm.computeLine(0, 0, 10, 1);
        assertEquals(11, pts.size());
        assertArrayEquals(new int[]{0, 0}, pts.get(0));
        assertArrayEquals(new int[]{10, 1}, pts.get(10));
    }
    @Test
    public void testAlmostVertical() {
        List<int[]> pts = Algoritm.computeLine(0, 0, 1, 10);
        assertEquals(11, pts.size());
        assertArrayEquals(new int[]{0, 0}, pts.get(0));
        assertArrayEquals(new int[]{1, 10}, pts.get(10));
    }

    @Test
    public void testErrorZero() {
        List<int[]> pts = Algoritm.computeLine(0, 0, 4, 2);
        int[][] expected = {{0,0}, {1,0}, {2,1}, {3,1}, {4,2}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], pts.get(i));
        }
    }
}