package main;

public class Box extends Intersectable {
    public Vector A;
    public Vector B;

    public Box(Vector A, Vector B) {
        this.A = A;
        this.B = B;
    }

    public Vector getIntersect(Vector from, Vector to) {
        return null;
    }
}
