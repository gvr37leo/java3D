package main;

public abstract class Intersectable {
    public GColor color = new GColor();
    abstract Vector getIntersect(Vector from, Vector to);
}
