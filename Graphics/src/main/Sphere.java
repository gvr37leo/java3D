package main;

public class Sphere extends Intersectable {
    public Vector center;
    public double radius;
    public double volume;
    public double surface;

    public Sphere(Vector center, double radius){
        this.center = center;
        this.radius = radius;
        this.volume = 4 / 3 * Math.PI * Math.pow(radius, 3);
        this.surface = 4 * Math.PI * Math.pow(radius, 2);
    }

    public Sphere scale(double scalar){
        return new Sphere(center,radius * scalar);
    }

    public Vector getIntersect(Vector from, Vector to) {
        Vector ray = to.subtract(from);
        Vector rayToSphere = center.subtract(from);
        Vector projectionOnRay = ray.project(center);
        Vector projectionToSphere = projectionOnRay.subtract(center);

        if(ray.dot(rayToSphere) < 0){//sphere is located behind the ray
            return null;//still needs some work
        }else{
            if(projectionToSphere.calcLength() == radius){
                return projectionOnRay;
            }else if(projectionToSphere.calcLength() > radius){
                return null;
            }else{
                double a = projectionToSphere.length;
                double c = radius;
                double b = Math.pow(Math.pow(c,2) - Math.pow(a,2),0.5);
                return projectionOnRay.scale((projectionOnRay.length-b) / projectionOnRay.length);
            }
        }
    }
}
