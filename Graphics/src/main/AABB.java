package main;

public class AABB extends Intersectable {
    public Vector A;
    public Vector B;

    public AABB(Vector A, Vector B) {
        this.A = A;
        this.B = B;
    }

    public Vector getIntersect(Vector from, Vector to) {
        return null;
    }
}
