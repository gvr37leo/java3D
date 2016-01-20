package main;

public class Triangle extends Intersectable {
    Vector A;
    Vector B;
    Vector C;
    public Vector normal;
    public Vector centroid;
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
        this.A = this.A.rotate(x,y,z,this.centroid);
        this.B = this.B.rotate(x,y,z,this.centroid);
        this.C = this.C.rotate(x,y,z,this.centroid);
        this.normal = this.normal.rotate(x,y,z,this.centroid);
    }

    public  void translate(Vector vector){
        this.A = this.A.add(vector);
        this.B = this.B.add(vector);
        this.C = this.C.add(vector);
        this.centroid = this.centroid.add(vector);
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

//    public boolean isInTriangle(Vector Intersect){
//        Vector AB = B.subtract(A);
//        Vector CB = B.subtract(C);
//        Vector Va = AB.subtract(CB.project(AB));
//        Vector AI = Intersect.subtract(A);
//        double a = 1 - Va.dot(AI)/Va.dot(AB);
//        if(a < 0){
//            return false;
//        }
//
//        Vector BC = C.subtract(B);
//        Vector AC = C.subtract(A);
//        Vector Vb = BC.subtract(AC.project(BC));
//        Vector BI = Intersect.subtract(B);
//        double b = 1 - Vb.dot(BI)/Vb.dot(BC);
//        return b > 0;
//    }

    public boolean isInTriangle(Vector intersect){
        Vector u = B.subtract(A);
        Vector v = C.subtract(A);
        Vector w = intersect.subtract(A);

        Vector vCrossW = v.cross(w);
        Vector vCrossU = v.cross(u);

        if (vCrossW.dot(vCrossU) < 0){
            return false;
        }

        Vector uCrossW = u.cross(w);
        Vector uCrossV = u.cross(v);

        if (uCrossW.dot(uCrossV) < 0) {
            return false;
        }

        double denom = uCrossV.calcLength();
        double r = vCrossW.calcLength() / denom;
        double t = uCrossW.calcLength() / denom;
        return (r + t <= 1);
    }


}
