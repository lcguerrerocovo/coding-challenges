package com.github.lcguerrerocovo;

class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void trickySwap(Point p1, Point p2) {
        // java passes by value which means that for objects it passes the reference to the object
        // with this reference we can change objects, but we can't swap because for method invocation
        // it creates a new reference to the object that points to the same memory location as the previous
        // reference, thus we don't have access to the original reference that is set in the scope of the caller and
        // we can't swap since that would require changing that reference. In this failed attempt we are only
        // changing the reference in the scope of the callee which fails miserably since the original
        // references are used whenever the function returns
        p1.x = 100;
        p1.y = 100;
        Point temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public String toString() {
        return "X: " + x + " Y: " + y;
    }
}
