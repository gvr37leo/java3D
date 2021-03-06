package main;

public class Vector{
    public double x;
    public double y;
    public double z;
    public double length;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = calcLength();
    }

    public static Vector getPlaneIntersect(Vector line1, Vector line2, Triangle triangle){
        Vector normal = triangle.normal;
        double u = normal.dot(triangle.A.subtract(line1)) / normal.dot(line2.subtract(line1));
        return line1.add(line2.subtract(line1).scale(u));
    }

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

    public static Vector calcNormal(Vector A, Vector B, Vector C){
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

    public Vector rotate(double x, double y, double z, Vector center){
        Vector selfCopy = this.subtract(center);
        //maybe an idea to even for rotate return a new Vector object maybe that will make this xyz bullshit go away and make the returning of objects uniform
        selfCopy.rotateX(x);
        selfCopy.rotateY(y);
        selfCopy.rotateZ(z);
        selfCopy.add(center);
        return selfCopy.add(center);
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

    public Intersectable castRay(Vector to, Scene scene){
        Intersectable closestObject = null;
        Vector closest = new Vector(0,0,0);
        closest.length = Double.POSITIVE_INFINITY;
        for(Intersectable object:scene.objects){
            Vector intersection = object.getIntersect(this,to);//maybe vector from camera to intersection has to be calculated
            // because now only the location of the intersection is calculated atleast in triangle
            if(intersection != null){
                Vector cameraToIntersection = intersection.subtract(this);
                if(cameraToIntersection.length < closest.length){
                    closest = cameraToIntersection;
                    closestObject = object;
                }
            }
        }
        return closestObject;
    }

    public Vector project(Vector vector){
        double scalar = this.dot(vector)/this.dot(this);
        return this.scale(scalar);
    }

    public boolean equals(Vector other){
        return other.x == x && other.y == y && other.z == z;
    }

    public Vector parametricForm(Vector to,double scale){
        return this.add(to.subtract(this).scale(scale));
    }

    //still figuring this one out
    public Vector reflectOn(Plane plane, Vector intersect){//can be optimized if plane normal is guaranteed normalized
        Vector Vp = plane.normal.project(this);
        Vector reflection = this.subtract(Vp.scale(2));
        return intersect.add(reflection);
    }

    //still needs work
    public Vector refractOn(Plane plane, Vector intersect){
        double riWater = 1.33;
        double riAir =  1.00029;
        double incomningAngle = this.calcAngle(plane.normal);
        double outgoingAngle = Math.asin(riAir * Math.sin(incomningAngle)/riWater);
        return null;
    }

    public Vector normalize(){
        return this.scale(1/length);
    }
}