package com.gvamsikris.interviewbit.arrays;

public class MinStepsInInfiniteGrid {

    public int minStepsBtwPoints(Point p1, Point p2) {
        int maxX = Math.abs(p1.x - p2.x);
        int maxY = Math.abs(p1.y - p2.y);
        return Math.max(maxX, maxY);
    }

    public int minStepsInInfiniteGrid(Point... points) {
        int steps = 0;
        for(int i =0; i < points.length - 1; i++) {
            steps += minStepsBtwPoints(points[i], points[i+1]);
        }
        return steps;
    }

    public static void main(String[] args) {
        MinStepsInInfiniteGrid sol = new MinStepsInInfiniteGrid();
        int steps = sol.minStepsInInfiniteGrid(new Point(0, 0), new Point(1, 1), new Point(1, 2));
        System.out.println("Min Steps: " + steps);

    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
