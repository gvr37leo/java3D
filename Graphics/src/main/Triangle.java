package main;

public class Triangle extends Intersectable {
    Vector A;
    Vector B;
    Vector C;
    public Vector normal;
    public Vector centroid;
    public GColor color = new GColor();
    public double area;

    public Triangle(Vector A, Vector B, Vector C) {
        this.A = A;
        this.B = B;
        this.C = C;
        centroid = A.add(B).add(C).scale(1/3);
        normal = Vector.calcNormal(A, B, C);
        area = getTriangleArea(this);
    }

    public double getTriangleArea(Triangle triangle){
        Vector temp = triangle.C.subtract(triangle.A).cross(triangle.C.subtract(triangle.B));
        double x = Math.pow(temp.x, 2);
        double y = Math.pow(temp.y, 2);
        double z = Math.pow(temp.z, 2);
        return Math.pow(x + y + z, 0.5) / 2;
    }

    public void rotate(double x, double y,double z){
        this.A.rotate(x,y,z,this.centroid);
        this.B.rotate(x,y,z,this.centroid);
        this.C.rotate(x,y,z,this.centroid);
        this.normal.rotate(x,y,z,this.centroid);
    }

    public  void translate(Vector vector){
        this.A.add(vector);
        this.B.add(vector);
        this.C.add(vector);
        this.centroid.add(vector);
    }

    public Vector getIntersect(Vector from, Vector to) {
        Vector v = to.subtract(from);
        Vector w = A.subtract(from);
        double k = w.dot(normal)/v.dot(normal);
        Vector intersectionPoint = from.add(to.subtract(from).scale(k));
        if(isInTriangle(intersectionPoint)){
            return intersectionPoint;
        }else{
            return null;
        }
    }

    public boolean isInTriangle(Vector vector){
        return false;
    }


}
