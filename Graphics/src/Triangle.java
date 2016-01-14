public class Triangle {
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
        normal = Vector.calcNnormal(A, B, C);
        area = getTriangleArea(this);
    }

    public double getTriangleArea(Triangle triangle){
        Vector temp = triangle.C.subtract(triangle.A).cross(triangle.C.subtract(triangle.B));
        double x = Math.pow(temp.x, 2);
        double y = Math.pow(temp.y, 2);
        double z = Math.pow(temp.z, 2);
        return Math.pow(x + y + z, 0.5) / 2;
    }
}