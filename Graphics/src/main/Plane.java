package main;

public class Plane extends Intersectable {
    public Vector point;
    public Vector normal;
    public Material material;

    public Plane(Vector point, Vector normal) {
        this.point = point;
        this.normal = normal;
    }

    public Vector getIntersect(Vector from, Vector to) {
        Vector v = to.subtract(from);
        Vector w = point.subtract(from);
        double k = w.dot(normal)/v.dot(normal);
        return from.add(to.subtract(from).scale(k));
    }
}
