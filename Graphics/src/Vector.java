public class Vector {
    public double x;
    public double y;
    public double z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector getPlaneIntersect(Vector line1, Vector line2, Triangle triangle){
        Vector normal = triangle.normal;
        double u = normal.dot(triangle.A.subtract(line1)) / normal.dot(line2.subtract(line1));
        return line1.add(line2.subtract(line1).scale(u));
    };

    public Vector subtract(Vector vector){
        double x = this.x - vector.x;
        double y = this.y - vector.y;
        double z = this.z - vector.z;
        return new Vector(x, y, z);
    }

    public Vector add(Vector vector){
        double x = this.x + vector.x;
        double y = this.y + vector.y;
        double z = this.z + vector.z;
        return new Vector(x, y, z);
    }

    public Vector scale(double scalar){
        return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double dot(Vector vector){
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector cross(Vector vector){
        double x = this.y * vector.z - this.z * vector.y;
        double y = this.z * vector.x - this.x * vector.z;
        double z = this.x * vector.y - this.y * vector.x;
        return new Vector(x, y, z);
    }

    public double calcLength(){
        return Math.pow(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2), 0.5);
    }

    public double calcAngle(Vector vector){
        return Math.acos(this.dot(vector) / (this.calcLength() * vector.calcLength()));
    }

    public static Vector calcNnormal(Vector A,Vector B,Vector C){
        return B.subtract(A).cross(C.subtract(A));
    }

    public boolean isInTriangle(Triangle triangle){
        Vector u = triangle.B.subtract(triangle.A);
        Vector v = triangle.C.subtract(triangle.A);
        Vector w = this.subtract(triangle.A);

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

    public void rotate(double x, double y, double z, Vector center){
        this.subtract(center);
        this.rotateX(x);
        this.rotateY(y);
        this.rotateZ(z);
        this.add(center);
    }

    public void rotateX(double t){
        double newy = this.y * Math.cos(t) - this.z * Math.sin(t);
        double newz = this.y * Math.sin(t) + this.z * Math.cos(t);
        this.y = newy;
        this.z = newz;
    }

    public void rotateY(double t){
        double newz = this.z * Math.cos(t) - this.x * Math.sin(t);
        double newx = this.z * Math.sin(t) + this.x * Math.cos(t);
        this.z = newz;
        this.x = newx;
    }

    public void rotateZ(double t){
        double newx = this.x * Math.cos(t) - this.y * Math.sin(t);
        double newy = this.x * Math.sin(t) + this.y * Math.cos(t);
        this.x = newx;
        this.y = newy;
    }
}